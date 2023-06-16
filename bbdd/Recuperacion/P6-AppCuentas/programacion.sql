-- Programación de la base de datos: Modificar transacciones y sacar toda la info por CONCAT

-- Procedimientos del Cliente: -------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE ingreso(numeroCuenta INT, cantidad INT)
BEGIN
    DECLARE saldo_actual INT;
    SELECT saldo INTO saldo_actual FROM ccorriente WHERE numCuenta = numeroCuenta;
    
	START TRANSACTION;
		IF saldo_actual IS NULL THEN
			ROLLBACK;
			SELECT 'La cuenta especificada no existe.';
		END IF;

		IF cantidad <= 0 THEN
			ROLLBACK;
			SELECT 'La cantidad ingresada debe ser mayor a 0.';
		END IF;
    
		SET saldo_actual = saldo_actual + cantidad;
	
		UPDATE ccorriente SET saldo = saldo_actual WHERE numCuenta = numeroCuenta;
	COMMIT;
    
	SELECT 'Ingreso exitoso.' AS 'Resultado', numCuenta, saldo FROM ccorriente WHERE numCuenta = numeroCuenta;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE retirada(numeroCuenta INT, cantidad INT)
BEGIN
	DECLARE saldo_actual INT;
	SELECT saldo INTO saldo_actual FROM ccorriente WHERE numCuenta = numeroCuenta;
	
	START TRANSACTION;
		IF saldo_actual IS NULL THEN
			ROLLBACK;
			SELECT 'La cuenta especificada no existe.';
		END IF;
    
		IF cantidad <= 0 THEN
			ROLLBACK;
			SELECT 'La cantidad solicitada debe ser mayor a 0.';
		END IF;
    
		IF saldo_actual >= cantidad THEN
			SET saldo_actual = saldo_actual - cantidad;
			UPDATE ccorriente SET saldo = saldo_actual WHERE numCuenta = numeroCuenta;
			
			COMMIT;
			
			SELECT 'Retiro exitoso.', numCuenta, saldo, cantidad AS 'cantidad_retirada' FROM ccorriente WHERE numCuenta = numeroCuenta;
		ELSE
			ROLLBACK;
			SELECT CONCAT('Lamentamos comunicarte que NO tienes saldo suficiente. Te quedan sólo ', saldo_actual, ' € y has solicitado ', cantidad, ' €.') AS 'ERRORRRR',
			numCuenta, saldo FROM ccorriente WHERE numCuenta = numeroCuenta;
		END IF;
END $$
DELIMITER ;

-- Procedimientos del Trabajador: -----------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
CREATE PROCEDURE contratoSeguro(numeroCuenta int, alta BOOLEAN)
BEGIN 
	START TRANSACTION;
		IF NOT EXISTS (SELECT * FROM seguro WHERE numCuentaA = numeroCuenta) THEN
			IF alta THEN 
				INSERT INTO seguro VALUES (
				null, numeroCuenta);
				COMMIT;
				SELECT CONCAT('El seguro de la cuenta ', numeroCuenta, ' ha sido dado de alta') AS 'AVISO';
			END IF;
		ELSE 
			IF alta = FALSE THEN
				DELETE FROM seguro WHERE numCuentaA = numeroCuenta;
				COMMIT;
				SELECT CONCAT('El seguro de la cuenta ', numeroCuenta, ' ha sido dado de baja') AS 'AVISO';
			END IF;
		END IF;
END $$
DELIMITER ;		

-- Revisar excepcion en el caso de que no exista dicha cuenta de ahorro:
DELIMITER $$
CREATE PROCEDURE altaCC(numeroCliente int, numeroCA int)
BEGIN 
	START TRANSACTION;
		IF NOT EXISTS (SELECT * FROM ccorriente WHERE numCliente = numeroCliente AND numCuentaA = numeroCA) THEN
			ROLLBACK;
			SELECT CONCAT('No se ha creado su cuenta corriente, porque la cuenta ahorro ', numeroCA, ' no existe, o no es de ese cliente.') AS 'AVISO';
		ELSE	
			INSERT INTO ccorriente(numCuenta, saldo, numCliente, numCuentaA) VALUES
			(null, 0, numeroCliente, numeroCA);
		END IF;
	COMMIT;
	SELECT CONCAT('Se ha creado una cuenta para el cliente numero ', numeroCliente, '.') AS 'AVISO';
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE bajaCC(numeroCuenta int)
BEGIN
	START TRANSACTION;
		IF NOT EXISTS (SELECT * FROM ccorriente WHERE numCuenta = numeroCuenta) THEN
			ROLLBACK;
			SELECT 'La cuenta corriente que quieres borrar no existe...' AS 'ERROR';
		ELSE 
			DELETE FROM ccorriente WHERE numCuenta = numeroCuenta;
			COMMIT;
			SELECT CONCAT('La cuenta corriente ', numeroCuenta, ' ha sido eliminada') AS 'AVISO';
		END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE altaCA(numeroCliente int)
BEGIN 
	START TRANSACTION;
		INSERT INTO cahorro VALUES (
			null, 0, numeroCliente);
	COMMIT;
	SELECT CONCAT('Se ha creado una cuenta de ahorro para el cliente numero ', numeroCliente, '.') AS 'AVISO';
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE bajaCA(numeroCuenta int)	
BEGIN
	START TRANSACTION;
		IF NOT EXISTS (SELECT * FROM cahorro WHERE numCuenta = numeroCuenta) THEN
			ROLLBACK;
			SELECT 'La cuenta de ahorro que quieres borrar no existe...' AS 'ERROR';
		ELSE 
			DELETE FROM cahorro WHERE numCuenta = numeroCuenta;
			COMMIT;
			SELECT CONCAT('La cuenta de ahorro ', numeroCuenta, ' ha sido eliminada') AS 'AVISO';
		END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION hallarInteres(numCuenta INT) RETURNS decimal(3,2)
BEGIN
	IF NOT EXISTS (SELECT * FROM seguro WHERE numCuentaA = numCuenta) THEN
		RETURN 0.20;
	ELSE 
		RETURN 0.25;
	END IF;
END $$	
DELIMITER ;

-- Triggers: ----------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
CREATE TRIGGER avisoExtracto
	BEFORE UPDATE ON ccorriente
	FOR EACH ROW 
	BEGIN
		DECLARE combinado INT;
		DECLARE estracto INT;
		DECLARE saldoCA INT;
		DECLARE extra INT;
		
		SELECT saldo FROM cahorro WHERE numCuenta = OLD.numCuentaA INTO saldoCA;
		SET combinado = OLD.saldo + saldoCA;
		SET estracto = OLD.saldo - NEW.saldo;
		
		IF combinado > estracto THEN
			IF OLD.saldo < estracto THEN 
				SET extra := estracto - OLD.saldo;
				SET saldoCA = saldoCA - extra;
				
				UPDATE cahorro SET saldo = saldoCA WHERE numCuenta = OLD.numCuentaA; 
				SET NEW.saldo = 0;
			END IF;
		ELSE
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No tienes suficiente saldo combinado';
		END IF;
	END; $$
DELIMITER ;	

DELIMITER $$
CREATE PROCEDURE testTrigger(cantidad INT, numeroCA INT)
BEGIN
    DECLARE saldoCC DECIMAL(10, 2);
    DECLARE saldoCA DECIMAL(10, 2);
    
    SELECT cc.saldo INTO saldoCC
    FROM ccorriente cc
    WHERE cc.numCuentaA = numeroCA;
    
    SELECT ca.saldo INTO saldoCA
    FROM cahorro ca
    WHERE ca.numCuenta = numeroCA;
    
    START TRANSACTION;
    
    IF (saldoCC + saldoCA) > cantidad THEN
        UPDATE ccorriente
        SET saldo = cantidad
        WHERE numCuentaA = numeroCA;
        
        COMMIT;
        
        SELECT cc.numCuenta AS 'NumCC', cc.saldo AS 'Saldo_CuentaCorriente', cc.numCuentaA AS 'NumCA', ca.saldo AS 'Saldo_CuentaAhorro'
        FROM ccorriente cc
        INNER JOIN cahorro ca ON ca.numCuenta = cc.numCuentaA;
    ELSE
        ROLLBACK;
        
        SELECT cc.numCuenta AS 'NumCC', cc.saldo AS 'Saldo_CuentaCorriente', cc.numCuentaA AS 'NumCA', ca.saldo AS 'Saldo_CuentaAhorro'
        FROM ccorriente cc
        INNER JOIN cahorro ca ON cc.numCuentaA = ca.numCuenta;
    END IF;
END $$
DELIMITER ;

-- Eventos: ----------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
CREATE EVENT traspaso
    ON SCHEDULE EVERY 1 DAY
    STARTS CURRENT_TIMESTAMP
    DO
    BEGIN
        CALL testTraspaso();
    END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE testTraspaso()
BEGIN
	START TRANSACTION;
		UPDATE ccorriente cc INNER JOIN cahorro ca ON cc.numCuentaA = ca.numCuenta
		SET cc.saldo = cc.saldo - 1000,
		    ca.saldo = ca.saldo + 1000
		WHERE cc.saldo >= 1000;
		COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE EVENT devengos
    ON SCHEDULE
    EVERY 1 MONTH
    STARTS CONCAT(LAST_DAY(CURRENT_DATE), ' 23:59:59')
    DO
    BEGIN
        CALL testIntereses();
    END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE testIntereses()
BEGIN
	START TRANSACTION;
		UPDATE cahorro
		SET saldo = saldo + (hallarInteres(numCuenta) * 1000);
		COMMIT;
END $$
DELIMITER ;

-- Le damos derechos a los roles: ------------------------------------
GRANT EXECUTE ON ingreso TO cliente;
GRANT EXECUTE ON retirada TO cliente;

GRANT EXECUTE ON altaCA TO trabajador;
GRANT EXECUTE ON bajaCA TO trabajador;
GRANT EXECUTE ON altaCC TO trabajador;
GRANT EXECUTE ON bajaCC TO trabajador;
GRANT EXECUTE ON contratoSeguro TO trabajador;
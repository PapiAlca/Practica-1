-- Programación de la base de datos:

-- Funciones y Procedimientos del Cliente: ------------------------------------

-- Meter transacciones en todo:
DELIMITER $$
CREATE FUNCTION ingresar(numCuenta INT, cantidad INT) RETURNS VARCHAR(200)
BEGIN
    DECLARE saldo_actual INT;
    SELECT saldo INTO saldo_actual FROM ccorriente WHERE numCuenta = numCuenta;
    
	START TRANSACTION 
		IF saldo_actual IS NULL THEN
			RETURN 'La cuenta especificada no existe.';
		END IF;

		IF cantidad <= 0 THEN
			RETURN 'La cantidad ingresada debe ser mayor a 0.';
		END IF;
    
		SET saldo_actual = saldo_actual + cantidad;
	
		UPDATE ccorriente SET saldo = saldo_actual WHERE numCuenta = numCuenta;
	COMMIT;
    
	RETURN 'Ingreso exitoso.';
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE ingreso(numCuenta INT, cantidad INT)
BEGIN
    ingresar(numCuenta , cantidad)
    SELECT 'Ingreso exitoso.' AS Resultado;
END $$
DELIMITER

DELIMITER $$
CREATE FUNCTION retirar(numCuenta INT, cantidad INT) RETURNS VARCHAR(200)
BEGIN
    DECLARE saldo_actual INT;
    SELECT saldo INTO saldo_actual FROM ccorriente WHERE numCuenta = numCuenta;
    
    IF saldo_actual IS NULL THEN
        RETURN 'La cuenta especificada no existe.';
    END IF;
    
    IF cantidad <= 0 THEN
        RETURN 'La cantidad solicitada debe ser mayor a 0.';
    END IF;
    
    IF saldo_actual >= cantidad THEN
        SET saldo_actual = saldo_actual - cantidad;
        UPDATE ccorriente SET saldo = saldo_actual WHERE numCuenta = numCuenta;
        RETURN 'Retiro exitoso.';
    ELSE
        RETURN CONCAT('Lamentamos comunicarte que NO tienes saldo suficiente. Te quedan sólo ', saldo_actual, ' € y has solicitado ', cantidad, ' €.');
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE retirada()
BEGIN

END $$
DELIMITER

-- Funciones y Procedimientos del Trabajador: ------------------------------------



-- Triggers: ---------------------------------------------------------------------



-- Eventos: ----------------------------------------------------------------------



-- Examen t6.3 de Juan Parejo García.

-- Creación de tablas y asignación de claves primarias:

USE 22_db_tiendaBicis;

CREATE TABLE Clientes(
	cliente_id INT(12),
	nombre VARCHAR(20),
	apellidos VARCHAR(20),
	direccion VARCHAR(40),
	fecha_nacimiento DATE,
	PRIMARY KEY(cliente_id)
);

CREATE TABLE CuentasCorrientes(
	cuenta_id INT(12),
	fk_cliente_id INT(12),
	saldo INT(9),
	PRIMARY KEY(cuenta_id)
);

CREATE TABLE CuentasAhorros(
	ahorros_id INT(12),
	saldo INT(9),
	interes INT(12),
	PRIMARY KEY(ahorros_id)
);

-- ------------------------------------

-- Alteración de tablas para asignar claves foráneas:

ALTER TABLE CuentasCorrientes 
	ADD FOREIGN KEY (fk_cliente_id) REFERENCES Clientes(cliente_id);

-- ------------------------------------

-- Ejercicio 1:

-- Paso 1: Alterar tablas para conectar las tablas CuantasCorrientes y CuentasAhorros:

ALTER TABLE CuentasCorrientes	
	ADD ahorros_id INT(12),
	ADD FOREIGN KEY (ahorros_id) REFERENCES CuentasAhorros(ahorros_id);

-- Paso 2: Una vez ya alteradas las tablas para realizar las conexiones entre tablas, 
-- crearemos la función traspaso() que traspasará 1000€ de la cuenta corriente a la de 
-- ahorro el primer día del mes si en la cuenta de ahorro sobrepasa los 1000€. 
-- También usaremos para facilitarnos la función generar_primer_dia() para sacar el primer día del mes

DELIMITER $$
CREATE FUNCTION generar_primer_dia(mes INT, anho INT) RETURNS DATE
BEGIN
    DECLARE fecha DATE;
    SET fecha = CONCAT(anho, '-', mes, '-01');
    RETURN fecha;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION traspaso(mes INT, anho INT, ahorrosID INT) RETURNS INT
BEGIN 
	DECLARE saldoCC;
	DECLARE saldoCA;
	DECLARE f_ini;
	DECLARE f_actual;
	
	SET f_ini := generar_primer_dia(mes, anho);
	
	SELECT ca.saldo, cc.saldo FROM CuentasCorrientes cc 
	INNER JOIN CuentasAhorros ca ON cc.ahorros_id = ca.ahorros_id
	WHERE ahorros_id = ahorrosID
	INTO saldoCA, saldoCC;
	
	IF(saldoCC>1000 && f_ini==f_actual) THEN
		saldoCC = saldoCC - 1000;
		saldoCA = saldoCA + 1000;
	END IF
END $$
DELIMITER ;
	

-- Ejercicio 2



-- Ejercicio 3


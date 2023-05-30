-- Programación de la base de datos:

-- Funciones y Procedimientos del Cliente:
DELIMITER $$
CREATE FUNCTION	ingresar(cantidad INT) RETURNS INT
BEGIN
	SELECT cc.saldo, co.saldo FROM CuentasCorrientes	
END $$
DELIMITER

DELIMITER $$
CREATE PROCEDURE ingreso()
BEGIN

END $$
DELIMITER

DELIMITER $$
CREATE FUNCTION retirar()
BEGIN

END $$
DELIMITER

CREATE FUNCTION retirada()

-- Funciones y Procedimientos del Trabajadoe:
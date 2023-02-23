- Crear HolaMundo:
-----------------------------------------------------
DROP FUNCTION IF EXISTS holaMundo();
DELIMITER $$
	CREATE FUNCTION holaMundo()
			 RETURNS VARCHAR(20)
			 BEGIN
				RETURN 'Hola Mundo';
	END $$
DELIMITER ;

SELECT holaMundo();
-----------------------------------------------------

- Sumar dos enteros:
-----------------------------------------------------------------------
DROP FUNCTION IF EXISTS suma;
DELIMITER $$
	CREATE FUNCTION suma(operador1 INT, operador2 INT)
		RETURNS INT DETERMINISTIC
			 BEGIN
				DECLARE resultado INT;

				SET resultado := operador1 + operador2;
				RETURN resultado;
	END $$
DELIMITER;

SELECT suma();
-----------------------------------------------------------------------

- Dado un timestamp devuelva una fecha en formato DD de MES de AAAA:
--------------------------------------------------------------------------------------------------------------
DROP FUNCTION IF EXISTS fechaBonica
DELIMITER $$
	CREATE FUNCTION fechaBonica(marcaTiempo TIMESTAMP) 
		RETURNS VARCHAR(50) DETERMINISTIC
 			BEGIN
				RETURN FROM_UNIXTIME(marcaTiempo, '%d de %m de %y';
	END $$
DELIMITER;

SELECT fechaBonica(timestamp(now())) as 'timestamp MariaDB', FROM_UNIXTIME(161675264725) as 'timestamp Unix';
--------------------------------------------------------------------------------------------------------------


- Dado una fecha en formato MariaDB devuelva la fecha en formato anterior
- Acepte un num de pedido (P4) y devuelva la fecha invocando la funcion anterior
- Dada una fecha en formato DD de MES de AAAA devuelva un timestamp
- Dada la fecha en formato DD de MES de AAAA devuelva una fecha en formato MariaDB
- Queremos sacar un listado para un listado para un sorteo .segun indicaciones de la AEPD para la aplicacion provisional de la disposicon adicional 7º de 
la  LOPDGDD,realiza una funcciion que oculte partes de dni de los particicpantes. usar los datos de la practica 3 para las pruebas 
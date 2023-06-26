-- Procedimientos:
--Crea la tabla Alumnos(id, nombre, telefono)
--Inserta 12 alumnos cualesquiera.
--Crea un procedimiento que recorra toda la tabla mostrando por salida todos los campos.
--Crea otro procemiento que muestre sólo los alumnos cuyo nombre comienze por "A".
--Crea otro que muestre sólo los nombres y los teléfonos de los 10 primeros alumnos.
--Triggers:
--Modifica la tabla anterior añadiéndole el campo edad con valores random.
--Crea un trigger que recorra todos los registros modificados añadiendo 1 al campo edad.
--Crea un trigger que recorra todos los registros insertados poniendo la edad a 18 si es menor.
--Crea un trigger que recorra todos los registros eliminados volcándo sus datos a la tabla Alumnos_Eliminados.
--Crea un evento que:
--Crea la tabla Mensajes(id, datetime, mensaje)
--Llame a un procedimiento que guarde la hora en la tabla mensajes y el nombre del evento.
--JOINS: Practica consultas con subconsultas, CTE y JOINS ya que van a caer SEGURO en el exámen.

CREATE TABLE Alumnos (
  id int(9) AUTO_INCREMENTAL,
  nombre VARCHAR(20),
  telefono int(9),
  PRIMARY KEY(id)
);

INSERT INTO Alumnos (nombre, telefono)
VALUES
  ('Juan', 123456789),
  ('María', 987654321),
  ('Pedro', 555555555),
  ('Ana', 999999999),
  ('Carlos', 111111111),
  ('Laura', 444444444),
  ('Andrés', 666666666),
  ('Sofía', 222222222),
  ('Miguel', 888888888),
  ('Lucía', 777777777),
  ('Alejandro', 333333333),
  ('Valentina', 555555555);

DELIMITER $$
CREATE PROCEDURE MostrarAlumnos()
BEGIN
  SELECT * FROM Alumnos;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MostrarAlumnosA()
BEGIN
  SELECT * FROM Alumnos WHERE nombre LIKE 'A%';
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE MostrarNombresYTelefonos()
BEGIN
  SELECT nombre, telefono FROM Alumnos LIMIT 10;
END $$
DELIMITER ;

ALTER TABLE Alumnos ADD edad INT;

UPDATE Alumnos set edad = FLOOR(RAND()*99)+11;

DELIMITER $$
CREATE TRIGGER IncrementarEdad AFTER UPDATE ON Alumnos
FOR EACH ROW
BEGIN
    SET NEW.edad = OLD.edad + 1;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER EstablecerEdad18 AFTER INSERT ON Alumnos
FOR EACH ROW
BEGIN
  IF OLD.edad < 18 THEN
    SET NEW.edad = 18;
  END IF;
END $$
DELIMITER ;

CREATE TABLE Alumnos_Eliminados (
  id INT,
  nombre VARCHAR(20),
  telefono INT(9),
  edad INT
);


DELIMITER $$
CREATE TRIGGER GuardarAlumnosEliminados AFTER DELETE ON Alumnos
FOR EACH ROW
BEGIN
  INSERT INTO Alumnos_Eliminados (id, nombre, telefono, edad)
  VALUES (OLD.id, OLD.nombre, OLD.telefono, OLD.edad);
END $$
DELIMITER ;

DELETE FROM Alumnos WHERE nombre = 'Juan';


CREATE TABLE Mensajes (
	  id int(9) AUTO_INCREMENTAL,
	  hora DATETIME,
	  mensaje VARCHAR(200),
	  PRIMARY KEY(id)
	);

DELIMITER $$
	CREATE PROCEDURE guardarHoraYEvento(evento VARCHAR(100))
	BEGIN
	  INSERT INTO Mensajes (hora, mensaje)
  VALUES ( NOW(), evento);
  
  SELECT CONCAT('Se ha creado un nuevo mensaje con id ', id) AS 'Aviso' FROM Mensajes ORDER BY id LIMIT 1;
  SELECT id, hora, mensaje FROM Mensajes;
END $$
DELIMITER ;

CREATE Event llamarProc()
ON SCHEDULE EVERY 1 DAY
STARTS NOW()
DO
  CALL guardarHoraYEvento('llamarProc');
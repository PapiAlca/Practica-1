-- 1.- Cree una DB con tu NUM_db_NOMBRE similar a la que tenías en MariaDB

DROP DATABASE IF EXISTS 22_db_Juan;
CREATE DATABASE 22_db_Juan;

-- 2.- Crea un usuario y asígnale los permisos sobre la DB anterior
CREATE USER Juan WITH PASSWORD '1234';
GRANT ALL PRIVILEGES ON DATABASE 22_db_Juan TO Juan; 

-- 3.- Crea un esquema que permita implementar el apartado 1 de la Práctica 2.1 (Personas Alumnos y Profesores).

CREATE TABLE Persona (
    DNI VARCHAR (9),
    Nombre VARCHAR (20) NOT NULL,
    Email VARCHAR (20),
    TLF INT (20),
    Direccion VARCHAR (20),
	PRIMARY KEY(DNI)
);

CREATE TABLE Profesor (
    DNI VARCHAR (9),
    Antiguedad DATE,
    Num_seg_social INT (9),
	PRIMARY KEY(DNI),
    FOREIGN KEY (DNI) REFERENCES Persona(DNI)
)INHERITS (Persona);

CREATE TABLE Alumno (
    DNI VARCHAR (9),
    TLF_padres INT(20),
    Nombre_padres VARCHAR(20),
	PRIMARY KEY(DNI),
    FOREIGN KEY (DNI) REFERENCES Persona(DNI)
)INHERITS (Persona); 


/*Apartado 4: Modifica Personas de forma que tenga una tipo personalizado 
de datos denominado DIRECCIÓN que contenga: 
tipo, nombre, número, piso, letra, cp, localidad y provincia. 
Por ejemplo: Av de la Constitución 23, 4º J, 06001, Badajoz, Badajoz.
*/
-- Se crea el tipo personalizado de datos DIRECCION
CREATE TYPE DIRECCION AS (
    tipo VARCHAR(20),
    nombre VARCHAR(20),
    numero INT(20),
    piso INT(2),
    letra VARCHAR(1),
    cp INT (5),
    localidad VARCHAR(20),
    provincia VARCHAR(20)
);

-- Se altera la tabla Persona para tener una columna de tipo DIRECCION
ALTER TABLE Persona ADD COLUMN direccion DIRECCION;

--Apartado 5: Ingresa 2 personas, 2 alumnos y 2 profesores.

-- Insertando dos personas en la tabla Persona
INSERT INTO Persona (DNI, Nombre, Email, TLF, direccion)
VALUES ('11111111A', 'Juan Pérez', 'juan@gmail.com', 666111222, 
        ('Calle Mayor', '23', '2º', 'A', 28001, 'Madrid', 'Madrid')),
       ('22222222B', 'María García', 'maria@gmail.com', 666222333,
        ('Avenida de la Constitución', '15', '1º', 'B', 41001, 'Sevilla', 'Sevilla'));

-- Insertando dos alumnos en la tabla Alumno
INSERT INTO Alumno (DNI, Nombre, Email, TLF, direccion, TLF_padres, Nombre_padres)
VALUES ('33333333C', 'Pedro Gómez', 'pedro@gmail.com', 666333444,
        ('Calle San Antonio', '10', '3º', 'C', 46002, 'Valencia', 'Valencia'),
        '666555444', 'Luisa Gómez'),
       ('44444444D', 'Sara López', 'sara@gmail.com', 666444555,
        ('Calle San Francisco', '7', '2º', 'B', 29001, 'Málaga', 'Málaga'),
        666777888, 'Javier López');

-- Insertando dos profesores en la tabla Profesor
INSERT INTO Profesor (DNI, Nombre, Email, TLF, direccion, Antiguedad, Num_seg_social)
VALUES ('55555555E', 'Carlos Rodríguez', 'carlos@gmail.com', 666555666,
        ('Calle Mayor', '5', '1º', 'C', 46001, 'Valencia', 'Valencia'),
        5, 1234567890123456),
       ('66666666F', 'Lucía Martínez', 'lucia@gmail.com', 666666777,
        ('Plaza España', '2', '2º', 'B', '50001', 'Zaragoza', 'Zaragoza'),
        3, 6543210987654321);
-- Creación de la base de datos para los alumnos, que más adelante utilizaremos en Intellij IDEA.

-- Creamos la base de datos:
CREATE DATABASE p11;

-- Creamos la tabla alumnos:
USE p11;

CREATE TABLE alumnos(
	id int(9) PRYMARY KEY,
	nombre VARCHAR(20),
	dni VARCHAR(9),
	email VARCHAR(20),
	fechaNacimiento VARCHAR(20)
);
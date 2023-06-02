-- Creación de la base de datos:
DROP DATABASE IF EXISTS cuentas;
CREATE DATABASE IF NOT EXISTS cuentas;

-- Creación de tablas: ---------------------------------------
USE cuentas;
CREATE TABLE persona(
	dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(20),
	apellido VARCHAR(20),
	direccion VARCHAR(20),
	telefono int(9)
);

CREATE TABLE cliente(
	numCliente int(9) AUTO_INCREMENT,
	dni VARCHAR(9),
	PRIMARY KEY(numCliente)
);

CREATE TABLE trabajador(
	numTrabajador int(9) AUTO_INCREMENT,
	dni VARCHAR(9),
	nss VARCHAR(22),
	PRIMARY KEY(numTrabajador)
);

CREATE TABLE ccorriente(
	numCuenta int(9) AUTO_INCREMENT,
	saldo int(6),
	numCliente int(9),
	PRIMARY KEY(numCuenta)
);

CREATE TABLE cahorro(
	numCuenta int(9) AUTO_INCREMENT,
	saldo int(6),
	numCliente int(9),
	PRIMARY KEY(numCuenta)
);

CREATE TABLE seguro(
	numSeguro int(9) AUTO_INCREMENT,
	numCliente int(9),
	cuentaA int(9),
	PRIMARY KEY(numSeguro)
);

-- Añadimos claves foraneas ------------------------------------
ALTER TABLE cliente
	ADD FOREIGN KEY (dni) REFERENCES persona (dni);
	
ALTER TABLE trabajador
	ADD FOREIGN KEY (dni) REFERENCES persona (dni);	
	
ALTER TABLE ccorriente
	ADD FOREIGN KEY (numCliente) REFERENCES cliente (numCliente);	
	
ALTER TABLE cahorro
	ADD FOREIGN KEY (numCliente) REFERENCES cliente (numCliente);		
	
ALTER TABLE seguro
	ADD FOREIGN KEY (numCliente) REFERENCES cliente (numCliente),		
	ADD FOREIGN KEY (cuentaA) REFERENCES cahorro (numCuenta);			
-- -------------------------------------------------------------
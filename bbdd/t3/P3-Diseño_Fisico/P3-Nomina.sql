USE 22_db_Juan;

CREATE TABLE IF NOT EXISTS P3_EMPRESA(
    CIF VARCHAR(9),
    nombre VARCHAR(50),
    dir VARCHAR(50),
    cp INT(9),
    prov VARCHAR(50),
    ccc BIGINT(11),
    tlf INT(9),
    PRIMARY KEY(CIF)
); 


CREATE TABLE IF NOT EXISTS P3_TRABAJADOR(
    NIF CHAR(9),
    nombre VARCHAR(50),
    ape1 VARCHAR(50),
    ape2 VARCHAR(50),
    tlf INT(9),
    nss BIGINT(12),
    catID INT(9),
    cotID INT(9),
    PRIMARY KEY(NIF)
); 

CREATE TABLE IF NOT EXISTS P3_CONTRATO(
    numContrato INT(9) NOT NULL AUTO_INCREMENT,
    fAlta DATE,
    fBaja DATE,
    codContrato INT(9),
    NIF CHAR(9),
    CIF VARCHAR(9),
    PRIMARY KEY(numContrato)
); 

CREATE TABLE IF NOT EXISTS P3_TCONTRATO(
    codContrato INT(9),
    nombre VARCHAR(50),
    PRIMARY KEY(codContrato)
); 

CREATE TABLE IF NOT EXISTS P3_CAT(
        ID INT(9),
        nombreCat VARCHAR(50),
        PRIMARY KEY(ID)
);  

CREATE TABLE IF NOT EXISTS P3_COT(
	ID INT(9),
        grupo VARCHAR(50),
        PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS P3_CONCSALARIO(
    ID INT(9) NOT NULL AUTO_INCREMENT,
    numContrato INT(9),
    conTipo INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

CREATE TABLE IF NOT EXISTS P3_CONCTIPO(
    conTipo INT(9),
    nombre VARCHAR(50),
    Tipo VARCHAR(50),
    PRIMARY KEY(conTipo)
); 

CREATE TABLE IF NOT EXISTS P3_BASECOT(
    ID INT(9),
    numContrato INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

CREATE TABLE IF NOT EXISTS P3_BASESTIPO(
    ID INT(9),
    nombre VARCHAR(50),
    porcentaje INT(9),
    PRIMARY KEY(ID)
); 

CREATE TABLE IF NOT EXISTS P3_DEDUCCION(
    ID INT(9),
    tipoDeduccion INT(9),
    anho YEAR,
    mes INT(2),
    NIF INT(9),
    numContrato INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

CREATE TABLE IF NOT EXISTS P3_TIPOEDUC(
    tipoDeduccion INT(9),
    nombre VARCHAR(50),
    receptor VARCHAR(50),
    PRIMARY KEY(tipoDeduccion)
); 

CREATE TABLE IF NOT EXISTS P3_PERCEPCION(
    ID INT(9),
    numContrato INT(9),
    conTipo INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

ALTER TABLE P3_TRABAJADOR 
	ADD FOREIGN KEY(catID) REFERENCES P3_CAT(ID),
	ADD FOREIGN KEY(cotID) REFERENCES P3_COT(ID);

ALTER TABLE P3_CONCSALARIO 
	ADD FOREIGN KEY(conTipo) REFERENCES P3_CONCTIPO(conTipo),
	ADD FOREIGN KEY(numContrato) REFERENCES P3_CONTRATO(numContrato);

ALTER TABLE P3_CONTRATO 
	ADD FOREIGN KEY(codContrato) REFERENCES P3_TCONTRATO(codContrato),
	ADD FOREIGN KEY(NIF) REFERENCES P3_TRABAJADOR(NIF),
	ADD FOREIGN KEY(CIF) REFERENCES P3_EMPRESA(CIF);

ALTER TABLE P3_PERCEPCION 
	ADD FOREIGN KEY(conTipo) REFERENCES P3_CONCTIPO(conTipo),
	ADD FOREIGN KEY(numContrato) REFERENCES P3_CONTRATO(numContrato);

ALTER TABLE P3_TRABAJADOR 
	ADD FOREIGN KEY(NIF) REFERENCES P3_CONTRATO(NIF);
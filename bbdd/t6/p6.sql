USE 22_db_Juan_nominas;

DROP TABLE IF EXISTS EMPRESA;
CREATE TABLE IF NOT EXISTS EMPRESA(
    CIF VARCHAR(9),
    nombre VARCHAR(50),
    dir VARCHAR(50),
    cp INT(9),
    prov VARCHAR(50),
    ccc BIGINT(11),
    tlf INT(9),
    PRIMARY KEY(CIF)
); 

DROP TABLE IF EXISTS TRABAJADOR;
CREATE TABLE IF NOT EXISTS TRABAJADOR(
    NIF VARCHAR(50),
    nombre VARCHAR(50),
    ape1 VARCHAR(50),
    ape2 VARCHAR(50),
    tlf INT(9),
    nss BIGINT(12),
    catID INT(9),
    cotID INT(9),
	numContrato INT(9) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(NIF)
); 

DROP TABLE IF EXISTS TLF;
CREATE TABLE IF NOT EXISTS TLF(
    ID INT(9),
    pre INT(3),
    TLF INT(9),
    PRIMARY KEY(ID) 
); 

DROP TABLE IF EXISTS CONTRATO;
CREATE TABLE IF NOT EXISTS CONTRATO(
    numContrato INT(9) NOT NULL AUTO_INCREMENT,
    fAlta DATE,
    fBaja DATE,
    codContrato INT(9),
    NIF VARCHAR(9),
    CIF VARCHAR(9),
    PRIMARY KEY(numContrato)
); 

DROP TABLE IF EXISTS TCONTRATO;
CREATE TABLE IF NOT EXISTS TCONTRATO(
    codContrato INT(9),
    nombre VARCHAR(50),
    PRIMARY KEY(codContrato)
); 

DROP TABLE IF EXISTS CAT
CREATE TABLE IF NOT EXISTS CAT(
        ID INT(9),
        nombreCat VARCHAR(50),
        PRIMARY KEY(ID)
);  

DROP TABLE IF EXISTS COT
CREATE TABLE IF NOT EXISTS COT(
	ID INT(9),
        grupo VARCHAR(50),
        PRIMARY KEY(ID)
);

DROP TABLE IF EXISTS CONCSALARIO;
CREATE TABLE IF NOT EXISTS CONCSALARIO(
    ID INT(9) NOT NULL AUTO_INCREMENT,
    numContrato INT(9),
    conTipo INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

DROP TABLE IF EXISTS CONCTIPO;
CREATE TABLE IF NOT EXISTS CONCTIPO(
    conTipo INT(9),
    nombre VARCHAR(50),
    Tipo VARCHAR(50),
    PRIMARY KEY(conTipo)
); 

DROP TABLE IF EXISTS BASECOT;
CREATE TABLE IF NOT EXISTS BASECOT(
    ID INT(9),
    numContrato INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

DROP TABLE IF EXISTS BASESTIPO;
CREATE TABLE IF NOT EXISTS BASESTIPO(
    ID INT(9),
    nombre VARCHAR(50),
    porcentaje INT(9),
    PRIMARY KEY(ID)
); 

DROP TABLE IF EXISTS DEDUCCION;
CREATE TABLE IF NOT EXISTS DEDUCCION(
    ID INT(9),
    tipoDeduccion INT(9),
    anho YEAR,
    mes INT(2),
    NIF INT(9),
    numContrato INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

DROP TABLE IF EXISTS TIPOEDUC;
CREATE TABLE IF NOT EXISTS TIPOEDUC(
    tipoDeduccion INT(9),
    nombre VARCHAR(50),
    receptor VARCHAR(50),
    PRIMARY KEY(tipoDeduccion)
); 

DROP TABLE IF EXISTS PERCEPCION;
CREATE TABLE IF NOT EXISTS PERCEPCION(
    ID INT(9),
    numContrato INT(9),
    conTipo INT(9),
    cantidad INT(9),
    PRIMARY KEY(ID)
); 

ALTER TABLE TRABAJADOR ADD FOREIGN KEY(catID) REFERENCES CAT(ID),
ADD FOREIGN KEY(cotID) REFERENCES COT(ID);

ALTER TABLE CONCSALARIO ADD FOREIGN KEY(conTipo) REFERENCES CONCTIPO(conTipo),
ADD FOREIGN KEY(numContrato) REFERENCES CONTRATO(numContrato);

ALTER TABLE CONTRATO ADD FOREIGN KEY(codContrato) REFERENCES TCONTRATO(codContrato),
ADD FOREIGN KEY(NIF) REFERENCES TRABAJADOR(NIF),
ADD FOREIGN KEY(CIF) REFERENCES EMPRESA(CIF);

ALTER TABLE PERCEPCION ADD FOREIGN KEY(conTipo) REFERENCES CONCTIPO(conTipo),
ADD FOREIGN KEY(numContrato) REFERENCES CONTRATO(numContrato);
	
ALTER TABLE TRABAJADOR ADD FOREIGN KEY(NIF) REFERENCES TRABAJADOR(NIF),
ADD FOREIGN KEY(numContrato) REFERENCES CONTRATO(numContrato);
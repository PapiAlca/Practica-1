USE nominas;

CREATE TABLE IF NOT EXISTS `P3_EMPRESA`(
    CIF VARCHAR(10) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    dir VARCHAR(25) NOT NULL,
    cp INT(5) NOT NULL,
    prov VARCHAR(25),
    ccc CHAR(11) NOT NULL,
    tlfID INT(20),
    PRIMARY KEY (CIF)
);

CREATE TABLE IF NOT EXISTS `P3_TRABAJADOR`(
    NIF VARCHAR(20) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    ape1 VARCHAR(25) NOT NULL,
    ape2 VARCHAR(25) NOT NULL,
    tlfID INT(20),
    nss VARCHAR(20) NOT NULL,
    catID INT(5),
    cotID INT(5),
    PRIMARY KEY (NIF)
);

CREATE TABLE IF NOT EXISTS `P3_CAT`(
    ID INT NOT NULL AUTO_INCREMENT,
    nombreCat VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_COT`(
    ID INT NOT NULL AUTO_INCREMENT,
    grupo VARCHAR(25) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_CONTRATO`(
    numContrato INT NOT NULL AUTO_INCREMENT,
    FAlta DATE NOT NULL,
    FBaja DATE,
    codContrato INT(5) NOT NULL,
    NIF VARCHAR(20) NOT NULL,
    CIF VARCHAR(10) NOT NULL,
    PRIMARY KEY (numContrato)
);

CREATE TABLE IF NOT EXISTS `P3_TCONTRATO`(
    codContrato INT(5) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (codContrato)
);

CREATE TABLE IF NOT EXISTS `P3_CONCSALARIO`(
    ID INT NOT NULL AUTO_INCREMENT,
    numContrato INT(5) NOT NULL,
    conTipo VARCHAR(25) NOT NULL,
    cantidad FLOAT(5) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_CONCTIPO`(
    conTipo VARCHAR(25) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(25) NOT NULL,
    PRIMARY KEY (conTipo)
);

CREATE TABLE IF NOT EXISTS `P3_BASESCOT`(
    ID INT NOT NULL AUTO_INCREMENT,
    numContrato INT(5) NOT NULL,
    cantidad FLOAT(5) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_BASESTIPOS`(
    ID INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    porcentaje FLOAT(5),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_DEDUCCION`(
    ID INT NOT NULL AUTO_INCREMENT,
    tipoDeduccion VARCHAR(25) NOT NULL,
    anho INT(4) NOT NULL,
    mes INT(2) NOT NULL,
    NIF VARCHAR(20) NOT NULL,
    cantidad INT(10),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS `P3_TIPODEDUC`(
    tipoDeduccion VARCHAR(25) NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    receptor VARCHAR(25) NOT NULL,
    PRIMARY KEY (tipoDeduccion)

);

ALTER TABLE P3_TRABAJADOR
ADD FOREIGN KEY (catID) REFERENCES P3_CAT(ID),
ADD FOREIGN KEY (cotID) REFERENCES P3_COT(ID);

ALTER TABLE P3_CONTRATO
ADD FOREIGN KEY (codContrato) REFERENCES P3_TCONTRATO(codContrato),
ADD FOREIGN KEY (NIF) REFERENCES P3_TRABAJADOR(NIF),
ADD FOREIGN KEY (CIF) REFERENCES P3_EMPRESA(CIF);

ALTER TABLE P3_CONCSALARIO
ADD FOREIGN KEY (conTipo) REFERENCES P3_CONCTIPO(conTipo),
ADD FOREIGN KEY (numContrato) REFERENCES P3_CONTRATO(numContrato);

ALTER TABLE P3_BASESCOT
ADD FOREIGN KEY (numContrato) REFERENCES P3_CONTRATO(numContrato);

ALTER TABLE P3_DEDUCCION
ADD FOREIGN KEY (tipoDeduccion) REFERENCES P3_TIPODEDUC(tipoDeduccion);
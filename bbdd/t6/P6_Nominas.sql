USE p6_nominas;

-- Creamos las tablas con sus datos:
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS empresas(
	empresa_id int(11),
    CIF VARCHAR(9),
    nombre VARCHAR(50),
    dir VARCHAR(50),
    cp INT(9),
    prov VARCHAR(50),
    ccc BIGINT(11),
    PRIMARY KEY(empresa_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS trabajadores(
	trabajador_id int(11),
    NIF VARCHAR(9),
    nombre VARCHAR(20),
    ape1 VARCHAR(20),
    ape2 VARCHAR(20),
    tlf INT(9),
    nss BIGINT(12),
    categoria_id INT(11),
    cotizacion_id INT(1),
    PRIMARY KEY(trabajador_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS contratos(
    contrato_id INT(9) NOT NULL AUTO_INCREMENT,
    fAlta DATE,
    fBaja DATE,
    tipo_de_contrato_id INT(9),
    trabajador_id int(11),
    empresa_id int(11),
    PRIMARY KEY(contrato_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS tipos_de_contrato(
    tipo_de_contrato_id INT(9),
    nombre VARCHAR(50),
    PRIMARY KEY(tipo_de_contrato_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS categorias(
        categoria_id INT(11),
        nombre_categoria VARCHAR(50),
        PRIMARY KEY(categoria_id)
);  

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS cotizaciones(
	cotizacion_id INT(11),
    grupo VARCHAR(50),
    PRIMARY KEY(cotizacion_id)
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS conceptos_de_salario(
    concepto_id INT(11) NOT NULL AUTO_INCREMENT,
    contrato_id INT(11),
    tipo_de_concepto_id INT(11),
    cantidad INT(11),
    PRIMARY KEY(concepto_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS tipos_de_conceptos(
    tipo_de_concepto_id INT(11),
    nombre VARCHAR(20),
    tipo int(11),
    PRIMARY KEY(tipo_de_concepto_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS bases_de_cotizacion(
    base_cot_id INT(11),
    contrato_id INT(11),
    cantidad INT(11),
    PRIMARY KEY(base_cot_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS tipos_aplicables(
    tipo_base_id INT(11),
    nombre VARCHAR(20),
    porcentaje INT(11),
    PRIMARY KEY(tipo_base_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS deducciones(
    deduccion_id INT(11),
    tipo_deduccion_id INT(11),
    anho int(11),
    mes INT(11),
    trabajador_id INT(11),
    contrato_id INT(11),
    cantidad INT(11),
    PRIMARY KEY(deduccion_id)
); 

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS tipos_deducciones(
    tipo_deduccion_id INT(11),
    nombre VARCHAR(20),
    receptor VARCHAR(20),
    PRIMARY KEY(tipo_deduccion_id)
); 

-- Creamos las foreign key:
-- --------------------------------------------------------
ALTER TABLE trabajadores 
	ADD FOREIGN KEY(categoria_id) REFERENCES categorias(categoria_id),
	ADD FOREIGN KEY(cotizacion_id) REFERENCES cotizaciones(cotizacion_id);

-- --------------------------------------------------------
ALTER TABLE contratos 
	ADD FOREIGN KEY(tipo_de_contrato_id) REFERENCES tipos_de_contrato(tipo_de_contrato_id),
	ADD FOREIGN KEY(trabajador_id) REFERENCES trabajadores(trabajador_id),
	ADD FOREIGN KEY(empresa_id) REFERENCES empresas(empresa_id);

-- --------------------------------------------------------
ALTER TABLE conceptos_de_salario
	ADD FOREIGN KEY(contrato_id) REFERENCES contratos(contrato_id),
	ADD FOREIGN KEY(tipo_de_concepto_id) REFERENCES tipos_de_conceptos(tipo_de_concepto_id);

-- --------------------------------------------------------
ALTER TABLE deducciones
ADD FOREIGN KEY (tipo_deduccion_id) REFERENCES tipos_deducciones(tipo_deduccion_id),
ADD FOREIGN KEY (trabajador_id) REFERENCES trabajadores(trabajador_id),
ADD FOREIGN KEY (contrato_id) REFERENCES contratos(contrato_id);

-- --------------------------------------------------------
ALTER TABLE bases_de_cotizacion
ADD FOREIGN KEY (contrato_id) REFERENCES contratos(contrato_id);

-- --------------------------------------------------------

-- Insertamos los datos de la base de datos:
-- --------------------------------------------------------
INSERT INTO `categorias` (`categoria_id`, `nombre_categoria`) VALUES
	(1, 'Ing. y licenciados'),
	(2, 'Ing. tec. y tit. ayudantes'),
	(3, 'Jefes ad y de taller'),
	(4, 'Ayud no titulados');
-- ---------------------------------------------------------	
INSERT INTO `cotizaciones` (`cotizacion_id`, `grupo`) VALUES
(1, 'Grupo 1'),
(2, 'Grupo 2'),
(3, 'Grupo 3'),
(4, 'Grupo 4');

-- --------------------------------------------------------
INSERT INTO `empresas` (`empresa_id`, `cif`, `nombre`, `dir`, `cp`, `prov`, `ccc`) VALUES
(1, 'A00000001', 'Bar Pepe, S.L.', 'c/Portugual 27B', 6001, 'Badajoz', 6123456701),
(2, 'B00000001', 'Alimentación Manolo', 'Avda/ Elvas S/N', 6008, 'Badajoz', 6765432199),
(3, 'G11111111', 'Asoc. Informaticos en Paro', 'Av. Santiago Ramón y Cajal', 6003, 'Badajoz', 6761432199);

-- --------------------------------------------------------
INSERT INTO `trabajadores` (`trabajador_id`, `nif`, `nombre`, `ape1`, `ape2`, `nss`, `categoria_id`, `cotizacion_id`) VALUES
(1, '12345678A', 'Pepe', 'González', 'Gutierrez', 61234567812, 3, 3),
(2, '87654321Z', 'Marina', 'Antúnez', 'Pérez', 68765432134, 2, 2),
(3, '34654321Z', 'Luis', 'Martínez', 'Sánchez', 102567832134, 4, 4);

-- --------------------------------------------------------
INSERT INTO `tipos_de_contrato` (`tipo_de_contrato_id`, `nombre`) VALUES
(100, 'Indef., T.C., ordinario'),
(109, 'Indef., T.C., fomento contratación'),
(130, 'Indef., T.C., discapacitados'),
(200, 'Indef., T.P.,ordinario'),
(209, 'Indef., T.P.,fomento contratación'),
(402, 'Dur det., T.C., eventual producción'),
(403, 'Dur det.,T.C., inserción'),
(420, 'Dur det., T.C., prácticas'),
(421, 'Temporal, T.C., formación');

-- --------------------------------------------------------
INSERT INTO `contratos` (`contrato_id`, `fAlta`, `fBaja`, 
			`tipo_de_contrato_id`, `trabajador_id`, `empresa_id`) VALUES
(1, '2022-01-01', '2022-03-31', 420, 2, 1),
(2, '2022-07-01', '2022-09-30', 421, 1, 2),
(3, '2022-04-01', NULL, 109, 2, 1),
(4, '2022-10-01', NULL, 200, 1, 2);

-- --------------------------------------------------------
INSERT INTO `tipos_de_conceptos` (`tipo_de_concepto_id`, `nombre`, `tipo`) VALUES
(1, 'Salario base', 1),
(2, 'Plus de convenio', 1),
(3, 'Antigüedad', 1),
(4, 'Nocturnidad', 1),
(5, 'Guardias', 1),
(6, 'Comisiones', 1),
(7, 'Horas extra', 1),
(8, 'Pro. Pagas Extra', 1),
(9, 'Incentivos', 1),
(10, 'Plus de peligrosidad', 0),
(11, 'Plus de transporte', 0),
(12, 'Ropa de trabajo', 0);

-- --------------------------------------------------------
INSERT INTO `conceptos_de_salario` (`concepto_id`, `contrato_id`, `tipo_de_concepto_id`, `cantidad`) VALUES
(1, 1, 1, 1000),
(2, 1, 2, 80),
(3, 2, 1, 1100),
(4, 2, 11, 50),
(5, 3, 1, 1000),
(6, 3, 2, 80),
(7, 3, 5, 100),
(8, 4, 1, 1100),
(9, 4, 7, 70),
(10, 4, 11, 50);

-- --------------------------------------------------------

-- Paso 1 de la Nómina: Crear Procedimiento datos_del_Trabajador():
DELIMITER $$
	CREATE PROCEDURE datos_del_Trabajador()
	BEGIN
		SELECT t.NIF, t.nombre, t.ape1, t.ape2, t.tlf, cat.nombre_categoria, cotiz.grupo FROM trabajadores t
			INNER JOIN categorias cat on t.trabajador_id = cat.categoria_id
			INNER JOIN cotizaciones cotiz on t.trabajador_id = cotiz.cotizacion_id;
END$$


-- Haz esta sentencia para llamar al procedimiento: CALL datos_del_Trabajador();

-- --------------------------------------------------------

-- Paso 2 de la Nómina: 
DELIMITER $$
	CREATE PROCEDURE datos_de_la_Empresa()
	BEGIN
		SELECT CIF, nombre, dir, cp, prov, ccc FROM empresas;
END$$

-- Haz esta sentencia para llamar al procedimiento:CALL datos_de_la_Empresa();

-- --------------------------------------------------------

-- Paso 3 de la Nómina: Crear funcion dias_trabajados()

-- --------------------------------------------------------

-- Funcion generar_fecha():
DELIMITER $$
CREATE FUNCTION generar_fecha(mes INT, anho INT) RETURNS DATE
BEGIN
    DECLARE fecha DATE;
    SET fecha = CONCAT(anho, '-', mes, '-01');
    RETURN fecha;
END $$
DELIMITER ;

-- --------------------------------------------------------

-- Funcion dias_trabajados():
DELIMITER $$
CREATE FUNCTION dias_trabajados(mes INT, anho INT, contratoID INT) RETURNS INT
BEGIN
    DECLARE f_ini DATE;
    DECLARE f_fin DATE;
    DECLARE f_alta DATE;
    DECLARE f_baja DATE;
    DECLARE f_3 DATE;
    DECLARE f_1 DATE;
    DECLARE f_2 DATE;
    DECLARE dias INT DEFAULT 0;

    #-- crear fecha inicio mes
    SET f_ini := generar_fecha(mes, anho);

    #-- crear fecha fin de mes
    SET f_fin := LAST_DAY(f_ini);

    #-- crear fecha baja virtual(nula)
    SELECT fAlta, fBaja from contratos WHERE contrato_id = contratoID INTO f_alta, f_baja;
    SET f_baja := IFNULL(f_baja, '2199-12-31');

    -- PRIMER DIA TRABAJADO DE ESE MES
    IF (f_ini > f_alta) THEN SET f_1 := f_ini;
    ELSE SET f_1 := f_alta;
    END IF;

    -- ÚLTIMO DIA TRABAJADO DE ESE MES
    IF (f_baja > f_fin) THEN SET f_2 := f_fin;
    ELSE SET f_2 := f_baja;
    END IF;

    -- DETERMINACION DE DIAS TRABAJADOS
    SET dias := DATEDIFF(f_2, f_1) + 1;
    IF (dias > 30) THEN SET dias := 30;
    END IF;

    -- Si estamos en febrero...
    IF (mes = 2) THEN
        IF (dias = DATEDIFF(f_fin, f_ini) + 1) THEN
            SET dias := 30;
        END IF;
    END IF;

    RETURN dias;
END $$
DELIMITER ;

-- --------------------------------------------------------

-- Paso 4 de la Nómina: Crear funcion hallar_devengos():

DELIMITER $$
CREATE FUNCTION hallar_devengos( contratoID INT) RETURNS INT
BEGIN 
	DECLARE salario_total INT;
	DECLARE dias INT;
	DECLARE devengos INT;
	
	SELECT SUM(cantidad) FROM conceptos_de_salario WHERE contrato_id = contratoID INTO salario_total;
	SET dias := dias_trabajados(mes, anho, contratoID);
	SET devengos := (dias/30) * salario_total;
	
	
	RETURN devengos
END$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION hallar_devengos(contratoID INT) RETURNS INT
BEGIN 
    DECLARE salario_total INT;
    DECLARE dias INT;
    DECLARE devengos INT;
    
    SELECT SUM(cantidad) FROM conceptos_de_salario WHERE contrato_id = contratoID INTO salario_total;
    SET dias = dias_trabajados(mes, anho, contratoID);
    SET devengos = ROUND((dias/30.0) * salario_total); -- Agregamos la función ROUND para redondear el resultado a un número entero
    
    RETURN devengos;
END$$
DELIMITER ;
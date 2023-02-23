USE 22_db_Juan;
-- Ejercicio 1:
DROP PROCEDURE IF EXISTS verContrato;
DELIMITER //
CREATE PROCEDURE verContrato(IN numContrato INT)
BEGIN
    DECLARE nombreModalidad VARCHAR(50);
    
    SELECT a.NIF, a.nombre, a.ape1, b.CIF, b.nombre, b.prov, c.fAlta, c.fBaja, c.codContrato
    INTO @NIF, @nombre, @ape1, @CIF, @nombreEmp, @provEmp, @fAlta, @fBaja, @codContrato
    FROM P3_TRABAJADOR a
    INNER JOIN P3_CONTRATO c ON a.numContrato = c.numContrato;
    INNER JOIN P3_EMPRESA b ON b.CIF = c.CIF;
    WHERE c.numContrato = a.numContrato;
    
    SELECT nombreMod
    INTO @nombreModalidad
    FROM modalidad_contrato
    WHERE codContrato = @codContrato;
    
    SELECT 'NIF: ', @NIF, ', Nombre: ', @nombre, ', Apellido: ', @ape1, 
           ', CIF: ', @CIF, ', Nombre Empresa: ', @nombreEmp, ', Provincia: ', @provEmp, 
           ', Fecha Alta: ', @fAlta, ', Fecha Baja: ', @fBaja, ', Código Contrato: ', @codContrato, 
           ', Modalidad: ', @nombreModalidad;
END //
DELIMITER ;
		
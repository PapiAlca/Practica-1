-- Ejercicio 1:
DELIMITER $$
CREATE FUNCTION fecha (fecha_mariaDB DATE)
	RETURNS VARCHAR(10)
	BEGIN
	DECLARE fecha VARCHAR(10);
	SET fecha = DATE_FORMAT(fecha_mariaDB, '%d-%m-%Y');
  RETURN fecha;
END$$
DELIMITER ;

-- Ejercicio 2:
DROP TABLE IF EXISTS ejercicio2;
CREATE TABLE ejercicio2 AS (
	SELECT employee_id, fecha(start_date), fecha(end_date), job_id, department_id FROM job_history
		LIMIT 3);
		
-- Ejercicio 3:
DELIMITER $$
CREATE FUNCTION tlf (phone VARCHAR(20)) 
	RETURNS VARCHAR(20) 
	BEGIN 
	DECLARE mascara VARCHAR(20); 
	SET mascara = CONCAT('***.' + phone + '.' + phone + '***'); 
	RETURN mascara; 
END $$;
DELIMITER


-- Ejercicio 4:
DROP TABLE IF EXISTS ejercicio4;
CREATE TABLE ejercicio4 AS (
	SELECT employee_id, first_name, tlf(phone_number) FROM employees
		LIMIT 3);
-- Examen de BBDD Tema 4 --- 13 de Enero de 2023 
-- autor: Juan Parejo García
-- ·Ejercicio 1:
SELECT customer_id, product_id, quantity FROM orders, order_items 
	WHERE quantity >= 1 ORDER BY quantity;
	
-- ·Ejercicio 2:
SELECT i.product_id FROM stocks i
	LEFT OUTER JOIN products d ON d.product_id = i.product_id
	WHERE i.quantity = NULL;
	
-- ·Ejercicio 3
SELECT category_id FROM products
	GROUP BY MAX(product_id) LIMIT 1;
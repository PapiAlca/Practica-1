-- Muestra todos los compradores que tengan más de una compra.
	SELECT first_name, last_name FROM customers WHERE customer_id IN(
		SELECT customer_id FROM orders GROUP BY customer_id HAVING(COUNT(customer_id) > 1)
	);
-- Lista aquellos productos sin stock.
	SELECT product_name FROM products WHERE product_id IN ( 
		SELECT product_id FROM stocks GROUP BY quantity WHERE quantity = NULL;
	);

-- Lista aquellos productos con un stock menor de 3 unidades en orden ascendente. 
-- Lista los 4 productos con más stock: LIMIT 4
-- En la empresa
-- Por cada tienda
-- Determina el dinero bloqueado en ese stock por empresa y en cada tienda.
-- Y en todo el stock de la empresa por empresa y en cada tienda ordenados por los compradores del más gastoso al menos
-- Lista sólo los 10 más gastosos ordenados por compradores del que más productos ha comprado al que menos.
-- Lista sólo los 5 compradores que más productos han comprado, ordenados por productos vendidos y por cantidad facturada.
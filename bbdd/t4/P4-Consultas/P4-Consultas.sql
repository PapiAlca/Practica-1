USE 22_db_tiendaBicis
select ' Muestra todos los compradores que tengan más de una compra.';
	SELECT first_name, last_name FROM customers WHERE customer_id IN(
		SELECT customer_id FROM orders GROUP BY customer_id HAVING(COUNT(customer_id) > 1)
	);
select ' Lista aquellos productos sin stock.';	SELECT product_name FROM products WHERE product_id IN( 
		SELECT product_id FROM stocks WHERE quantity = 0 
	);

select ' Lista aquellos productos con un stock menor de 3 unidades en orden ascendente.';	SELECT p.product_name FROM products p
		LEFT JOIN stocks s
		ON p.product_id = s.product_id
		WHERE s.quantity IS NULL OR s.quantity = 0;
	
select ' Lista los 4 productos con más stock: LIMIT 4';select ' En la empresa:';	SELECT b.brand_name, p.product_name, s.quantity
		FROM products p
		INNER JOIN brands b ON p.brand_id = b.brand_id
		INNER JOIN stocks s ON p.product_id = s.product_id
		ORDER BY b.brand_name, s.quantity DESC LIMIT 4;

select ' Por cada tienda:';	SELECT t.store_name, p.product_name, s.quantity FROM stores t
		INNER JOIN stocks s ON t.store_id = s.store_id
		INNER JOIN productos p ON s.product_id = p.product_id
		WHERE s.quantity > 0
		ORDER BY t.store_name, s.quantity DESC LIMIT 4;

select ' Determina el dinero bloqueado en ese stock por empresa y en cada tienda:';	SELECT b.brand_name, p.product_name, SUM(oi.quantity * oi.list_price) AS dinero_bloqueado FROM products p
		INNER JOIN brands b ON p.brand_id = b.brand_id
		INNER JOIN (
			SELECT product_id, quantity FROM stocks
				WHERE store_id = 1 AND quantity > 0
				ORDER BY quantity DESC LIMIT 4
		) s ON p.product_id = s.product_id
		INNER JOIN order_items oi ON oi.product_id = p.product_id
		GROUP BY b.brand_name, p.product_name;

select ' Y en todo el stock de la empresa por empresa y en cada tienda ordenados por los compradores del más gastoso al menos:';	
	SELECT c.first_name, c.last_name, SUM(oi.list_price * oi.quantity) AS total_gastado FROM customers c
		INNER JOIN orders o ON c.customer_id = o.customer_id
		INNER JOIN order_items oi ON o.order_id = oi.order_id
		GROUP BY c.customer_id
		ORDER BY total_spent DESC;

select ' Lista sólo los 10 más gastosos ordenados por compradores del que más productos ha comprado al que menos.';	SELECT c.first_name, c.last_name, SUM(order_items.list_price * order_items.discount) AS total_gastado FROM customers c
		INNER JOIN orders o ON c.customer_id = o.customer_id
		INNER JOIN order_items ON o.order_id = order_items.order_id
		GROUP BY c.customer_id 
		ORDER BY `total_gastado` DESC LIMIT 10
	
select ' Lista sólo los 5 compradores que más productos han comprado, ordenados por productos vendidos y por cantidad facturada.';	SELECT c.first_name, c.last_name, COUNT(DISTINCT order_items.product_id) AS cantidad_productos FROM customers c
		INNER JOIN orders o ON c.customer_id = o.customer_id
		INNER JOIN order_items ON o.order_id = order_items.order_id
		GROUP BY c.customer_id
		ORDER BY cantidad_productos DESC LIMIT 5;
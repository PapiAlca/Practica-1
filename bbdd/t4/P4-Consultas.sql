USE 22_db_tiendaBicis

SELECT (SELECT 'Muestra todos los compradores que tengan más de una compra.' AS 'Ejercicio 1');
	SELECT first_name, last_name FROM customers WHERE customer_id IN(
		SELECT customer_id FROM orders GROUP BY customer_id HAVING(COUNT(customer_id) > 1)
	);
	
SELECT (SELECT 'Lista aquellos productos sin stock.' AS 'Ejercicio 2');	
	SELECT p.product_name FROM products p
		LEFT JOIN stocks s ON p.product_id = s.product_id
		WHERE s.quantity IS NULL
		GROUP BY p.product_name
		HAVING COUNT(DISTINCT s.store_id) = 3;
		
SELECT (SELECT 'Lista aquellos productos con un stock menor de 3 unidades en orden ascendente.' AS 'Ejercicio 3');
	SELECT p.product_name, s.quantity FROM products p 
		INNER JOIN stocks s ON p.product_id = s.product_id 
		WHERE s.quantity < 3 
		ORDER BY s.quantity ASC;
	
SELECT 'Lista los 4 productos con más stock:';

SELECT (SELECT 'En la empresa:' AS 'Ejercicio 4');
	SELECT p.product_name, SUM(stocks.quantity) AS "stocks.quantity" FROM products p 
		INNER JOIN stocks ON p.product_id = stocks.product_id 
		GROUP BY p.product_name 
        ORDER BY SUM(stocks.quantity) DESC 			
        LIMIT 4;

SELECT (SELECT 'Por cada tienda:' AS 'Ejercicio 5');
	SELECT 'Tienda 1';
	SELECT st.store_id, st.store_name, p.product_name, SUM(s.quantity) as cantidad FROM stocks s 
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 1 
		GROUP BY s.store_id, s.product_id 
		ORDER BY SUM(s.quantity) DESC 
		LIMIT 4;
		
	SELECT 'Tienda 2';	
	SELECT st.store_id, st.store_name, p.product_name, SUM(s.quantity) as cantidad FROM stocks s 
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 2 
		GROUP BY s.store_id, s.product_id 
		ORDER BY SUM(s.quantity) DESC 
		LIMIT 4;
	
	SELECT 'Tienda 3';
	SELECT st.store_id, st.store_name, p.product_name, SUM(s.quantity) as cantidad FROM stocks s 
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 3 
		GROUP BY s.store_id, s.product_id 
		ORDER BY SUM(s.quantity) DESC 
		LIMIT 4;	
	
SELECT (SELECT 'Determina el dinero bloqueado en ese stock por empresa y en cada tienda:'AS 'Ejercicio 6');	
	SELECT p.product_name, SUM(s.quantity) as cantidad, SUM(p.list_price * s.quantity) AS dinero_bloqueado_stock_total FROM products p
		INNER JOIN stocks s ON s.product_id = p.product_id 
		GROUP BY s.product_id 
		ORDER BY SUM(s.quantity) DESC  
		LIMIT 4;

	SELECT st.store_name, p.product_name, SUM(s.quantity) as cantidad, SUM(p.list_price * s.quantity) AS dinero_bloqueado_stock_tienda1 FROM stocks s
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 1 
		GROUP BY s.product_id 
		ORDER BY s.store_id, SUM(s.quantity) DESC 
		LIMIT 4;

	SELECT st.store_name, p.product_name, SUM(s.quantity) as cantidad, SUM(p.list_price * s.quantity) AS dinero_bloqueado_stock_tienda2 FROM stocks s
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 2 
		GROUP BY s.product_id 
		ORDER BY s.store_id, SUM(s.quantity) DESC 
		LIMIT 4;

	SELECT st.store_name, p.product_name, SUM(s.quantity) as cantidad, SUM(p.list_price * s.quantity) AS dinero_bloquado_stock_tienda3 FROM stocks s
		INNER JOIN stores st ON s.store_id = st.store_id
		INNER JOIN products p ON s.product_id = p.product_id 
		WHERE s.store_id = 3 
		GROUP BY s.product_id 
		ORDER BY s.store_id, SUM(s.quantity) DESC 
		LIMIT 4;
				
SELECT (SELECT 'Y en todo el stock de la empresa por empresa y en cada tienda ordenados por los compradores del más gastoso al menos:' AS 'Ejercicio 7');
	SELECT SUM(s.quantity * p.list_price) AS dinero_total_stock FROM stocks s
				INNER JOIN products p ON s.product_id = p.product_id;

	SELECT store_name, SUM(list_price * quantity) AS dinero_tienda_stock FROM products 
				INNER JOIN stocks ON products.product_id = stocks.product_id 
				INNER JOIN stores ON stocks.store_id = stores.store_id 
				GROUP BY store_name;
				
SELECT (SELECT 'Lista sólo los 10 más gastosos ordenados por compradores del que más productos ha comprado al que menos.' AS 'Ejercicio 8');	
	SELECT c.first_name, c.last_name, SUM(order_items.list_price * order_items.discount) AS total_gastado FROM customers c
		INNER JOIN orders o ON c.customer_id = o.customer_id
		INNER JOIN order_items ON o.order_id = order_items.order_id
		GROUP BY c.customer_id 
		ORDER BY `total_gastado` DESC LIMIT 10
	
SELECT (SELECT 'Lista sólo los 5 compradores que más productos han comprado, ordenados por productos vendidos y por cantidad facturada.' AS 'Ejercicio 9');	
	SELECT c.first_name, c.last_name, COUNT(DISTINCT order_items.product_id) AS cantidad_productos FROM customers c
		INNER JOIN orders o ON c.customer_id = o.customer_id
		INNER JOIN order_items ON o.order_id = order_items.order_id
		GROUP BY c.customer_id
		ORDER BY cantidad_productos DESC LIMIT 5;
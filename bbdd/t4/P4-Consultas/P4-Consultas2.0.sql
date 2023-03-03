-- Lista los 4 productos con más stock:

-- En la empresa:
SELECT b.brand_name, p.product_name, s.quantity
	FROM products p
	INNER JOIN brands b ON p.brand_id = b.brand_id
	INNER JOIN stocks s ON p.product_id = s.product_id
		ORDER BY b.brand_name, s.quantity DESC LIMIT 4;

-- Por cada tienda:
SELECT t.store_name, p.product_name, s.quantity FROM stores t
	INNER JOIN stocks s ON t.store_id = s.store_id
	INNER JOIN productos p ON s.product_id = p.product_id
		WHERE s.quantity > 0
		ORDER BY t.store_name, s.quantity DESC LIMIT 4;

-- Determina el dinero bloqueado en ese stock por empresa y en cada tienda:
SELECT b.brand_name, p.product_name, SUM(oi.quantity * oi.list_price * oi.discount) AS blocked_money
FROM products p
JOIN brands b ON p.brand_id = b.brand_id
JOIN (
  SELECT product_id, quantity
  FROM stocks
  WHERE store_id = 1 AND quantity > 0
  ORDER BY quantity DESC
  LIMIT 4
) s ON p.product_id = s.product_id
JOIN order_items oi ON oi.product_id = p.product_id
GROUP BY b.brand_name, p.product_name;

-- Y en todo el stock de la empresa por empresa y en cada tienda ordenados por los compradores del más gastoso al menos:
SELECT c.first_name, c.last_name, SUM(order_items.quantity) AS total_comprado, 
       brands.brand_name, t.store_name, 
       SUM(order_items.quantity * (p.list_price - p.list_price * order_items.discount) * s.quantity) AS blocked_money
FROM orders o 
INNER JOIN customers c ON c.customer_id = o.customer_id
INNER JOIN order_items ON o.order_id = order_items.order_id
INNER JOIN products p ON order_items.product_id = p.product_id
INNER JOIN stocks s ON p.product_id = s.product_id
INNER JOIN stores t ON s.store_id = t.store_id
INNER JOIN brands ON p.brand_id = brands.brand_id
WHERE t.store_id = 1
GROUP BY brands.brand_name, t.store_name, c.customer_id
ORDER BY total_comprado DESC;

-- Lista sólo los 10 más gastosos ordenados por compradores del que más productos ha comprado al que menos.
SELECT c.first_name, c.last_name, SUM(order_items.list_price * order_items.discount) AS total_gastado
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items ON o.order_id = order_items.order_id
GROUP BY c.customer_id 
ORDER BY `total_gastado` DESC LIMIT 10
	

-- Lista sólo los 5 compradores que más productos han comprado, ordenados por productos vendidos y por cantidad facturada.
SELECT c.first_name, c.last_name, COUNT(DISTINCT order_items.product_id) AS cantidad_productos
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items ON o.order_id = order_items.order_id
GROUP BY c.customer_id
ORDER BY cantidad_productos DESC
LIMIT 5;

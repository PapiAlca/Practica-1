# Práctica 4 de Bases de Datos. Consultas

* Muestra todos los compradores que tengan más de una compra.
* Lista aquellos productos sin stock.
SELECT * FROM products WHERE product_id NOT IN( SELECT  );

* Lista aquellos productos con un stock menor de 3 unidades en orden ascendente.
* Lista los 4 productos con más stock:
* En la empresa
* Por cada tienda
* Determina el dinero bloqueado en ese stock por empresa y en cada tienda.
* Y en todo el stock de la empresa por empresa y en cada tienda ordenados por los compradores del más gastoso al menos
* Lista sólo los 10 más gastosos ordenados por compradores del que más productos ha comprado al que menos.
* Lista sólo los 5 compradores que más productos han comprado, ordenados por productos vendidos y por cantidad facturada.
USE cuentas;

INSERT INTO persona VALUES
	(
		"1111111a", "Juan", "Parejo", "Plaza España", 313313313
	),
	(	
		"22222222b", "Pablo", "Verdejo", "Plaza España", 616616616
	),
	(	
		"33333333c", "Miguel", "Calles", "Plaza España", 616616617
	),
	(	
		"44444444d", "José", "Pardo", "Plaza España", 616616618
	),
	(	
		"55555555e", "José Antonio", "Ballester", "Plaza España", 616616619
	);

INSERT INTO cliente VALUES
	(
		null, "1111111a"
	),
	(
		null, "33333333c"
	),
	(
		null, "55555555e"
	);

INSERT INTO trabajador VALUES
	(
		null, "22222222b", null
	),
	(
		null, "44444444d", null
	);
	
INSERT INTO cahorro (numCuenta, saldo, numCliente) VALUES
	(null, 0, 1),
    (null, 50, 2),
    (null, 110, 3),
    (null, 115, 3);

INSERT INTO ccorriente (numCuenta, saldo, numCliente, numCuentaA) VALUES
    (null, 1500, 1, 1),
    (null, 500, 2, 2),
    (null, 3000, 2, 3),
    (null, 2500, 3, 4);
# Práctica 3 JavaBasicIO
Este ejercicio pese a que se haga en la misma clase main, consta de dos apartados la parte de los usuarios, \
y la de obtener el resto y que salga con colores por pantalla: 
## Introducción
+ Antes de crear el main etc... Lo primero que haremos será importar la clase scanner e insertar dos finals, que seran ANSI_AZUL y ANSI_ROJO.
+ Estos finals lo que harán será poner de colores a los elementos que hayamos seleccionado anteriormente, que saldrán por pantalla.
+ Luego una vez ya creado el main, crearemos las variables de tipo int, y una variable de tipo Scanner que usaremos más tarde.
## Parte 1 Obtencion de Usuario
+ Para sacar el usuario por pantalla crearemos una variable de tipo String llamada username que tendrá como valor System.getProperty("user.name");
+ Y para sacar el nombre del sistema operativo crearemos otra variable de tipo String llamada sistemaname que tendrá como valor System.getProperty("os.name");
+ Luego para sacar el nombre por pantalla utilizaremos la sentencia System.out.println("El nombre de usuario es : " + username);
+ Y para sacar el nombre del sistema operativo utilizaremos la sentencia System.out.println("El nombre del sistema operativo : " + sistemaname);
## Parte 2 Obtencion de un módulo de dos operadores
+ Para obtener un módulo o el resto de la división entre dos operadores lo primero que tenemos que hacer es insertar los valores de las variables operador1, y operador2 con el Scanner.
+ El resto lo conseguiremos con esta sentencia: resto = operador1 % operador2;
+ Y para finalizar y poner los colores utilizaremos esta ultima sentencia System.out.println(ANSI_AZUL+operador1+"/"+operador2+ "=" + modulo + ANSI_ROJO + " El resto del modulo es: " + resto);
### Y aquí el resultado de la práctica:
![Imagen 2](/Programacion/P3-BasicIO/img/captura1.png)
![Imagen 2](/Programacion/P3-BasicIO/img/captura2.png)

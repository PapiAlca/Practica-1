# Práctica del Tema 6 Posicionamiento de brazos robóticos.
## Como Hacerlo:
### Paso 1: Crear la clase y desarrollar el método float[] cinematicaInversa2D(int x, int y).
Crearemos el método statico float[] cinematicaInversa2D() en donde e insertaremos las cordenadas x e y de nuestros¡ brazo robótico y nos dará un  array con los ángulos \
que le corresponden. Dentro del método habrá varias variables de tipo double ya que sino no podremos usar los métodos de la clase Math importada, algunas de ellas como \
q1Double y q2Double más tarde las cambiaremos a tipo float. Y por último l será la longitud de cada brazo que tendrá el valor de 1.

### Paso 2: Usar los métodos de la clase Math para realizar las cuentas necesarias.
![Imagen](/Programacion/.img/Anotaciones.png) \
Todas esas líneas son donde hago todas las cuentas para obtener los ángulos q1 y q2.

### Paso 3: Pasar de radianes a grados y de double a float.
Para pasar de radianes a grados lo que tendrémos que hacer es multiplicar nuestra variable(q1 o q2) por 180 y dividirla entre PI. \
Luego despues de pasar de radianes a grados cambiaremos las variables q1 y q2 por otras de tipo float que es los que nos pide en el ejercicio. \
![Imagen](/Programacion/.img/Anotaciones2.png)

### Paso 4 Por último creamos nuestro array, lo imprimiremos por pantalla y usaremos el método en el main.
Creamos nuestro array en donde su contenido serán los dos ángulos dados(q1, q2), lo imprimimos por pantalla y cerramos el método. \
Creamos nuestro método main en donde pondremos a prueba nuestro programa.

## Pruebas:
### X = 0, Y = 0:
![Imagen](/Programacion/.img/T6-Prueba1.png)
### X = 10, Y = 0:
![Imagen](/Programacion/.img/T6-Prueba2.png)
### X = 0, Y = 10:
![Imagen](/Programacion/.img/T6-Prueba3.png)
### X = 10, Y = 10:
![Imagen](/Programacion/.img/T6-Prueba4.png)
### X = 5, Y = 7:
![Imagen](/Programacion/.img/T6-Prueba5.png)

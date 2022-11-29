# Práctica 4  POO
## Clase Libro:
![Imagen 1](/Programacion/P4-POO/T4-POO-Libro/Libro/Libro.java) \
Esta clase la definimos como el objeto, y para ello deberemos creas sus respectivas variables, incluyendo la variable importada scanner, sus dos constructores, y sus getters y setters. \
A continuación crearemos los siguientes métodos para utilizarlos en la clase main:
+ prestamo() de tipo boolean, que nos dirá sí el libro que hemos escogido está prestado o no, en el caso de que lo escojamos pondrá que el libro está prestado hasta que se devuelva.
+ devolucion() de tipo boolean, que nos dirá sí el libro se ha devuelto el libro o no, en el caso de que lo devolvamos cambiará el estado del libro a devuelto.
+ toString() de tipo String, nos mostrará toda la información de los atributos de los objetos que usemos.
## Clase ProbarLibro:
![Imagen 2](/Programacion/P4-POO/T4-POO-Libro/Libro/ProbarLibro.java) \
Esta es la clase main donde utilizaremos el objeto Libro. 
+ Empezaremos creando dos objetos Libro, uno por defecto y otro con los datos que nos piden(como nos pide el enunciado).
+ Utilizaremos el método prestamo() con los dos Libros creados (n1 y n2), para ver si podemos llevar ambos libros.
+ Luego sacaremos por pantalla ambos libros para mostrar sus atributos.
+ A continuación utilizaremos el metodo devolucion() para devolver ambos libros (n1, n2)
+ Y por último comprobaremos los atributos de ambos objetos para saber su estado.

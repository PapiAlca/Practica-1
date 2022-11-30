# Práctica 5 Estructuras de Control
Esta práctica esta definida por 3 clases que he creado: Clase Objeto Nodo, Clase Objeto Arbol y Clase Main ProbarArbol
## Clase Objeto Nodo
### Introducción:
La Clase Nodo tiene 3 variables: una de tipo String (valor), una de tipo int (altura), y una de tipo boolean (hijo).
### Explicación:
+ Esta clase lo que hace es crear un nodo almacenando el valor que tiene, su altura para luego calcular la altura del arbol, y comprobar si ese nodo es hijo de otro nodo
+ Lo primero que nos encontramos en esta clase son dos constructores, uno para introducir valor por valor, y otro a diferencia del primero está pensado para generar el primer nodo del árbol que es solo uno y no es hijo de nadie.
+ Luego tenemos los setters y getters.
+ Y por último nos encontramos con los dos métodos que usaremos en las demás clases:
  + boolean esHijoDe(): es un método que a partir del boolean hijo de cada nodo nos dirá sí es hijo de algun nodo. Para ello mirará si dicho nodo tiene más de 1 de altura.
  + void calcularAltura(): este método lo que hace es calcular la altura que tiene cada nodo y para ello conprobará si ese nodo es hijo de otro nodo.
  
## Clase Objeto Arbol
### Introducción:
La Clase Arbol tiene 4 variables: una de tipo String (cadena), una de tipo int (profundidad), una de tipo Nodo (standard) y una de tipo Scanner (sc).
### Explicación:
+ Esta clase lo que hace es ir almacenando los valores del atributo valor de Nodo, calcula la profundidad del Arbol.
+ Lo primero que nos encontramos en esta clase es un constructor, para introducir Nodo por Nodo, así con cada valor de cada nodo ir rellenando la cadena de Arbol y luego analizar la profundidad con un método.
+ Luego tenemos los setters y getters.
+ Y por último encontramos el método void rellenarCadena() que lo que hace es rellenar la cadena con los valores de cada Nodo. Este método es un menú que te obliga a insertar el primer nodo y luego te dá total libertad para insertar todos los Nodos que quieras.
+ Lo que le falta a esta clase es otro método para hallar la profundidad del Arbol teniendo en cuenta las alturas de los Nodos.

## Clase Main ProbarArbol
### Introducción:
La Clase ProbarArbol lo único que hice fue crear un Arbol porque al no ser capaz de plantear el método de hallar la profundidad no pude acabar la práctica.

# Practica 10 Serialización de archivos.
## Introducción:
Hay dos carpetas, una que es P10 que es la práctica sin los test unitarios, y P10Test que es exactamente la misma práctica pero con los test unitarios \
### Nota: importa la carpeta P10Test directamente en el intellij para usar los tests, ya que he configurado el xml y esta en esa versión de junit, sino te dará error.
## Introducción 2:
Primero crearemos los dos archivos: alumnos.csv con los datos pedidos de la práctica; y otro archivo llamado alumnosSerializados.serialize que estará vacío.
## Paso 1 Clase Objeto Alumno:
Esta simple clase consta de 4 variables de tipo String, que serán los 4 atributos correspondientes del archivo .csv \
Esta clase de tipo Objeto tiene un constructor sencillo y un toString() personalizado para que salga todos los atributos ordenados y con separaciones a la hora de imprimirlos.
## Paso 2 Interfaz DAO:
En esta interfaz constará de 3 métodos uno para leer el csv, otro para leer el archivo serializado y otro para escribir en el archivo serializado.
## Paso 3 Clase AlumnoDAO:
En está clase implementaremos la interfaz DAO, y declararemos sus métodos en esta. El más complejo será leerFichero, ya que para leer el fichero no será tan sencillo porque \
tendremos que utilizar una serie de while y for dentro del try catch para crear un objeto de tipo alumno y los datos en sus atributos. Exceptuando la primera línea del csv \
ya que no la queremos (nombre, email, dni, f nacimiento). \
También instanciaremos los métodos para leer y escribir en el fichero serializado que constará de un simple trycatch en donde leeremos y escribiremos con los objetos de la clase \
Buffered.
## Paso 4 Clase Main Controlador:
En la clase ejecutable Controlador primero declararemos las listas que guardaran los datos del csv y del fichero serializado. \
También crearemos un objerto de tipo DAO que sera igual a un nuevo objeto de tipo AlumnoDAO. \
Luego leeremos el fichero usando los métodos de nuestra interfaz creada, y luego mostraremos por pantalla la lista del fichero para ver si sale en formato objeto Alumno. \
Después escribiremos en el fichero serializado los objetos de tipo Alumno almacenados en la lista fichero. \
Y por último leeremos el contenido del fichero serializado y lo mostraremos por pantalla.
## Paso 5 Tests:
Para los tests tendremos que crear otro proyecto de tipo maven y descargar la versión de JUnit (en mi caso la 4.13.1) y depositaremos nuestras clases e interfaz en la \
carpeta main > java y los tests los crearemos en la carpeta test > java. \
Mi clase para los test que utilizaremos se llamará AlumnoDAOTest, en esta habrá un test para cada método de la clase AlumnoDAO que lo que hará será comprobar si cada \ 
método cumple su función.
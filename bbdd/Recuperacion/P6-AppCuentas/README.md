# Examen Final de Juan Parejo García

## Ejercicio 1:
Solo he podido sacar el primer resultado

## Ejercicio 2:
En el ejercicio 2 disponemos de 4 clases y 2 interfaces, 1 de las clases y 1 de las interfaces las utilizaremos para guardar \
las credenciales nuestras para poder acceder a nuestra base de datos.

Usaremos la interfaz DAO como almacén de nuestros dos métodos: getByNombre() y updateById(). 

La clase Persona será un objeto que lo utilizaremos en los métodos de la siguiente clase.

La clase DAOImpMariaDB estan los dos métodos de la interfaz y el método privado getAll() que obtiene todos las personas de nuestra bbdd. \
El método getByNombre hace la consulta de obtener todas las personas que tengan el nombre que daremos en el Controlador y te los agrupa \
por id. Y el método updateById() lo que hace es mediante un id cambiar el nombre de la persona que tenga ese id. En este he tenido problemas \
con la base de datos, realmente no da error en el intellij pero si vas a la base de datos no realiza el cambio.

Y la clase Controlador es la clase Main
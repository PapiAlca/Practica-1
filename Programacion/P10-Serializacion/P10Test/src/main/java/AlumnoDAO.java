/*
 * Autor Juan Parejo García
 * Clase AlumnoDAO
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements DAO <Alumno> {
    File csv = new File("alumnos.csv");
    File serialize = new File("alumnosSerializados.serialize");

    //Metodo para leer el fichero csv.
    /*
    * Este método lo que hace es: mediante un while que está dentro del try catch, primero crea un objeto y luego transforma
    * cada cadena de carácteres separada por comas del .csv, en cada atributo del objeto creado. Se crean tantos objetos
    * como líneas halla en el csv. En este caso serian 2, la primera línea no la pillamos al no haber datos reales.
    */
    @Override
    public List<Alumno> leerFichero() {
        FileReader fr = null;
        try {
            fr = new FileReader(csv);
            BufferedReader br = new BufferedReader(fr);
            String encabezado = br.readLine();
            String[] atributos = encabezado.split(",");
            String linea;
            String[] alumnosAtributos;
            List<Alumno> alumnos = new ArrayList<>();
            while((linea = br.readLine())!=null) {
                String nombre="";
                String email="";
                String dni="";
                String f_nacimiento="";
                alumnosAtributos = linea.split(",");
                for(int i=0; i<alumnosAtributos.length; i++) {
                    switch(atributos[i].trim()) {
                        case "nombre":
                            nombre = alumnosAtributos[i].trim();
                            break;
                        case "email":
                            email = alumnosAtributos[i].trim();
                            break;
                        case "dni":
                            dni = alumnosAtributos[i].trim();
                            break;
                        case "f nacimiento":
                            f_nacimiento = alumnosAtributos[i].trim();
                            break;
                    }
                }
                alumnos.add(new Alumno(nombre, email, dni, f_nacimiento));
            }
            return alumnos;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Método para leer el fichero serializado.
    @Override
    public List<Alumno> leerFicheroSerializado() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(serialize);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (List<Alumno>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Método para escribir en el fichero serializado.
    @Override
    public void escribirFicheroSerializado(List<Alumno> alumnos) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(serialize);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(alumnos);

            oos.close();
            bos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

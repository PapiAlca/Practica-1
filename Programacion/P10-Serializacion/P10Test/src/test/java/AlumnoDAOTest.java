/*
* Autor: Juan Parejo García.
* Clase: AlumnoDAOTest (Tests de la clase AlumnoDAO)
*/

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOTest {
    // Test del método leerFichero() de la clase AlumnoDAO
    @Test
    public void leerFicheroTest() {
        DAO dao = new AlumnoDAO();
        List<Alumno> alumnos = dao.leerFichero();

        assertEquals(alumnos.size(), 2);
        assertEquals(alumnos.get(0), new Alumno("Juan", "juan@miemail.es", "12345678a", "25/1/2000"));
        assertEquals(alumnos.get(1), new Alumno("Pedro", "pedro.gonzalez@mi.email.es", "23456789b", "1/10/2005"));
    }

    // Test del método leerFicheroSerializado() de la clase AlumnoDAO
    @Test
    public void leerFicheroSerTest() {
        DAO dao = new AlumnoDAO();
        List<Alumno> alumosSerializado;
        dao.escribirFicheroSerializado(dao.leerFichero());
        alumosSerializado = dao.leerFicheroSerializado();

        assertEquals(alumosSerializado.size(), 2);
        assertEquals(alumosSerializado.get(0), new Alumno("Juan", "juan@miemail.es", "12345678a", "25/1/2000"));
        assertEquals(alumosSerializado.get(1), new Alumno("Pedro", "pedro.gonzalez@mi.email.es", "23456789b", "1/10/2005"));
    }

    // Test del método escribirFicheroSerializado() de la clase AlumnoDAO
    @Test
    public void escribirFicheroSerTest() {
        DAO dao = new AlumnoDAO();
        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno("Juan", "juan@miemail.es", "12345678a", "25/1/2000"));
        alumnos.add(new Alumno("Pedro", "pedro.gonzalez@mi.email.es", "23456789b", "1/10/2005"));
        alumnos.add(new Alumno("Pepe", "pepe@hotmail.com", "81234576j", "11/09/2002"));

        dao.escribirFicheroSerializado(alumnos);
        alumnos = dao.leerFicheroSerializado();

        assertEquals(alumnos.size(), 3);
        assertEquals(alumnos.get(0), new Alumno("Juan", "juan@miemail.es", "12345678a", "25/1/2000"));
        assertEquals(alumnos.get(1), new Alumno("Pedro", "pedro.gonzalez@mi.email.es", "23456789b", "1/10/2005"));
        assertEquals(alumnos.get(2), new Alumno("Pepe", "pepe@hotmail.com", "81234576j", "11/09/2002"));
    }
}

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) throws SQLException {
        DAO daoCSV = new DaoImpCSV();
        DAO daoBBDD = new DAOImpMySQL();
        Scanner sc = new Scanner(System.in);
        List<Alumno> alumnos;

        System.out.println("+====================================================================+");
        System.out.println("Estos son todos los datos que introduciremos en nuestra base de datos:");
        alumnos = daoCSV.getAll();
        System.out.println(alumnos);
    }
}

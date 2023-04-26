import java.sql.SQLException;
import java.util.List;

public class Controlador {
    public static void main(String[] args) throws SQLException {
        DAO daoCSV = new CSVImpDAO();
        DAO daoBBDD = new BBDDImpDAO();
        List<Alumno> alumnos;

        alumnos = daoCSV.getAll();
        System.out.println(alumnos);
    }
}

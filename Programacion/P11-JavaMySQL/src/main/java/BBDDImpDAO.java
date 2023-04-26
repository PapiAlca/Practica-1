import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BBDDImpDAO implements DAO {
    private Connection conn;
    private Conn conexion;

    public BBDDImpDAO() throws SQLException {
        conexion = (Conn) DriverManager.getConnection(Conn.getUri());
    }

    /**
     * Obtiene el elemento indicado por su id
     *
     * @param id de tipo long
     * @return Objeto de la clase T
     */
    @Override
    public Object getById(long id) throws SQLException {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setLong(1, id);
        ResultSet resultSet = stat.executeQuery();
        if (resultSet.next()) {
            return new Alumno(resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("dni"),
                    resultSet.getString("email"),
                    resultSet.getString("fecha_nacimiento"));
        } else {
            return null;
        }
    }

    /**
     * Obtiene una lista con TODOS elementos de T
     *
     * @return List<Alumno>
     */
    @Override
    public List getAll() throws SQLException {
        String sql = "SELECT * FROM alumnos";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Alumno> alumnos = new ArrayList<>();
        while (resultSet.next()) {
            alumnos.add(new Alumno(resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("dni"),
                    resultSet.getString("email"),
                    resultSet.getString("fecha_nacimiento")));
        }
        return alumnos;
    }

    /**
     * Inserta un nuevo elemento Alumno
     *
     * @param alumno de tipo Alumno
     * @return (tipo long) id del elemento insertado o -1 si se produjo algún error.
     */
    @Override
    public long add(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO alumnos (nombre, dni, email, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, alumno.getNombre());
        statement.setString(2, alumno.getDni());
        statement.setString(3, alumno.getEmail());
        statement.setString(4, alumno.getFechaNacimiento());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected == 1) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Error al obtener el id del alumno insertado.");
            }
        } else {
            return -1;
    }

    /**
     * Inserta una coleción completa de T
     *
     * @param list@return List<long> con una lista de todos los id's o -1 si se produjo error al insertar elementos. Si no hubo
     *                    error, pero no se insertó ninguno se devuelve una List de tamaño 0.
     */
    @Override
    public List<Long> addList(List list) {
        return null;
    }

    /**
     * Elimina el elemnto de identificador id
     *
     * @param id elemento a eliminar
     * @return Retorna el id del elemento eliminado, 0 si no existe y -1 si hubo error.
     */
    @Override
    public long del(long id) {
        return 0;
    }

    /**
     * Modifica el elemento e de identificador id. Si no existe debe crearse.
     *
     * @param id long que identifica al elemnto a modificar.
     * @param e  -> Elemento de tipo T para modificar el que está almacenado.
     * @return Retornará 0 si se realizó correctamente, -1 si hubo un error y 1 si no existía previamente.
     */
    @Override
    public int update(long id, Object e) {
        return 0;
    }
}

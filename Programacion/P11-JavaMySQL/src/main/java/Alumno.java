import java.sql.Date;

public class Alumno {
    // Variables:
    long id;
    String nombre, email, dni, f_nacimiento;

    // Constructor
    public Alumno(long id, String dni, String nombre, String email, String f_nacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.f_nacimiento = f_nacimiento;
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getDni() {
        return dni;
    }
    public String getFechaNacimiento() {
        return f_nacimiento;
    }

    // Método toString
    @Override
    public String toString() {
        return  "\n" +
                "==============================================" + "\n" +
                "·Id: " + id + "." + "\n" +
                "·Nombre: " + nombre + "." + "\n" +
                "·Email: " + email + "." + "\n" +
                "·DNI: " + dni + "." + "\n" +
                "·Fecha de nacimiento: " + f_nacimiento + "." + "\n" +
                "==============================================" + "\n";
    }
}

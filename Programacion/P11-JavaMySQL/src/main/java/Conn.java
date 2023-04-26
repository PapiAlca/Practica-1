public class Conn implements Conexion {
    /**
     * Obtener el nombre de usuario
     * @return String
     */
    static String getUser(){
        String user = "root";
        return user;
    }

    /**
     * Obtener el password
     * @return String
     */
    static String getPassword(){
        String pass = "";
        return pass;
    }

    /**
     * Obtener el FQDN del host o la ip
     * @return String con FQDN o ip
     */
    static String getHost(){
        String host = "localhost";
        return host;
    }

    /**
     * Obtener el puerto de conexión
     * @return int con el puerto de la db
     */
    static int getPort(){
        int port = 3306;
        return port;
    }

    /**
     * Obtener la db
     * @return String con el nombre de la base de datos
     */
    static String getDb(){
        String db = "";
        return db;
    }

    /**
     * Obtener el URI completo a la bbdd. Tendrá la forma
     * jdbc:mysql://user:pass@host:port/db
     * @return URI
     */
    static String getUri(){
        String uri = "jdbc:mysql://"+getUser()+":"+getPassword()+"@"+getHost()+":"+getPort()+"/"+getDb();
        return uri;
    }
}

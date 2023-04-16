public class TramaEthernet {
    String preambulo;
    String sfd;
    String direccionDestino;
    String direccionOrigen;
    int longitud;
    String datos;
    int numeroTrama;

    //Constructor
    public TramaEthernet(String preambulo, String sfd, String direccionDestino, String direccionOrigen,
                         int longitud, String datos, int numeroTrama) {
        this.preambulo = preambulo;
        this.sfd = sfd;
        this.direccionDestino = direccionDestino;
        this.direccionOrigen = direccionOrigen;
        this.longitud = longitud;
        this.datos = datos;
        this.numeroTrama = numeroTrama;
    }

    //Getters:
    public String getPreambulo() {
        return preambulo;
    }
    public String getSfd() {
        return sfd;
    }
    public String getDireccionDestino() {
        return direccionDestino;
    }
    public String getDireccionOrigen() {
        return direccionOrigen;
    }
    public int getLongitud() {
        return longitud;
    }
    public String getDatos() {
        return datos;
    }
    public int getNumeroTrama() {
        return numeroTrama;
    }

    //Setters:
    public void setPreambulo(String preambulo) {
        this.preambulo = preambulo;
    }
    public void setSfd(String sfd) {
        this.sfd = sfd;
    }
    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }
    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    public void setDatos(String datos) {
        this.datos = datos;
    }
    public void setNumeroTrama(int numeroTrama) {
        this.numeroTrama = numeroTrama;
    }
}

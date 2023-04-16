public class Brazo {
    int x;
    int y;
    int l;
    float q;

    //Constructor:
    public Brazo(int x, int y) {
        if(0<=x && x<=10){
            this.x = x;
        }
        if(0<=y && y<=10){
            this.y = y;
        }
        this.l = 1;
    }

    //Getters:
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getL() {
        return l;
    }
    public float getQ() {
        return q;
    }

    //Métodos:

    @Override
    public String toString() {
        return  "Coordenada x = " + x +
                " Coordenada y = " + y +
                " Lado = " + l +
                " Angulo q = " + q + "."
                ;
    }
}

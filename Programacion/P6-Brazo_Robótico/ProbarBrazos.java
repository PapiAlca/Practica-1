import java.util.Scanner;
public class ProbarBrazos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Brazo n1 = new Brazo(0, 0);
        Brazo n2 = new Brazo(0, 0);
        Brazo brazos[][] = {{n1}, {n2}};

        for(int i=0; i<brazos.length; i++) {
            for(int j=0; j<brazos.length; j++){
                System.out.println(brazos[i][j]);
            }
        }
    }
}

public class MatricesDeTransformacion {
    // Longitud de los brazos robóticos
    private static final double L = 1.0;

    // Método para calcular la cinemática inversa
    public static float[] cinematicaInversa2D(int x, int y) {
        double r = Math.sqrt(x * x + y * y);
        double beta = Math.acos((L * L + r * r - L * L) / (2 * L * r));
        double alpha = Math.atan2(y, x) - Math.atan2((L * Math.sin(beta)), (L + L * Math.cos(beta)));
        return new float[] {(float) Math.toDegrees(alpha), (float) Math.toDegrees(beta)};
    }

    // Método main para probar la solución
    public static void main(String[] args) {
        // Test de algunos puntos en el cubo 1x1
        int[][] puntos = {{0, 0}, {0, 10}, {10, 0}, {10, 10}, {5, 7}};
        for (int i = 0; i < puntos.length; i++) {
            float[] angulos = cinematicaInversa2D(puntos[0][0], puntos[0][0]);
            System.out.println("Punto (" + puntos[0][0] + ", " + puntos[0][0] + "): Angulo 1 = " + angulos[0] + ", Angulo 2 = " + angulos[1]);
        }
    }
}
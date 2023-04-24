import java.util.HashSet;
import java.util.List;

import java.util.Map;
import java.util.Set;

public class AlumnosMetodos {

    //Métodos:
    public static float getMediaAlumno(int id, List<Map<Integer, Float>> notas) {
        float media = 0;
        float suma = 0;
        int count = 0;
        for (Map<Integer, Float> mapa : notas) {
            Float entry = mapa.get(id);
            if (entry != -1) {
                suma += entry;
                count++;
            }
        }
        media = suma / count;
        return media;
    }

    public static float getMediaModulo(Map<Integer, Float> asignatura) {
        Set<Map.Entry<Integer, Float>> notas = asignatura.entrySet();
        float media = 0;
        float suma = 0;
        int count = 0;

        for (Map.Entry<Integer, Float> mapa : notas) {
            Float entry = mapa.getValue();
            if (entry != -1) {
                suma += entry;
                count++;
            }
        }
        media = suma / count;
        return media;
    }
}

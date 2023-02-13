package Ejercicio1;

public class Partido extends Equipos{
    int jornada;
    Equipo equipoLocal;
    Equipo equipoVisitante;
    int golesLocal;
    int golesVisitante;

    //Constructor
    public Partido(int golesLocal, int golesVisitante) {
        for (int i=0; i < equipos.size(); i++) {
            for (int j=0; j < equipos.size(); j++) {
                this.jornada = i*j;
            }
        }
        if(this.equipoLocal != equipoVisitante) {
            for(int i=0; i<equipos.size(); i++) {
                this.equipoLocal = equipos.get(i);
            }
            for(int i=0; i<equipos.size(); i++) {
                this.equipoVisitante = equipos.get(i);
            }
        }
        this.golesLocal=golesLocal;
    }

    //Getters
    public int getJornada() {
        return jornada;
    }
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    public int getGolesLocal() {
        return golesLocal;
    }
    public int getGolesVisitante() {
        return golesVisitante;
    }

    //Métodos
    public boolean resultados(int golesLocal, int golesVisitante) {
        //Variables
        boolean ganador = false;
        int puntuacionLocal = equipoLocal.getPuntuacion();
        int puntuacionVisitante = equipoVisitante.getPuntuacion();
        
        if(getGolesLocal() > getGolesVisitante()) {
            System.out.println("Ha ganado el equipo local " + equipoLocal + ".");
            //set puntuacion +3 local
            puntuacionLocal += 3;
            ganador = true;
        }
        else {
            if(getGolesVisitante() > getGolesLocal()) {
                System.out.println("Ha ganado el equipo visitante " + equipoVisitante + ".");
                //set puntuacion +3 visitante
                puntuacionVisitante += 3;
                ganador = true;
            }
            else {
                if(getGolesLocal() == getGolesVisitante()) {
                    System.out.println("Han empatado el local " + equipoLocal + " con el visitante " + equipoVisitante + ".");
                    //set puntuacion +1 local
                    puntuacionLocal += 1;
                    //set puntuacion +1 visitante
                    puntuacionVisitante += 1;
                    ganador = false;
                }
            }
        }
        return ganador;
    }
}
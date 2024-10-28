package Modelo.Objetivo;

import Modelo.Rutina.Rutina;
import Modelo.Socio;

public abstract class Objetivo implements IObjetivo {
    private int minutosEntreMax;
    private int minutosEntreMin;
    private int nivelAerobicoMin;
    private int nivelAerobicoMax;

    public Objetivo(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax) {
        this.minutosEntreMax = minutosEntreMax;
        this.minutosEntreMin = minutosEntreMin;
        this.nivelAerobicoMin = nivelAerobicoMin;
        this.nivelAerobicoMax = nivelAerobicoMax;
    }

    @Override
    public Rutina obtenerPlan() {
        return null; //Este deberia hacer algo aca??? o se implementa en la herencia?
                    // y si es asi comosabemos que no tomara esta y no la de la herencia(?)
    }

    public double calcularPesoIdeal(Socio socio) {
        //ToDo: implementar calcularPesoIdeal en Objetivo
        return Double.parseDouble(null);
    }

    public Rutina crearRutina (){
        //ToDo: implementar crearRutina en Objetivo
        return null;
    }
}

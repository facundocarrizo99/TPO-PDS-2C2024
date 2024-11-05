package Modelo.Objetivo;

import Modelo.Rutina.Rutina;
import Modelo.Socio;

public abstract class Objetivo {
    private int minutosEntreMax;
    private int minutosEntreMin;
    private int nivelAerobicoMin;
    private int nivelAerobicoMax;
    private Rutina rutina;
    private IEstadoObjetivo estado;
    

    public Objetivo(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax) {
        this.minutosEntreMax = minutosEntreMax;
        this.minutosEntreMin = minutosEntreMin;
        this.nivelAerobicoMin = nivelAerobicoMin;
        this.nivelAerobicoMax = nivelAerobicoMax;
    }

    public abstract Rutina obtenerPlan();

    public double calcularPesoIdeal(Socio socio) {
        //ToDo: implementar calcularPesoIdeal en Objetivo
        return Double.parseDouble(null);
    }

    public Rutina crearRutina (){
        //ToDo: implementar crearRutina en Objetivo
        return null;
    }
    
    public void cambiarEstado(IEstadoObjetivo estado) {
    	this.estado = estado;
    }
}

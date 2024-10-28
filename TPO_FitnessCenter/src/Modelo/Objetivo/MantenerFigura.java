package Modelo.Objetivo;

import Modelo.Rutina.Rutina;

public class MantenerFigura extends Objetivo{

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de MantenerFigura
        return null;
    }

    //Constructor creado porque me daba error, revisar despues//
    public MantenerFigura(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax) {
        super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax);
    }
}

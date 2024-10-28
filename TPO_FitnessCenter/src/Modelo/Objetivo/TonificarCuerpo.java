package Modelo.Objetivo;

import Modelo.Rutina.Rutina;

public class TonificarCuerpo extends Objetivo{

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de TonidicarCuerpo
        return null;
    }

    //Constructor creado porque me daba error, revisar despues//
    public TonificarCuerpo(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax) {
        super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax);
    }
}

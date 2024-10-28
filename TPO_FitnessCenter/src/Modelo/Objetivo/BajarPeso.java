package Modelo.Objetivo;

import Modelo.Rutina.Rutina;

public class BajarPeso extends Objetivo{

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de BajarPeso
        return null;
    }

    //Constructor creado porque me daba error, revisar despues//
    public BajarPeso(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax) {
        super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax);
    }

    public double calcularPesoIdeal(Socio socio){
        double alturaEnMetros = socio.getAltura() / 100.0;
        int edad = socio.getEdad();
        return 22 * alturaEnMetros * alturaEnMetros - (0.1 * edad);
    }

    
}

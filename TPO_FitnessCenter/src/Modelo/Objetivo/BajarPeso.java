package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Socio;
import Modelo.Rutina.Rutina;

public class BajarPeso extends Objetivo{
	private double pesoIdealKg;

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de BajarPeso
        return null;
    }
    
    
    
    public BajarPeso(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax,
			NivelExigencia nivelExigencia, double pesoIdealKg) {
		super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax, nivelExigencia);
		this.pesoIdealKg = pesoIdealKg;
	}



	public double calcularPesoIdeal(Socio socio){
        double alturaEnMetros = socio.getAltura() / 100.0;
        int edad = socio.getEdad();
        return 22 * alturaEnMetros * alturaEnMetros - (0.1 * edad);
    }

    
}

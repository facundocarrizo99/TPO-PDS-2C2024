package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Rutina.Rutina;

public class MantenerFigura extends Objetivo{
	
	private int valorConfigurable;

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de MantenerFigura
        return null;
    }

	public MantenerFigura(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax,
			NivelExigencia nivelExigencia, int valorConfigurable) {
		super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax, nivelExigencia);
		this.valorConfigurable = valorConfigurable;
	}

    
}

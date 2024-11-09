package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Rutina.Rutina;

public class TonificarCuerpo extends Objetivo{
	
	private double masaMuscularIdeal;
	private double porcentajeGrasaIdeal;

    public Rutina obtenerPlan(){
        //TODO: implementar metodo obtenerPlan de TonidicarCuerpo
        return null;
    }

	public TonificarCuerpo(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax,
			NivelExigencia nivelExigencia, double masaMuscularIdeal, double porcentajeGrasaIdeal) {
		super(minutosEntreMax, minutosEntreMin, nivelAerobicoMin, nivelAerobicoMax, nivelExigencia);
		this.masaMuscularIdeal = masaMuscularIdeal;
		this.porcentajeGrasaIdeal = porcentajeGrasaIdeal;
	}

	
    
}

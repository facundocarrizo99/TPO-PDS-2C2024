package Modelo.Objetivo;

import Modelo.Rutina.Rutina;
import Enum.NivelExigencia;
import Modelo.Socio;

public abstract class Objetivo {
    private int minutosEntreMax;
    private int minutosEntreMin;
    private int nivelAerobicoMin;
    private int nivelAerobicoMax;
    private NivelExigencia nivelExigencia;
    private Rutina rutina;
    private boolean estadoObjetivo; //False significa en curso
    
    

    public Objetivo(int minutosEntreMax, int minutosEntreMin, int nivelAerobicoMin, int nivelAerobicoMax,
			NivelExigencia nivelExigencia) {
		this.minutosEntreMax = minutosEntreMax;
		this.minutosEntreMin = minutosEntreMin;
		this.nivelAerobicoMin = nivelAerobicoMin;
		this.nivelAerobicoMax = nivelAerobicoMax;
		this.nivelExigencia = nivelExigencia;
		estadoObjetivo = false;
	}

	public abstract Rutina obtenerPlan();	 //se supone que este es el que crea la rutina 
											//por eso se implementa en la herencia

    
}

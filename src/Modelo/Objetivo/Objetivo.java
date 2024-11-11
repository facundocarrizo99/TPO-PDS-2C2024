package Modelo.Objetivo;

import Controladores.RutinaControlador;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.Rutina;
import Modelo.Socio;

import java.util.ArrayList;

public abstract class Objetivo implements EstrategiaObjetivo {
    protected Rutina rutina;

	public Objetivo() {
	}

	public boolean seEstaCumpliendo(Socio socio){return false;}

	public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista){
		return null;
	}

	public void generarRutina(){
		this.rutina = RutinaControlador.getInstance().createRutina(this);
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

}

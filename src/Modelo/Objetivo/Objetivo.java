package Modelo.Objetivo;

import Controladores.RutinaControlador;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.Rutina;
import Enum.NivelExigencia;

import java.util.ArrayList;

public abstract class Objetivo implements EstrategiaObjetivo {
    private Rutina rutina;
    private boolean estadoObjetivo;//False significa en curso
	private EstrategiaObjetivo estrategia;

	public Objetivo(Rutina rutina, boolean estadoObjetivo, EstrategiaObjetivo estrategia) {
		this.rutina = rutina;
		this.estadoObjetivo = estadoObjetivo;
		this.estrategia = estrategia;
	}

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

	public boolean isEstadoObjetivo() {
		return estadoObjetivo;
	}

	public void setEstadoObjetivo(boolean estadoObjetivo) {
		this.estadoObjetivo = estadoObjetivo;
	}

	public EstrategiaObjetivo getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaObjetivo estrategia) {
		this.estrategia = estrategia;
	}



}

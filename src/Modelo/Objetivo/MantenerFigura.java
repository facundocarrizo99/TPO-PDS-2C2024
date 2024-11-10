package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.Rutina;

import java.util.ArrayList;

public class MantenerFigura extends Objetivo {
	
	private int valorConfigurable;

	public MantenerFigura(Rutina rutina, boolean estadoObjetivo, EstrategiaObjetivo estrategia, int valorConfigurable) {
		super(rutina, estadoObjetivo, estrategia);
		this.valorConfigurable = valorConfigurable;
	}

	@Override
	public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista){
		ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
		for (Ejercicio ejercicio : lista){
			if (ejercicio.getNivelAerobico() >= 2 && ejercicio.getNivelAerobico() <= 4 && ejercicio.getNivelExigencia() == NivelExigencia.BAJO
					|| ejercicio.getNivelExigencia() ==NivelExigencia.MEDIO){
				listaFiltrada.add(ejercicio);
			}
		}
		return listaFiltrada;
	}

    
}

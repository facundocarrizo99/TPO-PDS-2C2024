package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.Rutina;

import java.util.ArrayList;

public class TonificarCuerpo extends Objetivo{
	
	private double masaMuscularIdeal;
	private double porcentajeGrasaIdeal;

	public TonificarCuerpo(Rutina rutina, boolean estadoObjetivo, EstrategiaObjetivo estrategia, double masaMuscularIdeal, double porcentajeGrasaIdeal) {
		super(rutina, estadoObjetivo, estrategia);
		this.masaMuscularIdeal = masaMuscularIdeal;
		this.porcentajeGrasaIdeal = porcentajeGrasaIdeal;
	}

	@Override
	public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista){
		ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
		for (Ejercicio ejercicio : lista){
			if (ejercicio.getNivelAerobico() <= 4 && ejercicio.getNivelExigencia() == NivelExigencia.ALTO){
				listaFiltrada.add(ejercicio);
			}
		}
		return listaFiltrada;
	}

	
    
}

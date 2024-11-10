package Modelo.Objetivo;

import Controladores.RutinaControlador;
import Enum.NivelExigencia;
import Modelo.Rutina.Ejercicio;
import Modelo.Socio;
import Modelo.Rutina.Rutina;

import java.util.ArrayList;

public class BajarPeso extends Objetivo {
	private double pesoIdealKg;

    public BajarPeso(Rutina rutina, boolean estadoObjetivo, EstrategiaObjetivo estrategia, double pesoIdealKg) {
        super(rutina, estadoObjetivo, estrategia);
        this.pesoIdealKg = pesoIdealKg;
    }

    public double calcularPesoIdeal(Socio socio){
        double alturaEnMetros = socio.getAltura() / 100.0;
        int edad = socio.getEdad();
        return 22 * alturaEnMetros * alturaEnMetros - (0.1 * edad);
    }

    public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista){
        ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
        for (Ejercicio ejercicio : lista){
            if (ejercicio.getNivelAerobico() >= 3){
                listaFiltrada.add(ejercicio);
            }
        }
        return listaFiltrada;
    }

    
}

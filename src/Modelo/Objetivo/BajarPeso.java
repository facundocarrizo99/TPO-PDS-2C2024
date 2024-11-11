package Modelo.Objetivo;

import Modelo.Peso.Peso;
import Modelo.Rutina.Ejercicio;
import Modelo.Socio;


import java.util.ArrayList;

public class BajarPeso extends Objetivo {
    private double pesoIdealKg;

    public BajarPeso(Socio socio) {
        this.generarRutina();
        this.pesoIdealKg = this.calcularPesoIdeal(socio);
    }

    public double calcularPesoIdeal(Socio socio) {
        double alturaEnMetros = socio.getAltura() / 100.0;
        int edad = socio.getEdad();
        return 22 * alturaEnMetros * alturaEnMetros - (0.1 * edad);
    }

    @Override
    public boolean seEstaCumpliendo(Socio socio) {
        boolean res = false;
        Peso ultimo = socio.getPesos().getLast();
        if (ultimo.getPesoKG() <= this.pesoIdealKg) {
            res = true;
        }
        return res;
    }

    public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista) {
        ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
        for (Ejercicio ejercicio : lista) {
            if (ejercicio.getNivelAerobico() >= 3) {
                ejercicio.setRepeticiones(20);
                ejercicio.setCantidadSeries(4);
                ejercicio.setPeso(5);
                listaFiltrada.add(ejercicio);
            }
        }
        //agregale los pesos
        return listaFiltrada;
    }


}

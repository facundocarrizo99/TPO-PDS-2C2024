package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Peso.Peso;
import Modelo.Rutina.Ejercicio;
import Modelo.Socio;

import java.util.ArrayList;

public class TonificarCuerpo extends Objetivo {

    private double masaMuscularIdeal;
    private double porcentajeGrasaIdeal;

    public TonificarCuerpo() {
        this.generarRutina();
        this.masaMuscularIdeal = 80;
        this.porcentajeGrasaIdeal = 15;
    }

    @Override
    public boolean seEstaCumpliendo(Socio socio) {
        boolean res = false;
        Peso ultimo = socio.getPesos().getLast();
        if (ultimo.getMasaMuscularKG() >= this.masaMuscularIdeal &&
                ultimo.getPorcentajeGrasa() <= this.porcentajeGrasaIdeal) {
            res = true;
        }
        return res;
    }

    @Override
    public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista) {
        ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
        for (Ejercicio ejercicio : lista) {
            if (ejercicio.getNivelAerobico() <= 4 && ejercicio.getNivelExigencia() == NivelExigencia.ALTO) {
                ejercicio.setRepeticiones(8);
                ejercicio.setCantidadSeries(4);
                ejercicio.setPeso(20);
                listaFiltrada.add(ejercicio);
            }
        }
        return listaFiltrada;
    }


}

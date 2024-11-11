package Modelo.Objetivo;

import Enum.NivelExigencia;
import Modelo.Peso.Peso;
import Modelo.Rutina.Ejercicio;
import Modelo.Socio;

import java.util.ArrayList;

public class MantenerFigura extends Objetivo {

    private Double valorConfigurable;
    private Peso pesoInicial;

    public MantenerFigura(Double valorConfigurable, Peso pesoInicial) {
        this.generarRutina();
        this.valorConfigurable = valorConfigurable;
        this.pesoInicial = pesoInicial;
    }

    public Double getValorConfigurable() {
        return valorConfigurable;
    }

    public Peso getPesoInicial() {
        return pesoInicial;
    }

    @Override
    public boolean seEstaCumpliendo(Socio socio) {
        boolean res = false;
        Peso ultimo = socio.getPesos().getLast();
        if ((this.valorConfigurable - pesoInicial.getPesoKG()) <= ultimo.getPesoKG() &&
                ultimo.getPesoKG() <= (pesoInicial.getPesoKG() + this.valorConfigurable)) {
            res = true;
        }
        return res;
    }

    @Override
    public ArrayList<Ejercicio> filtrarEjercicios(ArrayList<Ejercicio> lista) {
        ArrayList<Ejercicio> listaFiltrada = new ArrayList<>();
        for (Ejercicio ejercicio : lista) {
            if (ejercicio.getNivelAerobico() >= 2 && ejercicio.getNivelAerobico() <= 4 && ejercicio.getNivelExigencia() == NivelExigencia.BAJO
                    || ejercicio.getNivelExigencia() == NivelExigencia.MEDIO) {
                ejercicio.setRepeticiones(12);
                ejercicio.setCantidadSeries(4);
                ejercicio.setPeso(10);
                listaFiltrada.add(ejercicio);
            }
        }
        return listaFiltrada;
    }


}

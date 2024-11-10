package Controladores;

import DTO.EjercicioDTO;
import Modelo.Objetivo.Objetivo;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.Rutina;

import java.util.ArrayList;

public final class RutinaControlador {

    private static RutinaControlador instance;
    private ArrayList<Ejercicio> ejerciciosExistentes;

    private RutinaControlador() {
    }

    public static RutinaControlador getInstance() {
        if (instance == null) {
            instance = new RutinaControlador();
        }
        return instance;
    }

    public ArrayList<Ejercicio> elegirEjercicios(Objetivo objetivo) {
        ArrayList<Ejercicio> ejerciciosFiltrados = new ArrayList<>();

        for (Ejercicio ejercicio : ejerciciosExistentes) {
            objetivo.filtrarEjercicios(ejerciciosExistentes); //objetivo filtrar todo y devolver una lista de ejercicios

        }
        return ejerciciosFiltrados;
    }

    public Rutina createRutina(Objetivo objetivo) {
        return new Rutina(objetivo);
    }

    public void crearEjercicio(EjercicioDTO ejercicioDTO) {
        Ejercicio ejercicio = new Ejercicio(ejercicioDTO.getID(), ejercicioDTO.getDescripcion(), ejercicioDTO.getGrupoMuscular(), ejercicioDTO.getCantidadSerie(),
                ejercicioDTO.getRepeticiones(), ejercicioDTO.getPeso(), ejercicioDTO.getNivelAerobico(), ejercicioDTO.getNivelExigencia(), ejercicioDTO.getVideoIlustrativo());


    }

}

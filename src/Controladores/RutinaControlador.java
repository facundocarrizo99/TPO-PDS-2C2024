package Controladores;

import DTO.EjercicioDTO;
import DTO.EntrenamientoDTO;
import DTO.SocioDTO;
import Modelo.Objetivo.Objetivo;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.EjercicioRealizado;
import Modelo.Rutina.Entrenamiento;
import Modelo.Rutina.Rutina;
import Modelo.Socio;
import Enum.GrupoMuscular;
import Enum.NivelExigencia;


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
        return objetivo.filtrarEjercicios(ejerciciosExistentes);
    }

    public Rutina createRutina(Objetivo objetivo) {
        return new Rutina(objetivo);
    }

    public void reforzarRutina(int refuerzo, Rutina rutina) {
        ArrayList<Entrenamiento> entrenamientos = rutina.getEntrenamientos();
        for (Entrenamiento entrnamiento : entrenamientos) {
            ArrayList<Ejercicio> ejercicios = entrnamiento.getEjercicios();
            for (Ejercicio ejercicio : ejercicios) {
                ejercicio.setPeso(ejercicio.getPeso() + refuerzo);
                ejercicio.setCantidadSeries(ejercicio.getCantidadSeries() + 1);
                ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 4);
            }
        }
    }

    /// Entrenamiento
    public Entrenamiento entrenamientoDelDia(Socio socio) {
        return socio.getObjetivo().getRutina().getEntrenamientoParaHoy();
    }

    public void finalizarUnEntrenamiento(EntrenamientoDTO entrenamientoDTO, Socio socio) {
        Entrenamiento entrenamientoCompletado = this.entrenamientoToModel(entrenamientoDTO, socio);
        //update rutina original?
    }

    public EntrenamientoDTO comenzarEntremaniento(SocioDTO socioDTO) {
        SocioControlador socioControlador = SocioControlador.getInstancia();
        Socio socio = socioControlador.getSocioByID(socioDTO.getID());
        return this.entrenamientoToDTO(this.entrenamientoDelDia(socio));
    }

    /// ABM Ejercicio
//    public void crearEjercicio(EjercicioDTO ejercicioDTO) {
//        Ejercicio ejercicio = new Ejercicio(ejercicioDTO.getDescripcion(), ejercicioDTO.getGrupoMuscular(), ejercicioDTO.getNivelAerobico(),
//                ejercicioDTO.getNivelExigencia(), ejercicioDTO.getVideoIlustrativo());
//        ejerciciosExistentes.add(ejercicio);
//    }

    //todo es debatible si quiero editar un ejercicio que ya conozco con el dto o si lo tengo que buscar pero fue.
//    public void modificarEjercicio(Ejercicio ejercicio, EjercicioDTO ejercicioDTO) {
//        ejercicio.setDescripcion(ejercicioDTO.getDescripcion());
//        ejercicio.setGrupoMuscular(ejercicioDTO.getGrupoMuscular());
//        ejercicio.setNivelAerobico(ejercicioDTO.getNivelAerobico());
//        ejercicio.setNivelExigencia(ejercicioDTO.getNivelExigencia());
//        ejercicio.setVideoIlustrativo(ejercicioDTO.getVideoIlustrativo());
//    }
    public void eliminarEjercicio(Ejercicio ejercicio) {
        ejerciciosExistentes.remove(ejercicio);
    }

    public ArrayList<Ejercicio> getEjerciciosExistentes() {
        return ejerciciosExistentes;
    }

    public EjercicioDTO toString(Ejercicio ejercicio) {
        return new EjercicioDTO(ejercicio.getDescripcion(), String.valueOf(ejercicio.getCantidadSeries()),
                String.valueOf(ejercicio.getRepeticiones()), String.valueOf(ejercicio.getPeso()), ejercicio.getGrupoMuscular().toString(),
                String.valueOf(ejercicio.getNivelAerobico()), ejercicio.getNivelExigencia().toString(), ejercicio.getLinkVideo());
    }

    public EjercicioRealizado ejercicioRealizadoToModel(EjercicioDTO ejercicioDTO) {
        return new EjercicioRealizado(Integer.valueOf(ejercicioDTO.getCantidadSeries()),
                Integer.parseInt(ejercicioDTO.getRepeticiones()), Double.valueOf(ejercicioDTO.getPeso()),
                this.ejercicioFromDTO(ejercicioDTO));
    }

    public Ejercicio ejercicioFromDTO(EjercicioDTO ejercicioDTO) {
        return new Ejercicio(ejercicioDTO.getDescripcion(), GrupoMuscular.valueOf(ejercicioDTO.getGrupoMuscular()),
                Integer.parseInt(ejercicioDTO.getNivelAerobico()), NivelExigencia.valueOf(ejercicioDTO.getNivelExigencia()),
                ejercicioDTO.getVideoIlustrativo());
    }

    public EntrenamientoDTO entrenamientoToDTO(Entrenamiento entrenamiento) {
        ArrayList<EjercicioDTO> listaEjercicioDTO = new ArrayList<>();
        for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
            EjercicioDTO ejercicioDTO = toString(ejercicio);
            listaEjercicioDTO.add(ejercicioDTO);
        }
        ArrayList<EjercicioDTO> listaFinalizados = new ArrayList<>();
        return new EntrenamientoDTO(listaEjercicioDTO, String.valueOf(entrenamiento.getDiaRutina()), listaFinalizados);
    }

    public Entrenamiento entrenamientoToModel(EntrenamientoDTO entrenamientoDTO, Socio socio) {
        Entrenamiento entrenamientoAModificar = this.entrenamientoDelDia(socio);
        for (EjercicioDTO ejercicioDTO : entrenamientoDTO.getEjerciciosFinalizados()) {
            entrenamientoAModificar.getEjerciciosFinalizados().add(this.ejercicioRealizadoToModel(ejercicioDTO));
        }
        return entrenamientoAModificar;
    }
}

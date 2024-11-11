package Controladores;

import DTO.EjercicioDTO;
import DTO.EntrenamientoDTO;
import DTO.RutinaDTO;
import DTO.SocioDTO;
import Modelo.Objetivo.Objetivo;
import Modelo.Rutina.Ejercicio;
import Modelo.Rutina.EjercicioRealizado;
import Modelo.Rutina.Entrenamiento;
import Modelo.Rutina.Rutina;
import Modelo.Socio;
import Enum.GrupoMuscular;
import Enum.NivelExigencia;
import baseDatos.BD;


import java.util.ArrayList;

public final class RutinaControlador {
    private static final BD base = BD.getInstancia();
    private static RutinaControlador instance;

    private RutinaControlador() {
    }

    public static RutinaControlador getInstance() {
        if (instance == null) {
            instance = new RutinaControlador();
        }
        return instance;
    }

    public ArrayList<Ejercicio> elegirEjercicios(Objetivo objetivo) {
        return objetivo.filtrarEjercicios(base.getEjercicios());
    }

    public Rutina createRutina(Objetivo objetivo) {
        return new Rutina(objetivo);
    }

    public void reforzarRutina(double refuerzo, Rutina rutina) {
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
        Rutina rutina = socio.getObjetivo().getRutina();
        ArrayList<Entrenamiento> entrenamientos= rutina.getEntrenamientos();
        for (Entrenamiento entrenamiento : entrenamientos) {
            if(entrenamiento.getDiaRutina() == entrenamientoCompletado.getDiaRutina()){
                entrenamiento.setEjerciciosFinalizados(entrenamientoCompletado.getEjerciciosFinalizados());
            }
        }
    }

    public EntrenamientoDTO comenzarEntremaniento(SocioDTO socioDTO) {
        SocioControlador socioControlador = SocioControlador.getInstancia();
        Socio socio = socioControlador.getSocioByID(socioDTO.getID());
        return this.entrenamientoToDTO(this.entrenamientoDelDia(socio));
    }

    /// ABM Ejercicio
    public void crearEjercicio(EjercicioDTO ejercicioDTO) {
        BD baseDatos = BD.getInstancia();
        Ejercicio ejercicio = this.ejercicioFromDTO(ejercicioDTO);
        baseDatos.getEjercicios().add(ejercicio);
    }

    public void modificarEjercicio(Ejercicio ejercicio, EjercicioDTO ejercicioDTO) {}

    public void eliminarEjercicio(Ejercicio ejercicio) {}

    public EjercicioDTO toString(Ejercicio ejercicio) {
        return new EjercicioDTO(ejercicio.getDescripcion(), String.valueOf(ejercicio.getCantidadSeries()),
                String.valueOf(ejercicio.getRepeticiones()), String.valueOf(ejercicio.getPeso()), ejercicio.getGrupoMuscular().toString(),
                String.valueOf(ejercicio.getNivelAerobico()), ejercicio.getNivelExigencia().toString(), ejercicio.getLinkVideo());
    }

    public Ejercicio ejercicioFromDTO(EjercicioDTO ejercicioDTO) {
        return new Ejercicio(ejercicioDTO.getDescripcion(), GrupoMuscular.valueOf(ejercicioDTO.getGrupoMuscular()),
                Integer.parseInt(ejercicioDTO.getNivelAerobico()), NivelExigencia.valueOf(ejercicioDTO.getNivelExigencia()),
                ejercicioDTO.getVideoIlustrativo());
    }

    public EjercicioRealizado ejercicioRealizadoToModel(EjercicioDTO ejercicioDTO) {
        return new EjercicioRealizado(Integer.valueOf(ejercicioDTO.getCantidadSeries()),
                Integer.parseInt(ejercicioDTO.getRepeticiones()), Double.valueOf(ejercicioDTO.getPeso()),
                this.ejercicioFromDTO(ejercicioDTO));
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

    public RutinaDTO rutinaToDTO(Rutina rutina){
        ArrayList<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            entrenamientosDTO.add(this.entrenamientoToDTO(entrenamiento));
        }
        return new RutinaDTO(entrenamientosDTO, rutina.getFechaInicio().toString(), rutina.getFechaFin().toString());
    }
}

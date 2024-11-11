package Modelo.Rutina;

import Controladores.RutinaControlador;
import Interfaeces.IObservable;
import Interfaeces.IObserver;
import Modelo.NotificadorPush;
import Modelo.Objetivo.Objetivo;
import Enum.GrupoMuscular;
import Modelo.Socio;
import Modelo.Trofeo.TrofeoConstancia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Rutina implements IObservable {
    private ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<IObserver> observers = new ArrayList<>();
    private Socio socio;

    public Rutina(Objetivo objetivo) {
        this.crearNEntranamientos(objetivo);
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusDays(30);

        NotificadorPush notificadorPush = new NotificadorPush();

        TrofeoConstancia trofeoConstancia = new TrofeoConstancia(notificadorPush);
        this.agregarO(trofeoConstancia);
    }

    @Override
    public void agregarO(IObserver observador) {
        observers.add(observador);
    }

    @Override
    public void eliminarO(IObserver observador) {
        observers.remove(observador);
    }

    @Override
    public void notificar() {
        for (IObserver observer : observers) {
            observer.serNotificadoPor(this);
        }
    }

    public void completarEntrenamiento() {
        this.notificar();
    }

    ///Solo generamos Entrnamientos por semana pero se repiten cada semana entonces genero 5 entrenamientos y los muestro las 4 semanas del mes
    public void crearNEntranamientos(Objetivo objetivo) {
        ArrayList<Ejercicio> ejerciciosDisponibles;
        for (int i = 0; i < 1; i++) {
            Entrenamiento temp = new Entrenamiento(LocalDate.now().plusDays(i));
            ejerciciosDisponibles = RutinaControlador.getInstance().elegirEjercicios(objetivo);
            this.ejerciciosParaEntrenamiento(temp, ejerciciosDisponibles, i);
            this.agregarEntramiento(temp);
        }
    }

    public void ejerciciosParaEntrenamiento(Entrenamiento entrenamiento, ArrayList<Ejercicio> ejerciciosDisponibles, Integer pos) {
        ArrayList<Ejercicio> ejerciciosGrupo = new ArrayList<>();
        ArrayList<Ejercicio> ejerciciosNuevos = new ArrayList<>();
        int val = pos % 5;
        ejerciciosGrupo = switch (val) {
            case 0 ->
                    new ArrayList<>(ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PECHO)).collect(Collectors.toList()));
            case 1 ->
                    new ArrayList<>(ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.ESPALDA)).collect(Collectors.toList()));
            case 2 ->
                    new ArrayList<>(ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.HOMBROS)).collect(Collectors.toList()));
            case 3 ->
                    new ArrayList<>(ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PIERNAS)).collect(Collectors.toList()));
            case 4 ->
                    new ArrayList<>(ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.BRAZOS)).collect(Collectors.toList()));
            default -> ejerciciosGrupo;
        };
        for (Ejercicio ejercicio : ejerciciosGrupo) {
            ejerciciosNuevos.add(new Ejercicio(ejercicio.getDescripcion(), ejercicio.getGrupoMuscular(), ejercicio.getNivelAerobico(), ejercicio.getNivelExigencia(), ejercicio.getLinkVideo(), ejercicio.getCantidadSeries(), ejercicio.getRepeticiones(), ejercicio.getPeso()));
        }
        entrenamiento.setEjercicios(ejerciciosNuevos);
    }

    public void agregarEntramiento(Entrenamiento entrenamiento) {
        this.entrenamientos.add(entrenamiento);
    }

    public Entrenamiento getEntrenamientoParaHoy() {
        return this.entrenamientos.stream().filter(entrenamiento -> entrenamiento.getDiaRutina().equals(LocalDate.now())).findFirst().get();
    }

    public ArrayList<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}

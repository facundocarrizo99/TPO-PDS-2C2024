package Modelo.Rutina;

import Controladores.RutinaControlador;
import Interfaeces.IObservable;
import Interfaeces.IObserver;
import Modelo.Objetivo.Objetivo;
import Enum.GrupoMuscular;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rutina implements IObservable {
    private ArrayList<Entrenamiento> entrenamientos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<IObserver> observers;

    public Rutina(Objetivo objetivo) {
        this.crearNEntranamientos(objetivo);
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusDays(30);

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

    ///Solo generamos Entrnamientos por semana pero se repiten cada semana entonces genero 5 entrenamientos y los muestro las 4 semanas del mes
    public void crearNEntranamientos(Objetivo objetivo){
        ArrayList<Ejercicio> ejerciciosDisponibles;
        for (int i = 0; i < 20; i++) {
            Entrenamiento temp = new Entrenamiento(LocalDate.now().plusDays(i));
            ejerciciosDisponibles = RutinaControlador.getInstance().elegirEjercicios(objetivo);
            this.ejerciciosParaEntrenamiento(temp, ejerciciosDisponibles, i);
            this.agregarEntramiento(temp);
        }
    }

    public void ejerciciosParaEntrenamiento(Entrenamiento entrenamiento, ArrayList<Ejercicio> ejerciciosDisponibles, Integer pos){
        ArrayList<Ejercicio> resultado = new ArrayList<>();
        int val = pos % 5;
        resultado = switch (val) {
            case 0 ->
                    (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PECHO)).toList();
            case 1 ->
                    (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.ESPALDA)).toList();
            case 2 ->
                    (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.HOMBROS)).toList();
            case 3 ->
                    (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PIERNAS)).toList();
            case 4 ->
                    (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.BRAZOS)).toList();
            default -> resultado;
        };
        entrenamiento.setEjercicios(resultado);
    }

    public void agregarEntramiento(Entrenamiento entrenamiento){
        this.entrenamientos.add(entrenamiento);
    }

    public Entrenamiento getEntrenamientoParaHoy(){
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

}

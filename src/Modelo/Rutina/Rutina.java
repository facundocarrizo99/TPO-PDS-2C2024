package Modelo.Rutina;

import Controladores.RutinaControlador;
import Interfaeces.IObservable;
import Interfaeces.IObserver;
import Modelo.Objetivo.Objetivo;
import Enum.GrupoMuscular;
import Modelo.Trofeo.TrofeoConstancia;

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
        ArrayList<Ejercicio> ejerciciosDisponibles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Entrenamiento temp = new Entrenamiento(LocalDate.now().plusDays(i));
            ejerciciosDisponibles = RutinaControlador.getInstance().elegirEjercicios(objetivo);
            //todo: falta asignarle las repeticiones y peso por defecto a los ejercicios
            this.ejerciciosParaEntrenamiento(temp, ejerciciosDisponibles, i);
            this.agregarEntramiento(temp);
        }
    }

    public void ejerciciosParaEntrenamiento(Entrenamiento entrenamiento, ArrayList<Ejercicio> ejerciciosDisponibles, Integer pos){
        ArrayList<Ejercicio> resultado = new ArrayList<>();
        int val = pos % 5;
        switch (val){
            case 0:
                resultado = (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PECHO)).toList();
                break;
            case 1:
                resultado = (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.ESPALDA)).toList();
                break;
            case 2:
                resultado = (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.HOMBROS)).toList();
                break;
            case 3:
                resultado = (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.PIERNAS)).toList();
                break;
            case 4:
                resultado = (ArrayList<Ejercicio>) ejerciciosDisponibles.stream().filter(ejercicio -> ejercicio.getGrupoMuscular().equals(GrupoMuscular.BRAZOS)).toList();
                break;
        }
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

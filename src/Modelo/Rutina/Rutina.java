package Modelo.Rutina;

import Controladores.RutinaControlador;
import Interfaeces.IObserver;
import Modelo.Objetivo.Objetivo;
import Enum.GrupoMuscular;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rutina {
    private ArrayList<Entrenamiento> entrenamientos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<IObserver> Observers; //TODO

    public Rutina(Objetivo objetivo) {
        this.crearNEntranamientos(5, objetivo);
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now().plusDays(30);
    }

    ///Solo generamos Entrnamientos por semana pero se repiten cada semana entonces genero 5 entrenamientos y los muestro las 4 semanas del mes
    public void crearNEntranamientos(int n, Objetivo objetivo){
        ArrayList<Ejercicio> ejerciciosDisponibles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Entrenamiento temp = new Entrenamiento(LocalDate.now().plusDays(i));
            ejerciciosDisponibles = RutinaControlador.getInstance().elegirEjercicios(objetivo);
            this.ejerciciosParaEntrenamiento(temp, ejerciciosDisponibles, i);
            this.agregarEntramiento(temp);
        }
    }

    public void ejerciciosParaEntrenamiento(Entrenamiento entrenamiento, ArrayList<Ejercicio> ejerciciosDisponibles, Integer pos){
        ArrayList<Ejercicio> resultado = new ArrayList<>();
        switch (pos){
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

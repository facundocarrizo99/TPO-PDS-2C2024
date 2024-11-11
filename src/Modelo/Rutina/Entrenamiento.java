package Modelo.Rutina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Entrenamiento {
    private ArrayList<Ejercicio> ejercicios;
    private LocalDate diaRutina;
    private ArrayList<EjercicioRealizado> ejerciciosFinalizados;

    public Entrenamiento(LocalDate diaRutina) {
        this.ejercicios = new ArrayList<Ejercicio>();
        this.diaRutina = diaRutina;
        this.ejerciciosFinalizados = new ArrayList<EjercicioRealizado>();
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public LocalDate getDiaRutina() {
        return diaRutina;
    }

    public void setDiaRutina(LocalDate diaRutina) {
        this.diaRutina = diaRutina;
    }

    public ArrayList<EjercicioRealizado> getEjerciciosFinalizados() {
        return ejerciciosFinalizados;
    }

    public void setEjerciciosFinalizados(ArrayList<EjercicioRealizado> ejerciciosFinalizados) {
        this.ejerciciosFinalizados = ejerciciosFinalizados;
    }
}

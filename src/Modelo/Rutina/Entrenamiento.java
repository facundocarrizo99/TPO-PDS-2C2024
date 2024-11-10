package Modelo.Rutina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Entrenamiento {
    private ArrayList<Ejercicio> ejercicios;
    private LocalDate diaRutina;
    private ArrayList<Ejercicio> ejerciciosFinalizados;

    public Entrenamiento(LocalDate diaRutina) {
        this.ejercicios = new ArrayList<Ejercicio>();
        this.diaRutina = diaRutina;
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

    public ArrayList<Ejercicio> getEjerciciosFinalizados() {
        return ejerciciosFinalizados;
    }

    public void setEjerciciosFinalizados(ArrayList<Ejercicio> ejerciciosFinalizados) {
        this.ejerciciosFinalizados = ejerciciosFinalizados;
    }

    //TODO: To Strings
}

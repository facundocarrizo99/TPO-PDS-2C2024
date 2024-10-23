package Modelo.Rutina;

import java.util.Date;
import java.util.List;

public class Entrenamiento {
    private List<Ejercicio> ejercicios;
    private Date diaRutina;
    private int duracionMinutos;
    private List<Ejercicio> ejerciciosFinalizados;

    public void guardarEjercicioFinalizado(Ejercicio ejercicio){
        ejerciciosFinalizados.add(ejercicio);
    }

    public Entrenamiento finalizarEntrenamiento () {
        //TODO: Implementar FinalizarEntrenamiento en Entrenamietos, falta tambien crear la clase HistorialSocio que es donde se deberia Guardar//
        return null;
    }
}

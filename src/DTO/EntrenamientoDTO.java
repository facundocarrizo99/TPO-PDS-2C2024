package DTO;

import java.util.ArrayList;

public class EntrenamientoDTO {
    private ArrayList<EjercicioDTO> ejercicios;
    private String diaRutina;
    private ArrayList<EjercicioDTO> ejerciciosFinalizados;

    public EntrenamientoDTO(ArrayList<EjercicioDTO> ejercicios, String diaRutina, ArrayList<EjercicioDTO> ejerciciosFinalizados) {
        this.ejercicios = ejercicios;
        this.diaRutina = diaRutina;
        this.ejerciciosFinalizados = ejerciciosFinalizados;
    }

    // Getter para ejercicios
    public ArrayList<EjercicioDTO> getEjercicios() {
        return ejercicios;
    }

    // Getter para diaRutina
    public String getDiaRutina() {
        return diaRutina;
    }

    // Getter para ejerciciosFinalizados
    public ArrayList<EjercicioDTO> getEjerciciosFinalizados() {
        return ejerciciosFinalizados;
    }


}

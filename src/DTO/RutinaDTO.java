package DTO;

import java.util.ArrayList;

public record RutinaDTO(ArrayList<EntrenamientoDTO> rutina, String fechaInicio, String fechaFin) {
}

//public class RutinaDTO {
//    private final ArrayList<EntrenamientoDTO> rutina;
//    private final String fechaInicio;
//    private final String fechaFin;
//
//    public RutinaDTO(ArrayList<EntrenamientoDTO> rutina, String fechaInicio, String fechaFin) {
//        this.rutina = rutina;
//        this.fechaInicio = fechaInicio;
//        this.fechaFin = fechaFin;
//    }
//
//    public ArrayList<EntrenamientoDTO> getRutina() {
//        return rutina;
//    }
//
//    public String getFechaInicio() {
//        return fechaInicio;
//    }
//
//    public String getFechaFin() {
//        return fechaFin;
//    }
//}

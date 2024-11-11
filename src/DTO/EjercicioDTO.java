package DTO;

public class EjercicioDTO {
    private String grupoMuscular;
    private String cantidadSeries;
    private String repeticiones;
    private String peso;
    private String nivelAerobico;
    private String nivelExigencia;
    private String videoIlustrativo;
    private String descripcion;

    public EjercicioDTO(String grupoMuscular, String cantidadSeries, String repeticiones, String peso, String nivelAerobico, String nivelExigencia, String videoIlustrativo, String descripcion) {
        this.grupoMuscular = grupoMuscular;
        this.cantidadSeries = cantidadSeries;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigencia = nivelExigencia;
        this.videoIlustrativo = videoIlustrativo;
        this.descripcion = descripcion;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(String cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(String nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public String getNivelExigencia() {
        return nivelExigencia;
    }

    public void setNivelExigencia(String nivelExigencia) {
        this.nivelExigencia = nivelExigencia;
    }

    public String getVideoIlustrativo() {
        return videoIlustrativo;
    }

    public void setVideoIlustrativo(String videoIlustrativo) {
        this.videoIlustrativo = videoIlustrativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EjercicioDTO copiar() {
        return new EjercicioDTO(
                this.grupoMuscular,
                this.cantidadSeries,
                this.repeticiones,
                this.peso,
                this.nivelAerobico,
                this.nivelExigencia,
                this.videoIlustrativo,
                this.descripcion
        );
    }
}

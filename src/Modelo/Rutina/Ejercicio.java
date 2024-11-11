package Modelo.Rutina;

import Enum.GrupoMuscular;
import Enum.NivelExigencia;

public class Ejercicio {
    private GrupoMuscular grupoMuscular;
    private Integer cantidadSeries;
    private Integer repeticiones;
    private double peso;
    private Integer nivelAerobico;
    private NivelExigencia nivelExigencia;
    private String videoIlustrativo;
    private String descripcion;
    private boolean baja;

    public Ejercicio(String descripcion, GrupoMuscular grupoMuscular, Integer nivelAerobico,
                     NivelExigencia nivelExigencia, String videoIlustrativo) {
        this.descripcion = descripcion;
        this.grupoMuscular = grupoMuscular;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigencia = nivelExigencia;
        this.videoIlustrativo = videoIlustrativo;
        this.baja = false;
    }

    public Ejercicio(String descripcion, GrupoMuscular grupoMuscular, Integer nivelAerobico, NivelExigencia nivelExigencia, String videoIlustrativo, Integer cantidadSeries, Integer repeticiones, double peso) {
        this.grupoMuscular = grupoMuscular;
        this.cantidadSeries = cantidadSeries;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.nivelAerobico = nivelAerobico;
        this.nivelExigencia = nivelExigencia;
        this.videoIlustrativo = videoIlustrativo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public int getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(int cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(int nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public NivelExigencia getNivelExigencia() {
        return nivelExigencia;
    }

    public void setNivelExigencia(NivelExigencia nivelExigencia) {
        this.nivelExigencia = nivelExigencia;
    }

    public String getLinkVideo() {
        return videoIlustrativo;
    }

    public void setVideoIlustrativo(String linkVideo) {
        this.videoIlustrativo = linkVideo;
    }


    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

}

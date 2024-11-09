package Modelo.Rutina;

import Enum.GrupoMuscular;
import Enum.NivelExigencia;

public class Ejercicio {
	private int ID;
	private String descripcion;
    private GrupoMuscular grupoMuscular;
    private int cantidadSeries;
    private int repeticiones;
    private double peso;
    private int nivelAerobico;
    private NivelExigencia nivelExigencia;
    private String videoIlustrativo;
    private boolean baja;
    
    
    public void completar(double pesoUtilizado, int repeticiones, int series){
        
    }
	public Ejercicio(int ID, String descripcion, GrupoMuscular grupoMuscular, int cantidadSeries, int repeticiones, double peso, int nivelAerobico,
			NivelExigencia nivelExigencia, String videoIlustrativo) {
		this.descripcion= descripcion;
		this.grupoMuscular = grupoMuscular;
		this.cantidadSeries = cantidadSeries;
		this.repeticiones = repeticiones;
		this.peso = peso;
		this.nivelAerobico = nivelAerobico;
		this.nivelExigencia = nivelExigencia;
		this.videoIlustrativo= videoIlustrativo;
		this.ID= ID;
		this.baja = false;
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
	public int getID() {
		return ID;
	}
	public boolean getBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
	
}

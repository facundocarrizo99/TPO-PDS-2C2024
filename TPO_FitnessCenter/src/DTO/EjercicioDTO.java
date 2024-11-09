package DTO;

public class EjercicioDTO {
	private String ID;
	private String descripcion;
	private String grupoMuscular;
	private String cantidadSerie;
	private String repeticiones;
	private String peso;
	private String nivelAerobico;
	private String NivelExigencia;
	private String videoIlustrativo;
	public EjercicioDTO(String ID,String descripcion,String grupoMuscular, String cantidadSerie, String repeticiones, String peso,
			String nivelAerobico, String nivelExigencia, String videoIlustrativo) {
		this.descripcion= descripcion;
		this.grupoMuscular = grupoMuscular;
		this.cantidadSerie = cantidadSerie;
		this.repeticiones = repeticiones;
		this.peso = peso;
		this.nivelAerobico = nivelAerobico;
		this.NivelExigencia = nivelExigencia;
		this.videoIlustrativo = videoIlustrativo;
		this.ID= ID;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGrupoMuscular() {
		return grupoMuscular;
	}
	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
	public String getCantidadSerie() {
		return cantidadSerie;
	}
	public void setCantidadSerie(String cantidadSerie) {
		this.cantidadSerie = cantidadSerie;
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
		return NivelExigencia;
	}
	public void setNivelExigencia(String nivelExigencia) {
		NivelExigencia = nivelExigencia;
	}
	public String getVideoIlustrativo() {
		return videoIlustrativo;
	}
	public void setVideoIlustrativo(String videoIlustrativo) {
		this.videoIlustrativo = videoIlustrativo;
	}

	public String getID() {
		return ID;
	}
	
	
	
	

}

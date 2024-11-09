package Controladores;

import DTO.EjercicioDTO;
import Enum.GrupoMuscular;
import Enum.NivelExigencia;
import Modelo.Rutina.Ejercicio;
import baseDatos.BD;

public class EjercicioControlador {
	private static EjercicioControlador  instancia;
	private BD bd = BD.getInstancia();
	
	private  EjercicioControlador() {}
	
	public static EjercicioControlador getIntancia() {
		if(instancia==null) {
			instancia= new EjercicioControlador();
		}
		return instancia;
	}
	
	public void crearEjercicio(EjercicioDTO ejercicioDTO) {
		Ejercicio ejercicioNuevo = toModel(ejercicioDTO);
		bd.agregarEjercicio(ejercicioNuevo);
		
	}
	public void modificarEjercicio(EjercicioDTO ejercicioDTO) {
		Ejercicio ejercicioModificar = toModel(ejercicioDTO);
		Ejercicio ejercicioBaseDeDatos = bd.getEjercicioByID(Integer.parseInt(ejercicioDTO.getID()));
		
		if(ejercicioDTO.getDescripcion()!="0") {
			ejercicioBaseDeDatos.setDescripcion(ejercicioModificar.getDescripcion());
			}
		if(ejercicioDTO.getGrupoMuscular()!="0") {
			ejercicioBaseDeDatos.setGrupoMuscular(ejercicioModificar.getGrupoMuscular());
			
		}
		if(ejercicioDTO.getCantidadSerie()!="0") {
			ejercicioBaseDeDatos.setCantidadSeries(ejercicioModificar.getCantidadSeries());
			
		}
		if(ejercicioDTO.getRepeticiones()!="0") {
			ejercicioBaseDeDatos.setRepeticiones(ejercicioModificar.getRepeticiones());
			
		}
		if(ejercicioDTO.getPeso()!="0") {
			ejercicioBaseDeDatos.setPeso(ejercicioModificar.getPeso());
			
		}
		if(ejercicioDTO.getNivelAerobico()!="0") {
			ejercicioBaseDeDatos.setNivelAerobico(ejercicioModificar.getNivelAerobico());
			
		}
		if(ejercicioDTO.getNivelExigencia()!="0") {
			ejercicioBaseDeDatos.setNivelExigencia(ejercicioModificar.getNivelExigencia());
			
		}
		if(ejercicioDTO.getVideoIlustrativo()!="0") {
			ejercicioBaseDeDatos.setVideoIlustrativo(ejercicioModificar.getLinkVideo());
			
		}
		}
	public void eliminarEjercicio(EjercicioDTO ejercicioDTO) {
		bd.eliminarEjercicio(Integer.valueOf(ejercicioDTO.getID()));
		}
	
	// ejemplo para el commit //
	
	public Ejercicio toModel(EjercicioDTO ejercicioDTO) {
		GrupoMuscular grupoMuscular;
		NivelExigencia nivelExigencia;
		int ID = bd.getSizeEjercicios()+1;
		
		
		switch (ejercicioDTO.getGrupoMuscular()) {
	    case "PECHO":
	    	grupoMuscular = GrupoMuscular.PECHO;
	        
	        break;
	    case "ESPALDA":
	    	grupoMuscular = GrupoMuscular.ESPALDA;
	        break;
	    case "HOMBROS":
	    	grupoMuscular = GrupoMuscular.HOMBROS;
	        break;
	    case "PIERNAS":
	    	grupoMuscular = GrupoMuscular.PIERNAS;
	    default:
	    	grupoMuscular = GrupoMuscular.BRAZOS;
	       
	}
		switch (ejercicioDTO.getNivelExigencia()) {
	    case "BAJO":
	    	nivelExigencia = NivelExigencia.BAJO;
	        
	        break;
	    case "MEDIO":
	    	nivelExigencia = NivelExigencia.MEDIO;
	        break;
	  
	    default:
	    	nivelExigencia = NivelExigencia.ALTO;
	       
	}
		
		Ejercicio ejercicio= new Ejercicio(
				ID,
				ejercicioDTO.getDescripcion(),
				grupoMuscular,
				Integer.parseInt(ejercicioDTO.getCantidadSerie()),
				Integer.parseInt(ejercicioDTO.getRepeticiones()),
				Double.parseDouble(ejercicioDTO.getPeso()),
				Integer.parseInt(ejercicioDTO.getNivelAerobico()),
				nivelExigencia,
				ejercicioDTO.getVideoIlustrativo()
				);
		return ejercicio;
	}

}

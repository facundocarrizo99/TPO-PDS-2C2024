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
	public Ejercicio toModel(EjercicioDTO ejercicioDTO) {
		GrupoMuscular grupoMuscular;
		NivelExigencia nivelExigencia;
		
		
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

package Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DTO.SocioDTO;
import Modelo.Socio;
import baseDatos.BD;

public class SocioControlador {
	private static SocioControlador instancia;
	private BD bd = BD.getInstancia();
	
	private SocioControlador() {
	}
	
	public static SocioControlador getInstancia() {
		if (instancia == null) {
			instancia = new SocioControlador();
		}
		return instancia;
	}
	
	public boolean registrarSocio(SocioDTO socio) {
		Socio nuevoSocio = toModel(socio);
		bd.agregarSocio(nuevoSocio);
		return true;
	}
	
	public void editarSocio(SocioDTO socio) {
		Socio editado = bd.getSocioByID(Integer.valueOf(socio.getID()));
		Socio datosNuevos = toModel(socio);
		editado.setMail(datosNuevos.getMail());
		editado.setClave(datosNuevos.getClave());
		editado.setNombre(datosNuevos.getNombre());
		editado.setApellido(datosNuevos.getApellido());
		editado.setEdad(datosNuevos.getEdad());
		editado.setFechaNacimiento(datosNuevos.getFechaNacimiento());
		editado.setSexo(datosNuevos.getSexo());
		editado.setAltura(datosNuevos.getAltura());
	}
	
	public boolean eliminarSocio(SocioDTO socio) {
		Socio socioBorrar = bd.getSocioByID(Integer.valueOf(socio.getID()));
		
		return true;
	}
	
	public void pesarse(SocioDTO socio) {
		int socioID = Integer.valueOf(socio.getID());
		bd.eliminarSocio(socioID);
	}
	
	private Socio toModel(SocioDTO socio) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fecha = null;
        
        try {
        	fecha = formato.parse(socio.getFechaNacimiento());
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        
        BD bd = BD.getInstancia();
        int ID = bd.getsizeSocios() + 1;

		Socio nuevoSocio = new Socio(
				socio.getMail(),	
				socio.getClave(),
				socio.getNombre(),
				socio.getApellido(),
				Integer.valueOf(socio.getEdad()),
				fecha,
				socio.getSexo(),
				Double.valueOf(socio.getAltura()),
				ID
				);
		return nuevoSocio;
	}
}

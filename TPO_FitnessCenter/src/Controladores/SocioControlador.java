package Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DTO.SocioDTO;
import Modelo.Socio;
import baseDatos.BD;

public class SocioControlador {
	private static SocioControlador instancia;
	
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
		BD bd = BD.getInstancia();
		bd.agregarSocio(nuevoSocio);
		return true;
	}
	
	public void editarSocio(SocioDTO socio) {
		BD bd = BD.getInstancia();
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
		BD bd = BD.getInstancia();
		Socio socioBorrar = bd.getSocioByID(Integer.valueOf(socio.getID()));
		return true;
	}
	
	private Socio toModel(SocioDTO socio) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fecha = null;
        
        try {
        	fecha = formato.parse(socio.getFechaNacimiento());
            //System.out.println("Fecha convertida: " + fecha);
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

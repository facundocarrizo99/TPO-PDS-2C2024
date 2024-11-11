package Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DTO.SocioDTO;
import Modelo.Socio;
import baseDatos.BD;
import Modelo.Objetivo.Objetivo;
import Modelo.Objetivo.BajarPeso;
import Modelo.Objetivo.MantenerFigura;
import Modelo.Objetivo.TonificarCuerpo;
import Enum.NivelExigencia;

public class SocioControlador {
	private static SocioControlador instancia;
	private BD bd;
	private Scanner lector;

	//TODO: pasar todos los valores a main porque aca tiene que ser todo abstracto

	private SocioControlador() {
		lector = new Scanner(System.in);
		bd = BD.getInstancia();
	}
	
	public static SocioControlador getInstancia() {
		if (instancia == null) {
			instancia = new SocioControlador();
		}
		return instancia;
	}

	public Socio getSocioByID(String ID){
		return bd.getSocioByID(Integer.parseInt(ID));
	}

	public SocioDTO getSocioDtobyID(String ID){
		Socio socio = bd.getSocioByID(Integer.parseInt(ID));

		return new SocioDTO(
				socio.getMail(),
				"",
				socio.getNombre(),
				socio.getApellido(),
				"",
				"",
				"",
				"",
				String.valueOf(socio.getID())
		);
	}
	
	public boolean registrarSocio(SocioDTO socio) {
		Socio nuevoSocio = toModel(socio);
		bd.agregarSocio(nuevoSocio);
		return true;
	}
	
	public void editarSocio(SocioDTO socio) {
		Socio editado = bd.getSocioByID(Integer.valueOf(socio.getID()));
		Socio datosNuevos = toModel(socio);
		if(socio.getMail() != "") {
			editado.setMail(datosNuevos.getMail());
		}
		if (socio.getClave() != "") {
			editado.setClave(datosNuevos.getClave());
		}
		if (socio.getNombre() != "") {
			editado.setNombre(datosNuevos.getNombre());
		}
		if (socio.getApellido() != "") {
			editado.setApellido(datosNuevos.getApellido());
		}
		if (socio.getEdad() != "0") {
			editado.setEdad(datosNuevos.getEdad());
		}
		if (socio.getFechaNacimiento() != "0") {
			editado.setFechaNacimiento(datosNuevos.getFechaNacimiento());
		}
		if (socio.getSexo() != "") {
			editado.setSexo(datosNuevos.getSexo());
		}
		if (socio.getAltura() != "0") {
			editado.setAltura(datosNuevos.getAltura());
		}
	}
	
	public boolean eliminarSocio(SocioDTO socio) {
		int socioID = Integer.valueOf(socio.getID());
		bd.eliminarSocio(socioID);
		return true;//TODO analizar si es necesario que devuelva un booleano para la entrega
	}
	
	public void pesarse(SocioDTO socioDTO) {
		int socioID = Integer.valueOf(socioDTO.getID());
		Socio socio = bd.getSocioByID(socioID);
		socio.pesarse();
	}
	
	private Socio toModel(SocioDTO socio) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        
        Date fecha = null;
        
        try {
        	fecha = formato.parse(socio.getFechaNacimiento());
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        
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

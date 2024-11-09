package Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DTO.SocioDTO;
import Modelo.Socio;
import baseDatos.BD;
import Modelo.Objetivo.*;
import Enum.NivelExigencia;

public class SocioControlador {
	private static SocioControlador instancia;
	private BD bd;
	private Scanner lector;
	
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
		if (socio.getEdad() != "") {
			editado.setEdad(datosNuevos.getEdad());
		}
		if (socio.getFechaNacimiento() != "") {
			editado.setFechaNacimiento(datosNuevos.getFechaNacimiento());
		}
		if (socio.getSexo() != "") {
			editado.setSexo(datosNuevos.getSexo());
		}
		if (socio.getAltura() != "") {
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
	
	public void elegirObjetivo(SocioDTO socioDTO) {
		int socioID = Integer.valueOf(socioDTO.getID());
		Socio socio = bd.getSocioByID(socioID);
		System.out.print("\n\nElija su Objetivo, ingrese:\n1.- Tonificar Cuerpo\n2.- Bajar de Peso\n3.- Mantener Figura\n");
		int elegido = lector.nextInt();
		while ((elegido != 1) && (elegido != 2) && (elegido != 3)) {
			System.out.print("\n### Error con el dato ingresado ###");
			System.out.print("\nElija su Objetivo, ingrese:\n1.- Tonificar Cuerpo\n2.- Bajar de Peso\n3.- Mantener Figura\n");
			elegido = lector.nextInt();
		}
		// area de factory de objetivo //
		Objetivo obj;
		if (elegido == 1) {
			double masaMuscularIdeal;
			double porcentajeGrasaIdeal;
			if (socio.getSexo() == "masculino") {
				masaMuscularIdeal = 0.4;
				porcentajeGrasaIdeal = 0.17;
			}else {
				masaMuscularIdeal = 0.3;
				porcentajeGrasaIdeal = 0.24;
			}
			obj = new TonificarCuerpo(150, 120, 0, 4, NivelExigencia.ALTO, masaMuscularIdeal, porcentajeGrasaIdeal);
		}else if (elegido == 2) {
			double pesoIdeal;
			if (socio.getSexo() == "masculino") {
				pesoIdeal = socio.getAltura() - 100;
			}else {
				pesoIdeal = socio.getAltura() - 104;
			}
			obj = new BajarPeso(90, 60, 3, 10, null, pesoIdeal);
		}else {
			System.out.print("\nCuento te gustaria que pueda oscilar tu peso ideal? (Numero Entero positivo, menor a 20)\n");
			int valorConfigurable = lector.nextInt();
			while (valorConfigurable < 0 || valorConfigurable > 20) {
				System.out.print("### Error dato incorrecto ###");
				System.out.print("\nCuento te gustaria que pueda oscilar tu peso ideal? (Numero Entero positivo, menor a 20)\n");
				valorConfigurable = lector.nextInt();
			}
			obj = new MantenerFigura(45, 80, 2, 4, NivelExigencia.BAJO, valorConfigurable);
		}
		socio.setObjetivo(obj);
	}
	
	
	
	private Socio toModel(SocioDTO socio) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
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

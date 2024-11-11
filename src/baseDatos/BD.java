package baseDatos;

import java.util.ArrayList;
import java.util.List;

import DTO.LoginDTO;
import Modelo.Socio;
import Modelo.Rutina.Ejercicio;
import Enum.GrupoMuscular;
import Enum.NivelExigencia;

public class BD {
	private List<Socio> socios;
	private List<Ejercicio> ejercicios;
	private static BD instancia;
	
	private BD() {
		socios = new ArrayList<>();
		ejercicios= new ArrayList<>();
		guardarEjercicios();
	}
	
	public static BD getInstancia() {
		if (instancia == null) {
			instancia = new BD();
		}
		return instancia;
	}
	
	public void agregarSocio(Socio socio) {
		socios.add(socio);
	}
	
	public int getsizeSocios() {
		return socios.size();
	}
	
	public Socio getSocioByID(int ID) {
		if (ID > socios.size()) {
			return null; //validacion de que el ID sea valido
		}
		Socio socio = socios.get(ID-1);
		if(!socio.getBaja()) {
			return socio;
		}
		return null;
	}
	
	public void eliminarSocio(int ID) {
		Socio socio = socios.get(ID-1);
		socio.setBaja(true);
	}
	
	public void mostrarSocioPrueba() {
		System.out.println(socios.get(0).getFechaNacimiento());
		System.out.println(socios.get(0).getNombre());
	}
	//Metodo de ejecicios
	
	public void eliminarEjercicio(int ID) {
		Ejercicio ejercicio = ejercicios.get(ID-1);
		ejercicio.setBaja(true);
	}
	
	public void agregarEjercicio(Ejercicio ejercicio) {
		ejercicios.add(ejercicio);
	}
	
	public void mostrarEjercicioPrueba() {
		System.out.println(ejercicios.get(0).getDescripcion()+ ejercicios.get(0).getCantidadSeries());
	}
	public int getSizeEjercicios() {
		return ejercicios.size();
		
	}
	public Ejercicio getEjercicioByID(int ID) {
		if(ID>ejercicios.size()) {
			return null;
		}
		if(!ejercicios.get(ID-1).getBaja()) {
			return ejercicios.get(ID-1);
		}
		return null;
	}

	public LoginDTO loginSocio(LoginDTO datosLogin){
		LoginDTO consulta = null;
		for (Socio socio : socios) {
			consulta = socio.auth(datosLogin.getEmail(), datosLogin.getClave());
			if (consulta.getRespuestaTipo() == "ok" || consulta.getRespuestaTipo() == "claveInvalida") {
				return consulta;
			}
		}
		return consulta;
	}

	public void guardarEjercicios() {
		ejercicios.add(new Ejercicio("Bicicleta", GrupoMuscular.PIERNAS, 3, NivelExigencia.MEDIO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Flexiones", GrupoMuscular.BRAZOS, 3, NivelExigencia.MEDIO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Remo al mentón", GrupoMuscular.HOMBROS, 4, NivelExigencia.MEDIO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Pull-Over", GrupoMuscular.ESPALDA, 3, NivelExigencia.MEDIO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Press de banca", GrupoMuscular.PECHO, 3, NivelExigencia.MEDIO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Flexiones", GrupoMuscular.PECHO, 2, NivelExigencia.ALTO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Remo con mancuernas", GrupoMuscular.ESPALDA, 2, NivelExigencia.ALTO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Press Militar", GrupoMuscular.HOMBROS, 2, NivelExigencia.ALTO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Sentadillas", GrupoMuscular.PIERNAS, 2, NivelExigencia.ALTO, "Video.mp4"));
		ejercicios.add(new Ejercicio("Flexiones Triceps",GrupoMuscular.BRAZOS,2,NivelExigencia.ALTO,"Video.mp4"));
		ejercicios.add(new Ejercicio("Flexiones", GrupoMuscular.PECHO,2,NivelExigencia.MEDIO,"Video.mp4"));
		ejercicios.add(new Ejercicio("Remo con barra ",GrupoMuscular.ESPALDA,3,NivelExigencia.BAJO,"Video.mp4"));
		ejercicios.add(new Ejercicio("Elevanciones Laterales",GrupoMuscular.HOMBROS,2, NivelExigencia.MEDIO,"Video.mp4" ));
		ejercicios.add(new Ejercicio("Sentadilla",GrupoMuscular.PIERNAS,3,NivelExigencia.BAJO,"Video.mp4"));
		ejercicios.add(new Ejercicio("Fondos de Tríceps", GrupoMuscular.BRAZOS,3,NivelExigencia.MEDIO,"Video.mp4"));


	}
}

package baseDatos;

import java.util.ArrayList;
import java.util.List;
import Modelo.Socio;
import Modelo.Rutina.Ejercicio;

public class BD {
	private List<Socio> socios;
	private List<Ejercicio> ejercicios;
	private static BD instancia;
	
	private BD() {
		socios = new ArrayList<>();
		ejercicios= new ArrayList<>();
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
	
	public void agregarEjercicio(Ejercicio ejercicio) {
		ejercicios.add(ejercicio);
	}
	
	public void mostrarEjercicioPrueba() {
		System.out.println(ejercicios.get(0).getDescripcion());
	}
}

package baseDatos;

import java.util.ArrayList;
import java.util.List;
import Modelo.Socio;

public class BD {
	private List<Socio> socios;
	private static BD instancia;
	
	private BD() {
		socios = new ArrayList<>();
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
		Socio socio = socios.get(ID-1);
		if(!socio.getBaja()) {
			return socio;
		}
		return null;
	}
	
	public void mostrarSocioPrueba() {
		System.out.println(socios.get(0).getFechaNacimiento());
		System.out.println(socios.get(0).getNombre());
	}
}

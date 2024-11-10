package TPO_FitnessCenter.src.Modelo;

import Modelo.Objetivo.Objetivo;
import Modelo.Peso.IPesoAdapter;
import Modelo.Peso.Peso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {
	private String mail;
    private String clave;
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private String sexo;
    private List<Peso> pesos;
    private double alturaCM;
    private Objetivo objetivo;
    private int ID;
    private boolean baja;
    private IPesoAdapter balanza;

    public void pesarse() {
    	Peso nuevoPeso = balanza.obtenerPeso();
    	this.pesos.add(nuevoPeso);
    }
    
    // Constructor, getter y setter //
	public Socio(String mail, String clave, String nombre, String apellido, int edad, Date fechaNacimiento, String sexo, double altura, 
			int ID) {
		this.mail = mail;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.alturaCM = altura;
		this.ID = ID;
		this.baja = false;
		pesos = new ArrayList<>();
	}

	// TODO
	public void mostrarProgreso() {

	}
	public void Auth() {

	}
	public void notificar() {

	}
	public void cambiarObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getAltura() {
        return alturaCM;
    }

    public void setAltura(double altura) {
        this.alturaCM = altura;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

	public int getEdad() {
		return edad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean getBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public List<Peso> getPesos() {
		return pesos;
	}

	public void setPesos(List<Peso> pesos) {
		this.pesos = pesos;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
    
	
}

package Modelo.Peso;

import java.util.Date;

public class Peso {
    private double pesoKG;
    private double porcentajeGrasa;
    private double masaMuscularKG;
    private Date fecha;
    
	public Peso(double pesoKG, double porcentajeGrasa, double masaMuscularKG, Date fecha) {
		this.pesoKG = pesoKG;
		this.porcentajeGrasa = porcentajeGrasa;
		this.masaMuscularKG = masaMuscularKG;
		this.fecha = fecha;
	}

	public double getPesoKG() {
		return pesoKG;
	}

	public double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public double getMasaMuscularKG() {
		return masaMuscularKG;
	}

	public Date getFecha() {
		return fecha;
	}
    
	
    
}

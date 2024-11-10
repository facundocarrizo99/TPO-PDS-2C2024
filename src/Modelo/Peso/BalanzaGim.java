package Modelo.Peso;

import java.util.Scanner;
import java.util.Date;

public class BalanzaGim implements IPesoAdapter {
	private Scanner lector = new Scanner(System.in);
	Date fechaActual = new Date();

	@Override
	public Peso obtenerPeso() {
		System.out.print("\nIngrese el peso: ");
		double pesoKG = lector.nextDouble();
		while (pesoKG < 0 || pesoKG > 1000) {
			System.out.print("\n\n El peso ingresado es incorrecto, recuerde:\n1.- Debe ser positivo\n2.- Debe ser menor a 1000kg ");
			pesoKG = lector.nextDouble();
		}
		
		System.out.print("\nIngrese el porcentaje de masa muscular (valor entre 0 y 1): ");
		double masaMuscular = lector.nextDouble();
		while (masaMuscular <= 0 || masaMuscular >= 1) {
			System.out.print("\n\n El dato es incorrecto, recuerde que debe ser un valor entre 0 y 1");
			masaMuscular = lector.nextDouble();
		}
		
		System.out.print("\nIngrese el porcentaje de grasa (valor entre 0 y 1): ");
		double grasa = lector.nextDouble();
		while (grasa <= 0 || grasa >= 1) {
			System.out.print("\n\n El dato es incorrecto, recuerde que debe ser un valor entre 0 y 1");
			grasa = lector.nextDouble();
		}
		
		Peso newPeso = new Peso(
				pesoKG,
				grasa,
				masaMuscular,
				fechaActual
				);
		
		return newPeso;
	}

}

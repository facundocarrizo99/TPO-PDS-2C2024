package Modelo.Peso;

import java.util.Scanner;
import java.util.Date;

import java.util.Scanner;
import java.util.Date;

public class BalanzaGim implements IPesoAdapter {
    private final Scanner lector = new Scanner(System.in);
    Date fechaActual = new Date();

    @Override
    public Peso obtenerPeso() {
        double pesoKG = 0.0;
        boolean pesoValido = false;
        while (!pesoValido) {
            System.out.print("\nIngrese el peso: ");
            if (lector.hasNextDouble()) {
                pesoKG = lector.nextDouble();
                if (pesoKG >= 0 && pesoKG <= 1000) {
                    pesoValido = true;
                } else {
                    System.out.print("\n\n El peso ingresado es incorrecto, recuerde:\n1.- Debe ser positivo\n2.- Debe ser menor a 1000kg ");
                }
            } else {
                System.out.print("\n\n Entrada inválida. Ingrese un número válido.");
                lector.next();
            }
        }

        double masaMuscular = 0.0;
        boolean masaValida = false;
        while (!masaValida) {
            System.out.print("\nIngrese el porcentaje de masa muscular (valor entre 0 y 1, decimales con \",\"): ");
            if (lector.hasNextDouble()) {
                masaMuscular = lector.nextDouble();
                if (masaMuscular > 0 && masaMuscular < 1) {
                    masaValida = true;
                } else {
                    System.out.print("\n\n El dato es incorrecto, recuerde que debe ser un valor entre 0 y 1");
                }
            } else {
                System.out.print("\n\n Entrada inválida. Ingrese un número válido.");
                lector.next();
            }
        }

        double grasa = 0.0;
        boolean grasaValida = false;
        while (!grasaValida) {
            System.out.print("\nIngrese el porcentaje de grasa (valor entre 0 y 1, decimales con \",\"): ");
            if (lector.hasNextDouble()) {
                grasa = lector.nextDouble();
                if (grasa > 0 && grasa < 1) {
                    grasaValida = true;
                } else {
                    System.out.print("\n\n El dato es incorrecto, recuerde que debe ser un valor entre 0 y 1");
                }
            } else {
                System.out.print("\n\n Entrada inválida. Ingrese un número válido.");
                lector.next();
            }
        }

        return new Peso(pesoKG, grasa, masaMuscular, fechaActual);
    }
}

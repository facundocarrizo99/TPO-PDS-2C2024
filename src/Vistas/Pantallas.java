package Vistas;

import Controladores.RutinaControlador;
import DTO.EntrenamientoDTO;
import DTO.LoginDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import DTO.SocioDTO;

public class Pantallas {
    private static Scanner lector = new Scanner(System.in);
    private static RutinaControlador rutinaControlador;

    public static void limpiarPantalla () {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static boolean esFechaValida(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        formato.setLenient(false); // Evita que se realicen ajustes automáticos en la fecha

        try {
            Date date = formato.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static LoginDTO PantallaLogin () {
        System.out.print("Email: ");
        String email = lector.next();
        System.out.println();
        while (email == "") {
            System.out.print("### Error ###\nEl Email no puede estar vacio\n\n");
            System.out.print("Email: ");
            email = lector.next();
            System.out.println();
        }

        System.out.print("Contraseña: ");
        String clave = lector.next();
        System.out.println();
        while (clave == "") {
            System.out.print("### Error ###\nLa Contraseña no puede estar vaciá\n\n");
            System.out.print("Contraseña: ");
            clave = lector.next();
            System.out.println();
        }

        return new LoginDTO("","", email, clave);
    }

    public static SocioDTO registrarse (){
        System.out.print("Formulario para Registrarse: \n\n");
        System.out.print("Email: ");
        String email = lector.next();
        System.out.println();
        while (email == "") {
            System.out.print("### Error ###\nEl Email no puede estar vacio\n\n");
            System.out.print("Email: ");
            email = lector.next();
            System.out.println();
        }

        System.out.print("Contraseña: ");
        String clave = lector.next();
        System.out.println();
        while (clave == "") {
            System.out.print("### Error ###\nLa Contraseña no puede estar vaciá\n\n");
            System.out.print("Contraseña: ");
            clave = lector.next();
            System.out.println();
        }

        System.out.print("Nombre: ");
        String nombre = lector.next();
        System.out.println();
        while (nombre == "") {
            System.out.print("### Error ###\nEl nombre no puede estar vacio\n\n");
            System.out.print("Nombre: ");
            nombre = lector.next();
            System.out.println();
        }

        System.out.print("Apellido: ");
        String apellido = lector.next();
        System.out.println();
        while (apellido == "") {
            System.out.print("### Error ###\nEl apellido no puede estar vacio\n\n");
            System.out.print("Apellido: ");
            apellido = lector.next();
            System.out.println();
        }

        System.out.print("Edad: ");
        String edad = lector.next();
        System.out.println();
        while (edad == "") {
            System.out.print("### Error ###\nLa edad no puede estar vaciá\n\n");
            System.out.print("Edad: ");
            edad = lector.next();
            System.out.println();
        }

        System.out.print("Fecha de nacimiento \"dd-MM-yyyy\": ");
        String fechaNacimiento = lector.next();
        System.out.println();
        while (esFechaValida(fechaNacimiento)) {
            System.out.print("### Error ###\nLa Fecha de nacimiento no es valida\n\n");
            System.out.print("Fecha de nacimiento \"dd-MM-yyyy\": ");
            fechaNacimiento = lector.next();
            System.out.println();
        }

        System.out.print("Elija su genero:\nMasculino ingrese m\nFemenino ingrese f\n");
        String sexo = lector.next();
        System.out.println();
        while (sexo != "m" && sexo != "f") {
            System.out.print("### Error ###\nIngrese el tipo de genero correcto\n\n");
            System.out.print("Elija su genero:\nMasculino ingrese m\nFemenino ingrese f\n");
            sexo = lector.next();
            System.out.println(sexo);
        }

        System.out.print("Ingrese la altura (decimales separados con \".\")");
        String altura = lector.next();
        System.out.println();
        while (altura == "") {
            System.out.print("### Error ###\nLa altura no puede estar vaciá\n\n");
            System.out.print("Ingrese la altura (decimales separados con \".\")");
            altura = lector.next();
            System.out.println();
        }

        return new SocioDTO(
                email,
                clave,
                nombre,
                apellido,
                edad,
                fechaNacimiento,
                sexo,
                altura,
                ""
        );
    }

    //          Pantallas cuando el usuario esta logeado            //
    public static void homeUsuario(SocioDTO socioLogeado) {
        rutinaControlador = RutinaControlador.getInstance();
        System.out.println("Bienvenido "+socioLogeado.getNombre()+" "+socioLogeado.getApellido()+"\n");
        int respuesta = 0;
        while (respuesta != 1) {
            System.out.println("Menu:\n1.- Cerrar Sección\n2.- Empezar entrenamiento del día");
            System.out.println("3.- Ver Rutina\n4.- Ver logros");
            respuesta = lector.nextInt();
            System.out.println();
            while (respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4) {
                System.out.println("### Error en el ingreso de datos ###\n");
                System.out.println("Menu:\n1.- Cerrar Sección\n2.- Empezar entrenamiento del día");
                System.out.println("3.- Ver Rutina\n4.- Ver logros");
                respuesta = lector.nextInt();
            }
            if (respuesta == 1) {
                System.out.println("¿Estas seguro?\n1.- si\n0.- no");
                respuesta = lector.nextInt();
            }else if(respuesta == 2) {
                EntrenamientoDTO entrenamientoDTO = rutinaControlador.comenzarEntremaniento(socioLogeado);

            }else if(respuesta == 3) {

            }else {

            }
        }
    }

    private EntrenamientoDTO pantallaEntrenamientoDelDia(EntrenamientoDTO entrenamientoDTO) {

        return null;
    }

}

import Controladores.RutinaControlador;
import Controladores.SocioControlador;
import DTO.EjercicioDTO;
import DTO.LoginDTO;
import DTO.SocioDTO;
import Modelo.AutenticardorExterno;
import Vistas.Pantallas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        AutenticardorExterno validadorLogin = new AutenticardorExterno();
        SocioControlador socioControlador = SocioControlador.getInstancia();
        RutinaControlador rutinaControlador = RutinaControlador.getInstance();

        int respuesta = 0;
        while (respuesta != 4){
            System.out.print("Bienvenidos a la App Fitness Center\n\nElija una opcion:\n1.- Iniciar Sesion\n2.- Registrarse\n3.- Crear Ejercicio\n4.- Salir\n");
            respuesta = lector.nextInt();
            while (respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4) {
                Pantallas.limpiarPantalla();
                System.out.print("### Error en el dato ingresado ###\n\nElija una opcion:\n1.- Iniciar Sesion\n2.- Registrarse\n3.- Crear Ejercicio\n4.- Salir\n");
                respuesta = lector.nextInt();
            }

            if (respuesta == 1) {
                Pantallas.limpiarPantalla();
                LoginDTO respuestaLogin = validadorLogin.autenticarse(Pantallas.PantallaLogin());
                if (respuestaLogin.getRespuestaTipo().equals("claveInvalida")) {
                    Pantallas.limpiarPantalla();
                    System.out.print("### La contraseña es incorrecta ###");
                }else if(respuestaLogin.getRespuestaTipo().equals("correoInvalido")){
                    Pantallas.limpiarPantalla();
                    System.out.print("### Usuario no existe ###");
                }else {
                    SocioDTO socio = socioControlador.getSocioDtobyID(respuestaLogin.getSocioID());
                    Pantallas.homeUsuario(socio);
                }
            }else if (respuesta == 2) {
                Pantallas.limpiarPantalla();
                socioControlador.registrarSocio(Pantallas.registrarse());
            }
            else if (respuesta == 3) {
                Pantallas.limpiarPantalla();
                EjercicioDTO ejercicioNuevo = Pantallas.pantallaCrearEjercicio();
                rutinaControlador.crearEjercicio(ejercicioNuevo);
            }
        }
    }
  }
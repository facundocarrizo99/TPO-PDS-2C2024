package Vistas;

import Controladores.RutinaControlador;
import Controladores.SocioControlador;
import DTO.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Pantallas {
    public static final SocioControlador socioControlador = SocioControlador.getInstancia();
    private static final Scanner lector = new Scanner(System.in);

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean esFechaValida(String fecha) {
        return validarFormato(fecha);
    }

    private static boolean validarFormato(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        formato.setLenient(false); // Evita ajustes automáticos en la fecha
        try {
            formato.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static LoginDTO PantallaLogin() {
        showString("Email: ");
        String email = lector.next();
        System.out.println();
        while (email.isEmpty()) {
            showString("### Error ###\nEl Email no puede estar vacio\n\n");
            showString("Email: ");
            email = lector.next();
            System.out.println();
        }

        showString("Contraseña: ");
        String clave = lector.next();
        System.out.println();
        while (clave.isEmpty()) {
            showString("### Error ###\nLa Contraseña no puede estar vaciá\n\n");
            showString("Contraseña: ");
            clave = lector.next();
            System.out.println();
        }

        return new LoginDTO("", "", email, clave);
    }

    private static void showString(String s) {
        System.out.print(s);
    }

    public static SocioDTO registrarse() {
        showString("Formulario para Registrarse: \n\n");
        showString("Email: ");
        String email = lector.next();
        System.out.println();
        while (email.isEmpty()) {
            showString("### Error ###\nEl Email no puede estar vacio\n\n");
            showString("Email: ");
            email = lector.next();
            System.out.println();
        }

        showString("Contraseña: ");
        String clave = lector.next();
        System.out.println();
        while (clave.isEmpty()) {
            showString("### Error ###\nLa Contraseña no puede estar vaciá\n\n");
            showString("Contraseña: ");
            clave = lector.next();
            System.out.println();
        }

        showString("Nombre: ");
        String nombre = lector.next();
        System.out.println();
        while (nombre.isEmpty()) {
            showString("### Error ###\nEl nombre no puede estar vacio\n\n");
            showString("Nombre: ");
            nombre = lector.next();
            System.out.println();
        }

        showString("Apellido: ");
        String apellido = lector.next();
        System.out.println();
        while (apellido.isEmpty()) {
            showString("### Error ###\nEl apellido no puede estar vacio\n\n");
            showString("Apellido: ");
            apellido = lector.next();
            System.out.println();
        }

        showString("Edad: ");
        String edad = lector.next();
        System.out.println();
        while (edad.isEmpty()) {
            showString("### Error ###\nLa edad no puede estar vaciá\n\n");
            showString("Edad: ");
            edad = lector.next();
            System.out.println();
        }

        showString("Fecha de nacimiento \"dd-MM-yyyy\": ");
        String fechaNacimiento = lector.next();
        System.out.println();
        while (!esFechaValida(fechaNacimiento)) {
            showString("### Error ###\nLa Fecha de nacimiento no es valida\n\n");
            showString("Fecha de nacimiento \"dd-MM-yyyy\": ");
            fechaNacimiento = lector.next();
            System.out.println();
        }

        showString("Elija su genero:\nMasculino ingrese m\nFemenino ingrese f\n");
        String sexo = lector.next();
        System.out.println();
        while (!sexo.equals("m") && !sexo.equals("f")) {
            showString("### Error ###\nIngrese el tipo de genero correcto\n\n");
            showString("Elija su genero:\nMasculino ingrese m\nFemenino ingrese f\n");
            sexo = lector.next();
            System.out.println(sexo);
        }

        showString("Ingrese la altura en CM (decimales separados con \".\"): ");
        String altura = lector.next();
        System.out.println();
        while (altura.isEmpty()) {
            showString("### Error ###\nLa altura no puede estar vaciá\n\n");
            showString("Ingrese la altura (decimales separados con \".\")");
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
        RutinaControlador rutinaControlador = RutinaControlador.getInstance();

        System.out.println("Bienvenido " + socioLogeado.getNombre() + " " + socioLogeado.getApellido() + "\n");

        if (!socioControlador.tieneObjetivo(socioLogeado)) {
            socioControlador.pesarse(socioLogeado);
            elegirObjetivo(socioLogeado);
        }

        int respuesta = 0;
        while (respuesta != 8) {
            System.out.println("===== MENU GIMNASIO =====");
            System.out.println("1. Empezar Entrenamiento del Dia");
            System.out.println("2. Ver Rutina");
            System.out.println("3. Pesarse");
            System.out.println("4. Ver Progreso");
            System.out.println("5. Cambiar Objetivo");
            System.out.println("6. Ver Logros");
            System.out.println("7. Reforzar Rutina");
            System.out.println("8. Cerrar Sesion");
            System.out.println("============================");
            showString("Seleccione una opción (1-8): ");
            respuesta = lector.nextInt();
            System.out.println();
            while (respuesta != 1 && respuesta != 2 && respuesta != 3 && respuesta != 4 && respuesta != 5 &&
                    respuesta != 6 && respuesta != 7 && respuesta != 8) {
                System.out.println("### Por favor ingrese un valor valido ###\n");
                respuesta = lector.nextInt();
            }
            if (respuesta == 1) {
                EntrenamientoDTO entrenamientoDTO = rutinaControlador.comenzarEntremaniento(socioLogeado);
                EntrenamientoDTO entrenamientoFinalizado = pantallaEntrenamientoDelDia(entrenamientoDTO);
                socioControlador.finalizarEntrenamiento(socioLogeado, entrenamientoFinalizado);
            } else if (respuesta == 2) {
                RutinaDTO rutinaDTO = socioControlador.getRutinaDelSocio(socioLogeado);
                pantallaRutina(rutinaDTO);
            } else if (respuesta == 3) {
                socioControlador.pesarse(socioLogeado);
            } else if (respuesta == 4) {
                socioControlador.verProgreso(socioLogeado);

                enterParaContinuar();
            } else if (respuesta == 5) {
                elegirObjetivo(socioLogeado);
            } else if (respuesta == 6) {
                ArrayList<LogroDTO> logrosSocio = socioControlador.getlogrosSocio(socioLogeado);
                System.out.println("Aqui se muestran tus Trofeos");
                System.out.println("============================");
                for (LogroDTO logroDTO : logrosSocio) {
                    System.out.println("Trofeo: " + logroDTO.getNombre());
                }
                System.out.println("============================");
                enterParaContinuar();
            } else if (respuesta == 7) {
                System.out.println("Ingrese cuanto desea reforzar la rutina, debe ser en kg (los decimales con . )\n");
                String refuerzo = lector.next();
                while (Double.parseDouble(refuerzo) < 0) {
                    System.out.println("### Error el refuerzo debe ser positivo ###");
                    refuerzo = lector.next();
                }
                socioLogeado.setValorConfigurable(refuerzo);
                socioControlador.reforzarRutina(socioLogeado);
            }
        }
    }

    private static EntrenamientoDTO pantallaEntrenamientoDelDia(EntrenamientoDTO entrenamientoDTO) {
        limpiarPantalla();
        System.out.println("Entrenamiento del día: " + entrenamientoDTO.getDiaRutina());
        System.out.println("Lista de ejercicios:");

        // Recorremos la lista de ejercicios y mostramos los detalles de cada uno
        for (EjercicioDTO ejercicio : entrenamientoDTO.getEjercicios()) {
            System.out.println("======================================");
            System.out.println("Descripción: " + ejercicio.getDescripcion());
            System.out.println("Cantidad de Series: " + ejercicio.getCantidadSeries());
            System.out.println("Repeticiones: " + ejercicio.getRepeticiones());
            System.out.println("Peso: " + ejercicio.getPeso());
            System.out.println("Video Ilustrativo: " + ejercicio.getVideoIlustrativo());
            System.out.println("======================================\n");
            System.out.println("A continuacion ingrese los datos del ejercicio realizado");

            showString("Formulario de Ejercicio: \n\n");

            // Cantidad de Series
            showString("Cantidad de Series: ");
            String cantidadSeries = lector.next();
            System.out.println();
            while (cantidadSeries.isEmpty()) {
                showString("### Error ###\nLa Cantidad de Series no puede estar vacía\n\n");
                showString("Cantidad de Series: ");
                cantidadSeries = lector.next();
                System.out.println();
            }

            // Repeticiones
            showString("Repeticiones: ");
            String repeticiones = lector.next();
            System.out.println();
            while (repeticiones.isEmpty()) {
                showString("### Error ###\nLas Repeticiones no pueden estar vacías\n\n");
                showString("Repeticiones: ");
                repeticiones = lector.next();
                System.out.println();
            }

            // Peso
            showString("Peso: ");
            String peso = lector.next();
            System.out.println();
            while (peso.isEmpty()) {
                showString("### Error ###\nEl Peso no puede estar vacío\n\n");
                showString("Peso: ");
                peso = lector.next();
                System.out.println();
            }

            EjercicioDTO ejercicioFinalizado = ejercicio.copiar();
            ejercicioFinalizado.setCantidadSeries(cantidadSeries);
            ejercicioFinalizado.setRepeticiones(repeticiones);
            ejercicioFinalizado.setPeso(peso);

            entrenamientoDTO.getEjerciciosFinalizados().add(ejercicioFinalizado);
        }
        return entrenamientoDTO;
    }

    private static void pantallaRutina(RutinaDTO rutinaDTO) {
        limpiarPantalla();
        System.out.println("Rutina desde " + rutinaDTO.fechaInicio() + " hasta " + rutinaDTO.fechaFin());
        System.out.println("======================================");

        // Recorremos cada entrenamiento de la rutina
        for (EntrenamientoDTO entrenamiento : rutinaDTO.rutina()) {
            System.out.println("Entrenamiento del día: " + entrenamiento.getDiaRutina());
            System.out.println("Ejercicios:");

            // Recorremos cada ejercicio del entrenamiento y mostramos solo la descripción
            for (EjercicioDTO ejercicio : entrenamiento.getEjercicios()) {
                System.out.println("- Descripción: " + ejercicio.getDescripcion());
            }

            System.out.println("======================================\n");
        }
        enterParaContinuar();
    }

    private static void elegirObjetivo(SocioDTO socioDTO) {
        System.out.println("===== Cambiar Objetivo =====");
        System.out.println("1. Bajar de peso");
        System.out.println("2. Mantener Figura");
        System.out.println("3. Tonificar");
        System.out.println("============================");
        showString("Seleccione una opción (1-3): ");
        int opcion = lector.nextInt();
        if (opcion == 1) {
            System.out.println("Has seleccionado: Bajar de peso");
            socioDTO.setObjetivo("1");
        } else if (opcion == 2) {
            System.out.println("Has seleccionado: Mantener Figura");
            System.out.print("Ingrese el valor configurable (los decimales con . )\n");
            String refuerzo = lector.next();
            while (Double.parseDouble(refuerzo) < 0) {
                System.out.println("### Error el refuerzo debe ser positivo ###");
                refuerzo = lector.next();
            }
            socioDTO.setValorConfigurable(refuerzo);
            socioDTO.setObjetivo("2");
        } else if (opcion == 3) {
            System.out.println("Has seleccionado: Tonificar");
            socioDTO.setObjetivo("3");
        }
        socioControlador.cambiarObjetivo(socioDTO);
    }

    // Métodos para validar entrada numérica
    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static boolean isDouble(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    private static void enterParaContinuar(){
        System.out.print("Escriba algun numero para continuar...\n");
        int aux = lector.nextInt();
        System.out.print("\n\n");
    }

    public static EjercicioDTO pantallaCrearEjercicio() {

        // Pedir Descripción
        showString("Descripción del ejercicio: ");
        String descripcion = lector.nextLine();
        while (descripcion.isEmpty()) {
            showString("### Error ###\nLa descripción no puede estar vacía\n\n");
            showString("Descripción del ejercicio: ");
            descripcion = lector.nextLine();
        }

        // Pedir Video
        showString("Video ilustrativo del ejercicio: ");
        String video = lector.nextLine();
        while (video.isEmpty()) {
            showString("### Error ###\nEl Video No  no puede estar vacía\n\n");
            showString("Video ilustrativo del ejercicio: ");
            video = lector.nextLine();
        }

        // Pedir Dificultad
        showString("Dificultad (BAJO, MEDIO, ALTO): ");
        String nivelExigencia = lector.nextLine();
        while (!nivelExigencia.equals("BAJO") && !nivelExigencia.equals("MEDIO") && !nivelExigencia.equals("ALTO")) {
            showString("### Error ###\nDificultad no válida. Elija entre 'BAJO', 'MEDIO' o 'ALTO'\n\n");
            showString("Dificultad (BAJO, MEDIO, ALTO): ");
            nivelExigencia = lector.nextLine();
        }

        // Pedir Categoría
        showString("Grupo Muscular (PECHO, ESPALDA, HOMBROS, PIERNAS, BRAZOS): ");
        String grupoMuscular = lector.nextLine();
        while (!grupoMuscular.equals("PECHO") && !grupoMuscular.equals("ESPALDA") && !grupoMuscular.equals("HOMBROS") && !grupoMuscular.equals("PIERNAS") && !grupoMuscular.equals("BRAZOS")) {
            showString("### Error ###\nDificultad no válida. Elija entre 'PECHO', 'ESPALDA', HOMBROS, PIERNAS o 'BRAZOS'\n\n");
            showString("Grupo Muscular (PECHO, ESPALDA, HOMBROS, PIERNAS, BRAZOS): ");
            grupoMuscular = lector.nextLine();
        }

        // Pedir Nivel Aerobico
        showString("Nivel Aerobico: ");
        String nivelAerobico = lector.nextLine();
        while (nivelAerobico.isEmpty() || !isNumeric(nivelAerobico)) {
            showString("### Error ###\nEl Nivel Aerobico debe ser un número válido\n\n");
            showString("Nivel Aerobico: ");
            nivelAerobico = lector.nextLine();
        }
        // Crear y retornar el objeto EjercicioDTO
        return new EjercicioDTO(
                grupoMuscular,
                nivelAerobico,
                nivelExigencia,
                video,
                descripcion
        );
    }
}
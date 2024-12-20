package baseDatos;

import java.sql.Date;
import java.util.ArrayList;

import Modelo.Socio;
import Modelo.Rutina.Ejercicio;
import Enum.GrupoMuscular;
import Enum.NivelExigencia;

public class BD {
    private ArrayList<Socio> socios;
    private ArrayList<Ejercicio> ejercicios;
    private static BD instancia;

    private BD() {
        socios = new ArrayList<>();
        ejercicios = new ArrayList<>();
        guardarEjercicios();
        guardarSociosBase();
    }

    public static BD getInstancia() {
        if (instancia == null) {
            instancia = new BD();
        }
        return instancia;
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
        System.out.println(socios.get(socio.getID() - 1).getNombre());
    }

    public int getsizeSocios() {
        return socios.size();
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public Socio getSocioByID(int ID) {
        if (ID > socios.size()) {
            return null; //validacion de que el ID sea valido
        }
        Socio socio = socios.get(ID - 1);
        if (!socio.getBaja()) {
            return socio;
        }
        return null;
    }

    public void eliminarSocio(int ID) {
        Socio socio = socios.get(ID - 1);
        socio.setBaja(true);
    }

    public void eliminarEjercicio(int ID) {
        Ejercicio ejercicio = ejercicios.get(ID - 1);
        ejercicio.setBaja(true);
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    public void mostrarEjercicioPrueba() {
        System.out.println(ejercicios.getFirst().getDescripcion() + ejercicios.getFirst().getCantidadSeries());
    }

    public int getSizeEjercicios() {
        return ejercicios.size();

    }

    public Ejercicio getEjercicioByID(int ID) {
        if (ID > ejercicios.size()) {
            return null;
        }
        if (!ejercicios.get(ID - 1).getBaja()) {
            return ejercicios.get(ID - 1);
        }
        return null;
    }

    public void guardarSociosBase() {
        socios.add(new Socio("sam", "hola", "Sam", "Guerrero", 25,
                Date.valueOf("1999-10-10"), "M", 190, 1));
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
        ejercicios.add(new Ejercicio("Flexiones Triceps", GrupoMuscular.BRAZOS, 2, NivelExigencia.ALTO, "Video.mp4"));
        ejercicios.add(new Ejercicio("Flexiones", GrupoMuscular.PECHO, 2, NivelExigencia.MEDIO, "Video.mp4"));
        ejercicios.add(new Ejercicio("Remo con barra ", GrupoMuscular.ESPALDA, 3, NivelExigencia.BAJO, "Video.mp4"));
        ejercicios.add(new Ejercicio("Elevanciones Laterales", GrupoMuscular.HOMBROS, 2, NivelExigencia.MEDIO, "Video.mp4"));
        ejercicios.add(new Ejercicio("Sentadilla", GrupoMuscular.PIERNAS, 3, NivelExigencia.BAJO, "Video.mp4"));
        ejercicios.add(new Ejercicio("Fondos de Tríceps", GrupoMuscular.BRAZOS, 3, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Curl de Bíceps", GrupoMuscular.BRAZOS, 4, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Elevación de talones", GrupoMuscular.PIERNAS, 3, NivelExigencia.BAJO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Abdominales crunch", GrupoMuscular.PECHO, 3, NivelExigencia.BAJO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Plancha", GrupoMuscular.PECHO, 1, NivelExigencia.ALTO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Press de piernas", GrupoMuscular.PIERNAS, 3, NivelExigencia.ALTO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Press Arnold", GrupoMuscular.HOMBROS, 4, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Dominadas", GrupoMuscular.ESPALDA, 3, NivelExigencia.ALTO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Crunch oblicuo", GrupoMuscular.PECHO, 2, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Desplantes", GrupoMuscular.PIERNAS, 4, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Pull-Ups", GrupoMuscular.ESPALDA, 3, NivelExigencia.ALTO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Press francés", GrupoMuscular.BRAZOS, 3, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Flexión diamante", GrupoMuscular.BRAZOS, 2, NivelExigencia.ALTO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Mountain Climbers", GrupoMuscular.PECHO, 3, NivelExigencia.MEDIO, "Video.mp4"));
        this.ejercicios.add(new Ejercicio("Cardio en cinta", GrupoMuscular.PIERNAS, 5, NivelExigencia.ALTO, "Video.mp4"));


    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}

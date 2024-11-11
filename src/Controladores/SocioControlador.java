package Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.EntrenamientoDTO;
import DTO.LogroDTO;
import DTO.RutinaDTO;
import DTO.SocioDTO;
import Modelo.Objetivo.BajarPeso;
import Modelo.Objetivo.MantenerFigura;
import Modelo.Objetivo.Objetivo;
import Modelo.Objetivo.TonificarCuerpo;
import Modelo.Socio;
import Modelo.Trofeo.Trofeo;
import baseDatos.BD;
import Modelo.Peso.Peso;


public class SocioControlador {
    private static SocioControlador instancia;
    private final BD bd;
    private final RutinaControlador rutinaControlador;


    private SocioControlador() {
        bd = BD.getInstancia();
        rutinaControlador = RutinaControlador.getInstance();
    }

    public static SocioControlador getInstancia() {
        if (instancia == null) {
            instancia = new SocioControlador();
        }
        return instancia;
    }

    public Socio getSocioByID(String ID) {
        return bd.getSocioByID(Integer.parseInt(ID));
    }

    public SocioDTO getSocioDtobyID(String ID) {
        Socio socio = bd.getSocioByID(Integer.parseInt(ID));

        return new SocioDTO(
                socio.getMail(),
                "",
                socio.getNombre(),
                socio.getApellido(),
                "",
                "",
                "",
                "",
                String.valueOf(socio.getID())
        );
    }

    public void registrarSocio(SocioDTO socio) {
        Socio nuevoSocio = toModel(socio);
        bd.agregarSocio(nuevoSocio);
    }

    public void editarSocio(SocioDTO socio) {
        Socio editado = bd.getSocioByID(Integer.parseInt(socio.getID()));
        Socio datosNuevos = toModel(socio);
        if (!socio.getMail().isEmpty()) {
            editado.setMail(datosNuevos.getMail());
        }
        if (!socio.getClave().isEmpty()) {
            editado.setClave(datosNuevos.getClave());
        }
        if (!socio.getNombre().isEmpty()) {
            editado.setNombre(datosNuevos.getNombre());
        }
        if (!socio.getApellido().isEmpty()) {
            editado.setApellido(datosNuevos.getApellido());
        }
        if (!socio.getEdad().equals("0")) {
            editado.setEdad(datosNuevos.getEdad());
        }
        if (socio.getFechaNacimiento().equals("0")) {
            editado.setFechaNacimiento(datosNuevos.getFechaNacimiento());
        }
        if (!socio.getSexo().isEmpty()) {
            editado.setSexo(datosNuevos.getSexo());
        }
        if (socio.getAltura().equals("0")) {
            editado.setAltura(datosNuevos.getAltura());
        }
    }

    public boolean eliminarSocio(SocioDTO socio) {
        int socioID = Integer.parseInt(socio.getID());
        bd.eliminarSocio(socioID);
        return true;
    }

    public boolean pesarse(SocioDTO socioDTO) {
        int socioID = Integer.parseInt(socioDTO.getID());
        Socio socio = bd.getSocioByID(socioID);
        socio.pesarse();
        return socio.getObjetivo() != null && socio.getObjetivo().seEstaCumpliendo(socio) && socio.getObjetivo() instanceof BajarPeso;
    }

    private Socio toModel(SocioDTO socio) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        formato.setLenient(false);
        Date fecha = null;

        try {
            fecha = formato.parse(socio.getFechaNacimiento());
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        int ID = bd.getsizeSocios() + 1;
        return new Socio(
                socio.getMail(),
                socio.getClave(),
                socio.getNombre(),
                socio.getApellido(),
                Integer.parseInt(socio.getEdad()),
                fecha,
                socio.getSexo(),
                Double.parseDouble(socio.getAltura()),
                ID
        );
    }

    public boolean tieneObjetivo(SocioDTO socioDTO) {
        int id = Integer.parseInt(socioDTO.getID());
        Socio socio = bd.getSocioByID(id);
        return socio.getObjetivo() != null;
    }

    public void verProgreso(SocioDTO socioDTO) {
        Socio socio = bd.getSocioByID(Integer.parseInt(socioDTO.getID()));
        ArrayList<Peso> lista = socio.getPesos();

        System.out.println("Tu peso actual es de: " + lista.getLast().getPesoKG() + "Kg");
        System.out.println("Aqui tu historial de Pesos:");
        for (Peso peso : lista) {
            System.out.println("Peso: " + peso.getPesoKG() + "Kg ||" + "Fecha: " + (peso.getFecha()) + " || Masa muscular: " + peso.getMasaMuscularKG() + "% || Grasa corporal: " + peso.getPorcentajeGrasa() + "%");
        }

    }


    public void finalizarEntrenamiento(SocioDTO socioDTO, EntrenamientoDTO entrenamientoDTO) {
        Socio socio = bd.getSocioByID(Integer.parseInt(socioDTO.getID()));
        rutinaControlador.finalizarUnEntrenamiento(entrenamientoDTO, socio);
    }

    public void cambiarObjetivo(SocioDTO socioDTO) {
        int id = Integer.parseInt(socioDTO.getID());
        Socio socio = bd.getSocioByID(id);
        Objetivo objetivo = switch (socioDTO.getObjetivo()) {
            case "1" -> new BajarPeso(socio);
            case "2" ->
                    new MantenerFigura(Double.parseDouble(socioDTO.getValorConfigurable()), socio.getPesos().getLast());
            case "3" -> new TonificarCuerpo();
            default -> null;
        };
        socio.cambiarObjetivo(objetivo);
    }

    public RutinaDTO getRutinaDelSocio(SocioDTO socioDTO) {
        Socio socio = bd.getSocioByID(Integer.parseInt(socioDTO.getID()));
        return rutinaControlador.rutinaToDTO(socio.getObjetivo().getRutina());
    }

    public void reforzarRutina(SocioDTO socioDTO) {
        Socio socio = bd.getSocioByID(Integer.parseInt(socioDTO.getID()));
        rutinaControlador.reforzarRutina(Double.parseDouble(socioDTO.getValorConfigurable()), socio.getObjetivo().getRutina());
    }

    public ArrayList<LogroDTO> getlogrosSocio(SocioDTO socioDTO) {
        Socio socio = bd.getSocioByID(Integer.parseInt(socioDTO.getID()));
        ArrayList<Trofeo> trofeos = socio.getTrofeos();
        ArrayList<LogroDTO> logros = new ArrayList<>();
        for (Trofeo trofeo : trofeos) {
            logros.add(new LogroDTO(trofeo.getNombre()));
        }
        return logros;
    }
}

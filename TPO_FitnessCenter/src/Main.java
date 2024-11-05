import Controladores.SocioControlador;
import DTO.SocioDTO;
import baseDatos.BD;

public class Main {
    public static void main(String[] args) {
        SocioDTO socio = new SocioDTO(
        		"email",
        		"clave",
        		"sam",
        		"guerrero",
        		"5",
        		"1997-07-04",
        		"m",
        		"1.70",
        		""
        		);
        
        SocioControlador SC = SocioControlador.getInstancia();
        
        SC.registrarSocio(socio);
        BD bd = BD.getInstancia();
        bd.mostrarSocioPrueba();
        
        SocioDTO cambiosSamuel = new SocioDTO(
        		"",
        		"",
        		"samuel",
        		"guerrero",
        		"27",
        		"1997-07-04",
        		"m",
        		"1.70",
        		"1"
        		);
        SC.editarSocio(cambiosSamuel);
        System.out.println("-----");
        bd.mostrarSocioPrueba();
        
    }
}
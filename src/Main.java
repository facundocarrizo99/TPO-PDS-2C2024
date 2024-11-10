import Controladores.EjercicioControlador;
import Controladores.SocioControlador;
import DTO.EjercicioDTO;
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
        EjercicioDTO ejercicio = new EjercicioDTO(
        		"1",
        		"Salta Cuerda", 
        		"PECHO",
        		"2",   
        		"10",	
        		"10.00",	
        		"1",
        		"BAJA",
        		"VIDEO.MP4");
        EjercicioDTO ejercicio1 = new EjercicioDTO(
        		"1",
        		"Descripcion Cambiada", 
        		"PECHO",
        		"0",   
        		"10",	
        		"10.00",	
        		"1",
        		"BAJA",
        		"VIDEO.MP4");
      
        
        SocioControlador SC = SocioControlador.getInstancia();
		BD bd = BD.getInstancia();
        SC.registrarSocio(socio);
        bd.mostrarSocioPrueba();
        
        SocioDTO cambiosSamuel = new SocioDTO(
        		"",
        		"",
        		"",
        		"",
        		"",
        		"",
        		"",
        		"",
        		""
        		);
        SC.editarSocio(cambiosSamuel);
        System.out.println("-----");
        bd.mostrarSocioPrueba();
        

        
    }
  }
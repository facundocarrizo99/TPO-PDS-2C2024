package Modelo;

import Modelo.Trofeo.Trofeo;

public class NotificadorPush {

    public String notificarTrofeo(Socio socio, Trofeo trofeo) {
        String mensaje = "¡Felicidades " + socio.getNombre() + "! Has ganado el trofeo: " + trofeo.getNombre();
        System.out.println(mensaje); // Simulación de la notificación
        return mensaje;
    }
}

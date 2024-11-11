package Modelo.Trofeo;

import Interfaeces.IObserver;
import Modelo.NotificadorPush;
import Modelo.Socio;

public abstract class Trofeo implements IObserver {
    private String nombre;
    private NotificadorPush notificador = new NotificadorPush();

    public Trofeo(String nombre, NotificadorPush notificador) {
        this.nombre = nombre;
        this.notificador = notificador;
    }

    public void otorgarTrofeo(Socio socio) {
        socio.getTrofeos().add(this);
        notificador.notificarTrofeo(socio, this);
    };

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NotificadorPush getNotificador() {
        return this.notificador;
    }
}

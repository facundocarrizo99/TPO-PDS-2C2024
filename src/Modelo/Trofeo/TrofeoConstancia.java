package Modelo.Trofeo;

import Interfaeces.IObservable;
import Modelo.NotificadorPush;
import Modelo.Rutina.Entrenamiento;
import Modelo.Rutina.Rutina;
import Modelo.Socio;

public class TrofeoConstancia extends Trofeo {
    public TrofeoConstancia(NotificadorPush notificadorPush) {
        super("Trofeo a la Constancia", notificadorPush);
    }

    ///Analiza las rutinas de los socios y les otorga un trofeo si cumplen con toda la rutina

    @Override
    public void serNotificadoPor(IObservable observado) {
        if (observado instanceof Rutina rutina) {
            controlarEntrenamientos(rutina);
        }
    }

    public void controlarEntrenamientos(Rutina rutina) {
        boolean res = true;
        for (Entrenamiento entrenamiento : rutina.getEntrenamientos()) {
            if (entrenamiento.getEjercicios().size() != entrenamiento.getEjerciciosFinalizados().size()) {
                res = false;
                break;
            }
        }
        if (res) {
            otorgarTrofeo(rutina.getSocio());
        }
    }
}
package Modelo.Trofeo;

import Interfaeces.IObservable;
import Modelo.NotificadorPush;
import Modelo.Socio;

public class TrofeoDedicacion extends Trofeo {
    ///Se le asigna a aquel que cumpla su objetivo

    public TrofeoDedicacion(NotificadorPush notificadorPush) {
        super("Trofeo a la Dedicacion", notificadorPush);
    }

    @Override
    public void serNotificadoPor(IObservable observado) {
        if (observado instanceof Socio socio) {
            controlarEstadoObjetivo(socio);
        }
    }
    public void controlarEstadoObjetivo(Socio socio) {
        if(socio.getObjetivo().seEstaCumpliendo(socio)){
            otorgarTrofeo(socio);
        }
    }
}

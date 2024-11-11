package Modelo.Trofeo;

import Interfaeces.IObservable;
import Modelo.NotificadorPush;
import Modelo.Socio;

public class TrofeoCreido extends Trofeo {
    ///Se le asigna a aquel que se pese mas de 3 veces en un mes

    public TrofeoCreido(NotificadorPush notificadorPush) {
        super("Trofeo al Creido", notificadorPush);
    }


    @Override
    public void serNotificadoPor(IObservable observado) {
        if (observado instanceof Socio socio) {
            controlarCantidadPesajes(socio);
        }
    }
    public void controlarCantidadPesajes(Socio socio) {
        if (socio.getPesos().size() >= 3) {
            otorgarTrofeo(socio);
        }

    }
}

package Modelo;

import DTO.LoginDTO;
import Interfaeces.IAuth;
import baseDatos.BD;

import java.util.List;

public class AutenticardorExterno implements IAuth {

    public LoginDTO autenticarse(LoginDTO datosLogin) {
        BD baseDatos = BD.getInstancia();
        List<Socio> socios = baseDatos.getSocios();
        LoginDTO respuesta = new LoginDTO(
                "",
                "error",
                "",
                ""
        );
        for (Socio socio : socios) {
            if (socio.getMail().equals(datosLogin.getEmail())) {
                if (socio.getClave().equals(datosLogin.getClave())) {
                    respuesta = new LoginDTO(
                            String.valueOf(socio.getID()),
                            "ok",
                            "",
                            ""
                    );
                } else {
                    respuesta = new LoginDTO(
                            "",
                            "claveInvalida",
                            "",
                            ""
                    );
                }
            } else {
                respuesta = new LoginDTO(
                        "",
                        "correoInvalido",
                        "",
                        ""
                );
            }
        }

        return respuesta;
    }

}

package Modelo;

import DTO.LoginDTO;
import Interfaeces.IAuth;
import baseDatos.BD;

public class AutenticardorExterno implements IAuth {

    public LoginDTO autenticarse(LoginDTO datosLogin){
        BD baseDatos = BD.getInstancia();
        return baseDatos.loginSocio(datosLogin);
    }
}

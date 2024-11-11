package Interfaeces;

import DTO.LoginDTO;

public interface IAuth {
    LoginDTO autenticarse(LoginDTO datosLogin);
}

package DTO;

public class LoginDTO {
    private String socioID;
    private String respuestaTipo;
    private String email;
    private String clave;

    public LoginDTO(String socioID, String respuestaTipo, String email, String clave) {
        this.socioID = socioID;
        this.respuestaTipo = respuestaTipo;
        this.email = email;
        this.clave = clave;
    }

    public String getSocioID() {
        return socioID;
    }

    public String getRespuestaTipo() {
        return respuestaTipo;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Modelo.Usuario;

package Test;


public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
    }

    @Test
    public void testSetAndGetMail() {
        String mail = "test@example.com";
        usuario.setMail(mail);
        assertEquals(mail, usuario.getMail());
    }

    @Test
    public void testSetAndGetClave() {
        String clave = "password123";
        usuario.setClave(clave);
        assertEquals(clave, usuario.getClave());
    }

    @Test
    public void testSetAndGetNombre() {
        String nombre = "John";
        usuario.setNombre(nombre);
        assertEquals(nombre, usuario.getNombre());
    }

    @Test
    public void testSetAndGetApellido() {
        String apellido = "Doe";
        usuario.setApellido(apellido);
        assertEquals(apellido, usuario.getApellido());
    }
}
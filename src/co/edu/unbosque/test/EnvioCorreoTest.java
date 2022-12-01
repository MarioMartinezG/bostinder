/**
 * Pruebas unitarias para el envio de correo electronico
 */
package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.EnvioCorreo;

/**
 * @author Andres.Martinez
 *
 */
public class EnvioCorreoTest {
	private EnvioCorreo correo;
	private final static String destinatario = "dvmurcia@unbosque.edu.co";
	private final static String usuario = "dvmurcia";
	private final static String contrasena = "Test123*";

	@Before
	public void setUp() {
		correo = new EnvioCorreo();
	}

	@Test
	public void testEnvioCorreo() {
		boolean enviaCorreo = correo.enviarCorreo(destinatario, usuario, contrasena);
		assertEquals("Debe enviar el correo al destinatario designado.", true, enviaCorreo);
	}

}

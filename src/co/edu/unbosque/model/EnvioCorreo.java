/**
 * Clase con la logica para envio de correos
 */
package co.edu.unbosque.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Andres.Martinez
 *
 */
public class EnvioCorreo {
	private final Properties properties = new Properties();
	private final String remitente = "serviciovudu@gmail.com";
	private final String contrasena = "qqzittimwksylpwk";
	private static Session sesion;


	public boolean enviarCorreo(String destinatario, String usuario, String contrasena) {
		inicializar();

		try {
			MimeMessage message = new MimeMessage(sesion);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Verificacion de registro en Vudu");
			message.setText("Bienvenido a la aplicacion Vudu - Creada por Bostinder \n"
					+ "A continuacion, relacionamos sus credenciales de acceso para acceder a la aplicacion: \n"
					+ "Usuario: " + usuario +"\n"
					+ "Contraseña: " + contrasena);
			Transport.send(message);

			System.out.println("Correo enviado");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void inicializar() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		sesion = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, contrasena);
			}
		});
	}
}

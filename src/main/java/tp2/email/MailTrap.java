package tp2.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import tp2.model.Notificacion;

import java.util.Properties;

public class MailTrap implements Notificacion {

    private String host;
    private String username;
    private String password;
    private int port;

    public MailTrap(String host, String username, String password, int port){
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    @Override
    public void enviarEmail(String email, String textoDelEmail){
        // provide recipient's email ID
        String to = email;
        // provide sender's email ID
        String from = "mensajeCumpleaños@your.domain";
        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // set email subject field
            message.setSubject("Feliz cumpleaños");
            // set the content of the email message
            message.setText("¡Feliz cumpleaños!");

            // send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

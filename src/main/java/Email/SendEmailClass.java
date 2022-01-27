package Email;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * <h1>Email sending class</h1>
 * Sends an email using the javax.mail library
 *
 * @author Can Dechert
 */

public class SendEmailClass{
    public static void main(String[] args) throws MessagingException {

    }

    /**
     * @param receiver Email input for the recipient address
     * @param subject  Email header
     * @param text     Email text
     */
    public static void SendEmail(String receiver,
                                 String subject,
                                 String text) throws MessagingException
    {
        //Store the email account credentials
        String sender = "ehealth1@gmx.de";
        String password = "ehealth123";

        // Configuring the email server
        Properties properties = new Properties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "mail.gmx.net");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        //  Initializing the email account login session
        Session mailSession = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(sender, password);
            }
        });

        //  Initializing the message information and content
        Message message = new MimeMessage(mailSession);
        InternetAddress addressTo = new InternetAddress(receiver);
        message.setRecipient(Message.RecipientType.TO, addressTo);
        message.setFrom(new InternetAddress(sender));
        message.setSubject(subject);
        message.setContent(text, "text/plain");

        //  Sending message...
        Transport.send(message);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {

    public static void main(String args[]){
        try{
            
            String host ="smtp.gmail.com" ;
            String user = "pritom.podder@gmail.com";
            String pass = "password";
            String receiver = "supreme.koushik@gmail.com";
            String sender = "pritom.podder@gmail.com";
            
            String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();  // to set different types of properties

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            //we need securities which java provides
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(sender));
            InternetAddress[] address = {new InternetAddress(receiver)};  // Address of the sender
            msg.setRecipients(Message.RecipientType.TO, address);   // Reciever of email
            msg.setSubject(subject); msg.setSentDate(new Date());   // message sent date
            msg.setText(messageText);   // actual message

           Transport transport=mailSession.getTransport("smtp");  // server through which we are going to send mail
           transport.connect(host, user, pass);   // we need this to authetic sender mail & password
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        

    }
}
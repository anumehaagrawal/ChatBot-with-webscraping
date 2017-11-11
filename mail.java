    package chat;
    import java.util.*;  
    import javax.mail.*;  
    import javax.mail.internet.*;  
    import javax.activation.*;  
    import java.io.*;
    public class mail
    {  
        public static void main(String [] args)throws IOException
        {  
            DataInputStream in = new DataInputStream(System.in);
            System.out.println("Enter the sender's email id");
            String to = in.readLine(); 
            System.out.println("Enter the receiver's email id");
            String from = in.readLine();  
            String host = "localhost";//or IP address  
      
         //Get the session object  
          Properties properties = System.getProperties();  
          properties.setProperty("mail.smtp.host", host);  
          Session session = Session.getDefaultInstance(properties);  
      
         //compose the message  
          try{  
             MimeMessage message = new MimeMessage(session);  
             message.setFrom(new InternetAddress(from));  
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
             message.setSubject("Ping");  
             message.setText("Hello, this is example of sending email  ");  
      
             // Send message  
             Transport.send(message);  
             System.out.println("message sent successfully....");  
      
          }catch (MessagingException mex) {mex.printStackTrace();}  
       }  
    }  

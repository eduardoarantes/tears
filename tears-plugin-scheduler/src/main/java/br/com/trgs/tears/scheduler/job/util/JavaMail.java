package br.com.trgs.tears.scheduler.job.util;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail
{

   private Properties props = new Properties();
   private Authenticator authenticator;
   private String smtpUser;

   public JavaMail( String host, String port, String smtpUser, String smtpPassword, boolean smtpAuth )
   {
      this.smtpUser = smtpUser;
      authenticator = new PasswordAuthenticator( smtpUser, smtpPassword );
      props.put( "mail.smtp.host", host );
      props.put( "mail.smtp.port", port );

      if( smtpAuth )
      {
         props.put( "mail.smtp.auth", String.valueOf( smtpAuth ) );
         props.put( "mail.smtp.ssl.enable", String.valueOf( smtpAuth ) );
         props.put( "mail.smtp.socketFactory.port", "465" );
         props.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );
         props.put( "mail.smtp.socketFactory.fallback", "false" );
      }
   }

   public void sendMail( String emailTo, String subject, String messageText, String filename ) throws Exception
   {
      sendMail( emailTo, subject, messageText, filename, null );
   }

   public void sendMail( String emailTo, String subject, String messageText, String filename, String replyTo ) throws Exception
   {
      try
      {
         Session session = Session.getInstance( props, this.authenticator );
         InternetAddress from = new InternetAddress( smtpUser );
         InternetAddress to = new InternetAddress( emailTo );

         MimeMessage message = new MimeMessage( session );
         message.setFrom( from );
         message.addRecipient( Message.RecipientType.TO, to );
         message.setSubject( subject );

         if( replyTo != null )
         {
            Address[] addresses;
            addresses = new InternetAddress[1];
            addresses[0] = new InternetAddress( replyTo );
            message.setReplyTo( addresses );
         }
         MimeMultipart multipart = new MimeMultipart( "related" );
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setContent( messageText, "text/html" );
         multipart.addBodyPart( messageBodyPart );

         BodyPart attachmentBodyPart = new MimeBodyPart();

         // anexa o arquivo na mensagem
         File file = new File( filename );
         FileDataSource fds = new FileDataSource( file );
         attachmentBodyPart.setDataHandler( new DataHandler( fds ) );
         attachmentBodyPart.setFileName( fds.getName() );
         
         multipart.addBodyPart( attachmentBodyPart);

         message.setContent( multipart );
         message.setSentDate( new Date() );

         Transport.send( message );
      }
      catch( Exception e )
      {
         String msg = "Error sending email para : " + emailTo + ",  subject:" + subject;
         throw new Exception( msg, e );
      }
   }

}

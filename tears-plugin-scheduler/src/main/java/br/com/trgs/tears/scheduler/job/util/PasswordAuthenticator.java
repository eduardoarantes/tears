package br.com.trgs.tears.scheduler.job.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class PasswordAuthenticator extends Authenticator
{
   private String user = null;
   private String password = null;

   public PasswordAuthenticator( String user, String password )
   {
      super();
      this.user = user;
      this.password = password;
   }

   public PasswordAuthentication getPasswordAuthentication()
   {

      return new PasswordAuthentication( user, password );
   }

}

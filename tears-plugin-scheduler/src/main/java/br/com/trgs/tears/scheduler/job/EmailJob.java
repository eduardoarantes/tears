package br.com.trgs.tears.scheduler.job;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import br.com.trgs.tears.scheduler.job.util.JavaMail;

import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.ReportsApplication;

public class EmailJob extends AbstractJob implements Job
{

   @Override
   public void execute( JobExecutionContext context )
   {
      String encoding = (String) context.getJobDetail().getJobDataMap().get( "encoding" );
      if(encoding == null){
         encoding = ReportsApplication
         .getInstance().getApplicationProperty( IReportsApplication.PROPERTIES.ENCODING );
      }
      Collection< Collection< byte[] >> relatorios = getRecordSets( context, encoding );
//       Collection< Collection< byte[] >> relatorios = new ArrayList< Collection< byte[] > >();
//       Collection< byte[] > line = new ArrayList< byte[] >();
//       line.add( new byte[] { 100, 101, 100 } );
//       relatorios.add( line );

      Collection< StringBuilder > builders = new ArrayList< StringBuilder >();

      // read all parameters
      String filename = (String) context.getJobDetail().getJobDataMap().get( "filename" );
      String filepath = (String) context.getJobDetail().getJobDataMap().get( IReportsApplication.PROPERTIES.APPLICATION_TEMP_FOLDER );
      if( StringUtils.isBlank( filepath ) )
      {
         filepath = ReportsApplication.getInstance().getApplicationProperty( IReportsApplication.PROPERTIES.APPLICATION_TEMP_FOLDER );
      }
      String doCompressFile = (String) context.getJobDetail().getJobDataMap().get( "compressFile" );

      String to = (String) context.getJobDetail().getJobDataMap().get( "to" );
      String subject = (String) context.getJobDetail().getJobDataMap().get( "subject" );
      String message = (String) context.getJobDetail().getJobDataMap().get( "message" );
      String host = (String) context.getJobDetail().getJobDataMap().get( "host" );
      String port = (String) context.getJobDetail().getJobDataMap().get( "port" );
      boolean auth = Boolean.parseBoolean( (String) context.getJobDetail().getJobDataMap().get( "auth" ) );
      String user = (String) context.getJobDetail().getJobDataMap().get( "user" );
      String password = (String) context.getJobDetail().getJobDataMap().get( "password" );

      String[] tos = null;

      // create array with email adresses
      if( StringUtils.isNotBlank( to ) )
      {
         tos = StringUtils.split( to, "," );
      }

      try
      {
         builders = createBuilder( relatorios );
         filename = createFile( builders, filename, filepath, doCompressFile );
         JavaMail javaMail = new JavaMail( host, port, user, password, auth );
         for( String t : tos )
         {
            javaMail.sendMail( StringUtils.trim( t ), subject, message, filename );
         }
      }
      catch( Exception e )
      {
         log.error( e);
      }
   }
}

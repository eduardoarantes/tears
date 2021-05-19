package br.com.trgs.tears.scheduler.job;

import java.util.Collection;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.ReportsApplication;

public class FileSystemJob extends AbstractJob implements Job
{

   @Override
   public void execute( JobExecutionContext context ) throws JobExecutionException
   {
      String encoding = (String) context.getJobDetail().getJobDataMap().get( "encoding" );
      if( encoding == null )
      {
         encoding = ReportsApplication.getInstance().getApplicationProperty( IReportsApplication.PROPERTIES.ENCODING );
      }
      Collection< Collection< byte[] >> relatorios = getRecordSets( context, encoding );

      Collection< StringBuilder > builders;

      JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
      String filename = (String) jobDataMap.get( "filename" );
      String filepath = (String) jobDataMap.get( "filepath" );
      String doCompressFile = (String) jobDataMap.get( "compressFile" );
      try
      {
         String fileName = processFileName( filename );
         builders = createBuilder( relatorios );
         createFile( builders, fileName, filepath, doCompressFile );
      }
      catch( Exception e )
      {
         log.error( e );
      }
   }

}

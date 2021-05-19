package br.com.trgs.tears.scheduler.job;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import br.com.trgs.definition.report.IReportDefinition;
import br.com.trgs.tears.scheduler.ScheduleRunner;

import com.trgs.component.core.ColumnData;
import com.trgs.component.core.RecordSet;
import com.trgs.component.core.Report;
import com.trgs.component.report.ReportServiceDelegate;
import com.trgs.component.report.ReportsApplication;
import com.trgs.util.ReportHelper;
import com.trgs.util.export.ExportCSV;

public class AbstractJob
{
   Logger log = Logger.getLogger( ScheduleRunner.class );

   public Collection< Collection< byte[] >> getRecordSets( JobExecutionContext context, String encoding )
   {

      String reportId = (String) context.getJobDetail().getJobDataMap().get( "reportId" );
      Collection< Collection< byte[] >> filebytesCollection = new ArrayList< Collection< byte[] > >();
      try
      {
         Report report = null;
         IReportDefinition reportType = null;

         reportType = ReportsApplication.getInstance().getReportById( reportId );

         ReportServiceDelegate delegate = ReportServiceDelegate.getInstance();
         Map< String, String > recordsetFilter = Collections.emptyMap();
         Map< String, String > columnFilter = Collections.emptyMap();
         report = delegate.createGenericReport( reportType, null, recordsetFilter, columnFilter, null );
         report.setDescription( reportType.getDescription() );

         Map< RecordSet, List< List< ColumnData >>> relatorios =
            ReportHelper.convertReport( report, ReportsApplication.getInstance().getReportsLocator() );

         for( Entry< RecordSet, List< List< ColumnData >>> entry : relatorios.entrySet() )
         {
            ExportCSV exportCSV = new ExportCSV();
            exportCSV.createFile( entry.getValue() );
            Collection< byte[] > fileBytes = exportCSV.getFile( encoding );

            filebytesCollection.add( fileBytes );
         }
      }
      catch( Exception e )
      {
         log.warn( e );
      }

      return filebytesCollection;
   }

   protected String createFile( Collection< StringBuilder > builders, String filename, String filepath, String doCompressFile )
      throws FileNotFoundException, IOException
   {
      FileOutputStream outputStream;

      if( filepath != null && !filepath.endsWith( File.pathSeparator ) )
      {
         filepath = filepath + File.separatorChar;
      }

      String processedFileName = processFileName( filename );

      String fileToCreate = filepath + processedFileName;

      if( "true".equalsIgnoreCase( doCompressFile ) )
      {
         fileToCreate += ".zip";

         outputStream = new FileOutputStream( new File( fileToCreate ) );
         ZipOutputStream zipOutputStream = new ZipOutputStream( outputStream );
         ZipEntry zipEntry = new ZipEntry( processedFileName );
         zipOutputStream.putNextEntry( zipEntry );
         for( StringBuilder builder : builders )
         {
            zipOutputStream.write( builder.toString().getBytes() );
         }
         zipOutputStream.closeEntry();
         zipOutputStream.flush();
         zipOutputStream.close();
         outputStream.close();
      }
      else
      {
         outputStream = new FileOutputStream( new File( fileToCreate ) );
         for( StringBuilder builder : builders )
         {
            outputStream.write( builder.toString().getBytes() );
         }
         outputStream.flush();
         outputStream.close();
      }
      return fileToCreate;
   }

   protected Collection< StringBuilder > createBuilder( Collection< Collection< byte[] >> relatorios )
   {
      Collection< StringBuilder > builders = new ArrayList< StringBuilder >();
      StringBuilder stringBuilder;
      for( Collection< byte[] > relatorio : relatorios )
      {
         stringBuilder = new StringBuilder();
         for( byte[] bs : relatorio )
         {
            stringBuilder.append( new String( bs ) );
         }
         builders.add( stringBuilder );
      }
      return builders;
   }

   protected String processFileName( String filename )
   {
      return MessageFormat.format( filename, new Object[] { new Date() } );
   }

}

package br.com.trgs.tears.scheduler.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import br.com.trgs.tears.scheduler.Action;
import br.com.trgs.tears.scheduler.ActionTypeEnum;
import br.com.trgs.tears.scheduler.ISchedulerJobsReader;
import br.com.trgs.tears.scheduler.Parameter;
import br.com.trgs.tears.scheduler.Schedule;
import br.com.trgs.tears.scheduler.xmlfile.MasterRule;
import br.com.trgs.tears.scheduler.xmlfile.Param;
import br.com.trgs.tears.scheduler.xmlfile.ReportId;
import br.com.trgs.tears.scheduler.xmlfile.Schedules;

import com.trgs.component.core.MainConstants;
import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.IReportsApplication.PROPERTIES;
import com.trgs.component.report.ReportsApplication;
import com.trgs.util.Log;
import com.trgs.util.LogMemory;
import com.trgs.util.xmlcontrol.XmlVersionConverter;
import com.trgs.util.xmlcontrol.config.XML_TYPE;
import com.trgs.util.xmlcontrol.exception.VersionControlException;

public class SchedulerJobsReaderXML implements ISchedulerJobsReader
{

   private final LogMemory logMemory = new LogMemory();
   private IReportsApplication reportsApplication;
   private Log log = Log.get( MainConstants.APPLICATION_NAME, getClass() );
   private final Log appLog = Log.get( MainConstants.APPLICATION_NAME, this.getClass() );


   public SchedulerJobsReaderXML( IReportsApplication iReportsApplication )
   {
      this.reportsApplication = iReportsApplication;
   }

   @Override
   public List< Schedule > readSchedulerJobs()
   {

      String SCHEDULE_CONFIGURATIONS_FILE = IReportsApplication.CONFIGURATIONS_DIR + "Schedule.xml";

      InputStream inputStream = null;
      Reader in = null;
      File dir = new File( IReportsApplication.CONFIGURATIONS_DIR );

      if( dir.isDirectory() )
      {
         File scheduleConfig;
         try
         {
            scheduleConfig = new File( SCHEDULE_CONFIGURATIONS_FILE );
            appLog.trace( "scheduleConfig.isFile()=" + scheduleConfig.isFile() );
            appLog.trace( "scheduleConfig.canRead()=" + scheduleConfig.canRead() );

            scheduleConfig = XmlVersionConverter.getInstance().validateXML( scheduleConfig, XML_TYPE.SCHEDULE );
            if( !scheduleConfig.canRead() )
            {
               logMemory.info( "info.scheduleFileNotFound" );
               return Collections.emptyList();
            }
            try
            {
               inputStream = new FileInputStream( scheduleConfig );
               in = new InputStreamReader( inputStream, reportsApplication.getApplicationProperty( PROPERTIES.ENCODING ) );
               Schedules schedulesXML = Schedules.unmarshal( in );
               return readSchedulerJobsFromXML( schedulesXML );
            }
            catch( Exception e )
            {
               log.error( e );
               logMemory.error( "error.scheduleCloseReader", e.getMessage() );
            }
            finally
            {
               try
               {
                  if( in != null )
                  {
                     in.close();
                  }
               }
               catch( Exception e )
               {
                  log.error( e );
                  logMemory.error( "error.scheduleCloseReader", e.getMessage() );
               }
            }
         }
         catch( VersionControlException e )
         {
            logMemory.error( "error.version.control." + e.getType().getCode(), e.getFilePath() );
         }
      }
      else
      {
         logMemory.error( "error.directoryStruct" );
      }
      return null;
   }

   private List< Schedule > readSchedulerJobsFromXML( Schedules schedulesXML )
   {
      List< Schedule > scheduleList = new ArrayList< Schedule >();
      Schedule schedule;

      Map< String, String > masterRules = new HashMap< String, String >();

      for( MasterRule masterRule : schedulesXML.getMasterRule() )
      {
         masterRules.put( masterRule.getId(), masterRule.getRule() );
      }

      for( br.com.trgs.tears.scheduler.xmlfile.Schedule scheduleXML : schedulesXML.getSchedule() )
      {
         List< Parameter > generalParams = new ArrayList< Parameter >();
         List< Action > actions = new ArrayList< Action >();
         List< String > reportIds = new ArrayList< String >();
         String rule;

         Parameter param;
         for( Param paramXML : scheduleXML.getParam() )
         {
            param = new Parameter();
            try
            {
               BeanUtils.copyProperties( param, paramXML );
               generalParams.add( param );
            }
            catch( Exception e )
            {
               log.error( e );
            }

         }
         if( scheduleXML.getRule() != null )
         {
            rule = scheduleXML.getRule();
         }
         else
         {
            rule = masterRules.get( scheduleXML.getRuleId() );
         }

         Action action;
         for( br.com.trgs.tears.scheduler.xmlfile.Action actionXML : scheduleXML.getActionList().getAction() )
         {
            List< Parameter > localParams = new ArrayList< Parameter >();
            for( Param paramXML : actionXML.getParam() )
            {
               param = new Parameter();
               try
               {
                  BeanUtils.copyProperties( param, paramXML );
                  localParams.add( param );
               }
               catch( Exception e )
               {
                  log.error( e );
               }

            }
            localParams.addAll( generalParams );
            action = new Action( ActionTypeEnum.valueOf( actionXML.getType().toUpperCase() ), localParams );
            actions.add( action );
         }

         for( ReportId reportId : scheduleXML.getReportList().getReportId() )
         {
            if( reportsApplication.getReportById( reportId.getRefId() ) != null )
            {
               reportIds.add( reportId.getRefId() );
            }
            else
            {
               logMemory.warning( "warn.invalidReportId", reportId.getRefId() );
            }
         }
         schedule = new Schedule( scheduleXML.getId(), scheduleXML.getDescription(), rule, actions, reportIds );
         scheduleList.add( schedule );
      }

      return scheduleList;
   }

}

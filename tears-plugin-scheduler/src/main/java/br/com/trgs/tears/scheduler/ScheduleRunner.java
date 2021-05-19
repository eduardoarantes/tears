package br.com.trgs.tears.scheduler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import br.com.trgs.tears.scheduler.job.EmailJob;
import br.com.trgs.tears.scheduler.job.FileSystemJob;

import com.trgs.component.report.IReportsApplication.PROPERTIES;
import com.trgs.component.report.ReportsApplication;
import com.trgs.util.TearsException;

public class ScheduleRunner
{
   private static ScheduleRunner instance;
   private int jobName = 0;
   Logger log = Logger.getLogger( ScheduleRunner.class );
   Scheduler scheduler;

   private ScheduleRunner()
   {
   }

   public static ScheduleRunner getInstance()
   {
      if( instance == null )
      {
         instance = new ScheduleRunner();
      }
      return instance;
   }

   public static ScheduleRunner getInstance( boolean notInitialize )
   {
      if( notInitialize )
      {
         return instance;
      }
      return getInstance();
   }

   public void run( List< Schedule > scheduleSource ) throws TearsException
   {
      try
      {
         SchedulerFactory schedulerFactory = new StdSchedulerFactory();

         scheduler = schedulerFactory.getScheduler();

         for( Schedule schedule : scheduleSource )
         {
            List< Action > actions = schedule.getActions();
            List< JobDetail > jobDetails = new ArrayList< JobDetail >();
            for( Action action : actions )
            {
               for( String reportId : schedule.getReportIds() )
               {

                  JobDetail jobDetail = getJobDetail( action, schedule.getId() );
                  jobDetail.getJobDataMap().put( "reportId", reportId );

                  if( jobDetail != null )
                     jobDetails.add( jobDetail );
               }
            }

            CronTrigger trigger = new CronTrigger( "trigger", schedule.getId() );
            trigger.setCronExpression( schedule.getRule() );

            for( JobDetail jobDetail : jobDetails )
            {
               scheduler.scheduleJob( jobDetail, trigger );
            }
         }
         scheduler.start();
      }
      catch( SchedulerException e )
      {
         log.error( e );
      }
      catch( ParseException e )
      {
         log.error( e );
      }
   }

   private JobDetail getJobDetail( Action action, String group ) throws TearsException
   {
      JobDetail jobDetail;
      Job job = null;
      if( ActionTypeEnum.EMAIL.equals( action.getType() ) )
      {
         job = new EmailJob();
      }
      else if( ActionTypeEnum.FILESYSTEM.equals( action.getType() ) )
      {
         job = new FileSystemJob();
      }
      jobDetail = new JobDetail( String.valueOf( jobName++ ), group, job.getClass() );

      jobDetail.getJobDataMap().put( "application.temp.folder",
         ReportsApplication.getInstance().getApplicationProperty( PROPERTIES.APPLICATION_TEMP_FOLDER ) );

      for( Parameter param : action.getParams() )
      {
         if( jobDetail.getJobDataMap().containsKey( param.getName() ) )
         {
            String actualValue = (String) jobDetail.getJobDataMap().get( param.getName() );
            actualValue += ", " + param.getValue();
            jobDetail.getJobDataMap().put( param.getName(), actualValue );
         }
         else
         {
            jobDetail.getJobDataMap().put( param.getName(), param.getValue() );
         }
      }
      return jobDetail;
   }

   public void stop()
   {
      try
      {
         log.info( "parando os processos agendados" );
         if( this.scheduler != null )
         {
            this.scheduler.shutdown( true );
         }
      }
      catch( SchedulerException e )
      {
         log.error( e );
      }
   }
}

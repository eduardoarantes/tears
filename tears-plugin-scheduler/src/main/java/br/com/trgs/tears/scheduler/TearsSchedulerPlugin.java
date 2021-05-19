package br.com.trgs.tears.scheduler;

import java.lang.reflect.Constructor;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.trgs.tears.scheduler.reader.SchedulerJobsReaderXML;

import com.google.common.collect.Multimap;
import com.trgs.component.core.MainConstants;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.ReportsApplication;
import com.trgs.plugablecomponent.AbstractStartupProvider;
import com.trgs.util.Log;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;

public class TearsSchedulerPlugin extends AbstractStartupProvider
{

   private Log log = Log.get( MainConstants.APPLICATION_NAME, this.getClass() );
   private ISchedulerJobsReader jobsReader;

   public TearsSchedulerPlugin( final Multimap< String, Parameter > parameterMap, LogMemory logMemory, IReportsApplication reportsApplication )
   {
      super( parameterMap, logMemory, reportsApplication );
      if( parameterMap != null && parameterMap.get( "JobsReader" ) != null && parameterMap.get( "JobsReader" ).size() > 0
         && StringUtils.isNotBlank( parameterMap.get( "JobsReader" ).iterator().next().getValue() ) )
      {
         jobsReader = getReadersInstance( parameterMap.get( "JobsReader" ).iterator().next() );
      }
      else
      {
         jobsReader = new SchedulerJobsReaderXML( ReportsApplication.getInstance() );
      }
   }

   @Override
   public synchronized String start( LogMemory log ) throws TearsException
   {
      List< Schedule > schedules = jobsReader.readSchedulerJobs();
      if( schedules != null && schedules.size() > 0 )
      {
         ScheduleRunner runner = ScheduleRunner.getInstance();
         runner.run( schedules );
      }
      else
      {
         if( log != null )
         {
            log.info( "info.notSchedule" );
         }
      }

      return SUCCESS;
   }

   @Override
   public synchronized String reload( LogMemory log ) throws TearsException
   {
      shutdown( log );
      start( log );
      return SUCCESS;
   }

   @Override
   public synchronized String shutdown( LogMemory log )
   {
      ScheduleRunner instance = ScheduleRunner.getInstance( true );
      if( instance != null )
      {
         instance.stop();
      }
      return SUCCESS;
   }

   @Override
   public boolean isReloadAvailable()
   {
      return true;
   }

   @SuppressWarnings( "unchecked" )
   private ISchedulerJobsReader getReadersInstance( Parameter parameter )
   {
      Class< ? extends ISchedulerJobsReader > clazz;
      Constructor< ? extends ISchedulerJobsReader > ct;
      try
      {
         clazz = (Class< ? extends ISchedulerJobsReader >) Class.forName( parameter.getValue() );
         ct = clazz.getConstructor( ReportsApplication.class );
         return (ISchedulerJobsReader) ct.newInstance( ReportsApplication.getInstance() );
      }
      catch( java.lang.IllegalArgumentException e )
      {
         log.error( e );
      }
      catch( Exception ee )
      {
         log.error( ee );
      }
      return null;
   }
}

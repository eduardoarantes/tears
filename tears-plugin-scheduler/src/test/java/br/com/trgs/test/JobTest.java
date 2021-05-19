package br.com.trgs.test;

import java.text.ParseException;

import junit.framework.TestCase;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import br.com.trgs.tears.scheduler.job.EmailJob;
import br.com.trgs.tears.scheduler.job.FileSystemJob;


public class JobTest extends TestCase
{

   public void testEmail() throws SchedulerException, ParseException
   {
      // First we must get a reference to a scheduler
      SchedulerFactory sf = new StdSchedulerFactory();
      Scheduler sched = sf.getScheduler();
      // computer a time that is on the next round minute
      JobDetail job = new JobDetail("job1", "group1", EmailJob.class);
      job.getJobDataMap().put( "reportId", "CategoryList" );
      job.getJobDataMap().put( "filename", "reportCategory{0,date,hh-MM-ss}.csv" );
      job.getJobDataMap().put( "filepath", "c:/log/" );
      job.getJobDataMap().put( "compressFile", "true" );
      
      job.getJobDataMap().put( "to", "mcorrea@trgs.com.br" );
      job.getJobDataMap().put( "subject", "relatorio" );
      job.getJobDataMap().put( "message", "Relatorio: " );
      job.getJobDataMap().put( "host", "smtp.gmail.com" );
      job.getJobDataMap().put( "port", "465" );
      job.getJobDataMap().put( "auth", "true" );
      job.getJobDataMap().put( "user", "olaturista.suporte@trgs.com.br" );
      job.getJobDataMap().put( "password", "D3v_trigger" );
      // Trigger the job to run on the next round minute
      CronTrigger trigger = 
          new CronTrigger("trigger1", "group1");
      trigger.setCronExpression( "* 0/1 * * * ?" );
      // Tell quartz to schedule the job using our trigger
      sched.scheduleJob(job, trigger);
      // Start up the scheduler (nothing can actually run until the 
      // scheduler has been started)
      sched.start();
      // wait long enough so that the scheduler as an opportunity to 
      // run the job!
      try {
          // wait 90 seconds to show jobs
          Thread.sleep(90L * 1000L); 
          // executing...
      } catch (Exception e) {
      }
      // shut down the scheduler
      sched.shutdown(true);
   }

   public void testFileSystem() throws Exception{
            // First we must get a reference to a scheduler
      SchedulerFactory sf = new StdSchedulerFactory();
      Scheduler sched = sf.getScheduler();
      // computer a time that is on the next round minute
      JobDetail job = new JobDetail("job1", "group1", FileSystemJob.class);
      job.getJobDataMap().put( "reportId", "CategoryList" );
      job.getJobDataMap().put( "filename", "reportCategoryTest{0,date,hh-MM-ss}.csv" );
      job.getJobDataMap().put( "filepath", "c:/log/" );
      job.getJobDataMap().put( "compressFile", "true" );
      // Trigger the job to run on the next round minute
      CronTrigger trigger = 
         new CronTrigger("trigger1", "group1");
     trigger.setCronExpression( "* 0/1 * * * ?" );
      // Tell quartz to schedule the job using our trigger
      sched.scheduleJob(job, trigger);
      // Start up the scheduler (nothing can actually run until the 
      // scheduler has been started)
      sched.start();
      // wait long enough so that the scheduler as an opportunity to 
      // run the job!
      try {
          // wait 90 seconds to show jobs
          Thread.sleep(90L * 1000L); 
          // executing...
      } catch (Exception e) {
      }
      // shut down the scheduler
      sched.shutdown(true);
   }
}

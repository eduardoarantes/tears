package br.com.trgs.test;

import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;

import br.com.trgs.tears.scheduler.job.EmailJob;

public class SchedulerTest extends TestCase
{

   public void testEmailJob() throws SchedulerException, ParseException
   {
      SchedulerFactory schedulerFactory = new StdSchedulerFactory();

      Scheduler scheduler = schedulerFactory.getScheduler();

      JobDetail jobDetail = new JobDetail( "1", "2", EmailJob.class );

      jobDetail.getJobDataMap().put( "to", "test to" );
      jobDetail.getJobDataMap().put( "from", "test from" );
      jobDetail.getJobDataMap().put( "body", "test body" );

      CronTrigger trigger = new CronTrigger( "trigger", "group", "* * * * * ?" );

      scheduler.scheduleJob( jobDetail, trigger );
      scheduler.start();
      try
      {
         // wait five minutes to show jobs
         Thread.sleep( 300L * 1000L );
         // executing...
      }
      catch( Exception e )
      {
      }
      scheduler.shutdown( true );
      SchedulerMetaData metaData = scheduler.getMetaData();

   }

   public void testJob() throws SchedulerException, ParseException
   {

      // First we must get a reference to a scheduler
      SchedulerFactory sf = new StdSchedulerFactory();
      Scheduler sched = sf.getScheduler();
      // jobs can be scheduled before sched.start() has been called
      // job 1 will run every 20 seconds
      JobDetail job = new JobDetail( "job1", "group1", EmailJob.class );
      CronTrigger trigger = new CronTrigger( "trigger1", "group1", "job1", "group1", "0/20 * * * * ?" );
      sched.addJob( job, true );
      Date ft = sched.scheduleJob( trigger );
      // job 2 will run every other minute (at 15 seconds past the minute)
      job = new JobDetail( "job2", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger2", "group1", "job2", "group1", "15 0/2 * * * ?" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // job 3 will run every other minute but only between 8am and 5pm
      job = new JobDetail( "job3", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger3", "group1", "job3", "group1", "0 0/2 8-17 * * ?" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // job 4 will run every three minutes but only between 5pm and 11pm
      job = new JobDetail( "job4", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger4", "group1", "job4", "group1", "0 0/3 17-23 * * ?" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // job 5 will run at 10am on the 1st and 15th days of the month
      job = new JobDetail( "job5", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger5", "group1", "job5", "group1", "0 0 10am 1,15 * ?" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // job 6 will run every 30 seconds but only on Weekdays (Monday through
      // Friday)
      job = new JobDetail( "job6", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger6", "group1", "job6", "group1", "0,30 * * ? * MON-FRI" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // job 7 will run every 30 seconds but only on Weekends (Saturday and
      // Sunday)
      job = new JobDetail( "job7", "group1", EmailJob.class );
      trigger = new CronTrigger( "trigger7", "group1", "job7", "group1", "0,30 * * ? * SAT,SUN" );
      sched.addJob( job, true );
      ft = sched.scheduleJob( trigger );
      // All of the jobs have been added to the scheduler, but none of the
      // jobs
      // will run until the scheduler has been started
      sched.start();
      try
      {
         // wait five minutes to show jobs
         Thread.sleep( 300L * 1000L );
         // executing...
      }
      catch( Exception e )
      {
      }
      sched.shutdown( true );
      SchedulerMetaData metaData = sched.getMetaData();

   }

}

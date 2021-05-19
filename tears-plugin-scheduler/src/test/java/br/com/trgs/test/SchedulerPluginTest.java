package br.com.trgs.test;

import org.junit.Test;

public class SchedulerPluginTest extends AbstractReportsTest
{
   @Test
   public void testScheduler() throws Exception
   {
      //a propria abstractReportsTest cria o schuduler
      System.out.println( "" );

   }

   @Override
   public String getPrefix()
   {
      return "scheduler_";
   }

}

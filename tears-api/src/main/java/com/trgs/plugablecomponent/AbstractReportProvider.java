package com.trgs.plugablecomponent;

import com.google.common.collect.Multimap;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.plugablecomponent.interfaces.IReportProvider;
import com.trgs.util.LogMemory;

public abstract class AbstractReportProvider implements IReportProvider
{
   protected LogMemory logMemory;
   private String name;
   protected IReportsApplication reportsApplication;

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public void setName( String name )
   {
      this.name = name;
   }

   public AbstractReportProvider( Multimap< String, Parameter > parameterMap, LogMemory logMemory,
      IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
   }

}

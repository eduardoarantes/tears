package com.trgs.plugablecomponent;

import com.google.common.collect.Multimap;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.plugablecomponent.interfaces.IStartupProvider;
import com.trgs.util.LogMemory;

public abstract class AbstractStartupProvider implements IStartupProvider
{
   protected static final String SUCCESS = "success";
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

   public AbstractStartupProvider( final Multimap< String, Parameter > parameterMap, LogMemory logMemory, IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
   }

   /**
    * this method is intended to be used by user interface.
    * If true, the user with admin role will be able to invoke this plugin directly
    * @return
    */
   @Override
   public boolean isReloadAvailable()
   {
      return false;
   }
   
   

}

package com.trgs.plugablecomponent.interfaces;

import com.trgs.plugablecomponent.interfaces.basic.IPluggable;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;

public interface IStartupProvider extends IPluggable
{

   public String start( LogMemory logMemory ) throws TearsException;

   /**
    * reload this instance
    * 
    * debugInfo will be filled with debug information
    * 
    * @param reportsApplication
    * @param debugInfo
    * @return
    */
   public abstract String reload( LogMemory log ) throws TearsException;

   /**
    * must be implemented to shutdown all opened resources
    * 
    * debugInfo will be filled with debug information
    * 
    * @param reportsApplication
    * @param debugInfo
    * @return
    */
   public abstract String shutdown( LogMemory log ) throws TearsException;

   boolean isReloadAvailable();

}
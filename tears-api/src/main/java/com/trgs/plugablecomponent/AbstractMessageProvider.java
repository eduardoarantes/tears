package com.trgs.plugablecomponent;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Multimap;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.plugablecomponent.interfaces.IMessageProvider;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;

public abstract class AbstractMessageProvider implements IMessageProvider, Comparable< IMessageProvider >
{
   final static int BEFORE = -1;
   final static int EQUAL = 0;
   final static int AFTER = 1;
   private String name;
   private Integer priority;
   protected LogMemory logMemory;
   protected IReportsApplication reportsApplication;

   public AbstractMessageProvider( final Multimap< String, Parameter > parameterMap, LogMemory logMemory,
      IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
      if( parameterMap != null )
      {
         Collection< Parameter > parameters = parameterMap.get( "priority" );

         for( Parameter parameter : parameters )
         {
            setPriority( Integer.valueOf( parameter.getValue() ) );
            break;
         }
      }
   }

   @Override
   public abstract String getMessage( HttpServletRequest request, TearsException tearsException ) ;

   @Override
   public Integer getPriority()
   {
      return priority;
   }

   @Override
   public void setPriority( Integer priority )
   {
      this.priority = priority;
   }

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

   @Override
   public int compareTo( IMessageProvider other )
   {
      if( other.getPriority() == null )
      {
         return BEFORE;
      }
      else if( this.getPriority() == null )
      {
         return AFTER;
      }
      if( this.getPriority() > other.getPriority() )
      {
         return AFTER;
      }
      else if( this.getPriority() < other.getPriority() )
      {
         return BEFORE;
      }
      else
      {
         return EQUAL;
      }
   }

}

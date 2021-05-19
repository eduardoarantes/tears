package com.trgs.plugablecomponent;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.trgs.definition.chart.IPDFDraw;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.trgs.component.core.IRecordSet;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.plugablecomponent.interfaces.IChartProvider;
import com.trgs.util.Log;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;

public abstract class AbstractChartProvider implements IChartProvider, Comparable< IChartProvider >
{
   private Multimap< String, Parameter > parameters;
   final static int BEFORE = -1;
   final static int EQUAL = 0;
   final static int AFTER = 1;
   private String name;
   private Integer priority;
   protected LogMemory logMemory;
   protected IReportsApplication reportsApplication;
   private Log log = Log.get( this.getClass().getCanonicalName() );

   public AbstractChartProvider( final Multimap< String, Parameter > parameters, LogMemory logMemory,
      IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
      if( parameters == null )
      {
         this.parameters = HashMultimap.create();
      }
      else
      {
         this.parameters = parameters;
      }

      Parameter priorityParam = this.parameters.get( "priority" ).iterator().next();

      if( priorityParam != null )
      {
         if( !StringUtils.isEmpty( priorityParam.getValue() ) )
         {
            try
            {
               priority = Integer.parseInt( priorityParam.getValue() );
            }
            catch( NumberFormatException e )
            {
               log.error( "Invalid priority value", e );
            }
         }
      }

   }

   @Override
   public String renderHTML( IRecordSet recordSet ) throws TearsException
   {
      return "";
   }

   @Override
   public String renderPDF( IRecordSet recordSet, Map< String, IPDFDraw > plotMap ) throws TearsException
   {
      return "";
   }

   public Multimap< String, Parameter > getParameters()
   {
      return parameters;
   }

   public Parameter getParameter( String key )
   {
      return parameters.get( key ).iterator().next();
   }

   @Override
   public int compareTo( IChartProvider other )
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

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public void setPriority( Integer priority )
   {
      this.priority = priority;
   }

   @Override
   public Integer getPriority()
   {
      return priority;
   }

}

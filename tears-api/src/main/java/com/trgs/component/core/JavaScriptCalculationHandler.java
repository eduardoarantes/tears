package com.trgs.component.core;

import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang.StringUtils;

import com.trgs.util.Log;

public class JavaScriptCalculationHandler implements ICalculationHandler
{

   private Map< String, Object > map;

   private String expression;

   private String result = null;

   private Log log = Log.get( this.getClass().getName() );

   public JavaScriptCalculationHandler( final Map< String, Object > map, final String expression )
   {
      this.map = map;
      this.expression = expression;
   }

   @Override
   public String execute()
   {
      if( StringUtils.isNotBlank( result ) )
      {
         return result;
      }
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName( "javascript" );

      setVariables( engine );

      try
      {
         Object evaluatedValue = engine.eval( expression );
         if( evaluatedValue != null )
         {
            result = evaluatedValue.toString();
         }
         return result;
      }
      catch( ScriptException e )
      {
         log.error( "error calculating expression:" + expression, e );
      }

      return null;
   }

   private void setVariables( ScriptEngine engine )
   {
      if( map == null || map.size() == 0 )
      {
         return;
      }
      for( Entry< String, Object > entry : map.entrySet() )
      {
         engine.put( entry.getKey(), entry.getValue() );
      }
   }
}

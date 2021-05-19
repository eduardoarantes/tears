package com.trgs.plugablecomponent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import br.com.trgs.definition.report.IConfig;
import br.com.trgs.definition.report.IRecordsetDefinition;
import br.com.trgs.definition.report.IReportDefinition;

import com.google.common.collect.Multimap;
import com.trgs.component.core.ColumnDescription;
import com.trgs.component.core.IRecordSet;
import com.trgs.component.core.MainConstants;
import com.trgs.component.core.Parameter;
import com.trgs.component.core.datatypes.BasicData;
import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.IReportsApplication.PROPERTIES;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.plugablecomponent.interfaces.IDaoProvider;
import com.trgs.util.Log;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;
import com.trgs.util.User;

public abstract class AbstractDaoProvider implements IDaoProvider
{
   private static final Integer ZERO_INTEGER = new Integer( 0 );
   private static final Double ZERO_DOUBLE = new Double( 0 );
   private DataSourceConnection reportConnection;
   protected Log log = Log.get( MainConstants.APPLICATION_NAME, getClass() );
   protected LogMemory logMemory;
   private String name;
   protected IReportsApplication reportsApplication;

   public AbstractDaoProvider( Multimap< String, Parameter > parameterMap, LogMemory logMemory,
      IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
   }

   public DataSourceConnection getReportConnection()
   {
      return reportConnection;
   }

   public void setReportConnection( DataSourceConnection reportConnection ) throws TearsException
   {
      this.reportConnection = reportConnection;
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

   public abstract List< Map< ColumnDescription, BasicData >> createResultMap( IReportDefinition reportType, IRecordSet recordSet,
      IRecordsetDefinition recordsetTypeXML, Map< String, String > parameters, User user ) throws TearsException;

   protected String getConnectionParamater( String paramName )
   {
      if( StringUtils.isBlank( paramName ) )
      {
         return "";
      }
      List< Parameter > params = this.reportConnection.getParam();
      for( Parameter param : params )
      {
         if( paramName.equals( param.getName() ) )
         {
            return param.getValue();
         }
      }
      return "";
   }

   protected String getRecordsetConfig( IRecordsetDefinition recordsetTypeXML, String name )
   {
      if( StringUtils.isBlank( name ) )
      {
         return "";
      }
      List< IConfig > params = recordsetTypeXML.getConfig();
      for( IConfig param : params )
      {
         if( name.equals( param.getName() ) )
         {
            return param.getValue();
         }
      }
      return "";
   }

   public void releaseResource() throws TearsException
   {
   }

   public abstract Map< String, String > getReportParameteres( String sql, String key, String value, User user )
      throws TearsException;

   public List< String > handleParameters( StringBuilder statement )
   {
      String SQL = statement.toString();
      Pattern p = Pattern.compile( "#\\{([\\w\\.]*)\\}" );
      // Create a matcher with an input string
      Matcher m = p.matcher( SQL );

      List< String > sqlParmList = new ArrayList< String >();

      log.trace( "iniciando a busca em " + SQL );
      while( m.find() )
      {
         log.trace( "group encontrado :" + m.group() );
         sqlParmList.add( m.group( 1 ) );
         SQL = m.replaceFirst( getParameterControlerChar() );
         m = p.matcher( SQL );
         log.trace( "resultString " + SQL );

      }
      statement.delete( 0, statement.length() );

      statement.append( SQL );

      return sqlParmList;
   }

   protected Object createInteger( String recordsetData )
   {
      try
      {
         if( StringUtils.isBlank( recordsetData ) )
         {
            return ZERO_INTEGER;
         }
         Integer integer = Integer.parseInt( recordsetData );
         return integer;
      }
      catch( NumberFormatException e )
      {
         log.error( "Nao foi possivel criar o Integer de " + recordsetData );
      }

      return ZERO_INTEGER;
   }

   protected Double createDouble( String recordsetData )
   {
      try
      {
         if( StringUtils.isBlank( recordsetData ) )
         {
            return ZERO_DOUBLE;
         }
         Double double1 = Double.parseDouble( recordsetData );
         return double1;
      }
      catch( NumberFormatException e )
      {
         log.error( "Nao foi possivel criar o Double de " + recordsetData );
      }

      return ZERO_DOUBLE;
   }

   protected Date createDate( String recordsetData, String format ) throws TearsException
   {
      try
      {
         if( StringUtils.isBlank( recordsetData ) )
         {
            return null;
         }
         if( StringUtils.isBlank( format ) )
         {
            format = reportsApplication.getApplicationProperty( PROPERTIES.DATA_FORMAT );
         }

         SimpleDateFormat formatter = new SimpleDateFormat( format );
         Date date = formatter.parse( recordsetData );

         return date;
      }
      catch( ParseException e )
      {
         log.error( "Nao foi possivel criar o Date de " + recordsetData );
      }
      return null;
   }

   public abstract String getParameterControlerChar();

}

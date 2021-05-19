package com.trgs.component.reports.dao.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import br.com.trgs.definition.report.IRecordsetDefinition;
import br.com.trgs.definition.report.IReportDefinition;

import com.google.common.collect.Multimap;
import com.trgs.component.core.ColumnDescription;
import com.trgs.component.core.IRecordSet;
import com.trgs.component.core.Parameter;
import com.trgs.component.core.datatypes.BasicData;
import com.trgs.component.core.datatypes.DATA_TYPE;
import com.trgs.component.report.IReportsApplication;
import com.trgs.component.report.ReportsApplication;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.component.reports.dao.FileSystemReportDaoProvider;
import com.trgs.component.reports.dao.csv.util.CSVConstantsHelper;
import com.trgs.component.reports.dao.csv.util.CSVParamsEnum;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;
import com.trgs.util.User;

public class CsvDaoImpl extends FileSystemReportDaoProvider
{
   protected LogMemory logMemory;

   public CsvDaoImpl( Multimap< String, Parameter > parameterMap, LogMemory logMemory, IReportsApplication reportsApplication )
   {
      super( parameterMap, logMemory, reportsApplication );
   }

   @Override
   public List< Map< ColumnDescription, BasicData >> createResultMap( IReportDefinition report, IRecordSet recordSet,
      IRecordsetDefinition recordsetTypeXML, Map< String, String > parameters, User user ) throws TearsException
   {
      try
      {
         String pathname = getBasePathName( report );

         pathname += recordSet.getConfig( CSVParamsEnum.RECORDSET_PATH.getValue() );

         File file = new File( pathname );
         FileReader fileReader = new FileReader( file );
         BufferedReader bufferedReader = new BufferedReader( fileReader );

         String hasHeaderRow = getRecordsetConfig( recordsetTypeXML, FIRST_ROW_HEADER );

         boolean firstRowHeaderTrue = !"false".equalsIgnoreCase( hasHeaderRow );

         // verificar o caso de a primeira coluna nao ter o header
         String[] columnNames = getColumnNames( bufferedReader );

         fillFileColumnsName( recordSet, bufferedReader, columnNames );

         // nesse ponto devemos consultar o arquivo .properties para ver se existe alguma definicao de coluna.
         // com isso acertamos os data types

         List< Map< ColumnDescription, BasicData >> result = fillFileData( recordSet, bufferedReader, columnNames );
         return result;
      }
      catch( Exception e )
      {
         log.error( "Error in createGenericReport", e );
         throw new TearsException( e, this, "Error creating report ", "report.error.oncreate" );
      }
   }

   private List< Map< ColumnDescription, BasicData >> fillFileData( IRecordSet recordSet, BufferedReader bufferedReader,
      String[] columnNames ) throws IOException, TearsException
   {
      List< Map< ColumnDescription, BasicData >> result = new ArrayList< Map< ColumnDescription, BasicData >>();
      String line;
      while( ( line = bufferedReader.readLine() ) != null )
      {
         String[] values = split( line, CSVConstantsHelper.COMMA.getValue() );

         Map< String, Integer > colunmIndex = getColumnIndex( columnNames );

         Map< ColumnDescription, BasicData > data = new HashMap< ColumnDescription, BasicData >();

         for( ColumnDescription col : recordSet.getColumns() )
         {
            Object value = null;
            String recordsetData;
            switch( col.getDataType() )
            {
            case INTEGER:
               recordsetData = values[colunmIndex.get( col.getId() )];
               value = createInteger( recordsetData );
               break;
            case DATE:
               recordsetData = values[colunmIndex.get( col.getId() )];
               Date date = createDate( recordsetData, col.getFormat() );
               value = date;
               break;
            case DATE_TIME:
               recordsetData = values[colunmIndex.get( col.getId() )];
               Date date1 = createDate( recordsetData, col.getFormat() );
               value = date1;
               break;
            case DOUBLE:
               recordsetData = values[colunmIndex.get( col.getId() )];
               Double dob = createDouble( recordsetData );
               value = dob;
               break;
            case CURRENCY:
               recordsetData = values[colunmIndex.get( col.getId() )];
               Double dob1 = createDouble( recordsetData );
               value = dob1;
               break;
            default:
               recordsetData = values[colunmIndex.get( col.getId() )];
               value = recordsetData;
               break;
            }
            data.put( col, new BasicData( value, col.getDataType(), col.getFormat() ) );
         }
         result.add( data );
      }
      return result;
   }

   private Map< String, Integer > getColumnIndex( String[] columnNames )
   {
      Map< String, Integer > columnIndex = new HashMap< String, Integer >();
      for( int i = 0; i < columnNames.length; i++ )
      {
         columnIndex.put( columnNames[i], i );
      }
      return columnIndex;
   }

   private void fillFileColumnsName( IRecordSet recordSet, BufferedReader bufferedReader, String[] columnNames ) throws Exception
   {

      try
      {
         for( int i = 0; i < columnNames.length; i++ )
         {
            String columnId = columnNames[i];
            ColumnDescription column = recordSet.getColumn( columnId );

            if( column == null )
            {
               log.info( "no names defined for the column. Using meta data:" + columnId );

               DATA_TYPE dataType = DATA_TYPE.TEXT;

               String columnDescription = columnId;
               column = new ColumnDescription( columnId, columnDescription, dataType );
               column.setDisplay( true );
            }
            else if( column.getDataType() == null )
            {
               DATA_TYPE dataType = DATA_TYPE.TEXT;
               column.setDataType( dataType );
            }
            recordSet.addColumn( column );
         }
      }
      catch( Exception e )
      {
         log.error( e );
         throw e;
      }

   }

   private String[] getColumnNames( BufferedReader bufferedReader ) throws IOException
   {
      String firstLine = bufferedReader.readLine();
      return split( firstLine, CSVConstantsHelper.COMMA.getValue() );
   }

   private String getBasePathName( IReportDefinition report ) throws TearsException
   {
      DataSourceConnection connection = ReportsApplication.getInstance().getSelectedConnection( report.getConnectionId() );

      List< Parameter > params = connection.getParam();

      String pathname = "";
      for( Parameter param : params )
      {
         if( CSVParamsEnum.CONNECTION_ROOT_PATH.getValue().equals( param.getName() ) )
         {
            pathname = param.getValue();
         }
      }
      return pathname;
   }

   @Override
   public String getParameterControlerChar()
   {
      return "?";
   }

   @Override
   public Map< String, String > getReportParameteres( String sql, String key, String value, User user )
      throws TearsException 
   {
      return null;
      // Map< String, String > mapValues = null;
      //
      // PreparedStatement pstmt = null;
      // try
      // {
      // StringBuilder processedSQL = new StringBuilder( sql );
      // // TODO usar os parametros para o filtro
      // List< String > params = handleParameters( processedSQL );
      // pstmt = conn.prepareStatement( processedSQL.toString() );
      //
      // // -----------------------------------------------------------------------------
      // // bloco inserido para tratar el com valores do usuario logado
      // int paramIndex = 1;
      // String paramValue;
      // for( String param : params )
      // {
      // paramValue = handleUserDetail( param, user );
      // if( StringUtils.isBlank( paramValue ) )
      // {
      //
      // throw new DataAccessLayerException( "Parametro nao encontrado em nenhum contexto" );
      // }
      // pstmt.setString( paramIndex, paramValue );
      // paramIndex++;
      // }
      // // ----------------------------------------------------------------------------------
      //
      // ResultSet rs = pstmt.executeQuery();
      // mapValues = new LinkedHashMap< String, String >();
      //
      // if( StringUtils.isBlank( key ) )
      // {
      // key = "KEY";
      // }
      // if( StringUtils.isBlank( value ) )
      // {
      // value = "VALUE";
      // }
      //
      // while( rs.next() )
      // {
      // mapValues.put( rs.getString( key ), rs.getString( value ) );
      // }
      // return mapValues;
      // }
      // catch( Exception e )
      // {
      // log.error( e );
      // throw new DataAccessLayerException( "getParameterMapValues.error", e );
      // }
      // finally
      // {
      // try
      // {
      // pstmt.close();
      // }
      // catch( Exception e )
      // {
      // log.error( e );
      // }
      // }
   }

   private String[] split( String str, String separator )
   {
      char separatorChar = separator.charAt( 0 );
      if( str == null )
      {
         return null;
      }
      int len = str.length();
      if( len == 0 )
      {
         return ArrayUtils.EMPTY_STRING_ARRAY;
      }
      List< String > list = new ArrayList< String >();
      int i = 0, start = 0;
      boolean match = false;
      boolean lastMatch = false;
      boolean notQuotation = true;
      boolean contaisQuote = false;
      while( i < len )
      {
         if( str.charAt( i ) == separatorChar && notQuotation )
         {
            if( match )
            {
               if( contaisQuote )
               {
                  list.add( str.substring( start, i - 1 ) );
                  contaisQuote = false;
               }
               else
               {
                  list.add( str.substring( start, i ) );
               }
               match = false;
               lastMatch = true;
            }
            else
            {
               list.add( "" );
               match = false;
               lastMatch = true;
            }
            start = ++i;
            continue;
         }
         if( ( str.charAt( i ) == '\'' || str.charAt( i ) == '\"' ) )
         {
            if( lastMatch && notQuotation )
            {
               notQuotation = false;
               contaisQuote = true;
               start++;
            }
            else
            {
               notQuotation = true;
            }
         }
         lastMatch = false;
         match = true;
         i++;
      }
      if( match || lastMatch )
      {
         list.add( str.substring( start, i ) );
      }
      return list.toArray( new String[list.size()] );
   }
}
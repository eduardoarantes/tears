package com.trgs.component.core;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.trgs.component.core.datatypes.BasicData;
import com.trgs.component.core.datatypes.DATA_TYPE;
import com.trgs.util.Log;

public class Row implements Serializable
{
   private static final long serialVersionUID = -5341829002500864116L;
   private List< ColumnDescription > columns;

   private Map< ColumnDescription, BasicData > dataMap = new LinkedHashMap< ColumnDescription, BasicData >();

   private Vector< String > queryString = new Vector< String >();

   private Log log = Log.get( "", Row.class.toString() );
   private IRecordSet detailRecordSet;

   public Row( List< ColumnDescription > columns )
   {
      this.columns = columns;
   }

   /**
    * Esse metodo faz a traducao dos valores da coluna para o mapa definido na configuracao
    * retorna o novo valor adicionado a coluna no caso de mapeamento
    * 
    * @param newData
    * @return
    */

   public BasicData addData( ColumnDescription columnDescription, BasicData newData )
   {
      Map< String, String > mappedData = null;

      BasicData dataToAdd = newData;
      if( columnDescription != null )
      {
         mappedData = columnDescription.getMappedData();
      }

      // se existe um dataMap tentamos "traduzir" os valores das
      // colunas para os valores do mapa
      if( mappedData != null )
      {
         String lookupValue = newData.getRawValue().toString();
         String resultValue = "";
         if( StringUtils.isBlank( lookupValue ) )
         {
            resultValue = columnDescription.getMappedDataNotFound();
         }
         else
         {
            resultValue = mappedData.get( lookupValue.trim() );
            if( StringUtils.isBlank( resultValue ) )
            {
               log.trace( "mapped data no found for:" + lookupValue );
               resultValue = columnDescription.getMappedDataNotFound();
            }
         }
         dataToAdd = new BasicData( resultValue, DATA_TYPE.TEXT );

      }
      dataMap.put( columnDescription, dataToAdd );
      // if the column is allow auto filter we add all data to it
      // the column will take care of exclusive values
      if( columnDescription.isAllowFilter() )
      {
         columnDescription.addColumnData( dataToAdd );
      }
      return dataToAdd;
   }

   public Map< ColumnDescription, BasicData > getDataMap()
   {
      return dataMap;
   }

   /**
    * @return Returns the queryString.
    */
   public String getQueryString( int i )
   {
      return (String) queryString.get( i );
   }

   public List< String > getQueryStringList()
   {
      return queryString;
   }

   public Iterator< String > getAllQueryString()
   {
      return queryString.iterator();
   }

   /**
    * @param queryString
    *            The queryString to set.
    */
   public void setQueryString( int indice, String string )
   {
      if( this.queryString.size() <= indice )
         queryString.setSize( indice + 1 );
      queryString.setElementAt( string, indice );
   }

   public BasicData getData( ColumnDescription columnDescription )
   {

      BasicData basicData = dataMap.get( columnDescription );
      if( basicData == null )
      {
         log.warn( "Data not found for column: " + columnDescription.getId() );
      }
      return basicData;
   }

   public List< ColumnDescription > getColumns()
   {
      return columns;
   }

   public BasicData getData( String columnId )
   {
      ColumnDescription selectedColumnDescription = null;
      for( ColumnDescription columnDescription : columns )
      {
         if( columnDescription.getId().equals( columnId ) )
         {
            selectedColumnDescription = columnDescription;
            break;

         }
      }

      return dataMap.get( selectedColumnDescription );
   }

   public void setDetailRecordSet( IRecordSet detailRecordSet )
   {
      this.detailRecordSet = detailRecordSet;
   }

   public IRecordSet getDetailRecordSet()
   {
      return detailRecordSet;
   }
}
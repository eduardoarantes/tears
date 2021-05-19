package com.trgs.component.core;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.trgs.component.core.datatypes.BasicData;
import com.trgs.component.core.datatypes.DATA_TYPE;

public class ColumnDescription extends AbstractBaseInfo implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -7970762324718991500L;
   private DATA_TYPE dataType = DATA_TYPE.UNKNOWN;
   private LinkedList< Url > urls = null;
   /**
    * esse campo contem valores possiveis para essa coluna 
    * eles serao "traduzidos" dos valores das linhas
    */
   private Map< String, String > mappedData = null;
   private String mappedDataNotFound = "info not found";
   private String consolidator = null;
   private String groupByType = null;
   private String styleClass = null;
   // para colunas consolidadores reservamos a coluna de referencia
   private ColumnDescription referenceColumn;
   private String format;

   private String value;
   private String expression;
   private String styleExpression;

   private boolean allowFilter = false;

   private Set< BasicData > filteringColumnData;

   private boolean display = true;

   public ColumnDescription( String name, String description, DATA_TYPE dataType, LinkedList< Url > urls, String consolidator,
      String groupByType, String styleClass, String expression, String value, String styleExpression )
   {
      setId( name );
      setDescription( description );
      this.dataType = dataType;
      this.urls = urls;
      this.consolidator = consolidator;
      this.styleClass = styleClass;
      this.groupByType = groupByType;
      this.expression = expression;
      this.value = value;
      this.styleExpression = styleExpression;
   }

   public ColumnDescription( String name, String description, DATA_TYPE dataType, LinkedList< Url > urls, String consolidator,
      String groupByType, ColumnDescription referenceColumn, String styleClass )
   {
      this( name, description, dataType, urls, consolidator, groupByType, styleClass, null, null, null);
      this.referenceColumn = referenceColumn;
   }

   public ColumnDescription( String name, String description, DATA_TYPE dataType, LinkedList< Url > urls,
      Map< String, String > data, String consolidator, String groupBy, String styleClass, String expression, String value, String styleExpression )
   {
      this( name, description, dataType, urls, consolidator, groupBy, styleClass, expression, value, styleExpression );
      this.mappedData = data;
   }

   public ColumnDescription( String name, String description, DATA_TYPE dataType)
   {
      this( name, description, dataType, null, null, null, null, null, null, null);
   }

   public void setMappedData( Map< String, String > data )
   {
      this.mappedData = data;
   }

   public Map< String, String > getMappedData()
   {
      return mappedData;
   }

   public void addColumnData( BasicData data )
   {
      if( filteringColumnData == null )
      {
         filteringColumnData = new TreeSet< BasicData >();
      }
      filteringColumnData.add( data );
   }

   /**
    * @return Returns the url.
    */
   public List< Url > getUrls()
   {
      return urls;
   }

   /**
    * @param urls
    *            The url to set.
    */
   public void setUrls( LinkedList< Url > urls )
   {
      this.urls = urls;
   }

   /**
    * @return Returns the consolidator.
    */
   public String getConsolidator()
   {
      return consolidator;
   }

   /**
    * @param consolidator
    *            The consolidator to set.
    */
   public void setConsolidator( String consolidator )
   {
      this.consolidator = consolidator;
   }

   /**
    * @return Returns the groupBy.
    */
   public String getGroupByType()
   {
      return groupByType;
   }

   /**
    * @param groupByType
    *            The groupBy to set.
    */
   public void setGroupByType( String groupByType )
   {
      this.groupByType = groupByType;
   }

   public DATA_TYPE getDataType()
   {
      return dataType;
   }

   public void setDataType( DATA_TYPE dataType )
   {
      this.dataType = dataType;
   }

   public ColumnDescription getReferenceColumn()
   {
      return referenceColumn;
   }

   public void setReferenceColumn( ColumnDescription referenceColumn )
   {
      this.referenceColumn = referenceColumn;
   }

   public void setMappedDataNotFound( String mappedDataNotFound )
   {
      this.mappedDataNotFound = mappedDataNotFound;
   }

   public String getMappedDataNotFound()
   {
      return mappedDataNotFound;
   }

   public void setFormat( String format )
   {
      this.format = format;
   }

   public String getFormat()
   {
      return format;
   }

   public void setDisplay( boolean display )
   {
      this.display = display;
   }

   public boolean isDisplay()
   {
      return display;
   }

   public void setStyleClass( String styleClass )
   {
      this.styleClass = styleClass;
   }

   public String getStyleClass()
   {
      return styleClass;
   }

   public void setAllowFilter( boolean allowFilter )
   {
      this.allowFilter = allowFilter;
   }

   public boolean isAllowFilter()
   {
      return allowFilter;
   }

   public Set< BasicData > getFilteringColumnData()
   {
      return filteringColumnData;
   }

   public String getValue()
   {
      return value;
   }

   public String getExpression()
   {
      return expression;
   }

   public String getStyleExpression()
   {
      return styleExpression;
   }
}

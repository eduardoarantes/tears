package br.com.trgs.definition.report;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ColumnDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ColumnDefinition implements java.io.Serializable, IColumnDefinition
{

   /**
   * 
   */
   private static final long serialVersionUID = 3016509304416333818L;

   /**
    * Field _id.
    */
   private String id;

   /**
    * Field _description.
    */
   private String description;

   /**
    * Field _type.
    */
   private String type = "TEXT";

   /**
    * Field _consolidator.
    */
   private String consolidator;

   /**
    * Field _mappedDataNotFound.
    */
   private String mappedDataNotFound;

   /**
    * Field _display.
    */
   private boolean display = true;

   /**
    * allows to format data
    *  
    */
   private String format;

   /**
    * Field _styleClass.
    */
   private String styleClass;

   /**
    * Field _allowFilter.
    */
   private boolean allowFilter = false;

   /**
    * Field _value.
    */
   private String value;

   /**
    * Field _expression.
    */
   private String expression;

   /**
    * Field _styleExpression.
    */
   private String styleExpression;

   /**
    * Field _columnMapList.
    */
   private List< ColumnMap > columnMap = new ArrayList< ColumnMap >();

   /**
    * Field _urlList.
    */
   private List< UrlDefinition > url = new ArrayList< UrlDefinition >();

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getId()
    */
   @Override
   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getDescription()
    */
   @Override
   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getType()
    */
   @Override
   public String getType()
   {
      return type;
   }

   public void setType( String type )
   {
      this.type = type;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getConsolidator()
    */
   @Override
   public String getConsolidator()
   {
      return consolidator;
   }

   public void setConsolidator( String consolidator )
   {
      this.consolidator = consolidator;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getMappedDataNotFound()
    */
   @Override
   public String getMappedDataNotFound()
   {
      return mappedDataNotFound;
   }

   public void setMappedDataNotFound( String mappedDataNotFound )
   {
      this.mappedDataNotFound = mappedDataNotFound;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#isDisplay()
    */
   @Override
   public boolean isDisplay()
   {
      return display;
   }

   public void setDisplay( boolean display )
   {
      this.display = display;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getFormat()
    */
   @Override
   public String getFormat()
   {
      return format;
   }

   public void setFormat( String format )
   {
      this.format = format;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getStyleClass()
    */
   @Override
   public String getStyleClass()
   {
      return styleClass;
   }

   public void setStyleClass( String styleClass )
   {
      this.styleClass = styleClass;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#isAllowFilter()
    */
   @Override
   public boolean isAllowFilter()
   {
      return allowFilter;
   }

   public void setAllowFilter( boolean allowFilter )
   {
      this.allowFilter = allowFilter;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getValue()
    */
   @Override
   public String getValue()
   {
      return value;
   }

   public void setValue( String value )
   {
      this.value = value;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getExpression()
    */
   @Override
   public String getExpression()
   {
      return expression;
   }

   public void setExpression( String expression )
   {
      this.expression = expression;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getStyleExpression()
    */
   @Override
   public String getStyleExpression()
   {
      return styleExpression;
   }

   public void setStyleExpression( String styleExpression )
   {
      this.styleExpression = styleExpression;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getColumnMap()
    */
   @Override
   public List< ColumnMap > getColumnMap()
   {
      return columnMap;
   }

   public void addColumnMap( ColumnMap columnMap )
   {
      this.columnMap.add( columnMap );
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IColumnDefinition#getUrl()
    */
   @Override
   public List< UrlDefinition > getUrl()
   {
      return url;
   }

   public void addUrl( UrlDefinition url )
   {
      this.url.add( url );
   }

}

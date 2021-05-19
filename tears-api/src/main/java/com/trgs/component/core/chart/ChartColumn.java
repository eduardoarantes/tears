package com.trgs.component.core.chart;

import br.com.trgs.definition.chart.IChartColumnDefinition;

/**
 * Class ChartColumnDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ChartColumn implements java.io.Serializable, IChartColumnDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = -4585580796299493543L;

   // --------------------------/
   // - Class/Member Variables -/
   // --------------------------/

   /**
    * Field _refId.
    */
   private String _refId;

   /**
    * Field _description.
    */
   private String _description;

   /**
    * Field _type.
    */
   private String _type = "TEXT";

   /**
    * allows to format data
    *  
    */
   private String _format;

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartColumn#getDescription()
    */
   @Override
   public String getDescription()
   {
      return this._description;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartColumn#getFormat()
    */
   @Override
   public String getFormat()
   {
      return this._format;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartColumn#getRefId()
    */
   @Override
   public String getRefId()
   {
      return this._refId;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartColumn#getType()
    */
   @Override
   public String getType()
   {
      return this._type;
   }

   /**
   * Sets the value of field 'description'.
   * 
   * @param description the value of field 'description'.
   */
   public void setDescription( final String description )
   {
      this._description = description;
   }

   /**
    * Sets the value of field 'format'. The field 'format' has the
    * following description: allows to format data
    *  
    * 
    * @param format the value of field 'format'.
    */
   public void setFormat( final String format )
   {
      this._format = format;
   }

   /**
    * Sets the value of field 'refId'.
    * 
    * @param refId the value of field 'refId'.
    */
   public void setRefId( final String refId )
   {
      this._refId = refId;
   }

   /**
    * Sets the value of field 'type'.
    * 
    * @param type the value of field 'type'.
    */
   public void setType( final String type )
   {
      this._type = type;
   }
}

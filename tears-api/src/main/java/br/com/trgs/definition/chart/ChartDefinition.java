package br.com.trgs.definition.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.trgs.component.core.Parameter;

/**
 * Class Chart.
 * 
 * @version $Revision$ $Date$
 */

public class ChartDefinition implements Serializable, IChartDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = -4006106234813750514L;

   // --------------------------/
   // - Class/Member Variables -/
   // --------------------------/

   /**
    * Field _type.
    */
   private String _type;

   /**
    * Field _title.
    */
   private String _title;

   /**
    * Field _description.
    */
   private String _description;

   /**
    * Field _height.
    */
   private int _height;

   /**
   * Field _width.
   */
   private int _width;

   /**
   * Field _chartColumnList.
   */
   private List< IChartColumnDefinition > _chartColumnList = new ArrayList< IChartColumnDefinition >();

   /**
    * Field _paramList.
    */
   private List< Parameter > _paramList = new ArrayList< Parameter >();

   private String provider;

   // -----------/
   // - Methods -/
   // -----------/

   public void addChartColumn( final IChartColumnDefinition vChartColumn )
   {
      this._chartColumnList.add( vChartColumn );
   }

   public void addParam( final Parameter vParam )
   {
      this._paramList.add( vParam );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getChartColumn()
    */
   @Override
   public List< IChartColumnDefinition > getChartColumn()
   {
      return this._chartColumnList;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getDescription()
    */
   @Override
   public String getDescription()
   {
      return this._description;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getHeight()
    */
   @Override
   public int getHeight()
   {
      return this._height;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getParam()
    */
   @Override
   public List< Parameter > getParam()
   {
      return this._paramList;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getTitle()
    */
   @Override
   public String getTitle()
   {
      return this._title;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getType()
    */
   @Override
   public String getType()
   {
      return this._type;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChartDefinition#getWidth()
    */
   @Override
   public int getWidth()
   {
      return this._width;
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
    * Sets the value of field 'height'.
    * 
    * @param height the value of field 'height'.
    */
   public void setHeight( final int height )
   {
      this._height = height;
   }

   /**
    * Sets the value of field 'title'.
    * 
    * @param title the value of field 'title'.
    */
   public void setTitle( final String title )
   {
      this._title = title;
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

   /**
    * Sets the value of field 'width'.
    * 
    * @param width the value of field 'width'.
    */
   public void setWidth( final int width )
   {
      this._width = width;
   }

   @Override
   public String getProvider()
   {
      return this.provider;
   }

   public void setProvider( String provider )
   {
      this.provider = provider;
   }

}

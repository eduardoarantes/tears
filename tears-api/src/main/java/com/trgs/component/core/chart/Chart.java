package com.trgs.component.core.chart;

import java.util.ArrayList;
import java.util.List;

import br.com.trgs.definition.chart.IChartColumnDefinition;

import com.trgs.component.core.Parameter;

/**
 * Class Chart.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "serial" )
public class Chart implements java.io.Serializable, IChart
{
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

   public void addChartColumn( final ChartColumn vChartColumn )
   {
      this._chartColumnList.add( vChartColumn );
   }

   public void addParam( final Parameter vParam )
   {
      this._paramList.add( vParam );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getChartColumn()
    */
   @Override
   public List< IChartColumnDefinition > getChartColumn()
   {
      return this._chartColumnList;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getDescription()
    */
   @Override
   public String getDescription()
   {
      return this._description;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getHeight()
    */
   @Override
   public int getHeight()
   {
      return this._height;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getParam()
    */
   @Override
   public List< Parameter > getParam()
   {
      return this._paramList;
   }
   
   @Override
   public void setParamList( List< Parameter > _paramList )
   {
      this._paramList = _paramList;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getTitle()
    */
   @Override
   public String getTitle()
   {
      return this._title;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getType()
    */
   @Override
   public String getType()
   {
      return this._type;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getWidth()
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
   @Override
   public void setDescription( final String description )
   {
      this._description = description;
   }

   /**
    * Sets the value of field 'height'.
    * 
    * @param height the value of field 'height'.
    */
   @Override
   public void setHeight( final int height )
   {
      this._height = height;
   }

   /**
    * Sets the value of field 'title'.
    * 
    * @param title the value of field 'title'.
    */
   @Override
   public void setTitle( final String title )
   {
      this._title = title;
   }

   /**
    * Sets the value of field 'type'.
    * 
    * @param type the value of field 'type'.
    */
   @Override
   public void setType( final String type )
   {
      this._type = type;
   }

   /**
    * Sets the value of field 'width'.
    * 
    * @param width the value of field 'width'.
    */
   @Override
   public void setWidth( final int width )
   {
      this._width = width;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.chart.IChart#getProvider()
    */
   @Override
   public String getProvider()
   {
      return this.provider;
   }

   @Override
   public void setProvider( String provider )
   {
      this.provider = provider;
   }

}

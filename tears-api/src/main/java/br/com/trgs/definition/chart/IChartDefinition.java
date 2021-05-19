package br.com.trgs.definition.chart;

import java.util.List;

import com.trgs.component.core.Parameter;

public interface IChartDefinition
{

   public abstract List< IChartColumnDefinition > getChartColumn();

   /**
    * Returns the value of field 'description'.
    * 
    * @return the value of field 'Description'.
    */
   public abstract String getDescription();

   /**
    * Returns the value of field 'height'.
    * 
    * @return the value of field 'Height'.
    */
   public abstract int getHeight();

   /**
   * Method getParam.Returns the contents of the collection in an
   * Array.  <p>Note:  Just in case the collection contents are
   * changing in another thread, we pass a 0-length Array of the
   * correct type into the API call.  This way we <i>know</i>
   * that the Array returned is of exactly the correct length.
   * 
   * @return this collection as an Array
   */
   public abstract List< Parameter > getParam();

   /**
    * Returns the value of field 'title'.
    * 
    * @return the value of field 'Title'.
    */
   public abstract String getTitle();

   /**
    * Returns the value of field 'type'.
    * 
    * @return the value of field 'Type'.
    */
   public abstract String getType();

   /**
    * Returns the value of field 'width'.
    * 
    * @return the value of field 'Width'.
    */
   public abstract int getWidth();

   public String getProvider();

}
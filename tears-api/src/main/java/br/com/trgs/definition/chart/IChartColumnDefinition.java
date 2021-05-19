package br.com.trgs.definition.chart;

public interface IChartColumnDefinition
{

   /**
    * Returns the value of field 'description'.
    * 
    * @return the value of field 'Description'.
    */
   public abstract String getDescription();

   /**
    * Returns the value of field 'format'. The field 'format' has
    * the following description: allows to format data
    *  
    * 
    * @return the value of field 'Format'.
    */
   public abstract String getFormat();

   /**
    * Returns the value of field 'refId'.
    * 
    * @return the value of field 'RefId'.
    */
   public abstract String getRefId();

   /**
    * Returns the value of field 'type'.
    * 
    * @return the value of field 'Type'.
    */
   public abstract String getType();

}
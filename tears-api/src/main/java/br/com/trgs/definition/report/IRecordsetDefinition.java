package br.com.trgs.definition.report;

import java.util.List;

import br.com.trgs.definition.chart.IChartDefinition;
import br.com.trgs.definition.groupby.IGroupByDefinition;

public interface IRecordsetDefinition
{

   /**
    * Returns the value of field 'allowExport'.
    * 
    * @return the value of field 'AllowExport'.
    */
   public abstract String getAllowExport();

   /**
    * Returns the value of field 'chart'.
    * 
    * @return the value of field 'Chart'.
    */
   public abstract IChartDefinition getChart();

   /**
    * Returns the value of field 'columns'.
    * 
    * @return the value of field 'Columns'.
    */
   public abstract List< IColumnDefinition > getColumns();

   /**
    * Method getConfig.Returns the contents of the collection in
    * an Array.  <p>Note:  Just in case the collection contents
    * are changing in another thread, we pass a 0-length Array of
    * the correct type into the API call.  This way we <i>know</i>
    * that the Array returned is of exactly the correct length.
    * 
    * @return this collection as an Array
    */
   public abstract List< IConfig > getConfig();

   /**
    * Returns the value of field 'defaultSortColumn'.
    * 
    * @return the value of field 'DefaultSortColumn'.
    */
   public abstract String getDefaultSortColumn();

   /**
    * Returns the value of field 'description'.
    * 
    * @return the value of field 'Description'.
    */
   public abstract String getDescription();

   /**
    * Returns the value of field 'display'.
    * 
    * @return the value of field 'Display'.
    */
   public abstract boolean getDisplay();

   /**
    * Method getGroupBy.Returns the contents of the collection in
    * an Array.  <p>Note:  Just in case the collection contents
    * are changing in another thread, we pass a 0-length Array of
    * the correct type into the API call.  This way we <i>know</i>
    * that the Array returned is of exactly the correct length.
    * 
    * @return this collection as an Array
    */
   public abstract List< IGroupByDefinition > getGroupBy();

   /**
    * Returns the value of field 'id'.
    * 
    * @return the value of field 'Id'.
    */
   public abstract String getId();

   /**
    * Returns the value of field 'pageSize'.
    * 
    * @return the value of field 'PageSize'.
    */
   public abstract int getPageSize();

   /**
    * Returns the value of field 'rowCountLabel'. The field
    * 'rowCountLabel' has the following description: se esse
    * atributo for especificado será criada uma
    *  coluna com o contador de registros
    *  
    * 
    * @return the value of field 'RowCountLabel'.
    */
   public abstract String getRowCountLabel();

   /**
    * Returns the value of field 'sql'.
    * 
    * @return the value of field 'Sql'.
    */
   public abstract String getSql();

   /**
    * Returns the value of field 'styleClass'.
    * 
    * @return the value of field 'StyleClass'.
    */
   public abstract String getStyleClass();

   /**
    * Returns the value of field 'title'.
    * 
    * @return the value of field 'Title'.
    */
   public abstract String getTitle();

   /**
    * Returns the value of field 'display'.
    * 
    * @return the value of field 'Display'.
    */
   public abstract boolean isDisplay();

}
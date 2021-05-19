package br.com.trgs.definition.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.trgs.definition.chart.IChartDefinition;
import br.com.trgs.definition.groupby.IGroupByDefinition;

/**
 * Class RecordsetDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class RecordsetDefinition implements Serializable, IRecordsetDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = -8879966670396045141L;

   /**
    * Field _id.
    */
   private String _id;

   /**
    * Field _title.
    */
   private String _title;

   /**
    * Field _description.
    */
   private String _description;

   /**
    * Field _defaultSortColumn.
    */
   private String _defaultSortColumn;

   /**
    * se esse atributo for especificado será criada uma
    *  coluna com o contador de registros
    *  
    */
   private String _rowCountLabel;

   /**
    * Field _pageSize.
    */
   private int _pageSize;

   /**
    * Field _allowExport.
    */
   private String _allowExport = "";

   /**
    * Field _display.
    */
   private boolean _display = true;

   /**
    * Field _styleClass.
    */
   private String _styleClass;

   /**
    * Field _sql.
    */
   private String _sql;

   /**
    * Field _configList.
    */
   private List< IConfig > _configList;

   /**
    * Field _columns.
    */
   private List< IColumnDefinition > _columns;

   /**
    * Field _groupByList.
    */
   private List< IGroupByDefinition > _groupByList;

   /**
    * Field _chart.
    */
   private IChartDefinition _chart;

   // ----------------/
   // - Constructors -/
   // ----------------/

   public RecordsetDefinition()
   {
      super();
      setAllowExport( "" );
      this._configList = new ArrayList< IConfig >();
      this._groupByList = new ArrayList< IGroupByDefinition >();
      this._columns = new ArrayList< IColumnDefinition >(); 
   }

   // -----------/
   // - Methods -/
   // -----------/

   /**
    * 
    * 
    * @param vConfig
    * @throws IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addConfig( final IConfig vConfig ) throws IndexOutOfBoundsException
   {
      this._configList.add( vConfig );
   }

   /**
    * 
    * 
    * @param groupBy
    * @throws IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addGroupBy( final IGroupByDefinition groupBy ) throws IndexOutOfBoundsException
   {
      this._groupByList.add( groupBy );
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getAllowExport()
    */
   @Override
   public String getAllowExport()
   {
      return this._allowExport;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getChart()
    */
   @Override
   public IChartDefinition getChart()
   {
      return this._chart;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getColumns()
    */
   @Override
   public List< IColumnDefinition > getColumns()
   {
      return this._columns;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getConfig()
    */
   @Override
   public List< IConfig > getConfig()
   {
      return this._configList;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getDefaultSortColumn()
    */
   @Override
   public String getDefaultSortColumn()
   {
      return this._defaultSortColumn;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getDescription()
    */
   @Override
   public String getDescription()
   {
      return this._description;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getDisplay()
    */
   @Override
   public boolean getDisplay()
   {
      return this._display;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getGroupBy()
    */
   @Override
   public List< IGroupByDefinition > getGroupBy()
   {
      return this._groupByList;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getId()
    */
   @Override
   public String getId()
   {
      return this._id;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getPageSize()
    */
   @Override
   public int getPageSize()
   {
      return this._pageSize;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getRowCountLabel()
    */
   @Override
   public String getRowCountLabel()
   {
      return this._rowCountLabel;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getSql()
    */
   @Override
   public String getSql()
   {
      return this._sql;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getStyleClass()
    */
   @Override
   public String getStyleClass()
   {
      return this._styleClass;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#getTitle()
    */
   @Override
   public String getTitle()
   {
      return this._title;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IRecordsetDefinition#isDisplay()
    */
   @Override
   public boolean isDisplay()
   {
      return this._display;
   }

   /**
    * Sets the value of field 'allowExport'.
    * 
    * @param allowExport the value of field 'allowExport'.
    */
   public void setAllowExport( final String allowExport )
   {
      this._allowExport = allowExport;
   }

   /**
    * Sets the value of field 'chart'.
    * 
    * @param chart the value of field 'chart'.
    */
   public void setChart( final IChartDefinition chart )
   {
      this._chart = chart;
   }

   /**
    * Sets the value of field 'columns'.
    * 
    * @param columns the value of field 'columns'.
    */
   public void addColumn( final IColumnDefinition column )
   {
      this._columns.add( column );
   }

   /**
    * Sets the value of field 'defaultSortColumn'.
    * 
    * @param defaultSortColumn the value of field
    * 'defaultSortColumn'.
    */
   public void setDefaultSortColumn( final String defaultSortColumn )
   {
      this._defaultSortColumn = defaultSortColumn;
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
    * Sets the value of field 'display'.
    * 
    * @param display the value of field 'display'.
    */
   public void setDisplay( final boolean display )
   {
      this._display = display;
   }

   /**
    * Sets the value of field 'id'.
    * 
    * @param id the value of field 'id'.
    */
   public void setId( final String id )
   {
      this._id = id;
   }

   /**
    * Sets the value of field 'pageSize'.
    * 
    * @param pageSize the value of field 'pageSize'.
    */
   public void setPageSize( final int pageSize )
   {
      this._pageSize = pageSize;
   }

   /**
    * Sets the value of field 'rowCountLabel'. The field
    * 'rowCountLabel' has the following description: se esse
    * atributo for especificado será criada uma
    *  coluna com o contador de registros
    *  
    * 
    * @param rowCountLabel the value of field 'rowCountLabel'.
    */
   public void setRowCountLabel( final String rowCountLabel )
   {
      this._rowCountLabel = rowCountLabel;
   }

   /**
    * Sets the value of field 'sql'.
    * 
    * @param sql the value of field 'sql'.
    */
   public void setSql( final String sql )
   {
      this._sql = sql;
   }

   /**
    * Sets the value of field 'styleClass'.
    * 
    * @param styleClass the value of field 'styleClass'.
    */
   public void setStyleClass( final String styleClass )
   {
      this._styleClass = styleClass;
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

}

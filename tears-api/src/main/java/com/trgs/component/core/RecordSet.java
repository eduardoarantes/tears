package com.trgs.component.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.trgs.component.core.ResultListController.SortOrderEnum;
import com.trgs.component.core.chart.Chart;
import com.trgs.component.core.chart.IChart;
import com.trgs.util.Log;

public class RecordSet extends AbstractBaseInfo implements Serializable, IRecordSet
{
   private static final long serialVersionUID = 8553498482180885382L;
   private Map< String, ColumnDescription > columns = new LinkedHashMap< String, ColumnDescription >();
   private List< Row > rows = new LinkedList< Row >();

   private boolean consolidator = false;

   private String rowCountLabel;

   private boolean sortable = false;
   private int pageSize;
   private String allowExport = "";
   private String styleClass = "";
   private boolean display = true;

   private IChart chart;

   // in case it's a consolidator it hold its parentID
   private String parentRecordsetId = null;

   private ColumnDescription sortedColumn;

   private SortOrderEnum sortOrder = SortOrderEnum.ASC;
   private Log log = Log.get( "", this.getClass() );
   private String sortedColumnId;
   private Map< String, String > config = new HashMap< String, String >();

   private boolean hasFilter = false;

   private boolean withDetails = false;
   private String title;

   public RecordSet()
   {
   }

   public RecordSet( ColumnDescription sortedColumn, SortOrderEnum sortOrder )
   {
      this.sortedColumn = sortedColumn;
      this.sortOrder = sortOrder;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#isHasFilter()
    */
   @Override
   public boolean isHasFilter()
   {
      return hasFilter;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getSortedColumn()
    */
   @Override
   public ColumnDescription getSortedColumn()
   {
      return sortedColumn;
   }

   public void setRowCountLabel( String rowCount )
   {
      this.rowCountLabel = rowCount;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getRowCountLabel()
    */
   @Override
   public String getRowCountLabel()
   {
      return rowCountLabel;
   }

   public void setConsolidator( boolean consolidator )
   {
      this.consolidator = consolidator;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#isConsolidator()
    */
   @Override
   public boolean isConsolidator()
   {
      return consolidator;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#isSortable()
    */
   @Override
   public boolean isSortable()
   {
      return sortable;
   }

   public void setSortable( boolean sortable )
   {
      this.sortable = sortable;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getColumns()
    */
   @Override
   public List< ColumnDescription > getColumns()
   {
      return new LinkedList< ColumnDescription >( columns.values() );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getColumn(java.lang.String)
    */
   @Override
   public ColumnDescription getColumn( String columnId )
   {
      return columns.get( columnId );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#addColumn(com.trgs.component.core.ColumnDescription)
    */
   @Override
   public void addColumn( ColumnDescription column )
   {
      this.columns.remove( column.getId() );
      this.columns.put( column.getId(), column );
      if( !hasFilter && column.isAllowFilter() )
      {
         hasFilter = true;
      }
   }

   public void addColumns( List< ColumnDescription > columns )
   {
      for( ColumnDescription column : columns )
      {
         addColumn( column );
      }
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getColumnsCount()
    */
   @Override
   public int getColumnsCount()
   {
      return columns.size();
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getRow(int)
    */
   @Override
   public Row getRow( int index )
   {
      return (Row) rows.get( index );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getRows()
    */
   @Override
   public List< Row > getRows()
   {
      if( StringUtils.isNotBlank( sortedColumnId ) || sortedColumn != null )
      {

         sortedColumn = columns.get( sortedColumnId );

         log.trace( "Sorting by column:" + sortedColumnId + " direction:" + sortOrder );
         Comparator< Row > rowComparator = null;

         rowComparator = new RowComparator< Row >( sortedColumn, sortOrder );
         Collections.sort( rows, rowComparator );
      }
      else if( this.consolidator )
      {
         Comparator< Row > rowComparator = new ConsolidatorRowComparator< Row >( this );
         Collections.sort( rows, rowComparator );

      }
      return rows;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#addRow(com.trgs.component.core.Row)
    */
   @Override
   public void addRow( Row data )
   {
      this.rows.add( data );
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getRowsCount()
    */
   @Override
   public int getRowsCount()
   {
      return rows.size();
   }

   public void setPageSize( int pageSize )
   {
      this.pageSize = pageSize;

   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getPageSize()
    */
   @Override
   public int getPageSize()
   {
      return pageSize;
   }

   public void setAllowExport( String allowExport )
   {
      this.allowExport = allowExport;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getAllowExport()
    */
   @Override
   public String getAllowExport()
   {
      return allowExport;
   }

   public void setDisplay( boolean display )
   {
      this.display = display;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#isDisplay()
    */
   @Override
   public boolean isDisplay()
   {
      return display;
   }

   public void setParentRecordsetId( String parentRecordsetId )
   {
      this.parentRecordsetId = parentRecordsetId;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getParentRecordsetId()
    */
   @Override
   public String getParentRecordsetId()
   {
      return parentRecordsetId;
   }

   public void setChart( Chart chart )
   {
      this.chart = chart;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getChart()
    */
   @Override
   public IChart getChart()
   {
      return chart;
   }

   public void setSortColumnId( String sortColumnId )
   {
      this.sortedColumnId = sortColumnId;

   }

   public void setSortOrder( String sortOrder )
   {
      if( StringUtils.isNotBlank( sortOrder ) )
      {
         try
         {
            this.sortOrder = SortOrderEnum.valueOf( sortOrder );
         }
         catch( Exception e )
         {
            log.warn( "Error getting SortOrderEnum for:" + sortOrder + "  using default" );
            this.sortOrder = SortOrderEnum.ASC;
         }
      }
      else
      {
         log.warn( "Empty value provided for SortOrder using default" );
         this.sortOrder = SortOrderEnum.ASC;
      }

   }

   public void setStyleClass( String styleClass )
   {
      this.styleClass = styleClass;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getStyleClass()
    */
   @Override
   public String getStyleClass()
   {
      return styleClass;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getConfig(java.lang.Object)
    */
   @Override
   public String getConfig( Object key )
   {
      return config.get( key );
   }

   public String putConfig( String key, String value )
   {
      return config.put( key, value );
   }

   public int configsCount()
   {
      return config.size();
   }

   public void setConfigs( Map< String, String > params )
   {
      this.config = params;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getConfigs()
    */
   @Override
   public Map< String, String > getConfigs()
   {
      return config;
   }

   public void setWithDetails( boolean withDetails )
   {
      this.withDetails = withDetails;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#isWithDetails()
    */
   @Override
   public boolean isWithDetails()
   {
      return withDetails;
   }

   public void setTitle( String title )
   {
      this.title = title;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IRecordSet#getTitle()
    */
   @Override
   public String getTitle()
   {
      return title;
   }
}

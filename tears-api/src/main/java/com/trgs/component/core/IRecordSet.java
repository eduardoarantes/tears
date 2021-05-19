package com.trgs.component.core;

import java.util.List;
import java.util.Map;

import com.trgs.component.core.chart.IChart;

public interface IRecordSet extends IBaseInfo
{

   public abstract boolean isHasFilter();

   public abstract ColumnDescription getSortedColumn();

   public abstract String getRowCountLabel();

   public abstract boolean isConsolidator();

   public abstract boolean isSortable();

   public abstract List< ColumnDescription > getColumns();

   public abstract ColumnDescription getColumn( String columnId );

   public abstract void addColumn( ColumnDescription column );

   /**
    * @return
    */
   public abstract int getColumnsCount();

   public abstract Row getRow( int index );

   public abstract List< Row > getRows();

   public abstract void addRow( Row data );

   public abstract int getRowsCount();

   public abstract int getPageSize();

   public abstract String getAllowExport();

   public abstract boolean isDisplay();

   public abstract String getParentRecordsetId();

   public abstract IChart getChart();

   public abstract String getStyleClass();

   public abstract String getConfig( Object key );

   public abstract Map< String, String > getConfigs();

   public abstract boolean isWithDetails();

   public abstract String getTitle();

}
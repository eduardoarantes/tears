package com.trgs.component.core;

import java.util.Comparator;

import com.trgs.component.core.ResultListController.SortOrderEnum;
import com.trgs.component.core.datatypes.BasicData;

public class RowComparator< T extends Row > implements Comparator< T >
{

   private ColumnDescription sortedColumn;
   private SortOrderEnum sortOrder;

   // private Log log = Log.get( "", RowComparator.class );

   public RowComparator( ColumnDescription sortedColumn, SortOrderEnum sortOrder )
   {
      this.sortedColumn = sortedColumn;
      this.sortOrder = sortOrder;
   }

   @Override
   public int compare( Row row1, Row row2 )
   {

      if( sortedColumn == null )
      {
         return 0;
      }

      int returnValue;

      BasicData data1 = row1.getData( sortedColumn );

      BasicData data2 = row2.getData( sortedColumn );

      returnValue = data1.compareTo( data2 );

      // log.trace( "Comparing " + data1.getFormatedValue() + " to " + data2.getFormatedValue() + " = " + returnValue );

      if( sortOrder == SortOrderEnum.DESC )
      {
         returnValue = -1 * returnValue;
      }

      return returnValue;
   }

}

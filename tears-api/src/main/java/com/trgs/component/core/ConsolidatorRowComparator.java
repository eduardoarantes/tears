package com.trgs.component.core;

import java.util.Comparator;

import com.trgs.component.report.consolidator.IReportConsolidator;

public class ConsolidatorRowComparator< T extends Row > implements Comparator< T >
{

   private IRecordSet recordSet;

//   private Log log = Log.get( "", ConsolidatorRowComparator.class );

   private static final String comparatorToken = "___#___";

   public ConsolidatorRowComparator( IRecordSet recordSet )
   {
      this.recordSet = recordSet;
   }

   @Override
   public int compare( Row row1, Row row2 )
   {
      int returnValue;

      StringBuilder data1 = new StringBuilder();
      StringBuilder data2 = new StringBuilder();
      for( ColumnDescription columnDescription : recordSet.getColumns() )
      {
         if( IReportConsolidator.REPORTS_CONSOLIDATOR_GROUP_BY_COLUMN.equals( columnDescription.getGroupByType() ) )
         {
            data1.append( row1.getData( columnDescription ) ).append( comparatorToken );
            data2.append( row2.getData( columnDescription ) ).append( comparatorToken );
         }
      }

      returnValue = data1.toString().compareTo( data2.toString() );

      return returnValue;
   }

}

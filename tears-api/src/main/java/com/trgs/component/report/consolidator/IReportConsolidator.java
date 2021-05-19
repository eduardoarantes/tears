package com.trgs.component.report.consolidator;

public interface IReportConsolidator
{

   public enum CONSOLIDATOR_TYPE
   {
      SUM( "sum" ), AVERAGE( "average" ), COUNT( "count" ), COUNT_NOT_NULL( "countNotNull" );

      private String type;

      private CONSOLIDATOR_TYPE( String type )
      {
         this.type = type;
      }

      public String getType()
      {
         return type;
      }
   }

   public static final String REPORTS_CONSOLIDATOR = "reports.consolidator";

   public static final String REPORTS_CONSOLIDATOR_GROUP_BY_COLUMN = REPORTS_CONSOLIDATOR + ".group.by.column";

}
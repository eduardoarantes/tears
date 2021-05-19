package com.trgs.component.reports.dao.csv.util;

public enum CSVConstantsHelper
{
   COMMA( "," );

   private String value;

   private CSVConstantsHelper( String value )
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}

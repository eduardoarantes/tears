package com.trgs.component.reports.dao.csv.util;

public enum CSVParamsEnum
{
   CONNECTION_ROOT_PATH("RootPath"), RECORDSET_PATH("Path");
   
   
   private String value;
   
   private CSVParamsEnum(String value)
   {
      this.value = value;
   }

   public String getValue()
   {
      return value;
   }
}

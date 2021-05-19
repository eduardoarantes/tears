package com.trgs.component.core;

public class RecordsFlowControl
{

   private String sortField;
   private String sortOrder;
   private int currentPage;
   private String recordSetId;

   public RecordsFlowControl( String recordSetId, String sortField, String sortOrder, int currentPage )
   {
      this.sortField = sortField;
      this.currentPage = currentPage;
      this.sortOrder = sortOrder;
      this.recordSetId = recordSetId;

   }

   public String getSortField()
   {
      return sortField;
   }

   public String getSortOrder()
   {
      return sortOrder;
   }

   public int getCurrentPage()
   {
      return currentPage;
   }

   public String getRecordSetId()
   {
      return recordSetId;
   }

}

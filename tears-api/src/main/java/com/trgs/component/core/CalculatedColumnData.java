package com.trgs.component.core;


public class CalculatedColumnData
{

   private ColumnDescription refereceColumn;
   private String groupBy;

   /**
    * 
    */
   public CalculatedColumnData()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @return Returns the position.
    */
   public ColumnDescription getReferenceColumn()
   {
      return refereceColumn;
   }

   /**
    * @param position The position to set.
    */
   public void setReferenceColumn( ColumnDescription position )
   {
      this.refereceColumn = position;
   }

   /**
    * @return Returns the groupBy.
    */
   public String getGroupBy()
   {
      return groupBy;
   }

   /**
    * @param groupBy The groupBy to set.
    */
   public void setGroupBy( String groupBy )
   {
      this.groupBy = groupBy;
   }
}

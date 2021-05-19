package com.trgs.component.core;

import java.util.LinkedList;
import java.util.List;

import com.trgs.component.core.datatypes.BasicData;

public class ColumnData implements Comparable< Object >
{
   private ColumnDescription column;

   private BasicData value;

   private LinkedList< String > urls = new LinkedList< String >();
   private boolean isDownloadOnly;

   private String queryString;

   public ColumnData( ColumnDescription column, BasicData value )
   {
      this( column, value, null );
   }

   public ColumnData( ColumnDescription column, BasicData value, LinkedList< String > urls )
   {
      this.column = column;
      this.value = value;
      this.urls = urls;
   }

   public BasicData getValue()
   {
      return value;
   }

   public void setValue( BasicData value )
   {
      this.value = value;
   }

   public ColumnDescription getColumn()
   {
      return column;
   }

   public void setColumn( ColumnDescription column )
   {
      this.column = column;
   }

   public List< String > getUrls()
   {
      return urls;
   }

   public void setUrls( LinkedList< String > urls )
   {
      this.urls = urls;
   }

   public boolean isDownloadOnly()
   {
      return isDownloadOnly;
   }

   public void setDownloadOnly( boolean isDownloadOnly )
   {
      this.isDownloadOnly = isDownloadOnly;
   }

   @SuppressWarnings( "unchecked" )
   public int compareTo( Object o )
   {
      if( value instanceof Comparable )
      {
         Comparable comp = (Comparable) value;
         return comp.compareTo( o );
      }
      return value.toString().compareTo( o.toString() );
   }

   public void setQueryString( String queryString )
   {
      this.queryString = queryString;
   }

   public String getQueryString()
   {
      return queryString;
   }
}

package com.trgs.component.core;

import java.util.Collections;
import java.util.List;

public class ResultListController< T >
{

   private List< T > fullSourceList;
   private List< T > partialSourceList = null;
   private int pageSize;
   private int currentPage;
   private String sortColumn = "1";
   private SortOrderEnum sortDirection = SortOrderEnum.ASC;
   private int pageCount;
   private String recordsetId;

   private int pagerPages;

   private int pagerPagesSize = 10;
   private int pagerFirstPage;
   private int pagerLastPage;

   public ResultListController( String recordsetId, List< T > fullSourceList, int pageSize, int currentPage )
   {
      this( recordsetId, fullSourceList, pageSize, currentPage, 10 );
   }

   public ResultListController( String recordsetId, List< T > fullSourceList, int pageSize, int currentPage, int pagerPagesSize )
   {
      this.pagerPagesSize = pagerPagesSize;

      this.recordsetId = recordsetId;

      if( pageSize <= 0 )
      {
         pageSize = fullSourceList.size();
         pageCount = 1;
      }
      else if( fullSourceList.size() <= pageSize )
      {
         pageCount = 1;
      }
      else
      {
         pageCount = (int) Math.ceil( (float) fullSourceList.size() / (float) pageSize );
      }

      if( currentPage > pageCount )
      {
         currentPage = pageCount;
      }

      this.fullSourceList = fullSourceList;
      this.pageSize = pageSize;
      this.currentPage = currentPage;

      this.pagerPages = (int) Math.ceil( (float) pageCount / (float) pagerPagesSize );

      if( this.pagerPages == 1 || this.currentPage < this.pagerPagesSize )
      {
         this.pagerFirstPage = 1;
         this.pagerLastPage = ( this.pageCount > this.pagerPagesSize )? this.pagerPagesSize: this.pageCount;
      }
      else
      {
         int selectedPager = (int) Math.ceil( (float) this.currentPage / (float) pagerPagesSize );
         this.pagerFirstPage = ( selectedPager - 1 ) * pagerPagesSize + 1;
         this.pagerLastPage = selectedPager * pagerPagesSize;
         if( this.pagerLastPage > this.pageCount )
         {
            this.pagerLastPage = this.pageCount;
         }
      }
   }

   public ResultListController( String controllerId, List< T > fullSourceList, int pageSize, int currentPage, String sortColumn,
      SortOrderEnum sortDirection )
   {
      this( controllerId, fullSourceList, pageSize, currentPage );
      this.sortColumn = sortColumn;
      this.sortDirection = sortDirection;
   }

   public int getPagerFirstPage()
   {
      return pagerFirstPage;
   }

   public int getPagerLastPage()
   {
      return pagerLastPage;
   }

   public int getPagerPages()
   {
      return pagerPages;
   }

   public int getPagerPagesSize()
   {
      return pagerPagesSize;
   }

   public int getFullListSize()
   {
      if( fullSourceList == null )
      {
         return 0;
      }
      return fullSourceList.size();
   }

   public List< T > getList()
   {
      return getPartialSourceList();
   }

   private List< T > getPartialSourceList()
   {
      if( partialSourceList != null )
      {
         return partialSourceList;
      }
      if( fullSourceList == null || fullSourceList.size() == 0 )
      {
         return Collections.emptyList();
      }
      if( pageSize < 1 )
      {
         return fullSourceList;
      }
      int startRecord = 0;

      int currentPageRecords = 0;

      // pages are from 1 to n
      // but list starts from 0
      if( currentPage <= 1 )
      {
         currentPageRecords = 0;
      }
      else if( currentPage > 1 )
      {
         currentPageRecords = currentPage - 1;
      }

      startRecord = getDefaultPageSize() * currentPageRecords;

      int endRecord = startRecord + pageSize;
      if( endRecord > getFullListSize() )
      {
         endRecord = getFullListSize();
      }
      return fullSourceList.subList( startRecord, endRecord );
   }

   public int getDefaultPageSize()
   {
      return pageSize;
   }

   /**
    * Returns the number of objects per page. 
    * If this page is the last one should thus have a size
    * equal to the result of this method
    * @return the number of objects per page
    */
   public int getCurrentPageSize()
   {
      return getPartialSourceList().size();
   }

   public int getCurrentPage()
   {
      return currentPage;
   }

   public String getSortColumn()
   {
      return sortColumn;
   }

   public SortOrderEnum getSortDirection()
   {
      return sortDirection;
   }

   public enum SortOrderEnum
   {
      DESC( 1, "descending" ), ASC( 2, "ascending" );
      private int ordinal;
      private String description;

      SortOrderEnum( int ordinal, String description )
      {
         this.ordinal = ordinal;
         this.description = description;
      }

      public int getOrdinal()
      {
         return ordinal;
      }

      public String getDescription()
      {
         return description;
      }

      public SortOrderEnum getInverseOrder()
      {
         if( this.ordinal == 1 )
         {
            return ASC;
         }
         else
         {
            return DESC;
         }
      }
   }

   public int getPageCount()
   {

      return pageCount;
   }

   public boolean isFirstPage()
   {
      return 1 == currentPage;
   }

   public boolean isLastPage()
   {
      if( fullSourceList.size() <= pageSize )
      {
         return true;
      }

      return getPageCount() == currentPage;
   }

   public int getStartRecordIndex()
   {
      return ( currentPage - 1 ) * pageSize + 1;
   }

   public int getEndRecordIndex()
   {
      return getStartRecordIndex() + getCurrentPageSize() - 1;
   }

   public String getRecordsetId()
   {
      return this.recordsetId;
   }

}

package com.trgs.component.core.datatypes;

public class DataFormat
{
   private static final String END_PREFIX = "}";
   private static final String DATE_PREFIX = "{0,date";
   private static final String TIME_PREFIX = "{0,time";
   private static final String NUMBER_PREFIX = "{0,number";

   public static String getFormat( DATA_TYPE dataType, String format )
   {
      return getFormat( dataType.name(), format );
   }

   public static String getFormat( String dataTypeName, String format )
   {

      if( DATA_TYPE.DATE.name().equalsIgnoreCase( dataTypeName ) )
      {
         return( DATE_PREFIX + verifyFormat( format ) + END_PREFIX );
      }
      else if( DATA_TYPE.TIME.name().equalsIgnoreCase( dataTypeName ) )
      {
         return( TIME_PREFIX + verifyFormat( format ) + END_PREFIX );
      }
      else if( DATA_TYPE.DOUBLE.name().equalsIgnoreCase( dataTypeName ) )
      {
         return( NUMBER_PREFIX + verifyFormat( format ) + END_PREFIX );
      }
      else if( DATA_TYPE.INTEGER.name().equalsIgnoreCase( dataTypeName ) )
      {
         return( NUMBER_PREFIX + verifyFormat( format ) + END_PREFIX );
      }
      else if( DATA_TYPE.CURRENCY.name().equalsIgnoreCase( dataTypeName ) )
      {
         return( NUMBER_PREFIX + verifyFormat( format ) + END_PREFIX );
      }

      return null;
   }

   private static String verifyFormat( String format )
   {
      if( format == null )
      {
         return "";
      }
      return "," + format;
   }

   public static String getFormat( DATA_TYPE dataType )
   {
      return getFormat( dataType, null );
   }
}

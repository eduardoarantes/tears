package com.trgs.component.core.datatypes;

import com.trgs.util.Log;

public enum DATA_TYPE
{
   DATE, CURRENCY( true ), INTEGER( true ), TEXT, TIME, UNKNOWN, DATE_TIME, DOUBLE( true );

   private boolean isNumber = false;

   private DATA_TYPE()
   {
   }

   private DATA_TYPE( boolean isNumber )
   {
      this.isNumber = isNumber;
   }

   public boolean isNumber()
   {
      return isNumber;
   }

   public static DATA_TYPE valueOfWithDefault( String name )
   {
      DATA_TYPE dataType = TEXT;

      String _name = name;

      try
      {
         // all the values must be upper case
         if( _name != null && !_name.toUpperCase().equals( _name ) )
         {
            _name = _name.toUpperCase();
            Log.get( "tears", DATA_TYPE.class ).warn(
               "No enum const class for " + DATA_TYPE.class.getCanonicalName() + " must be uppercase. Using :" + _name );
         }

         dataType = DATA_TYPE.valueOf( _name );
      }
      catch( IllegalArgumentException e )
      {
         Log.get( "tears", DATA_TYPE.class ).warn(
            "No enum const class for " + DATA_TYPE.class.getCanonicalName() + " using " + _name );
      }

      return dataType;

   }

}
package com.trgs.component.core.datatypes;

public class InvalidData extends Exception
{
   private static final long serialVersionUID = 1L;

   public InvalidData( String string )
   {
      super( string );
   }
}

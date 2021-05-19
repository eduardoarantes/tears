package com.trgs.component.core.datatypes;

import java.text.MessageFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.trgs.component.core.MainConstants;
import com.trgs.util.Log;

public class BasicData implements Comparable< BasicData >
{

   private static final String ZERO = "ZERO";
   private static final String POSITIVE = "POSITIVE";
   private static final String NEGATIVE = "NEGATIVE";

   public static final BasicData EMPTY_TEXT = new BasicData( "", DATA_TYPE.TEXT );
   public static final BasicData EMPTY_INTEGER = new BasicData( new Integer( 1 ), DATA_TYPE.INTEGER );
   public static final BasicData EMPTY_DOUBLE = new BasicData( new Double( 1 ), DATA_TYPE.DOUBLE );
   public static final BasicData EMPTY_CURRENCY = new BasicData( new Double( 1 ), DATA_TYPE.CURRENCY );
   public static final BasicData EMPTY_DATE = new BasicData( new Date( 0 ), DATA_TYPE.DATE );

   private Object value;
   private String format;
   private DATA_TYPE dataType;
   private String styleClass;
   
   Log log = Log.get( MainConstants.APPLICATION_NAME, getClass() );

   public BasicData( Object value, DATA_TYPE dataType, String format )
   {
      this( value, dataType );
      this.format = format;
   }

   public BasicData( Object value, DATA_TYPE dataType )
   {
      this.value = value;
      this.dataType = dataType;
      switch( this.dataType )
      {
      case INTEGER:
         if( this.value.getClass() != Integer.class )
         {
            log.error( "Data type is:'" + this.dataType + "' but value is:'" + this.value.getClass() + "'" );
         }
         return;
      case DOUBLE:
         if( this.value.getClass() != Double.class )
         {
            log.error( "Data type is:'" + this.dataType + "' but value is:'" + this.value.getClass() + "'" );
         }
         return;
      }

      // throw new InvalidData( "Data type is:'" + this.dataType + "' but value is:'" + this.value.getClass() + "'" );

   }

   public Object getRawValue()
   {
      return value;
   }

   public String getFormatedValue()
   {

      if( StringUtils.isBlank( getFormat() ) )
      {
         return "" + getRawValue();
      }

      String formated;

      try
      {
         formated = MessageFormat.format( getFormat(), getRawValue() );
      }
      catch( Exception e )
      {
         log.warn( "error formating data (value=" + getRawValue() + ";format=" + getFormat() );
         formated = "" + getRawValue();
      }

      return formated;

   }

   @Override
   public String toString()
   {
      return getFormatedValue();
   }

   public String getFormat()
   {
      return format;
   }

   public DATA_TYPE getDataType()
   {
      return dataType;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( format == null )? 0: format.hashCode() );
      result = prime * result + ( ( value == null )? 0: value.hashCode() );
      return result;
   }

   public String getLevel()
   {
      if( !dataType.isNumber() )
      {
         return "";
      }

      if( value instanceof Integer )
      {
         long intValue = ( (Integer) value ).longValue();
         return testLong( intValue );

      }
      else if( value instanceof Long )
      {
         long intValue = ( (Long) value ).longValue();
         return testLong( intValue );

      }
      else if( value instanceof Double )
      {
         double dValue = ( (Double) value ).doubleValue();
         double dzero = dValue - 0.0;
         if( Math.abs( dzero ) < 0.000001 )
         {
            return ZERO;
         }
         else if( dzero > 0.0d )
         {
            return POSITIVE;
         }
         else
         {
            return NEGATIVE;
         }

      }
      return "";

   }

   private String testLong( long intValue )
   {
      if( intValue == 0 )
      {
         return ZERO;
      }
      else if( intValue > 0 )
      {
         return POSITIVE;
      }
      else
      {
         return NEGATIVE;
      }
   }

   @Override
   public boolean equals( Object obj )
   {
      if( this == obj )
         return true;
      if( obj == null )
         return false;
      if( getClass() != obj.getClass() )
         return false;
      BasicData other = (BasicData) obj;
      if( value == null )
      {
         if( other.value != null )
            return false;
      }
      else if( !value.equals( other.value ) )
      {
         return false;
      }
      return true;
   }

   @SuppressWarnings( "unchecked" )
   @Override
   public int compareTo( BasicData o )
   {

      Object object1 = this.getRawValue();
      Object object2 = o.getRawValue();

      int returnValue;
      if( object1 instanceof Comparable && object2 instanceof Comparable )
      {
         returnValue = ( (Comparable) object1 ).compareTo( object2 );
      }
      else
      {
         // if object are not null and don't implement comparable, compare using string values
         returnValue = object1.toString().compareTo( object2.toString() );
      }
      return returnValue;
   }

   public static BasicData getEmptyValue( DATA_TYPE dataTYPE )
   {
      switch( dataTYPE )
      {
      case TEXT:
         return EMPTY_TEXT;
      case INTEGER:
         return EMPTY_INTEGER;
      case DOUBLE:
         return EMPTY_DOUBLE;
      case CURRENCY:
         return EMPTY_CURRENCY;
      case DATE:
         return EMPTY_DATE;

      default:
         break;
      }
      return EMPTY_TEXT;
   }

   public void setStyleClass( String styleClass )
   {
      this.styleClass = styleClass;
   }

   public String getStyleClass()
   {
      return styleClass;
   }

}
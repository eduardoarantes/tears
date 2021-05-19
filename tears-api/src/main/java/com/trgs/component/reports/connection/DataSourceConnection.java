package com.trgs.component.reports.connection;

import java.util.ArrayList;
import java.util.List;

import com.trgs.component.core.Parameter;

public class DataSourceConnection implements java.io.Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = 8540088482119222731L;

   /**
    * Field _id.
    */
   private java.lang.String _id;

   /**
    * Field _type.
    */
   private String _type = "jdbc";

   /**
    * Field _paramList.
    */
   private List< Parameter > _paramList;

   public DataSourceConnection()
   {
      setType( "jdbc" );
      this._paramList = new ArrayList< Parameter >();
   }

   /**
    * 
    * 
    * @param vParam
    * @throws java.lang.IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addParam( final Parameter vParam ) throws IndexOutOfBoundsException
   {
      this._paramList.add( vParam );
   }

   /**
    * 
    * 
    * @param index
    * @param vParam
    * @throws java.lang.IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addParam( final int index, final Parameter vParam ) throws IndexOutOfBoundsException
   {
      this._paramList.add( index, vParam );
   }

   /**
    * Returns the value of field 'id'.
    * 
    * @return the value of field 'Id'.
    */
   public java.lang.String getId()
   {
      return this._id;
   }

   /**
    * Method getParam.
    * 
    * @param index
    * @throws java.lang.IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    * @return the value of the
    * com.trgs.component.reports.xmlfile.Param at the given index
    */
   public Parameter getParam( final int index ) throws java.lang.IndexOutOfBoundsException
   {
      // check bounds for index
      if( index < 0 || index >= this._paramList.size() )
      {
         throw new IndexOutOfBoundsException( "getParam: Index value '" + index + "' not in range [0.."
            + ( this._paramList.size() - 1 ) + "]" );
      }

      return (Parameter) _paramList.get( index );
   }

   /**
    * Method getParam.Returns the contents of the collection in an
    * Array.  <p>Note:  Just in case the collection contents are
    * changing in another thread, we pass a 0-length Array of the
    * correct type into the API call.  This way we <i>know</i>
    * that the Array returned is of exactly the correct length.
    * 
    * @return this collection as an Array
    */
   public List< Parameter > getParam()
   {
      return _paramList;
   }

   /**
    * Method getParamCount.
    * 
    * @return the size of this collection
    */
   public int getParamCount()
   {
      return this._paramList.size();
   }

   /**
    * Returns the value of field 'type'.
    * 
    * @return the value of field 'Type'.
    */
   public java.lang.String getType()
   {
      return this._type;
   }

   /**
    * Sets the value of field 'id'.
    * 
    * @param id the value of field 'id'.
    */
   public void setId( final java.lang.String id )
   {
      this._id = id;
   }

   /**
    * 
    * 
    * @param index
    * @param vParam
    * @throws java.lang.IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void setParam( final int index, final Parameter vParam ) throws java.lang.IndexOutOfBoundsException
   {
      // check bounds for index
      if( index < 0 || index >= this._paramList.size() )
      {
         throw new IndexOutOfBoundsException( "setParam: Index value '" + index + "' not in range [0.."
            + ( this._paramList.size() - 1 ) + "]" );
      }

      this._paramList.set( index, vParam );
   }

   /**
    * 
    * 
    * @param vParamArray
    */
   public void setParam( final Parameter[] vParamArray )
   {
      // -- copy array
      _paramList.clear();

      for( int i = 0; i < vParamArray.length; i++ )
      {
         this._paramList.add( vParamArray[i] );
      }
   }

   /**
    * Sets the value of field 'type'.
    * 
    * @param type the value of field 'type'.
    */
   public void setType( final java.lang.String type )
   {
      this._type = type;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( _id == null )? 0: _id.hashCode() );
      return result;
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
      DataSourceConnection other = (DataSourceConnection) obj;
      if( _id == null )
      {
         if( other._id != null )
            return false;
      }
      else if( !_id.equals( other._id ) )
         return false;
      return true;
   }

}

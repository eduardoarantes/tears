package com.trgs.component.core;

public abstract class AbstractBaseInfo implements IBaseInfo
{

   private String id;
   private String description;

   /* (non-Javadoc)
    * @see com.trgs.component.core.IBaseInfo#getId()
    */
   @Override
   public String getId()
   {
      return id;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IBaseInfo#setId(java.lang.String)
    */
   @Override
   public void setId( String id )
   {
      this.id = id;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IBaseInfo#getDescription()
    */
   @Override
   public String getDescription()
   {
      return description;
   }

   /* (non-Javadoc)
    * @see com.trgs.component.core.IBaseInfo#setDescription(java.lang.String)
    */
   @Override
   public void setDescription( String description )
   {
      this.description = description;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( id == null )? 0: id.hashCode() );
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
      AbstractBaseInfo other = (AbstractBaseInfo) obj;
      if( id == null )
      {
         if( other.id != null )
            return false;
      }
      else if( !id.equals( other.id ) )
         return false;
      return true;
   }

}

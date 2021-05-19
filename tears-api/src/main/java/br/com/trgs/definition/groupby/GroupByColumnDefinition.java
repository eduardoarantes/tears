package br.com.trgs.definition.groupby;

import java.io.Serializable;

/**
 * Class GroupByColumn.
 * 
 * @version $Revision$ $Date$
 */
public class GroupByColumnDefinition implements Serializable, IGroupByColumnDefinition
{

   /**
   * 
   */
   private static final long serialVersionUID = -3617509161899185436L;

   /**
     * internal content storage
     */
   private String content = "";

   /**
    * Field _refId.
    */
   private String refId;

   /**
    * Field _id.
    */
   private String id;

   /**
    * Field _consolidator.
    */
   private String consolidator;

   /**
    * Field _description.
    */
   private String description;

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByColumnDefinition#getContent()
    */
   @Override
   public String getContent()
   {
      return content;
   }

   public void setContent( String content )
   {
      this.content = content;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByColumnDefinition#getRefId()
    */
   @Override
   public String getRefId()
   {
      return refId;
   }

   public void setRefId( String refId )
   {
      this.refId = refId;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByColumnDefinition#getId()
    */
   @Override
   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByColumnDefinition#getConsolidator()
    */
   @Override
   public String getConsolidator()
   {
      return consolidator;
   }

   public void setConsolidator( String consolidator )
   {
      this.consolidator = consolidator;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByColumnDefinition#getDescription()
    */
   @Override
   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

}

package br.com.trgs.definition.groupby;

/**
 * Class CalculatedColumnDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class CalculatedColumnDefinition implements java.io.Serializable, ICalculatedColumnDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = -8367168655552429578L;

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
    * Field _type.
    */
   private String type;

   /**
    * Field _consolidator.
    */
   private String consolidator;

   /**
    * Field _description.
    */
   private String description;

   /**
    * Field _format.
    */
   private String format;

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getContent()
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
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getRefId()
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
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getId()
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
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getType()
    */
   @Override
   public String getType()
   {
      return type;
   }

   public void setType( String type )
   {
      this.type = type;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getConsolidator()
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
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getDescription()
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

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.ICalculatedColumnDefinition#getFormat()
    */
   @Override
   public String getFormat()
   {
      return format;
   }

   public void setFormat( String format )
   {
      this.format = format;
   }

}

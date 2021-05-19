package br.com.trgs.definition.report;

/**
 * Class ColumnMap.
 * 
 * @version $Revision$ $Date$
 */
public class ColumnMap implements java.io.Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 4521331259709714421L;

   /**
    * Field _key.
    */
   private String key;

   /**
    * Field _messageKey.
    */
   private String messageKey;

   public ColumnMap( String key, String messageKey )
   {
      this.key = key;
      this.messageKey = messageKey;
   }

   public String getKey()
   {
      return key;
   }

   public String getMessageKey()
   {
      return messageKey;
   }

}

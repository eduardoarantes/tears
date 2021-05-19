package br.com.trgs.definition.report;

/**
 * Class ReportParameter.
 * 
 * @version $Revision$ $Date$
 */
public class ReportParameter implements java.io.Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 8561430174385381102L;

   /**
    * Field _key.
    */
   private String key;

   /**
    * Field _messageKey.
    */
   private String messageKey;

   public ReportParameter( String key, String messageKey )
   {
      super();
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

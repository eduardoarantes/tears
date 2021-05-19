package br.com.trgs.definition.report;

/**
 * Class UrlParameter.
 * 
 * @version $Revision$ $Date$
 */
public class UrlParameter implements java.io.Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = -7977824744116630441L;

   /**
    * internal content storage
    */
   private String content = "";

   /**
    * Field _name.
    */
   private String name;

   public UrlParameter( String content, String name )
   {
      this.content = content;
      this.name = name;
   }

   public String getContent()
   {
      return content;
   }

   public String getName()
   {
      return name;
   }

}

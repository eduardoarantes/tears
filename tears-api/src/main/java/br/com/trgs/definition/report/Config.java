/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package br.com.trgs.definition.report;

import java.io.Serializable;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

/**
 * Class Config.
 * 
 * @version $Revision$ $Date$
 */
public class Config implements Serializable, IConfig
{

   // --------------------------/
   // - Class/Member Variables -/
   // --------------------------/

   /**
    * 
    */
   private static final long serialVersionUID = -4230561362940974253L;

   /**
    * Field _name.
    */
   private String name;

   /**
    * Field _value.
    */
   private String value;

   /**
    * Field _content.
    */
   private String content;

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IConfig#getName()
    */
   @Override
   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IConfig#getValue()
    */
   @Override
   public String getValue()
   {
      return value;
   }

   public void setValue( String value )
   {
      this.value = value;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IConfig#getContent()
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

}

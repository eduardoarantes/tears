package com.trgs.component.core;

import java.io.Serializable;

public class UrlParameter implements Serializable
{

   private static final long serialVersionUID = 6886797639005267558L;
   private String name = null;
   private String parameter = null;

   /**
    * 
    */
   public UrlParameter()
   {
      super();
   }

   /**
    * @return Returns the name.
    */
   public String getName()
   {
      return name;
   }

   /**
    * @param name The name to set.
    */
   public void setName( String name )
   {
      this.name = name;
   }

   /**
    * @return Returns the parameter.
    */
   public String getParameter()
   {
      return parameter;
   }

   /**
    * @param parameter The parameter to set.
    */
   public void setParameter( String parameter )
   {
      this.parameter = parameter;
   }

}

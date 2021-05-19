package br.com.trgs.tears.scheduler;

public class Parameter
{
   private String name;
   private String value;

   public Parameter()
   {
   }

   public Parameter( String name, String value )
   {
      this.name = name;
      this.value = value;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public void setValue( String value )
   {
      this.value = value;
   }

   public String getName()
   {
      return name;
   }

   public String getValue()
   {
      return value;
   }

}

package com.trgs.component.core;

public class Parameter
{
   private String name;
   private String value;
   private String applyTo;

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public String getValue()
   {
      return value;
   }

   public void setValue( String value )
   {
      this.value = value;
   }

   public String getApplyTo()
   {
      return applyTo;
   }

   public void setApplyTo( String applyTo )
   {
      this.applyTo = applyTo;
   }

   public Parameter clone()
   {
      Parameter newParam = new Parameter();

      newParam.applyTo = this.applyTo;
      newParam.value = this.value;
      newParam.name = this.name;
      return newParam;
   }
}

package br.com.trgs.tears.scheduler;

import java.util.List;

public class Action
{
   private List< Parameter > params;
   private ActionTypeEnum type;

   public Action( ActionTypeEnum type, List< Parameter > params )
   {
      this.type = type;
      this.params = params;
   }

   public ActionTypeEnum getType()
   {
      return type;
   }

   public List< Parameter > getParams()
   {
      return params;
   }
}

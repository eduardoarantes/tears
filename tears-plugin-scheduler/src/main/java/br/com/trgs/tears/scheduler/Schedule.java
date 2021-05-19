package br.com.trgs.tears.scheduler;

import java.util.List;

public class Schedule
{
   private String Id;
   private String Description;
   private String rule;
   List< Action > actions;
   List< String > reportIds;

   public Schedule( String Id, String Description, String rule, List< Action > actions, List< String > reportIds )
   {
      this.Id = Id;
      this.Description = Description;
      this.rule = rule;
      this.actions = actions;
      this.reportIds = reportIds;
   }

   public String getRule()
   {
      return rule;
   }

   public List< String > getReportIds()
   {
      return reportIds;
   }

   public List< Action > getActions()
   {
      return actions;
   }

   public String getId()
   {
      return Id;
   }

   public String getDescription()
   {
      return Description;
   }
}

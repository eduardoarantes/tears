package br.com.trgs.definition.report;

import java.util.List;

public interface IReportParameterDefinition
{

   public abstract boolean isRequired();

   public abstract String getId();

   public abstract String getType();

   public abstract String getDescription();

   public abstract String getDefaultValue();

   public List< ReportParameter > getReportParameterMap();

   public ReportParameterSql getReportParameterSql();

}
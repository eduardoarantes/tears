package br.com.trgs.definition.report;

import java.util.List;

public interface IURLDefinition
{

   public abstract String getReportId();

   public abstract String getDescription();

   public abstract String getPath();

   public abstract String getComplement();

   public abstract String getNewWindow();

   public abstract boolean isOpenInLine();

   public abstract List< UrlParameter > getUrlParameterList();

}
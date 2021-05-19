package br.com.trgs.definition.report;

import java.util.List;

public interface IColumnDefinition
{

   public abstract String getId();

   public abstract String getDescription();

   public abstract String getType();

   public abstract String getConsolidator();

   public abstract String getMappedDataNotFound();

   public abstract boolean isDisplay();

   public abstract String getFormat();

   public abstract String getStyleClass();

   public abstract boolean isAllowFilter();

   public abstract String getValue();

   public abstract String getExpression();

   public abstract String getStyleExpression();

   public abstract List< ColumnMap > getColumnMap();

   public abstract List< UrlDefinition > getUrl();

}
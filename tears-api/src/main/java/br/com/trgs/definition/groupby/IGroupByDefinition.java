package br.com.trgs.definition.groupby;

import java.util.List;

import br.com.trgs.definition.chart.IChartDefinition;

public interface IGroupByDefinition
{

   public abstract java.lang.String getDescription();

   public abstract java.lang.String getId();

   public abstract boolean isDisplay();

   public abstract boolean isWithDetails();

   public abstract List< IGroupByColumnDefinition > getGroupByColumns();

   public abstract List< ICalculatedColumnDefinition > getCalculatedColumns();

   public abstract IChartDefinition getChart();

}
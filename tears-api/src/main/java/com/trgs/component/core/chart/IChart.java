package com.trgs.component.core.chart;

import java.util.List;

import br.com.trgs.definition.chart.IChartColumnDefinition;

import com.trgs.component.core.Parameter;

public interface IChart
{

   public abstract List< IChartColumnDefinition > getChartColumn();

   public abstract String getDescription();

   public abstract int getHeight();

   public abstract List< Parameter > getParam();

   public abstract String getTitle();

   public abstract String getType();

   public abstract int getWidth();

   public abstract void setProvider( String provider );

   public abstract String getProvider();

   public abstract void setWidth( final int width );

   public abstract void setType( final String type );

   public abstract void setTitle( final String title );

   public abstract void setHeight( final int height );

   public abstract void setDescription( final String description );

   void setParamList( List< Parameter > paramList );

}
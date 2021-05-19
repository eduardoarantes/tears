package com.trgs.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.trgs.definition.chart.IChartColumnDefinition;
import br.com.trgs.definition.chart.IChartDefinition;

import com.trgs.component.core.ColumnDescription;
import com.trgs.component.core.Parameter;
import com.trgs.component.core.RecordSet;
import com.trgs.component.core.chart.Chart;
import com.trgs.component.core.chart.ChartColumn;

public class ReportAPIHelper
{
   public static void getChartDefinition( IChartDefinition chartDefinition, RecordSet recordSet, String defaultChartType,
      int defaultHeight, int defaultWidth )
   {

      if( chartDefinition == null )
      {
         return;
      }

      Chart chart = new Chart();
      
      recordSet.setChart( chart );

      chart.setDescription( chartDefinition.getDescription() );
      chart.setTitle( chartDefinition.getTitle() );
      chart.setProvider( chartDefinition.getProvider() );

      if( StringUtils.isBlank( chartDefinition.getType() ) )
      {
         chart.setType( defaultChartType );
      }
      else
      {
         chart.setType( chartDefinition.getType() );
      }
      if( chartDefinition.getHeight() == 0 )
      {
         chart.setHeight( defaultHeight );
      }
      else
      {
         chart.setHeight( chartDefinition.getHeight() );
      }

      if( chartDefinition.getWidth() == 0 )
      {
         chart.setWidth( defaultWidth );
      }
      else
      {
         chart.setWidth( chartDefinition.getWidth() );
      }

      List< Parameter > parameters = new ArrayList< Parameter >();

      for( Parameter parameter : chartDefinition.getParam() )
      {
         parameters.add( parameter.clone() );
      }

      chart.setParamList( parameters );

      if( chartDefinition.getChartColumn() != null && chartDefinition.getChartColumn().size() > 0 )
      {
         for( IChartColumnDefinition columnDefinition : chartDefinition.getChartColumn() )
         {
            ChartColumn vChartColumn = new ChartColumn();
            vChartColumn.setDescription( columnDefinition.getDescription() );
            vChartColumn.setFormat( columnDefinition.getFormat() );
            vChartColumn.setRefId( columnDefinition.getRefId() );
            vChartColumn.setType( columnDefinition.getType() );
            chart.addChartColumn( vChartColumn );
         }
      }
      else
      {
         for( ColumnDescription chartColumn : recordSet.getColumns() )
         {
            ChartColumn vChartColumn = new ChartColumn();
            vChartColumn.setDescription( chartColumn.getDescription() );
            vChartColumn.setFormat( chartColumn.getFormat() );
            vChartColumn.setRefId( chartColumn.getId() );
            vChartColumn.setType( chartColumn.getDataType().name() );
            chart.addChartColumn( vChartColumn );

         }
      }

   }

   public static String checkPath( String property )
   {
      if( property != null && !property.endsWith( File.separator ) )
      {
         return property + File.separator;
      }
      return property;
   }

}

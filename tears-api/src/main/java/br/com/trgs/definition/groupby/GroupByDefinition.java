package br.com.trgs.definition.groupby;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.trgs.definition.chart.IChartDefinition;

/**
 * Class GroupByDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class GroupByDefinition implements Serializable, IGroupByDefinition
{
   /**
    * 
    */
   private static final long serialVersionUID = 4253105901721163203L;

   /**
    * Field _description.
    */
   private String description;

   /**
    * Field _id.
    */
   private String id;

   /**
    * Field _display.
    */
   private boolean display = true;

   /**
    * Field _withDetails.
    */
   private boolean withDetails = false;

   /**
    * Field _groupByColumnList.
    */
   private List< IGroupByColumnDefinition > groupByColumns;

   /**
    * Field _calculatedColumnList.
    */
   private List< ICalculatedColumnDefinition > calculatedColumns;

   /**
    * Field _chart.
    */
   private IChartDefinition chart;

   // ----------------/
   // - Constructors -/
   // ----------------/

   public GroupByDefinition()
   {
      super();
      this.groupByColumns = new ArrayList< IGroupByColumnDefinition >();
      this.calculatedColumns = new ArrayList< ICalculatedColumnDefinition >();
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#getDescription()
    */
   @Override
   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#getId()
    */
   @Override
   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#isDisplay()
    */
   @Override
   public boolean isDisplay()
   {
      return display;
   }

   public void setDisplay( boolean display )
   {
      this.display = display;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#isWithDetails()
    */
   @Override
   public boolean isWithDetails()
   {
      return withDetails;
   }

   public void setWithDetails( boolean withDetails )
   {
      this.withDetails = withDetails;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#getGroupByColumns()
    */
   @Override
   public List< IGroupByColumnDefinition > getGroupByColumns()
   {
      return groupByColumns;
   }

   public void addGroupByColumns( GroupByColumnDefinition groupByColumn )
   {
      this.groupByColumns.add( groupByColumn );
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#getCalculatedColumns()
    */
   @Override
   public List< ICalculatedColumnDefinition > getCalculatedColumns()
   {
      return calculatedColumns;
   }

   public void addCalculatedColumns( CalculatedColumnDefinition calculatedColumn )
   {
      this.calculatedColumns.add( calculatedColumn );
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.groupby.IGroupByDefinition#getChart()
    */
   @Override
   public IChartDefinition getChart()
   {
      return chart;
   }

   public void setChart( IChartDefinition chart )
   {
      this.chart = chart;
   }

}

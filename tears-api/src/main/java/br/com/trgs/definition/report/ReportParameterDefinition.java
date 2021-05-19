package br.com.trgs.definition.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ReportParameterDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ReportParameterDefinition implements Serializable, IReportParameterDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = -2593141532449597100L;

   /**
    * Field _required.
    */
   private boolean required = true;

   /**
    * Field _id.
    */
   private String id;

   /**
    * Field _type.
    */
   private String type;

   /**
    * Field _description.
    */
   private String description;

   /**
    * Field _defaultValue.
    */
   private String defaultValue;

   /**
    * Field _reportParameterMapList.
    */
   private List< ReportParameter > reportParameterMapList = new ArrayList< ReportParameter >();

   /**
    * Field _reportParameterSql.
    */
   private ReportParameterSql reportParameterSql;

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IReportParameterDefinition#isRequired()
    */
   @Override
   public boolean isRequired()
   {
      return required;
   }

   public void setRequired( boolean required )
   {
      this.required = required;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IReportParameterDefinition#getId()
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
    * @see br.com.trgs.definition.report.IReportParameterDefinition#getType()
    */
   @Override
   public String getType()
   {
      return type;
   }

   public void setType( String type )
   {
      this.type = type;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IReportParameterDefinition#getDescription()
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
    * @see br.com.trgs.definition.report.IReportParameterDefinition#getDefaultValue()
    */
   @Override
   public String getDefaultValue()
   {
      return defaultValue;
   }

   public void setDefaultValue( String defaultValue )
   {
      this.defaultValue = defaultValue;
   }

   public void setReportParameterSql( ReportParameterSql reportParameterSql )
   {
      this.reportParameterSql = reportParameterSql;
   }

   public ReportParameterSql getReportParameterSql()
   {
      return reportParameterSql;
   }

   public void addReportParameterMap( ReportParameter reportParameterMap )
   {
      this.reportParameterMapList.add( reportParameterMap );
   }

   public List< ReportParameter > getReportParameterMap()
   {
      return reportParameterMapList;
   }

}

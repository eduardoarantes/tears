package br.com.trgs.definition.report;

import java.util.ArrayList;
import java.util.List;

/**
 * Class UrlDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class UrlDefinition implements java.io.Serializable, IURLDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = 7743805563922057307L;

   /**
    * Field _reportId.
    */
   private String reportId;

   /**
    * Field _description.
    */
   private String description;

   /**
    * Field _path.
    */
   private String path;

   /**
    * Field _complement.
    */
   private String complement;

   /**
    * Field _newWindow.
    */
   private String newWindow = "false";

   /**
    * Field _openInLine.
    */
   private boolean openInLine = false;

   /**
    * Field _urlParameterList.
    */
   private List< UrlParameter > urlParameterList = new ArrayList< UrlParameter >();

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#getReportId()
    */
   @Override
   public String getReportId()
   {
      return reportId;
   }

   public void setReportId( String reportId )
   {
      this.reportId = reportId;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#getDescription()
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
    * @see br.com.trgs.definition.report.IURLDefinition#getPath()
    */
   @Override
   public String getPath()
   {
      return path;
   }

   public void setPath( String path )
   {
      this.path = path;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#getComplement()
    */
   @Override
   public String getComplement()
   {
      return complement;
   }

   public void setComplement( String complement )
   {
      this.complement = complement;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#getNewWindow()
    */
   @Override
   public String getNewWindow()
   {
      return newWindow;
   }

   public void setNewWindow( String newWindow )
   {
      this.newWindow = newWindow;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#isOpenInLine()
    */
   @Override
   public boolean isOpenInLine()
   {
      return openInLine;
   }

   public void setOpenInLine( boolean openInLine )
   {
      this.openInLine = openInLine;
   }

   /* (non-Javadoc)
    * @see br.com.trgs.definition.report.IURLDefinition#getUrlParameterList()
    */
   @Override
   public List< UrlParameter > getUrlParameterList()
   {
      return urlParameterList;
   }

   public void addUrlParameter( UrlParameter urlParameter )
   {
      this.urlParameterList.add( urlParameter );
   }

}

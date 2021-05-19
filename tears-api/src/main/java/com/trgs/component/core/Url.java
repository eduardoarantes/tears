package com.trgs.component.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Eduardo rodrigues
 * @version $Revision$ Created : Jan 13, 2005
 */
public class Url implements Serializable
{
   private static final long serialVersionUID = -5595217818582191011L;
   private String path = "";
   private List< UrlParameter > parameters = new ArrayList< UrlParameter >();

   private String reportId;

   private String description;
   private boolean newWindow = false;

   private boolean openInLine = false;

   public Url( String path )
   {
      this.path = path;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription( String description )
   {
      this.description = description;
   }

   public UrlParameter getParameter( int index )
   {
      return (UrlParameter) parameters.get( index );
   }

   public Collection< UrlParameter > getParameters()
   {
      return parameters;
   }

   public void setParameter( UrlParameter parameter )
   {
      this.parameters.add( parameter );
   }

   public String getPath()
   {
      return path;
   }

   public void setPath( String path )
   {
      this.path = path;
   }

   public String getReportId()
   {
      return reportId;
   }

   public void setReportId( String reportId )
   {
      this.reportId = reportId;
   }

   public boolean isNewWindow()
   {
      return newWindow;
   }

   public void setNewWindow( boolean newWindow )
   {
      this.newWindow = newWindow;
   }

   public boolean isOpenInLine()
   {
      return openInLine;
   }

   public void setOpenInLine( boolean openInLine )
   {
      this.openInLine = openInLine;
   }

}
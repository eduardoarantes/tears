package com.trgs.component.report;

import java.io.File;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.trgs.definition.report.IReportDefinition;

import com.trgs.component.reports.connection.ApplicationConnections;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.component.reports.connection.interfaces.IUserReports;
import com.trgs.util.ReportAPIHelper;
import com.trgs.util.TearsException;

public interface IReportsApplication
{
   public static final String DIR_SETTINGS = ReportAPIHelper.checkPath( System.getProperty( "ReportPath" ) );
   public static final String CONFIGURATIONS_DIR = DIR_SETTINGS + "configurations" + File.separator;
   public static final String TEMPLATE_DIR = CONFIGURATIONS_DIR + "template" + File.separator;

   public static final String TREE_ROOT_PATH_ID = "ROOT";

   public enum PROPERTIES
   {
      ENCODING( "file.encoding" ), ROOT_FOLDER_NAME( "rootFolder.name" ), ROOT_FOLDER_DESCRIPTION( "rootFolder.description" ),
      DEFAULT_PAGE_SIZE( "recordset.defaultPageSize" ), APPLICATION_TEMP_FOLDER( "application.temp.folder" ), DEFAULT_CHAT_TYPE(
         "chart.defaultType" ), DEFAULT_CHAT_WIDTH( "chart.width" ), DEFAULT_CHAT_HEIGHT( "chart.height" ), CHART_DEFAULT_DYNAMIC(
         "chart.defaultDynamic" ), ALLOW_EXPORT( "recordset.allowExport" ), DATA_FORMAT( "data.format" ), ADMIN_ROLE(
         "application.adminRole" ), ROOT_PATH( "application.root.path" ), TEMPLATE_DOWNLOAD( "template.default" );
      PROPERTIES( String key )
      {
         this.key = key;
      }

      private String key;

      public String getKey()
      {
         return key;
      }
   }

   public enum FOLDER_CONFIG_ENUM
   {
      FOLDER_ROLES( "folder.roles" ), FOLDER_DESCRIPTION( "folder.description" );
      FOLDER_CONFIG_ENUM( String key )
      {
         this.key = key;
      }

      private String key;

      public String getKey()
      {
         return key;
      }
   }

   public String getApplicationProperty( PROPERTIES encoding );

   public String getApplicationProperty( String string ) throws TearsException;

   public ApplicationConnections getApplicationConnections() throws TearsException;

   public DataSourceConnection getSelectedConnection( String connectionId ) throws TearsException;

   public IReportDefinition getReportById( String refId );

   public void reloadConfigurations() throws TearsException;

   public void shutdown() throws TearsException;

   public IUserReports getUserReports( UserDetails user );

   public Map< String, IReportDefinition > getReportsLocator();

}

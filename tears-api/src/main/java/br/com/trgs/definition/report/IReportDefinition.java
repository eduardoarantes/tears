package br.com.trgs.definition.report;

import java.util.List;

public interface IReportDefinition
{

   /**
     * Returns the value of field 'connectionId'.
     * 
     * @return the value of field 'ConnectionId'.
     */
   public abstract String getConnectionId();

   /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
   public abstract String getDescription();

   /**
     * Returns the value of field 'downloadOnly'.
     * 
     * @return the value of field 'DownloadOnly'.
     */
   public abstract String getDownloadOnly();

   /**
     * Returns the value of field 'externalLink'.
     * 
     * @return the value of field 'ExternalLink'.
     */
   public abstract String getExternalLink();

   /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
   public abstract String getId();

   /**
     * Returns the value of field 'isMainReport'. The field
     * 'isMainReport' has the following description: used to hide
     * detailed reports, called from other
     *  reports
     *  
     * 
     * @return the value of field 'IsMainReport'.
     */
   public abstract String getIsMainReport();

   /**
     * Method getRecordset.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
   public abstract List< IRecordsetDefinition > getRecordset();

   /**
     * Returns the value of field 'reportParameters'.
     * 
     * @return the value of field 'ReportParameters'.
     */
   public abstract List< IReportParameterDefinition > getReportParameters();

   /**
     * Returns the value of field 'roles'.
     * 
     * @return the value of field 'Roles'.
     */
   public abstract String getRoles();

   /**
     * Returns the value of field 'templateName'.
     * 
     * @return the value of field 'TemplateName'.
     */
   public abstract String getTemplateName();

   /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
   public abstract String getTitle();

}
package br.com.trgs.definition.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ReportDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ReportDefinition implements Serializable, IReportDefinition
{

   /**
    * 
    */
   private static final long serialVersionUID = 6251591422216438513L;

   /**
    * Field _description.
    */
   private String _description;

   /**
    * Field _title.
    */
   private String _title;

   /**
    * Field _id.
    */
   private String _id;

   /**
    * Field _roles.
    */
   private String _roles;

   /**
    * used to hide detailed reports, called from other
    *  reports
    *  
    */
   private String _isMainReport = "true";

   /**
    * Field _externalLink.
    */
   private String _externalLink = "";

   /**
    * Field _connectionId.
    */
   private String _connectionId;

   /**
    * Field _downloadOnly.
    */
   private String _downloadOnly = "none";

   /**
    * Field _templateName.
    */
   private String _templateName = "Default.html";

   /**
    * Field _reportParameters.
    */
   private List< IReportParameterDefinition > _reportParameters = new ArrayList< IReportParameterDefinition >();

   /**
    * Field _recordsetList.
    */
   private List< IRecordsetDefinition > _recordsetList = new ArrayList< IRecordsetDefinition >();;

   // ----------------/
   // - Constructors -/
   // ----------------/

   public ReportDefinition()
   {
      super();
      setIsMainReport( "true" );
      setExternalLink( "" );
      setDownloadOnly( "none" );
      setTemplateName( "Default.html" );
   }

   // -----------/
   // - Methods -/
   // -----------/

   /**
    * 
    * 
    * @param vRecordset
    * @throws IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addRecordset( final IRecordsetDefinition vRecordset )
   {
      this._recordsetList.add( vRecordset );
   }

   /**
    * Returns the value of field 'connectionId'.
    * 
    * @return the value of field 'ConnectionId'.
    */
   public String getConnectionId()
   {
      return this._connectionId;
   }

   /**
    * Returns the value of field 'description'.
    * 
    * @return the value of field 'Description'.
    */
   public String getDescription()
   {
      return this._description;
   }

   /**
    * Returns the value of field 'downloadOnly'.
    * 
    * @return the value of field 'DownloadOnly'.
    */
   public String getDownloadOnly()
   {
      return this._downloadOnly;
   }

   /**
    * Returns the value of field 'externalLink'.
    * 
    * @return the value of field 'ExternalLink'.
    */
   public String getExternalLink()
   {
      return this._externalLink;
   }

   /**
    * Returns the value of field 'id'.
    * 
    * @return the value of field 'Id'.
    */
   public String getId()
   {
      return this._id;
   }

   /**
    * Returns the value of field 'isMainReport'. The field
    * 'isMainReport' has the following description: used to hide
    * detailed reports, called from other
    *  reports
    *  
    * 
    * @return the value of field 'IsMainReport'.
    */
   public String getIsMainReport()
   {
      return this._isMainReport;
   }

   /**
    * Method getRecordset.Returns the contents of the collection
    * in an Array.  <p>Note:  Just in case the collection contents
    * are changing in another thread, we pass a 0-length Array of
    * the correct type into the API call.  This way we <i>know</i>
    * that the Array returned is of exactly the correct length.
    * 
    * @return this collection as an Array
    */
   public List< IRecordsetDefinition > getRecordset()
   {
      return this._recordsetList;
   }

   /**
    * Method getRecordsetCount.
    * 
    * @return the size of this collection
    */
   public int getRecordsetCount()
   {
      return this._recordsetList.size();
   }

   /**
    * Returns the value of field 'reportParameters'.
    * 
    * @return the value of field 'ReportParameters'.
    */
   public List< IReportParameterDefinition > getReportParameters()
   {
      return this._reportParameters;
   }

   /**
    * Returns the value of field 'roles'.
    * 
    * @return the value of field 'Roles'.
    */
   public String getRoles()
   {
      return this._roles;
   }

   /**
    * Returns the value of field 'templateName'.
    * 
    * @return the value of field 'TemplateName'.
    */
   public String getTemplateName()
   {
      return this._templateName;
   }

   /**
    * Returns the value of field 'title'.
    * 
    * @return the value of field 'Title'.
    */
   public String getTitle()
   {
      return this._title;
   }

   /**
    * Sets the value of field 'connectionId'.
    * 
    * @param connectionId the value of field 'connectionId'.
    */
   public void setConnectionId( final String connectionId )
   {
      this._connectionId = connectionId;
   }

   /**
    * Sets the value of field 'description'.
    * 
    * @param description the value of field 'description'.
    */
   public void setDescription( final String description )
   {
      this._description = description;
   }

   /**
    * Sets the value of field 'downloadOnly'.
    * 
    * @param downloadOnly the value of field 'downloadOnly'.
    */
   public void setDownloadOnly( final String downloadOnly )
   {
      this._downloadOnly = downloadOnly;
   }

   /**
    * Sets the value of field 'externalLink'.
    * 
    * @param externalLink the value of field 'externalLink'.
    */
   public void setExternalLink( final String externalLink )
   {
      this._externalLink = externalLink;
   }

   /**
    * Sets the value of field 'id'.
    * 
    * @param id the value of field 'id'.
    */
   public void setId( final String id )
   {
      this._id = id;
   }

   /**
    * Sets the value of field 'isMainReport'. The field
    * 'isMainReport' has the following description: used to hide
    * detailed reports, called from other
    *  reports
    *  
    * 
    * @param isMainReport the value of field 'isMainReport'.
    */
   public void setIsMainReport( final String isMainReport )
   {
      this._isMainReport = isMainReport;
   }

   /**
    * Sets the value of field 'reportParameters'.
    * 
    * @param reportParameters the value of field 'reportParameters'
    */
   public void addReportParameter( final IReportParameterDefinition reportParameter )
   {
      this._reportParameters.add( reportParameter );
   }

   /**
    * Sets the value of field 'roles'.
    * 
    * @param roles the value of field 'roles'.
    */
   public void setRoles( final String roles )
   {
      this._roles = roles;
   }

   /**
    * Sets the value of field 'templateName'.
    * 
    * @param templateName the value of field 'templateName'.
    */
   public void setTemplateName( final String templateName )
   {
      this._templateName = templateName;
   }

   /**
    * Sets the value of field 'title'.
    * 
    * @param title the value of field 'title'.
    */
   public void setTitle( final String title )
   {
      this._title = title;
   }

}

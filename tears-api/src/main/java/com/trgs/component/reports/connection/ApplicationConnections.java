package com.trgs.component.reports.connection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ApplicationConnections implements java.io.Serializable
{

   /**
   * 
   */
   private static final long serialVersionUID = 6212190229069601430L;

   // --------------------------/
   // - Class/Member Variables -/
   // --------------------------/

   /**
    * Field _defaultConnection.
    */
   private String _defaultConnection;

   /**
    * Field _reportConnectionList.
    */
   private Map< String, DataSourceConnection > _reportConnectionList;

   // ----------------/
   // - Constructors -/
   // ----------------/

   public ApplicationConnections()
   {
      this._reportConnectionList = new HashMap< String, DataSourceConnection >();
   }

   // -----------/
   // - Methods -/
   // -----------/

   /**
    * 
    * 
    * @param vReportConnection
    * @throws IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    */
   public void addDataSourceConnection( final DataSourceConnection vReportConnection )
   {
      this._reportConnectionList.put( vReportConnection.getId(), vReportConnection );
   }

   /**
    * Returns the value of field 'defaultConnection'.
    * 
    * @return the value of field 'DefaultConnection'.
    */
   public String getDataSourceConnection()
   {
      return this._defaultConnection;
   }

   /**
    * Method getReportConnection.
    * 
    * @param index
    * @throws IndexOutOfBoundsException if the index
    * given is outside the bounds of the collection
    * @return the value of the
    * DataSourceConnection at the
    * given index
    */
   public DataSourceConnection getDataSourceConnection( final String id ) throws IndexOutOfBoundsException
   {
      return _reportConnectionList.get( id );
   }

   public Collection< DataSourceConnection > getDataSourceConnections() throws IndexOutOfBoundsException
   {
      return _reportConnectionList.values();
   }

   /**
    * Sets the value of field 'defaultConnection'.
    * 
    * @param defaultConnection the value of field
    * 'defaultConnection'.
    */
   public void setDefaultDataSourceConnection( final String defaultConnection )
   {
      this._defaultConnection = defaultConnection;
   }

}

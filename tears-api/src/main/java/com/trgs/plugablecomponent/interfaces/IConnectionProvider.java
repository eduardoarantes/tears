package com.trgs.plugablecomponent.interfaces;

import com.trgs.component.reports.connection.ApplicationConnections;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.util.TearsException;

public interface IConnectionProvider extends IStartupProvider
{
   public ApplicationConnections getConnectionList() throws TearsException;

   public DataSourceConnection getConnection( String connectionId ) throws TearsException;
}

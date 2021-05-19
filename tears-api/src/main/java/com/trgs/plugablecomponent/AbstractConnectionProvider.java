package com.trgs.plugablecomponent;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Multimap;
import com.trgs.component.core.Parameter;
import com.trgs.component.report.IReportsApplication;
import com.trgs.component.reports.connection.ApplicationConnections;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.plugablecomponent.interfaces.IConnectionProvider;
import com.trgs.util.LogMemory;
import com.trgs.util.TearsException;

public abstract class AbstractConnectionProvider implements IConnectionProvider
{
   private String name;
   protected static final String SUCCESS = "success";
   protected LogMemory logMemory;
   protected IReportsApplication reportsApplication;

   public AbstractConnectionProvider( final Multimap< String, Parameter > parameterMap, LogMemory logMemory,
      IReportsApplication reportsApplication )
   {
      this.logMemory = logMemory;
      this.reportsApplication = reportsApplication;
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public void setName( String name )
   {
      this.name = name;
   }

   @Override
   public DataSourceConnection getConnection( String connectionId ) throws TearsException
   {
      ApplicationConnections connectionList = this.getConnectionList();
      if( StringUtils.isBlank( connectionId ) )
      {
         connectionId = connectionList.getDataSourceConnection();
      }

      if( StringUtils.isBlank( connectionId ) )
      {
         // TODO improve error handling
         throw new TearsException( new Exception(), this,
            "a conexao nao pode ser encontrada, verifique a configuracao da aplicacao", "connection.not.found" );
      }

      // Connection connection = null;
      return connectionList.getDataSourceConnection( connectionId );
   }

   @Override
   public abstract ApplicationConnections getConnectionList();

   /**
    * this method is intended to be used by user interface.
    * If true, the user with admin role will be able to invoke this plugin directly
    * @return
    */
   @Override
   public boolean isReloadAvailable()
   {
      return false;
   }
}

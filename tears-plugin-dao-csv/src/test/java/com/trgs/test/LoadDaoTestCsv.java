package com.trgs.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.trgs.test.AbstractReportsTest;

import com.trgs.component.core.Parameter;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.component.reports.dao.csv.CsvDaoImpl;
import com.trgs.plugablecomponent.AbstractDaoProvider;
import com.trgs.plugablecomponent.factory.DaoProviderFactory;

public class LoadDaoTestCsv extends AbstractReportsTest
{
   @Test
   public void testLoadByEnumCsv() throws Exception
   {
      DataSourceConnection reportConnection = new DataSourceConnection();

      Parameter param;
      AbstractDaoProvider reportDAO;

      reportConnection.setType( "csv" );
      reportConnection.setId( "csvFiles" );

      param = new Parameter();
      param.setName( "RootPath" );
      param.setValue( "c:\\csv\\" );
      reportConnection.addParam( param );

      reportDAO = DaoProviderFactory.getDao( reportConnection );
      Assert.assertTrue( reportDAO instanceof CsvDaoImpl );
   }

}

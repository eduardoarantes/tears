package com.trgs.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.trgs.definition.report.IReportDefinition;
import br.com.trgs.test.AbstractReportsTest;

import com.trgs.component.core.RecordsFlowControl;
import com.trgs.component.reports.connection.interfaces.IUserReports;
import com.trgs.reports.DelegateException;
import com.trgs.util.User;

public class CsvDaoTest extends AbstractReportsTest
{

   @Before
   public void thisSetUp() throws Exception
   {
      // usar o debug configuration
      // System.setProperty( "ReportPath", "C:\\env\\workspace\\TEARS\\tears-webapp\\src\\main\\resources\\Test" );
   }
   
   @Test
   public void test() throws DelegateException
   {
      IReportDefinition reportType;
      Map< String, String > paramValues = new HashMap< String, String >();

      User user = new User();

      IUserReports userReports = reportsApplication.getUserReports( user );

      reportType = userReports.getReport( "Relatorios_csv" );

      RecordsFlowControl flowControl = new RecordsFlowControl( "CSVTest", "CSVTest", "ASC", 1 );

      com.trgs.component.core.Report report = delegate.createGenericReport( reportType, flowControl, paramValues, null, user );

      Assert.assertNotNull( report.getRecordsets() );
      Assert.assertTrue( report.getRecordsets().size() > 0 );

      printReport( report );
   }

   /**
    * @throws DelegateException
    */
   @Test
   public void testColumns() throws DelegateException
   {
      IReportDefinition reportType;
      Map< String, String > paramValues = new HashMap< String, String >();

      User user = new User();

      IUserReports userReports = reportsApplication.getUserReports( user );

      reportType = userReports.getReport( "Relatorios_csv" );

      RecordsFlowControl flowControl = new RecordsFlowControl( "CSVTestColumns", "CSVTestColumns", "ASC", 1 );

      com.trgs.component.core.Report report = delegate.createGenericReport( reportType, flowControl, paramValues, null, user );

      Assert.assertNotNull( report.getRecordsets() );
      Assert.assertTrue( report.getRecordsets().size() > 0 );

      printReport( report );
   }
}

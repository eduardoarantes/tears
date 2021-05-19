package com.trgs.plugablecomponent.interfaces;

import java.util.List;
import java.util.Map;

import br.com.trgs.definition.report.IRecordsetDefinition;
import br.com.trgs.definition.report.IReportDefinition;

import com.trgs.component.core.ColumnDescription;
import com.trgs.component.core.IRecordSet;
import com.trgs.component.core.datatypes.BasicData;
import com.trgs.component.reports.connection.DataSourceConnection;
import com.trgs.plugablecomponent.interfaces.basic.IPluggable;
import com.trgs.util.TearsException;
import com.trgs.util.User;

public interface IDaoProvider extends IPluggable
{

   public void releaseResource() throws TearsException;

   public List< Map< ColumnDescription, BasicData >> createResultMap( IReportDefinition reportType, IRecordSet recordSet,
      IRecordsetDefinition recordsetTypeXML, Map< String, String > parameters, User user ) throws TearsException;

   public DataSourceConnection getReportConnection();

   public void setReportConnection( DataSourceConnection reportConnection ) throws TearsException;

   public Map< String, String > getReportParameteres( String sql, String key, String value, User user ) throws TearsException;
}

package com.trgs.component.reports.connection.interfaces;

import java.util.Map;

import br.com.trgs.definition.report.IReportDefinition;

import com.trgs.util.TearsException;
import com.trgs.util.TreeViewMenuItem;

public interface IUserReports
{

   public abstract IReportDefinition getReport( String reportId ) throws TearsException;

   public abstract TreeViewMenuItem getSubMenu( String path ) throws TearsException;

   public int getReportCount();

   public Map< String, IReportDefinition > getReportLocator() throws TearsException;

}
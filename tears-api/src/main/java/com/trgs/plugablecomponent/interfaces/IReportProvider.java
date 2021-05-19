package com.trgs.plugablecomponent.interfaces;

import java.util.Map;

import com.trgs.plugablecomponent.interfaces.basic.IPluggable;
import com.trgs.util.TearsException;
import com.trgs.util.TreeViewMenuItem;

public interface IReportProvider extends IPluggable
{

   public Map< String, TreeViewMenuItem > getReportStructure() throws TearsException;

}

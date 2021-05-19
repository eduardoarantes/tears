package com.trgs.plugablecomponent.interfaces;

import java.util.Collection;
import java.util.Map;

import br.com.trgs.definition.chart.IPDFDraw;

import com.trgs.component.core.IRecordSet;
import com.trgs.plugablecomponent.interfaces.basic.IPluggable;
import com.trgs.util.TearsException;

public interface IChartProvider extends IPluggable
{

   public boolean isTypeAvailable( String type, String media ) throws TearsException;

   public boolean isMediaAvailable( String type ) throws TearsException;

   public Collection< String > getChartList( String media ) throws TearsException;

   public Collection< String > getMediaList( String type ) throws TearsException;

   public String renderHTML( IRecordSet recordSet ) throws TearsException;

   public String renderPDF( IRecordSet recordSet, Map< String, IPDFDraw > plotMap ) throws TearsException;

   public void setPriority( Integer i );

   public Integer getPriority();
}

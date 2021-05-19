package com.trgs.component.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author eduardo rodrigues
 * 
 * @version $Revision$
 * 
 */
public class Report extends AbstractBaseInfo implements Serializable
{
   private static final long serialVersionUID = 355958298557588061L;

   private Map< String, RecordSet > recordsetsMap = new LinkedHashMap< String, RecordSet >();

   private String title;
   
   public Report( String id )
   {
      setId( id );
   }

   public void addRecordset( RecordSet recordset )
   {
      recordsetsMap.put( recordset.getId(), recordset );
   }

   public Collection< RecordSet > getRecordsets()
   {
      return Collections.unmodifiableCollection( recordsetsMap.values() );
   }

   public RecordSet getRecordSetById( String id )
   {
      return recordsetsMap.get( id );
   }

   public void setTitle( String title )
   {
      this.title = title;
   }

   public String getTitle()
   {
      return title;
   }
}

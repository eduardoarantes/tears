package com.trgs.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MemoryLogHandler extends Handler
{

   private static ThreadLocal< MemoryLogHandler > repository = new ThreadLocal< MemoryLogHandler >();
   private LinkedList< LogRecord > logList = new LinkedList< LogRecord >();

   private MemoryLogHandler()
   {
   }

   public static MemoryLogHandler getInstance()
   {
      if(!( repository.get() instanceof MemoryLogHandler))
      {
         repository.set( new MemoryLogHandler());
      }
      return repository.get();
   }

   @Override
   public void close() throws SecurityException
   {
   }

   @Override
   public void flush()
   {
   }

   @Override
   public void publish( LogRecord record )
   {
      if( record != null )
         logList.add( record );
   }

   public List< LogRecord > getLog()
   {
      return logList;
   }

   public List< Map< String, String >> getHandleLog()
   {
      SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy hh:mm:ss" );

      List< Map< String, String >> report = new ArrayList< Map< String, String > >();
      Map< String, String > row;

      for( LogRecord record : logList )
      {
         row = new HashMap< String, String >();

         row.put( "level", record.getLevel().getName() );
         row.put( "date", dateFormat.format( new Date( record.getMillis() ) ) );
         row.put( "sequence", String.valueOf( record.getSequenceNumber() ) );
         row.put( "message", record.getMessage() );

         report.add( row );
      }

      return report;
   }

   public void clear()
   {
      logList = new LinkedList< LogRecord >();
   }
}

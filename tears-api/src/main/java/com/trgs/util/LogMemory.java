package com.trgs.util;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.log4j.Logger;

public class LogMemory
{
   private Logger log = Logger.getLogger( LogMemory.class );
   private static ResourceBundle bundle;
   private Level level;

   public LogMemory()
   {
      bundle = ResourceBundle.getBundle( "applicationMessages.BootStrap" );
      try
      {
         level = Level.parse( bundle.getString( "config.level" ) );
      }
      catch( Exception e )
      {
         level = Level.FINEST;
      }
     
   }

   public LogMemory( boolean isTest )
   {
      if( !isTest )
      {
         bundle = ResourceBundle.getBundle( "applicationMessages.BootStrap" );
         level = Level.parse( bundle.getString( "config.level" ) );
      }
      else
      {
         bundle = ResourceBundle.getBundle( "BootStrap" );
      }

   }

   private void log( Level level, String... params )
   {
      String msg = null;
      if( bundle.containsKey( params[0] ) )
      {
         msg = String.format( bundle.getString( params[0] ), handleParams( params ) );
      }
      else
      {
         msg = params[0];
      }
      LogRecord logRecord = new LogRecord( level, msg );
      MemoryLogHandler.getInstance().publish( logRecord );
      log.info( "<LGO-MEMORY-" + level.toString().toUpperCase() + ">" + msg );
   }

   /**
    * methods for SEVERE level
    * @param msg
    */
   public void severe( String... params )
   {
      log( Level.SEVERE, params );
   }

   public void fatal( String... params )
   {
      log( Level.SEVERE, params );
   }

   public void error( String... params )
   {
      log( Level.SEVERE, params );
   }

   public void severe( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );

      log( Level.SEVERE, msg.toString() );
   }

   public void fatal( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.SEVERE, msg.toString() );
   }

   public void error( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.SEVERE, msg.toString() );
   }

   public void error( String string, Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( string );
      msg.append( " - " );
      msg.append( e.getMessage() );
      
      log( Level.SEVERE, msg.toString() );
   }

   /**
    * methods for WARNING level
    * @param msg
    */
   public void warning( String... params )
   {
      log( Level.WARNING, params );
   }

   public void warn( String... params )
   {
      log( Level.WARNING, params );
   }

   public void warning( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.WARNING, msg.toString() );
   }

   public void warn( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.WARNING, msg.toString() );
   }

   public void warn( String string, Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( string );
      msg.append( " - " );
      msg.append( e.getMessage() );
      
      log( Level.WARNING, msg.toString() );
   }

   /**
    * methods for INFO level
    * @param msg
    */
   public void info( String... params )
   {
      log( Level.INFO, params );
   }

   public void info( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.INFO, msg.toString() );
   }

   /**
    * methods for CONFIG level
    * @param msg
    */
   public void config( String... params )
   {
      log( Level.CONFIG, params );
   }

   public void debug( String... params )
   {
      log( Level.CONFIG, params );
   }

   public void config( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.CONFIG, msg.toString() );
   }

   public void debug( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.CONFIG, msg.toString() );
   }

   public void debug( String string, Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( string );
      msg.append( " - " );
      msg.append( e.getMessage() );
      
      log( Level.CONFIG, msg.toString() );
   }

   /**
    * methods for low levels
    * @param msg
    */
   public void fine( String... params )
   {
      log( Level.FINE, params );
   }

   public void trace( String... params )
   {
      log( Level.FINE, params );
   }

   public void finer( String... params )
   {
      log( Level.FINER, params );
   }

   public void finest( String... params )
   {
      log( Level.FINEST, params );
   }

   public void fine( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.FINE, msg.toString() );
   }

   public void trace( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.FINE, msg.toString() );
   }

   public void finer( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.FINER, msg.toString() );
   }

   public void finest( Throwable e )
   {
      StringBuilder msg = new StringBuilder();
      msg.append( e.getMessage() );
      
      log( Level.FINEST, msg.toString() );
   }

   public boolean isTraceEnabled()
   {
      return Level.FINE.intValue() >= level.intValue();
   }

   public boolean isDebugEnabled()
   {
      return Level.CONFIG.intValue() >= level.intValue();
   }

   private Object[] handleParams( String... params )
   {
      Object params2[] = new Object[params.length - 1];
      for( int i = 1; i < params.length; i++ )
      {
         params2[i - 1] = params[i];
      }
      return params2;
   }

}

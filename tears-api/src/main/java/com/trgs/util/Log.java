package com.trgs.util;

import java.util.Enumeration;
import java.util.Formatter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.Priority;

/**
 * Encapsulates the access to the Jakarta/Apache Log engine
 * <a href="http://jakarta.apache.org/log4j/docs/index.html">jakarta.apache.org/log4j</a>
 *
 * @author Eduardo
 */

public class Log
{

   private Logger log;

   protected Log( String args )
   {
      log = Logger.getLogger( args );
   }

   protected Log( String applicationName, String args )
   {
      if( StringUtils.isNotBlank( applicationName ) )
      {
         args = applicationName + "." + args;
      }
      log = Logger.getLogger( args );
   }

   public static Log get( String category )
   {
      return new Log( category );
   }

   public static Log get( String applicationName, String category )
   {
      return new Log( applicationName, category );
   }

   public static Log get( String applicationName, @SuppressWarnings( "rawtypes" ) Class category )
   {
      return new Log( applicationName, category.getName() );
   }

   public synchronized void addAppender( Appender arg0 )
   {
      log.addAppender( arg0 );
   }

   public synchronized Appender getAppender( String arg0 )
   {
      return log.getAppender( arg0 );
   }

   @SuppressWarnings( { "rawtypes" } )
   public synchronized Enumeration getAllAppenders()
   {
      return log.getAllAppenders();
   }

   private static final String FULLY_QUALIFIED_NAME = Log.class.getName();

   public void trace( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.TRACE, arg0, arg1 );
   }

   public void trace( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.TRACE, arg0, null );
   }

   public boolean isTraceEnabled()
   {
      return log.isTraceEnabled();
   }

   public void debug( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.DEBUG, arg0, arg1 );
   }

   public void debug( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.DEBUG, arg0, null );
   }

   public boolean isDebugEnabled()
   {
      return log.isDebugEnabled();
   }

   public void info( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.INFO, arg0, arg1 );
   }

   public void info( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.INFO, arg0, null );
   }

   public boolean isInfoEnabled()
   {
      return log.isInfoEnabled();
   }

   public void warn( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.WARN, arg0, arg1 );
   }

   public void warn( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.WARN, arg0, null );
   }

   public void error( Throwable throwable, String pattern, String... values )
   {
      Formatter f = new Formatter();
      f.format( pattern, (Object) values );
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, f.toString(), throwable );
   }

   public void error( String pattern, String... values )
   {
      Formatter f = new Formatter();
      f.format( pattern, (Object) values );
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, f.toString(), null );
   }

   public void error( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, arg0, arg1 );
   }

   public void error( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, arg0, null );
   }

   public void fatal( Object arg0, Throwable arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.FATAL, arg0, arg1 );
   }

   public void fatal( Object arg0 )
   {
      log.log( FULLY_QUALIFIED_NAME, Level.FATAL, arg0, null );
   }

   public void log( Priority arg0, Object arg1, Throwable arg2 )
   {
      log.log( FULLY_QUALIFIED_NAME, arg0, arg1, arg2 );
   }

   public void log( Priority arg0, Object arg1 )
   {
      log.log( FULLY_QUALIFIED_NAME, arg0, arg1, null );
   }

   public void log( String arg0, Priority arg1, Object arg2, Throwable arg3 )
   {
      log.log( arg0, arg1, arg2, arg3 );
   }

   public void setLevel( Level arg0 )
   {
      log.setLevel( arg0 );
   }

   // we use these enum-types to avoid typos
   public enum EChannel
   {
      SABRE, TOURICO, JETPAY;
   }

   public enum EOperation
   {
      BOOK_EXECUTE, ROLLBACK_BOOK_EXECUTE, CANCEL_EXECUTE, PAYMENT_AUTHORIZE, PAYMENT_PURCHASE, PAYMENT_REFUND, PAYMENT_RETURN;
   }

   private void setMDC( String username, EChannel channel, EOperation operation )
   {
      // If we run this MDC.put(object,**null**), we will get a NULL
      // In order to avoid it, we have to check for a not null condition
      if( username != null )
         MDC.put( "username", username );
      if( operation != null )
         MDC.put( "operation", operation );
      if( channel != null )
         MDC.put( "channel", channel );
   }

   private void unsetMDC()
   {
      MDC.remove( "username" );
      MDC.remove( "operation" );
      MDC.remove( "channel" );
   }

   // user and operation params
   public void info( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.INFO, arg0, arg1 );
      unsetMDC();
   }

   public void info( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.INFO, arg0, null );
      unsetMDC();
   }

   public void debug( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.DEBUG, arg0, arg1 );
      unsetMDC();
   }

   public void debug( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.DEBUG, arg0, null );
      unsetMDC();
   }

   public void warn( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.WARN, arg0, arg1 );
      unsetMDC();
   }

   public void warn( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.WARN, arg0, null );
      unsetMDC();
   }

   public void error( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, arg0, arg1 );
      unsetMDC();
   }

   public void error( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.ERROR, arg0, null );
      unsetMDC();
   }

   public void fatal( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.FATAL, arg0, arg1 );
      unsetMDC();
   }

   public void fatal( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.FATAL, arg0, null );
      unsetMDC();
   }

   public void log( Priority arg0, Object arg1, Throwable arg2, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, arg0, arg1, arg2 );
      unsetMDC();
   }

   public void log( Priority arg0, Object arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, arg0, arg1, null );
      unsetMDC();
   }

   public void log( String arg0, Priority arg1, Object arg2, Throwable arg3, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( arg0, arg1, arg2, arg3 );
      unsetMDC();
   }

   public void trace( Object arg0, Throwable arg1, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.TRACE, arg0, arg1 );
      unsetMDC();
   }

   public void trace( Object arg0, String username, EChannel channel, EOperation operation )
   {
      setMDC( username, channel, operation );
      log.log( FULLY_QUALIFIED_NAME, Level.TRACE, arg0, null );
      unsetMDC();
   }
}

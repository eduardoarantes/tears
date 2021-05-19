package com.trgs.util;

import com.trgs.plugablecomponent.interfaces.basic.IPluggable;

public class TearsException extends Exception
{
   private static final long serialVersionUID = 4299706303028439004L;

   private IPluggable pluggable;
   private String defaultMessage;
   private String messageKey;
   private String[] params;

   public TearsException( Throwable e, IPluggable pluggable, String defaultMessage, String messageKey, String... params )
   {
      super( e );
      this.pluggable = pluggable;
      this.defaultMessage = defaultMessage;
      this.messageKey = messageKey;
      this.params = params;
   }

   public TearsException( Throwable e, IPluggable pluggable, String defaultMessage, String messageKey )
   {
      this( e, pluggable, defaultMessage, messageKey, new String[0] );
   }

   public String getPluginName()
   {
      return pluggable.getName();
   }

   public String getDefaultMessage()
   {
      return defaultMessage;
   }

   public String getMessageKey()
   {
      return messageKey;
   }

   public String[] getParams()
   {
      return params;
   }
}
package com.trgs.plugablecomponent.interfaces;

import javax.servlet.http.HttpServletRequest;

import com.trgs.plugablecomponent.interfaces.basic.IPluggable;
import com.trgs.util.TearsException;


public interface IMessageProvider extends IPluggable
{
   public String getMessage(HttpServletRequest request, TearsException tearsException) ;
   public void setPriority(Integer i);
   public Integer getPriority();
}

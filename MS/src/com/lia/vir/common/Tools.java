package com.lia.vir.common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.lia.vir.common.Constant.LogEnum;

public class Tools {

	public static Object getRemoteSessionBean(String sessionName,
			String sessionType) throws NamingException
	{ 
		String tmpType = sessionType;
		if ("".equals(sessionType))
		{
			tmpType = Constant.S_LOCAL_SESSION;
		}
		return getLocalSessionBean(sessionName, tmpType);
		
	}
	
	@SuppressWarnings("unchecked") 
	public static Object getLocalSessionBean(String sessionName,
			String sessionType) throws NamingException
	{ 
		LogUtil.log(LogEnum.INFOR, "new init context");
		Hashtable environment = new Hashtable(); 
		environment.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory"); 
		environment.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces"); 
		environment.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099"); 
		Context context = new InitialContext(environment); 
		return context.lookup(Constant.S_POJECT_NAME +"/" + sessionName
				+ "/" + sessionType);
	} 
	
}

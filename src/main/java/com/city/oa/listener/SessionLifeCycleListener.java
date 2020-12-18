package com.city.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionLifeCycleListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  { 
        System.out.println("会话对象创建了");
    }
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	ServletContext application = event.getSession().getServletContext();
		int usercount = (int) application.getAttribute("usercount") - 1;
		application.setAttribute("usercount", usercount);
		String id = (String) event.getSession().getAttribute("admin");
		@SuppressWarnings("unchecked")
		List<String> userlist = (List<String>) application.getAttribute("userlist");
		userlist.remove(id);
		application.setAttribute("userlist", userlist);
		System.out.println("session被销毁了");
    }
	
}

package com.city.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class UserLoginAdminListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (event.getName().equals("admin")) {
			ServletContext application = event.getSession().getServletContext();
			int usercount = (int) application.getAttribute("usercount") + 1;
			application.setAttribute("usercount", usercount);
			String id = (String) event.getSession().getAttribute("admin");
			System.out.println("session增加属性:admin;  值:" + id);
			@SuppressWarnings("unchecked")
			List<String> userlist = (List<String>) application.getAttribute("userlist");
			userlist.add(id);
			application.setAttribute("userlist", userlist);
			System.out.println("application中增加" + userlist);
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

}

package com.city.oa.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletStartListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("server start");
    }
}

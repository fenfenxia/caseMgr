package com.city.oa.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplictionAttributeChangeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent event)  { 
    	//取得增加的属性的名
    	String name=event.getName();
    	Object value=event.getValue();
    	System.out.println("application中增加属性:"+name+"="+value);
    }
}

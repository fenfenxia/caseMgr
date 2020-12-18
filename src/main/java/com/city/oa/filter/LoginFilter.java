package com.city.oa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "loginFilter", urlPatterns = { "*.do", "*.jsp" })
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(req);
		//0.强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//1.获取资源请求路径
		String uri = request.getRequestURI();
		//2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
		if(uri.contains("/login.html") || uri.contains("/login.do") || uri.contains("/assets/")  ){
			//包含，用户就是想登录。放行
			chain.doFilter(req, resp);
		}else{
			//不包含，需要验证用户是否登录
			//3.从获取session中获取user
			Object user = request.getSession().getAttribute("user");
			if(user != null){
				//登录了。放行
				chain.doFilter(req, resp);
			}else{
				//没有登录。跳转登录页面
				response.sendRedirect("/caseMgr/login.html");
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}

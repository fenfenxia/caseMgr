package com.city.oa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UserLogoutController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 15:59
 */
@WebServlet("/logout.do")
public class UserLogoutController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.getWriter().append("<script language=\"javascript\"> \r\n" +
                "alert(\"已退出登录,2秒后重新回到登录页面...\");\r\n" +
                "</script>");
        resp.setHeader("refresh", "2;url="+req.getContextPath()+"/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

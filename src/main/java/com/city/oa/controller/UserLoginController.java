package com.city.oa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UserLoginController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 15:52
 */
@WebServlet("/login.do")
public class UserLoginController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        if(password.equals("123456")&&user.equals("root")) {
            req.getSession().setAttribute("user",user);
            String path=req.getContextPath();
            resp.sendRedirect(path+"/index.html");
        }
        else {
            resp.getWriter().append("<script language=\"javascript\"> \r\n" +
                    "alert(\"登录名或密码错误,登录失败,2秒后重新回到登录页面...\");\r\n" +
                    "</script>");
            resp.setHeader("refresh", "2;url="+req.getContextPath()+"/index.jsp");
        }
    }
}

package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.service.ICaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: CaseDeleteController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 15:15
 */
@WebServlet("/pages/case/delete.do")
public class CaseDeleteController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        ICaseService cs = ServiceFactory.getCaseService();
        try {
            cs.deleteCase(id);
            String tishi="删除成功,3秒后自动回到主页...";
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            resp.setHeader("refresh", "3;url="+req.getContextPath()+"/pages/case/list.do");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

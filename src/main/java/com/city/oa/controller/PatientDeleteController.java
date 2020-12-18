package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.service.IPatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: PatientDeleteController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 13:10
 */
@WebServlet("/pages/patient/delete.do")
public class PatientDeleteController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        IPatientService patientService = ServiceFactory.getPatientService();
        try {
            patientService.deletePatient(id);
            String tishi="删除成功,3秒后自动回到主页...";
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            resp.setHeader("refresh", "3;url="+req.getContextPath()+"/pages/patient/list.do");
        }catch (Exception e) {
        	String tishi="删除失败,3秒后自动回到主页...\r\n原因是："+e.getMessage();
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            resp.setHeader("refresh", "3;url="+req.getContextPath()+"/pages/patient/list.do");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
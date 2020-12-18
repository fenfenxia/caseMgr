package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.PatientModel;
import com.city.oa.service.IPatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: PatientModifyController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 13:10
 */
@WebServlet("/pages/patient/update.do")
public class PatientModifyController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sex");
        double weight=Double.parseDouble(request.getParameter("weight"));
        double height=Double.parseDouble(request.getParameter("height"));
        PatientModel pm = new PatientModel();
        pm.setId(id);
        pm.setName(name);
        pm.setSex(sex);
        pm.setAge(age);
        pm.setWeight(weight);
        pm.setHeight(height);
        IPatientService patientService = ServiceFactory.getPatientService();
        try {
            patientService.modifyPatient(pm);
            String tishi="修改成功,3秒后自动回到主页...";
            response.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            response.setHeader("refresh", "3;url="+request.getContextPath()+"/pages/patient/list.do");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
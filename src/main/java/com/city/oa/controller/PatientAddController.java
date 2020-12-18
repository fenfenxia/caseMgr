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
 * @ClassName: PetientAddController
 * @Description: 病人增加servlet
 * @Author: xad
 * @Date: 2020/12/8 12:37
 */
@WebServlet("/pages/patient/add.do")
public class PatientAddController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sex");
        double weight=Double.parseDouble(request.getParameter("weight"));
        double height=Double.parseDouble(request.getParameter("height"));
        PatientModel pm = new PatientModel();
        pm.setName(name);
        pm.setSex(sex);
        pm.setAge(age);
        pm.setWeight(weight);
        pm.setHeight(height);
        IPatientService patientService = ServiceFactory.getPatientService();
        try {
            patientService.addPatient(pm);
            String tishi="增加成功,3秒后自动回到主页...";
            response.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            response.setHeader("refresh", "3;url="+request.getContextPath()+"/pages/patient/list.do");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

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
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PatientSelectController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 13:11
 */
@WebServlet("/pages/patient/select.do")
public class PatientSelectController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        IPatientService patientService = ServiceFactory.getPatientService();
        try {
            PatientModel pm = patientService.selectById(id);
            List<PatientModel> pmList = new ArrayList<>();
            pmList.add(pm);
            req.setAttribute("pmList", pmList);
            req.getRequestDispatcher("/pages/patient/main.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
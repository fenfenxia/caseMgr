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
import java.util.List;

/**
 * @ClassName: PatientToMainController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 13:12
 */
@WebServlet("/pages/patient/list.do")
public class PatientToMainController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int row = 8;
        int page = 1;
        if(req.getParameter("row")!=null&&req.getParameter("page")!=null){
            row = Integer.valueOf(req.getParameter("row"));;
            page = Integer.valueOf(req.getParameter("page"));
        }
        IPatientService patientService= ServiceFactory.getPatientService();
        List<PatientModel> pmList=null;
        try {
            pmList=patientService.selectByPage(row,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("pmList", pmList);
        req.getRequestDispatcher("/pages/patient/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

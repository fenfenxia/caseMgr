package com.city.oa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.CaseModel;
import com.city.oa.service.ICaseService;

/**
 * @ClassName: CaseSelectController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 15:31
 */
@WebServlet("/pages/case/select.do")
public class CaseSelectController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        ICaseService cs = ServiceFactory.getCaseService();
        try{
            CaseModel cm = cs.selectById(id);
            req.setAttribute("cm",cm);
            req.getRequestDispatcher("/pages/case/show.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

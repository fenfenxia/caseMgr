package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.MedicineModel;
import com.city.oa.service.IMedicineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MedicineSelectController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 13:21
 */
@WebServlet("/pages/medicine/select.do")
public class MedicineSelectController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        IMedicineService ms = ServiceFactory.getMedicineService();
        MedicineModel mm = null;
        try {
            mm = ms.selectById(id);
            List<MedicineModel> list = new ArrayList<>();
            list.add(mm);
            req.setAttribute("mmList",list);
            req.getRequestDispatcher("/pages/medicine/show.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

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
import java.util.List;

/**
 * @ClassName: MedicineToMainController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 13:48
 */
@WebServlet("/pages/medicine/list.do")
public class MedicineToMainController extends HttpServlet {
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
        IMedicineService ms= ServiceFactory.getMedicineService();
        List<MedicineModel> mmList=null;
        try {
            mmList=ms.selectByPage(row,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("mmList", mmList);
        req.getRequestDispatcher("/pages/medicine/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

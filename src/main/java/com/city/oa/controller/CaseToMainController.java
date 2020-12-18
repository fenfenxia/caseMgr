package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.CaseModel;
import com.city.oa.service.ICaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: CaseToMainController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 13:50
 */
@WebServlet("/pages/case/list.do")
public class CaseToMainController extends HttpServlet {
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
        ICaseService cs= ServiceFactory.getCaseService();
        List<CaseModel> cmList=null;
        try {
            cmList=cs.selectByPage(row,page);//直接调用服务层，服务层将需要的病人id和药物信息存入病历
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("cmList", cmList);
        req.getRequestDispatcher("/pages/case/main.jsp").forward(req, resp);
    }
}

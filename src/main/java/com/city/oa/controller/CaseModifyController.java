package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.CaseModel;
import com.city.oa.model.MedicineModel;
import com.city.oa.service.ICaseService;
import com.city.oa.service.IMedicineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: CaseModifyController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 15:12
 */
@WebServlet("/pages/case/update.do")
public class CaseModifyController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String suggest=req.getParameter("suggest");
        int pId = Integer.parseInt(req.getParameter("pId"));
        double price = 0;
        //对传入日期的处理
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date=null;
        try {
            date = format.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //对传入药物id的处理，转化为medicine类存入caseModel
        List<MedicineModel> list = new ArrayList<>();
        IMedicineService ms = ServiceFactory.getMedicineService();
        ICaseService cs = ServiceFactory.getCaseService();
        String med = req.getParameter("medicines")+",";
        String substring = med.substring(0, med.length() - 1);
        String[] result = substring.split(",");
        for (String r : result) {
            int mid = Integer.parseInt(r.substring(0,r.indexOf(":")));
            int num = Integer.parseInt(r.substring(r.indexOf(":")+1,r.length()));
            try {
                MedicineModel mm = ms.selectById(mid);
                if (mm!=null) {
                    mm.setNumber(num);
                    list.add(mm);
                    price += mm.getNumber()*mm.getPrice();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        CaseModel cm = new CaseModel();
        cm.setDate(date);
        cm.setPId(pId);
        cm.setSuggest(suggest);
        cm.setPrice(price);
        cm.setMedicines(list);
        try {
            cs.modifyCase(cm);
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+"增加成功！3秒后返回主页"+"\");\r\n" + "</script>");
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

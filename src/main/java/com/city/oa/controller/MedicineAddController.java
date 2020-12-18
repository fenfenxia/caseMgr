package com.city.oa.controller;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.MedicineModel;
import com.city.oa.service.IMedicineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: MedicineAddController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 12:58
 */
@WebServlet("/pages/medicine/add.do")
@MultipartConfig
public class MedicineAddController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("药品信息添加");
        String name=req.getParameter("name");
        double price=Double.parseDouble(req.getParameter("price"));
        Part part = req.getPart("photo");
        String type=part.getContentType();
        InputStream in=part.getInputStream();
        String path = part.getHeader("Content-Disposition").substring(
                part.getHeader("Content-Disposition").indexOf("filename=\"") + 10,
                part.getHeader("Content-Disposition").lastIndexOf("\""));
        byte[] bt=new byte[in.available()];
        in.read(bt);
        MedicineModel mm = new MedicineModel();
        mm.setName(name);
        mm.setPrice(price);
        mm.setPhoto(bt);
        mm.setType(type);
        mm.setPath(path);
        mm.setPhoto(bt);
        try {
            IMedicineService ms= ServiceFactory.getMedicineService();
            ms.addMedicine(mm);
            String tishi="增加成功,3秒后自动回到主页...";
            System.out.println("药品信息添加成功");
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            resp.setHeader("refresh", "3;url=/caseMgr/pages/medicine/list.do");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

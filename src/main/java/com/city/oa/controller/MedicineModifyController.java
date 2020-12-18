package com.city.oa.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.MedicineModel;
import com.city.oa.service.IMedicineService;

/**
 * @ClassName: MedicineModifyController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 13:17
 */
@WebServlet("/pages/medicine/update.do")
@MultipartConfig
public class MedicineModifyController extends HttpServlet {
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
        int id = Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        double price=Double.parseDouble(req.getParameter("price"));
        Part part = req.getPart("photo");
        String type=part.getContentType();
        InputStream in=part.getInputStream();
        String header = part.getHeader("Content-Disposition");
        String path = header.substring(
                header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        byte[] bt=new byte[in.available()];
        in.read(bt);
        MedicineModel mm = new MedicineModel();
        mm.setId(id);
        mm.setName(name);
        mm.setPrice(price);
        mm.setPhoto(bt);
        mm.setType(type);
        mm.setPath(path);
        mm.setPhoto(bt);
        try {
            IMedicineService ms= ServiceFactory.getMedicineService();
            ms.modifyMedicine(mm);
            String tishi="修改成功,3秒后自动回到主页...";
            resp.getWriter().write("<script language=\"javascript\"> \r\n" +
                    "alert(\""+tishi+"\");\r\n" + "</script>");
            resp.setHeader("refresh", "3;url=/caseMgr/pages/medicine/list.do");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

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
import java.io.OutputStream;

/**
 * @ClassName: MedicineShowPhotoController
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/9 13:22
 */
@WebServlet("/pages/medicine/showPhoto.do")
public class MedicineShowPhotoController extends HttpServlet {
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
            String type=mm.getType();
            resp.setContentType(type);
            OutputStream out=resp.getOutputStream();
            byte[] bt=mm.getPhoto();
            out.write(bt);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

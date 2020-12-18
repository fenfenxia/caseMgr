package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.dao.ICaseDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.CaseModel;
import com.city.oa.model.MedicineModel;
import com.city.oa.model.PatientModel;
import com.city.oa.service.ICaseService;

/**
 * @ClassName: CaseServiceImpl
 * @Description: 对病例的增删改查，涉及到关联表的操作
 * @Author: xad
 * @Date: 2020/12/8 9:18
 */
public class CaseServiceImpl implements ICaseService {



    @Override//传入的病例要包含病人id、药物信息（包括药物id和数量）
    public void addCase(CaseModel cm) throws Exception {
        PatientModel pm = DaoFactory.getPatientDao().selectById(cm.getPId());
        if(pm==null) {throw new Exception("没有该病人");}
        double price = 0;
        for (MedicineModel mm:cm.getMedicines()) {
            MedicineModel temp = DaoFactory.getMedicineDao().selectById(mm.getId());
            price+=mm.getNumber()*temp.getPrice();
        }
        cm.setPrice(price);
        ICaseDao dao = DaoFactory.getCaseDao();
        int id = dao.insert(cm);
        System.out.println(id);
        for (MedicineModel mm : cm.getMedicines()) {
			System.out.println(mm.getId()+mm.getNumber());
		}
        dao.addToCase(id, cm.getMedicines());
    }

    @Override
    public void deleteCase(int id) throws Exception {
    	DaoFactory.getCaseDao().deleteFromCase(id);
    	DaoFactory.getCaseDao().delete(id);
    }

    @Override
    public void modifyCase(CaseModel cm) throws Exception {
    	DaoFactory.getCaseDao().deleteFromCase(cm.getId());
    	DaoFactory.getCaseDao().modify(cm);
        DaoFactory.getCaseDao().addToCase(cm.getId(),cm.getMedicines());
    }

    @Override
    public CaseModel selectById(int id) throws Exception {
        CaseModel cm = DaoFactory.getCaseDao().selectById(id);
        return cm;
    }

    @Override
    public List<CaseModel> selectByPage(int row,int page) throws Exception {
        List<CaseModel> list = DaoFactory.getCaseDao().selectListByPage(row, page);
        return list;
    }
}

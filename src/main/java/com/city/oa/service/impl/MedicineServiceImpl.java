package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.factory.DaoFactory;
import com.city.oa.model.MedicineModel;
import com.city.oa.service.IMedicineService;

/**
 * @ClassName: MedicineServiceImpl
 * @Description: 对药物的增删改查
 * @Author: xad
 * @Date: 2020/12/8 9:19
 */
public class MedicineServiceImpl implements IMedicineService {


    @Override
    public void addMedicine(MedicineModel mm) throws Exception {
    	DaoFactory.getMedicineDao().insert(mm);
    }

    @Override
    public void deleteMedicine(int id) throws Exception {
    	DaoFactory.getMedicineDao().delete(id);
    }

    @Override
    public void modifyMedicine(MedicineModel mm) throws Exception {
    	DaoFactory.getMedicineDao().modify(mm);
    }

    @Override
    public MedicineModel selectById(int id) throws Exception {
        return DaoFactory.getMedicineDao().selectById(id);
    }

    @Override
    public List<MedicineModel> selectByPage(int row,int page) throws Exception {
        return DaoFactory.getMedicineDao().selectListByPage(row, page);
    }
}

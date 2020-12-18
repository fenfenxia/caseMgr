package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.factory.DaoFactory;
import com.city.oa.model.PatientModel;
import com.city.oa.service.IPatientService;

/**
 * @ClassName: PatientServiceImpl
 * @Description: 对病人的增删改查
 * @Author: xad
 * @Date: 2020/12/8 9:19
 */
public class PatientServiceImpl implements IPatientService {

    @Override
    public void addPatient(PatientModel pm) throws Exception {
    	DaoFactory.getPatientDao().insert(pm);
    }

    @Override
    public void deletePatient(int id) throws Exception {
    	DaoFactory.getPatientDao().delete(id);
    }

    @Override
    public void modifyPatient(PatientModel pm) throws Exception {
    	DaoFactory.getPatientDao().modify(pm);
    }

    @Override
    public PatientModel selectById(int id) throws Exception {
        return DaoFactory.getPatientDao().selectById(id);
    }

    @Override
    public List<PatientModel> selectByPage(int row,int page) throws Exception {
        return DaoFactory.getPatientDao().selectListByPage(row,page);
    }
}

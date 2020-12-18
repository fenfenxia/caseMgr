package com.city.oa.dao;

import com.city.oa.model.PatientModel;

import java.util.List;

public interface IPatientDao {
    public void insert(PatientModel patient) throws Exception;
    public void delete(int id) throws Exception;
    public void modify(PatientModel patient) throws Exception;
    public PatientModel selectById(int id)throws Exception;
    public List<PatientModel> selectListByPage(int row,int page)throws Exception;
}

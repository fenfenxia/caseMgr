package com.city.oa.service;

import com.city.oa.model.PatientModel;
import java.util.List;

public interface IPatientService {
    public void addPatient(PatientModel pm)throws Exception;
    public void deletePatient(int id)throws Exception;
    public void modifyPatient(PatientModel pm)throws Exception;
    public PatientModel selectById(int id)throws Exception;
    public List<PatientModel> selectByPage(int row,int page)throws Exception;
}

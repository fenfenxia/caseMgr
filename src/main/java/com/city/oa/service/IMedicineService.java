package com.city.oa.service;

import com.city.oa.model.MedicineModel;

import java.util.List;

public interface IMedicineService {
    public void addMedicine(MedicineModel mm)throws Exception;
    public void deleteMedicine(int id)throws Exception;
    public void modifyMedicine(MedicineModel mm)throws Exception;
    public MedicineModel selectById(int id)throws Exception;
    public List<MedicineModel> selectByPage(int row,int page)throws Exception;
}


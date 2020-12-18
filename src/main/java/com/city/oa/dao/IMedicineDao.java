package com.city.oa.dao;

import com.city.oa.model.MedicineModel;

import java.util.List;

public interface IMedicineDao {
    public void insert(MedicineModel medicine) throws Exception;
    public void delete(int id) throws Exception;
    public void modify(MedicineModel medicine) throws Exception;
    public MedicineModel selectById(int id)throws Exception;
    public List<MedicineModel> selectListByPage(int row, int page)throws Exception;
}

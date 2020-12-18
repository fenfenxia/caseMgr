package com.city.oa.dao;

import com.city.oa.model.CaseModel;
import com.city.oa.model.MedicineModel;

import java.util.List;

public interface ICaseDao {
    public int insert(CaseModel cs) throws Exception;
    public void delete(int id) throws Exception;
    public void modify(CaseModel cs) throws Exception;
    public CaseModel selectById(int id)throws Exception;
    public List<CaseModel> selectListByPage(int row, int page)throws Exception;
	void addToCase(int cid, List<MedicineModel> list) throws Exception;
	void deleteFromCase(int cid) throws Exception;
	List<MedicineModel> selectListByCase(int id) throws Exception;
}

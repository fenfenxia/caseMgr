package com.city.oa.service;

import com.city.oa.model.CaseModel;

import java.util.List;

/**
 * @ClassName: ICaseService
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 9:17
 */
public interface ICaseService {
    public void addCase(CaseModel cm)throws Exception;
    public void deleteCase(int id)throws Exception;
    public void modifyCase(CaseModel caseModel)throws Exception;
    public CaseModel selectById(int id)throws Exception;
    public List<CaseModel> selectByPage(int row,int page)throws Exception;
}

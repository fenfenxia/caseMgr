package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.ICaseDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.CaseModel;
import com.city.oa.model.MedicineModel;
import com.mysql.jdbc.Statement;

/**
 * @ClassName: CaseDaoImpl
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 9:14
 */
public class CaseDaoImpl implements ICaseDao {
    @Override
    public int insert(CaseModel cm) throws Exception {
        String sql = "insert into case_h(suggest,price,p_id,c_date) values(?,?,?,?)";
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, cm.getSuggest());
        ps.setDouble(2, cm.getPrice());
        ps.setInt(3, cm.getPId());
        ps.setDate(4,new Date(cm.getDate().getTime()));
        ps.executeUpdate();
        int autoIncKeyFromApi = -1;  
        ResultSet rs = ps.getGeneratedKeys();                                  // 获取自增主键！  
        if (rs.next()) {  
            autoIncKeyFromApi = rs.getInt(1);  
        }
        ps.close();
        cn.close();
        return autoIncKeyFromApi;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from case_h where id = ?";
        Connection cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public void modify(CaseModel cs) throws Exception {
        String sql = "update case_h set suggest = ?,price = ?,p_id = ?,c_date = ? where id = ?";
        Connection  cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, cs.getSuggest());
        ps.setDouble(2, cs.getPrice());
        ps.setInt(3, cs.getPId());
        ps.setDate(4,new Date(cs.getDate().getTime()));
        ps.setInt(5, cs.getId());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public CaseModel selectById(int id) throws Exception {
        String sql1 = "select c.suggest,c.price,c.p_id,c.c_date from case_h c where c.id = ?";
        String sql2 = "select m_id,medicine_num from csmd where c_id = ?";
        Connection cn = ConnectionFactory.getConnection();
        CaseModel cs = null;
        List<MedicineModel> list = new ArrayList<>();
        PreparedStatement ps = cn.prepareStatement(sql1);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            cs=new CaseModel();
            cs.setId(id);
            cs.setSuggest(rs.getString("suggest"));
            cs.setPrice(rs.getDouble("price"));
            cs.setPId(rs.getInt("p_id"));
            cs.setDate(rs.getDate("c_date"));
        }
        //取病历对应的药方
        ps = cn.prepareStatement(sql2);
        ps.setInt(1,id);
        rs=ps.executeQuery();
        while(rs.next()) {
            MedicineModel mm = DaoFactory.getMedicineDao().selectById(rs.getInt("m_id"));
            mm.setNumber(rs.getInt("medicine_num"));
            list.add(mm);
        }
        cs.setMedicines(list);
        rs.close();
        ps.close();
        cn.close();
        return cs;
    }

    @Override
    public List<CaseModel> selectListByPage(int row, int page) throws Exception {
        String sql = "select id,suggest,price,p_id,c_date from case_h";
        Connection cn = ConnectionFactory.getConnection();
        List<CaseModel> list = new ArrayList<>();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
            CaseModel cm = new CaseModel();
            cm.setId(rs.getInt("id"));
            cm.setSuggest(rs.getString("suggest"));
            cm.setPrice(rs.getDouble("price"));
            cm.setPId(rs.getInt("p_id"));
            cm.setDate(rs.getDate("c_date"));
            list.add(cm);
        }
        rs.close();
        ps.close();
        cn.close();
        return list;
    }
    
    @Override
    public void addToCase(int cid, List<MedicineModel> list) throws Exception {
    	if(list!=null) {
    		Connection cn = ConnectionFactory.getConnection();
	        String sql = "insert into csmd (m_id,c_id,medicine_num) values ";
	        StringBuffer sb = new StringBuffer();
	        for (MedicineModel mm:list) {
	            sb.append("("+mm.getId()+","+cid+","+mm.getNumber()+"),");
	        }
	        sb.deleteCharAt(sb.length()-1);
	        sql+=sb.toString();
	        System.out.println(sql);
	        PreparedStatement ps = cn.prepareStatement(sql);
	        ps.executeUpdate();
	        ps.close();        
	        cn.close();
    	}

    }

    @Override
    public void deleteFromCase(int cid) throws Exception {
    	Connection cn = ConnectionFactory.getConnection();
        String sql = "delete from csmd where c_id = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1,cid);
        ps.executeUpdate();
        ps.close();
        cn.close();

    }

    @Override
    public List<MedicineModel> selectListByCase(int id) throws Exception {
    	Connection  cn = ConnectionFactory.getConnection();
        String sql = "select m.id,m.name,m.price from csmd c inner join medicine m on c.m_id = m.id where c.m_id = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<MedicineModel> list = new ArrayList<>();
        while (rs.next()) {
            MedicineModel mm = new MedicineModel();
            mm.setId(rs.getInt("id"));
            mm.setName(rs.getString("name"));
            mm.setPrice(rs.getDouble("price"));
            list.add(mm);
        }
        rs.close();
        ps.close();
        cn.close();

        return list;
    }
}

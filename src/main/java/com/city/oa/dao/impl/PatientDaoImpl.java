package com.city.oa.dao.impl;

import com.city.oa.dao.IPatientDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.PatientModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PatientDaoImpl
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 9:16
 */
public class PatientDaoImpl implements IPatientDao {

    private Connection cn = null;
    @Override
    public void insert(PatientModel pm) throws Exception {
        String sql = "insert into patient(name,age,sex,weight,height) values(?,?,?,?,?)";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1,pm.getName());
        ps.setInt(2, pm.getAge());
        ps.setString(3, pm.getSex());
        ps.setDouble(4,pm.getWeight());
        ps.setDouble(5,pm.getHeight());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from patient where id = ?";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public void modify(PatientModel pm) throws Exception {
        String sql = "update patient set name = ?,age = ?,sex = ? ,weight = ?,height = ? where id = ?";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1,pm.getName());
        ps.setInt(2, pm.getAge());
        ps.setString(3, pm.getSex());
        ps.setDouble(4,pm.getWeight());
        ps.setDouble(5,pm.getHeight());
        ps.setInt(6,pm.getId());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public PatientModel selectById(int id) throws Exception {
        String sql = "select name,age,sex, weight,height from patient where id = ?";
        cn = ConnectionFactory.getConnection();
        PatientModel pm = null;
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            pm=new PatientModel();
            pm.setId(id);
            pm.setName(rs.getString("name"));
            pm.setAge(rs.getInt("age"));
            pm.setSex(rs.getString("sex"));
            pm.setWeight(rs.getDouble("weight"));
            pm.setHeight(rs.getDouble("height"));
        }
        rs.close();
        ps.close();
        cn.close();

        return pm;
    }

    @Override
    public List<PatientModel> selectListByPage(int row, int page) throws Exception {
        String sql = "select id,name,age,sex, weight,height from patient limit ?,?";
        cn = ConnectionFactory.getConnection();
        List<PatientModel> list = new ArrayList<>();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, row*(page-1));
        ps.setInt(2, row);
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
            PatientModel pm=new PatientModel();
            pm.setId(rs.getInt("id"));
            pm.setName(rs.getString("name"));
            pm.setAge(rs.getInt("age"));
            pm.setSex(rs.getString("sex"));
            pm.setWeight(rs.getDouble("weight"));
            pm.setHeight(rs.getDouble("height"));
            list.add(pm);
        }
        rs.close();
        System.out.println(row+"//"+page);
        ps.close();
        cn.close();
        return list;
    }
}

package com.city.oa.dao.impl;

import com.city.oa.dao.IMedicineDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.MedicineModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MedicineDaoImpl
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/8 9:15
 */
public class MedicineDaoImpl implements IMedicineDao {
    private Connection cn =  null;
    @Override
    public void insert(MedicineModel medicine) throws Exception {
        String sql = "insert into medicine(name,price,photo,type,path) values(?,?,?,?,?)";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, medicine.getName());
        ps.setDouble(2, medicine.getPrice());
        ps.setBytes(3,medicine.getPhoto());
        ps.setString(4,medicine.getType());
        ps.setString(5,medicine.getPath());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from medicine where id = ?";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public void modify(MedicineModel medicine) throws Exception {
        String sql = "update medicine m set m.name = ?,m.price = ?,m.photo = ?,m.type = ?,m.path = ? where m.id = ?";
        cn = ConnectionFactory.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, medicine.getName());
        ps.setDouble(2, medicine.getPrice());
        ps.setBytes(3,medicine.getPhoto());
        ps.setString(4,medicine.getType());
        ps.setString(5,medicine.getPath());
        ps.setInt(6,medicine.getId());
        ps.executeUpdate();
        ps.close();
        cn.close();
    }

    @Override
    public MedicineModel selectById(int id) throws Exception {
        String sql = "select name,price,photo,type,path from medicine where id = ?";
        cn = ConnectionFactory.getConnection();
        MedicineModel mm = null;
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            mm=new MedicineModel();
            mm.setId(id);
            mm.setName(rs.getString("name"));
            mm.setPrice(rs.getDouble("price"));
            mm.setPhoto(rs.getBytes("photo"));
            mm.setType(rs.getString("type"));
            mm.setPath(rs.getString("path"));
        }
        rs.close();
        ps.close();
        cn.close();

        return mm;
    }

    @Override
    public List<MedicineModel> selectListByPage(int row, int page) throws Exception {
        String sql = "select id,name,price from medicine";
        cn = ConnectionFactory.getConnection();
        List<MedicineModel> list = new ArrayList<>();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
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

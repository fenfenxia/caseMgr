package com.city.oa.factory;

import com.city.oa.dao.ICaseDao;
import com.city.oa.dao.IMedicineDao;
import com.city.oa.dao.IPatientDao;
import com.city.oa.dao.impl.CaseDaoImpl;
import com.city.oa.dao.impl.MedicineDaoImpl;
import com.city.oa.dao.impl.PatientDaoImpl;

public class DaoFactory {
	public static ICaseDao getCaseDao() {
		return new CaseDaoImpl();
	}
	public static IMedicineDao getMedicineDao() {
		return new MedicineDaoImpl();
	}
	public static IPatientDao getPatientDao() {
		return new PatientDaoImpl();
	}
}

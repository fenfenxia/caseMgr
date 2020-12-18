package com.city.oa.factory;

import com.city.oa.service.ICaseService;
import com.city.oa.service.IMedicineService;
import com.city.oa.service.IPatientService;
import com.city.oa.service.impl.CaseServiceImpl;
import com.city.oa.service.impl.MedicineServiceImpl;
import com.city.oa.service.impl.PatientServiceImpl;

public class ServiceFactory {
	public static ICaseService getCaseService() {
		return new CaseServiceImpl();
	}
	public static IMedicineService getMedicineService() {
		return new MedicineServiceImpl();
	}
	public static IPatientService getPatientService() {
		return new PatientServiceImpl();
	}
}

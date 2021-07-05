package com.saugata.Project.Electronic_Voucher_System.Dao;

import java.util.List;

import com.saugata.Project.Electronic_Voucher_System.Model.DepartmentManager;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

public interface DepartmentManagerDao {
	boolean insertDept(DepartmentManager departmentManager);
	DepartmentManager getDmByName(String Name);
	List<Voucher> getStatusPending(String pending);
}

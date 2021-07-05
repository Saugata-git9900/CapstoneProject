package com.saugata.Project.Electronic_Voucher_System.Dao;

import com.saugata.Project.Electronic_Voucher_System.Model.Employee;

public interface EmployeeDao {
	boolean insertEmployee(Employee employee);
	
	Employee getEmpByName(String empName);
}

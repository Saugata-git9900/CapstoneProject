package com.saugata.Project.Electronic_Voucher_System.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	
	@OneToOne(mappedBy="departments")
	private DepartmentManager dm;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employee;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public DepartmentManager getDm() {
		return dm;
	}

	public void setDm(DepartmentManager dm) {
		this.dm = dm;
	}
	
	
	
}

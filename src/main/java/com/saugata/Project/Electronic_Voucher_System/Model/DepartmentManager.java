package com.saugata.Project.Electronic_Voucher_System.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DepartmentManager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int dmId;
	private String name; 
	private String password;
	
	@OneToOne()
	@JoinColumn(name="deptId")
	private Department departments;

	public int getDmId() {
		return dmId;
	}

	public void setDmId(int dmId) {
		this.dmId = dmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	

	
}

package com.saugata.Project.Electronic_Voucher_System.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fsoId;
	private String name;
	private String password;
	
	
	public int getFsoId() {
		return fsoId;
	}
	public void setFsoId(int fsoId) {
		this.fsoId = fsoId;
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
	
	
}

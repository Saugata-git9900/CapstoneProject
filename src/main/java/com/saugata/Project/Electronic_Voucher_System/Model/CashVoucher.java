package com.saugata.Project.Electronic_Voucher_System.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="voucherId")
public class CashVoucher extends Voucher{
	

	private String recipent;
	private String date;
	
	
	public String getRecipent() {
		return recipent;
	}
	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
	
}


//@OneToOne
//@JoinColumn(name="voucherId")
//private Voucher voucher;
//
//
//public Voucher getVoucher() {
//	return voucher;
//}
//public void setVoucher(Voucher voucher) {
//	this.voucher = voucher;
//}
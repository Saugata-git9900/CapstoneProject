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
public class PhoneBill extends Voucher{
	
	private String date;
	private String fromPeriod;
	private String toPeriod;
	private String number;
	private String carrier;
	//public String reason;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFromPeriod() {
		return fromPeriod;
	}
	public void setFromPeriod(String fromPeriod) {
		this.fromPeriod = fromPeriod;
	}
	public String getToPeriod() {
		return toPeriod;
	}
	public void setToPeriod(String toPeriod) {
		this.toPeriod = toPeriod;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
//	public String getReason() {
//		return reason;
//	}
//	public void setReason(String reason) {
//		this.reason = reason;
//	}
	
	
}




//@OneToOne
//@JoinColumn(name="voucherId")
//private Voucher voucher;



//public Voucher getVoucher() {
//	return voucher;
//}
//public void setVoucher(Voucher voucher) {
//	this.voucher = voucher;
//}
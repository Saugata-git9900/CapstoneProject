package com.saugata.Project.Electronic_Voucher_System.Dao;

import java.util.List;

import com.saugata.Project.Electronic_Voucher_System.Model.Fso;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

public interface FsoDao {

	boolean insertFso(Fso f);
	Fso getFsoByName(String name);
	List<Voucher> getVoucher();
}

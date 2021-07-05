package com.saugata.Project.Electronic_Voucher_System.Dao;

import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

public interface VoucherDao {
	boolean insertVoucher(Voucher voucher);
	Voucher getVoucherById(int id);
	boolean deleteVoucher(Voucher vch);
}

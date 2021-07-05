package com.saugata.Project.Electronic_Voucher_System.Dao;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saugata.Project.Electronic_Voucher_System.Model.Employee;
import com.saugata.Project.Electronic_Voucher_System.Model.TravelAllowance;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

public interface TravelDao {
	boolean insertTravel(TravelAllowance travelAllowance);
	List<Voucher> getVoucherById(Employee emp);
}

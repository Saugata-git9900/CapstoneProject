package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.CashVoucherDao;
import com.saugata.Project.Electronic_Voucher_System.Model.CashVoucher;

@Repository("cvDao")
@Transactional
public class CashVoucherDaoImpl implements CashVoucherDao{
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertCashVoucher(CashVoucher cashVoucher) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(cashVoucher);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

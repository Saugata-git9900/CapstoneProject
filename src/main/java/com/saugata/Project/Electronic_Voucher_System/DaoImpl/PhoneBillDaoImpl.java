package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.PhoneBillDao;
import com.saugata.Project.Electronic_Voucher_System.Model.PhoneBill;

@Repository("phDao")
@Transactional
public class PhoneBillDaoImpl implements PhoneBillDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertPhonebill(PhoneBill bill) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(bill);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

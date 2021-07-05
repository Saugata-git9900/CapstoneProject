package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.MedicalDao;
import com.saugata.Project.Electronic_Voucher_System.Model.MedicalAllowance;

@Repository("medDao")
@Transactional
public class MedicalDaoImpl implements MedicalDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertMed(MedicalAllowance medical) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(medical);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}

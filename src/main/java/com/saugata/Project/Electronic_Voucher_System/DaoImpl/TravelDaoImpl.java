package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saugata.Project.Electronic_Voucher_System.Dao.TravelDao;
import com.saugata.Project.Electronic_Voucher_System.Model.Employee;
import com.saugata.Project.Electronic_Voucher_System.Model.TravelAllowance;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

@Repository("travelDao")
@Transactional
public class TravelDaoImpl implements TravelDao {
	@Autowired
	SessionFactory sessionFactory;
	
	//Declaring method for saving data in database through session object
	public boolean insertTravel(TravelAllowance travelAllowance) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(travelAllowance);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Voucher> getVoucherById(Employee emp){
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Voucher.class);
		cr.add(Restrictions.eq("employee", emp));
		List<Voucher> vchList = cr.list();
		//Collections.reverse(vchList);
		if(vchList.size()==0) {
			return null;
		}
		else {
			return vchList;
		}
	}

}

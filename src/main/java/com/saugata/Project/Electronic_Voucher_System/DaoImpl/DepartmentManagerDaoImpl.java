package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.DepartmentManagerDao;
import com.saugata.Project.Electronic_Voucher_System.Model.DepartmentManager;
import com.saugata.Project.Electronic_Voucher_System.Model.Employee;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

@Repository("dmDao")
@Transactional
public class DepartmentManagerDaoImpl implements DepartmentManagerDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//Defining method for saving data in database
	public boolean insertDept(DepartmentManager departmentManager) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(departmentManager);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	//Defining method for login validation
	public DepartmentManager getDmByName(String name) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(DepartmentManager.class);
		cr.add(Restrictions.eq("name", name));
		List<DepartmentManager> dm = cr.list();
		if(dm.size()==1) {
			return dm.get(0);
		}
		else {
			return null;
		}
	}
	
	public List<Voucher> getStatusPending(String pending){
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Voucher.class);
		cr.add(Restrictions.eq("status", pending));
		List<Voucher> vlist = cr.list();
		if(vlist.size()==0) {
			return null;
		}
		else {
			return vlist;
		}
	}
}

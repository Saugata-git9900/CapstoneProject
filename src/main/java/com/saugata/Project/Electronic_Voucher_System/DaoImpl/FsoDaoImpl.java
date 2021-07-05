package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.FsoDao;
import com.saugata.Project.Electronic_Voucher_System.Model.DepartmentManager;
import com.saugata.Project.Electronic_Voucher_System.Model.Fso;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

@Repository("fDao")
@Transactional
public class FsoDaoImpl implements FsoDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertFso(Fso f) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(f);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public Fso getFsoByName(String name) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Fso.class);
		cr.add(Restrictions.eq("name", name));
		List<Fso> f = cr.list();
		if(f.size()==1) {
			return f.get(0);
		}
		else {
			return null;
		}
	}
	
	public List<Voucher> getVoucher(){
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Voucher.class);
		List<Voucher> vlist = cr.list();
		if(vlist.size()==0) {
			return null;
		}
		else {
			return vlist;
		}
	}
}

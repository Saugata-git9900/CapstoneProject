package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.VoucherDao;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

@Repository("vDao")
@Transactional
public class VoucherDaoImpl implements VoucherDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertVoucher(Voucher voucher) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(voucher);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	public Voucher getVoucherById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Voucher.class);
		cr.add(Restrictions.eq("voucherId", id));
		List<Voucher> vlist = cr.list();
		if(vlist.size()==1) {
			return vlist.get(0);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteVoucher(Voucher v) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(v);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

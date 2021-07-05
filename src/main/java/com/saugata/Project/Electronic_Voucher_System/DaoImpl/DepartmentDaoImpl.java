package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.DepartmentDao;
import com.saugata.Project.Electronic_Voucher_System.Model.Department;

@Repository("deptDao")
@Transactional
public class DepartmentDaoImpl implements DepartmentDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	//Defining method for saving data in database
	public boolean insertDepartment(Department department) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(department);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
}

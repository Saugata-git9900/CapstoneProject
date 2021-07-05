package com.saugata.Project.Electronic_Voucher_System.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saugata.Project.Electronic_Voucher_System.Dao.EmployeeDao;
import com.saugata.Project.Electronic_Voucher_System.Model.Employee;



@Repository("empDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//Defining method for saving data in database
	public boolean insertEmployee(Employee employee) {
		try {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Defining method for login validation
	public Employee getEmpByName(String empName) {
		Session s = sessionFactory.getCurrentSession();
		Criteria cr = s.createCriteria(Employee.class);
		cr.add(Restrictions.eq("empName", empName));
		List<Employee> emp = cr.list();
		if(emp.size()==1) {
			return emp.get(0);
		}
		else {
			return null;
		}
	}
}

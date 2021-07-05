package com.saugata.Project.Electronic_Voucher_System.Controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saugata.Project.Electronic_Voucher_System.Dao.CashVoucherDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.DepartmentDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.DepartmentManagerDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.EmployeeDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.FsoDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.MedicalDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.PhoneBillDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.TravelDao;
import com.saugata.Project.Electronic_Voucher_System.Dao.VoucherDao;
import com.saugata.Project.Electronic_Voucher_System.Model.CashVoucher;
import com.saugata.Project.Electronic_Voucher_System.Model.Department;
import com.saugata.Project.Electronic_Voucher_System.Model.DepartmentManager;
import com.saugata.Project.Electronic_Voucher_System.Model.Employee;
import com.saugata.Project.Electronic_Voucher_System.Model.Fso;
import com.saugata.Project.Electronic_Voucher_System.Model.MedicalAllowance;
import com.saugata.Project.Electronic_Voucher_System.Model.PhoneBill;
import com.saugata.Project.Electronic_Voucher_System.Model.TravelAllowance;
import com.saugata.Project.Electronic_Voucher_System.Model.Voucher;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeDao empDao;
	@Autowired
	TravelDao travelDao;
	@Autowired
	MedicalDao medDao;
	@Autowired
	DepartmentManagerDao dmDao;
	@Autowired
	DepartmentDao deptDao;
	@Autowired
	VoucherDao vDao;
	@Autowired
	FsoDao fDao;
	@Autowired
	CashVoucherDao cvDao;
	@Autowired
	PhoneBillDao phDao;
	
	//Returning Homepage
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Home() {
		return"HomePage";
	}
	
	//Returning EmployeeLogin Page
	@RequestMapping(value="/empLogin",method=RequestMethod.GET)
	public String ELogin() {
		return"EmployeeLogin";
	}
	
	//Returning EmployeeRegister page
	@RequestMapping(value="/empRgstr",method=RequestMethod.GET)
	public String empRegister() {
		return"EmpRegister";
	}
	
	//Returning DMRegister Page
	@RequestMapping(value="/dmRgstr",method=RequestMethod.GET)
	public String dmRegister() {
		return"DmRegister";
	}
	
	//Returning DepartmentLogin Page
	@RequestMapping(value="/dmLogin",method=RequestMethod.GET)
	public String departmentLogin() {
		return"DmLogin";
	}
	
	//Returning FsoLogin Page
	@RequestMapping(value="/fsoLogin",method=RequestMethod.GET)
	public String fsoLogin() {
		return"FsoLogin";
	}

	
	//Returning TravelAllowance Page
	@RequestMapping(value="/travel", method=RequestMethod.GET)
	public String TravelAllwnc() {
		return "TravelAllowance";
	}
	
	//Returning MedicalAllowance Page
	@RequestMapping(value="/medical", method=RequestMethod.GET)
	public String MedicalAllwnc() {
		return "MedicalAllowance";
	}
	
	//Returning CashVoucher Page
	@RequestMapping(value="/cashvch", method=RequestMethod.GET)
	public String cashVoucher() {
		return "CashVoucher";
	}
	
	//Returning PhoneBill Page
	@RequestMapping(value="/phbill", method=RequestMethod.GET)
	public String phoneBill() {
		return "PhoneBill";
	}
	
	//Defining method for registering Employee details
	@RequestMapping(value="/EmpRegister",method=RequestMethod.POST)
	public String EmpRegister(HttpServletRequest request) {
		Employee emp = new Employee();
		emp.setEmpName(request.getParameter("userName"));
		emp.setPassword(request.getParameter("password"));
		emp.setEmpNum(request.getParameter("contact"));
		empDao.insertEmployee(emp);
		return "redirect:/empLogin";
	}
	
	//Defining method for registering DepartmentManager  details
		@RequestMapping(value="/managerReg",method=RequestMethod.POST)
		public String DmRegister(HttpServletRequest request) {
			DepartmentManager dm = new DepartmentManager();
			Department dep = new Department();
			dep.setDeptName(request.getParameter("dept"));
			deptDao.insertDepartment(dep);
			dm.setName(request.getParameter("userName"));
			dm.setPassword(request.getParameter("password"));
			dm.setDepartments(dep);
			dmDao.insertDept(dm);
			return "redirect:/dmLogin";
		}
		

	
	//Data insertion in Travel Allowance table and retrieving the list of voucher in employee home page
	@RequestMapping(value="/addTravel",method=RequestMethod.POST)
	public String addTravelVoucher(HttpServletRequest request, ModelMap model, RedirectAttributes rd) {
		String vchDate = request.getParameter("date");
		LocalDate currentDate = LocalDate.now();
		String cdate = currentDate.toString();
		if(vchDate.compareTo(cdate)>0) {
			rd.addFlashAttribute("errordate", "**Enter a valid date**");
			return "redirect:/travel";
		}
		HttpSession session = request.getSession();
		TravelAllowance trvl = new TravelAllowance();
		Employee emp =  (Employee) session.getAttribute("name");
		trvl.setEmployee(emp);
		trvl.setDate(vchDate);
		trvl.setMode(request.getParameter("mode"));
		trvl.setPlace(request.getParameter("place"));
		int ammount = Integer.parseInt(request.getParameter("amt"));
		System.out.println("Voucher Ammount: " +ammount);
		trvl.setAmmount(ammount);
		trvl.setReason(request.getParameter("reason"));
		trvl.setStatus("pending");
		trvl.setName("Travel Voucher");
		travelDao.insertTravel(trvl);
		List<Voucher> vch = travelDao.getVoucherById(emp);
		if(vch!=null) {
			Collections.reverse(vch);
			model.addAttribute("voucherList", vch);
//			String s = (String) session.getAttribute("emptyMsg");
//			session.setAttribute("msg", s);
//			session.invalidate();
			return "EmployeeHome";
		}
		else {
			rd.addFlashAttribute("Errormessage", "Error");
			return "redirect:/travel";
		}
	}
	
	//Data insertion in Medical Allowance table and retrieving the list of voucher in employee home page
	@RequestMapping(value="/addMed",method=RequestMethod.POST)
	public String addMedicalVoucher(HttpServletRequest request, ModelMap model, RedirectAttributes rd) {
		String vchDate = request.getParameter("date");
		LocalDate currentDate = LocalDate.now();
		String cDate = currentDate.toString();
		if(vchDate.compareTo(cDate)>0) {
			rd.addFlashAttribute("errordate", "**Enter a valid date**");
			return "redirect:/medical";
		}
		HttpSession session = request.getSession();
		MedicalAllowance med = new MedicalAllowance();
		Employee emp =  (Employee) session.getAttribute("name");
		med.setEmployee(emp);
		med.setNature(request.getParameter("nature"));
		med.setDate(vchDate);
		int ammount = Integer.parseInt(request.getParameter("amt"));
		med.setAmmount(ammount);
		med.setReason(request.getParameter("reason"));
		med.setStatus("pending");
		med.setName("Medical Voucher");
		medDao.insertMed(med);
		List<Voucher> vch = travelDao.getVoucherById(emp);
		if(vch!=null) {
			Collections.reverse(vch);
			model.addAttribute("voucherList", vch);
//			String s = (String) session.getAttribute("emptyMsg");
//			session.setAttribute("msg", s);
//			session.invalidate();
			return "EmployeeHome";
		}
		else {
			rd.addFlashAttribute("Errormessage", "Error");
			return "redirect:/medical";
		}
	}
	
	
	//Data insertion in CashVoucher table and retrieving the list of voucher in employee home page
	@RequestMapping(value="/addCashVch",method=RequestMethod.POST)
	public String addCashVoucher(HttpServletRequest request, ModelMap model, RedirectAttributes rd) {
		String vchDate = request.getParameter("date");
		LocalDate currentDate = LocalDate.now();
		String cDate = currentDate.toString();
		if(vchDate.compareTo(cDate)!=0) {
			rd.addFlashAttribute("errormsg", "Enter a valid date...");
			return "redirect:/cashvch";
		}
		HttpSession session = request.getSession();
		CashVoucher cvch = new CashVoucher();
		Employee emp =  (Employee) session.getAttribute("name");
		cvch.setEmployee(emp);
		cvch.setRecipent(request.getParameter("recipent"));
		cvch.setDate(vchDate);
		cvch.setAmmount(Integer.parseInt(request.getParameter("amt")));
		cvch.setReason(request.getParameter("reason"));
		cvch.setStatus("pending");
		cvch.setName("Cash Voucher");
		cvDao.insertCashVoucher(cvch);
		List<Voucher> vch = travelDao.getVoucherById(emp);
		if(vch!=null) {
			Collections.reverse(vch);
			model.addAttribute("voucherList", vch);
//			String s = (String) session.getAttribute("emptyMsg");
//			session.setAttribute("msg", s);
//			session.invalidate();
			return "EmployeeHome";
		}
		else {
			rd.addFlashAttribute("Errormessage", "Error");
			return "redirect:/cashvch";
		}
	}
	
	//Data insertion in PhoneBill table and retrieving the list of voucher in employee home page
		@RequestMapping(value="/addPhbill",method=RequestMethod.POST)
		public String addPhoneBill(HttpServletRequest request, ModelMap model, RedirectAttributes rd) {
			String startDate = request.getParameter("period");
			String endDate = request.getParameter("toPeriod");
			LocalDate currentDate = LocalDate.now();
			String cDate = currentDate.toString();
			
			if(startDate.compareTo(cDate)>0 && endDate.compareTo(cDate)<0) {
				rd.addFlashAttribute("errordt", "**Enter a valid start date and end date**");
				return "redirect:/phbill";
			}
			else if(startDate.compareTo(cDate)>0) {
				rd.addFlashAttribute("starterror", "**Enter a valid start date**");
				return "redirect:/phbill";
			}
			else if(endDate.compareTo(cDate)<0) {
				rd.addFlashAttribute("enderror", "**Enter a valid end date**");
				return "redirect:/phbill";
			}
			
			HttpSession session = request.getSession();
			PhoneBill pb = new PhoneBill();
			Employee emp =  (Employee) session.getAttribute("name");
			pb.setEmployee(emp);
			pb.setNumber(request.getParameter("number"));
			pb.setFromPeriod(startDate);
			pb.setToPeriod(endDate);
			pb.setCarrier(request.getParameter("carrier"));
			pb.setAmmount(Integer.parseInt(request.getParameter("amt")));
			pb.setStatus("pending");
			pb.setName("PhoneBill Voucher");
			pb.setReason(request.getParameter("reason"));
			phDao.insertPhonebill(pb);
			List<Voucher> vch = travelDao.getVoucherById(emp);
			if(vch!=null) {
				Collections.reverse(vch);
				model.addAttribute("voucherList", vch);

				return "EmployeeHome";
			}
			else {
				rd.addFlashAttribute("Errormessage", "Error");
				return "redirect:/phbill";
			}
		}
	
	//Validating username and password in Employee login form and displaying list of voucher employee home page
	@RequestMapping(value="/employeeLogin",method=RequestMethod.POST)
	public String EmployeeLogin(HttpServletRequest request, RedirectAttributes rd, Model model) {
		String Username = request.getParameter("userName");
		String Password = request.getParameter("password");
		Employee e = empDao.getEmpByName(Username);
		if(e!=null && e.getPassword().compareTo(Password)==0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", e);
			List<Voucher> vch = travelDao.getVoucherById(e);
			if(vch!=null) {
				Collections.reverse(vch);
				model.addAttribute("voucherList", vch);
				return "EmployeeHome";
			}
			else {
				model.addAttribute("voucherList", vch);
				return "EmployeeHome";
			}
			
			
		}
		else {
			rd.addFlashAttribute("message", "Incorrect Username & Password");	
			return "redirect:/empLogin";
		}
	}
	

	
	//Validating username and password in DepartmentManager login form and displaying list of voucher dm home page
	@RequestMapping(value="/dmLogin",method=RequestMethod.POST)
	public String DmLogin(HttpServletRequest request, RedirectAttributes rd, Model model) {
		String Username = request.getParameter("userName");
		String Password = request.getParameter("password");
		DepartmentManager dm = dmDao.getDmByName(Username);
		String pending = "pending";
		if(dm!=null && dm.getPassword().compareTo(Password)==0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", dm);
			List<Voucher> vch = dmDao.getStatusPending(pending);
			Collections.reverse(vch);
			model.addAttribute("pendingvoucher", vch);
			return "DmHome";
		}
		else {
			rd.addFlashAttribute("message", "Incorrect Username & Password");	
			return "redirect:/dmLogin";
		}
	}
	
	
	//Validating username and password in Fso login form and displaying list of voucher Fso home page
	@RequestMapping(value="/fsoLogin",method=RequestMethod.POST)
	public String FsoLogin(HttpServletRequest request, RedirectAttributes rd, Model model) {
		String Username = request.getParameter("userName");
		String Password = request.getParameter("password");
		Fso f = fDao.getFsoByName(Username);
		if(f!=null && f.getPassword().compareTo(Password)==0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", f);
			List<Voucher> vch = fDao.getVoucher();
			Collections.reverse(vch);
			model.addAttribute("voucher", vch);
			return "FsoHome";
		}
		else {
			rd.addFlashAttribute("message", "Incorrect Username & Password");	
			return "redirect:/fsoLogin";
		}
	}
	
	//DmHome Page approve reject process
	@RequestMapping(value="/statusupdate{voucherId}/{status}", method = RequestMethod.GET)
	public String ApproveRejectStatus(@PathVariable("voucherId")int id, @PathVariable("status")String approval, Model model) {
		Voucher vch = new Voucher();
		String pending = "pending";
		vch=vDao.getVoucherById(id);
		vch.setStatus(approval);
		vDao.insertVoucher(vch);
		List<Voucher> vlist = dmDao.getStatusPending(pending);
		Collections.reverse(vlist);
		model.addAttribute("pendingvoucher", vlist);
		return "DmHome";
	}
	
	//Dm HomePage set status process
	@RequestMapping(value="/dmSetStatus{voucherId}", method = RequestMethod.GET)
	public String dmSetStatus(@PathVariable("voucherId")int id,  Model model) {
		String travel = "Travel Voucher";
		String medical = "Medical Voucher";
		String cash = "Cash Voucher";
		String phone  = "PhoneBill Voucher";
		Voucher v = vDao.getVoucherById(id);
		
		if(v.getName().compareTo(travel)==0) {
			model.addAttribute("travelSetStatus", v);
			return "DmTravelStatus";
		}
		
		else if(v.getName().compareTo(medical)==0) {
			model.addAttribute("medicalSetStatus", v);
			return "DmMedicalStatus";
		}
		
		else if(v.getName().compareTo(cash)==0) {
			model.addAttribute("cashSetStatus", v);
			return "DmCashStatus";
		}
		
		else if(v.getName().compareTo(phone)==0) {
			model.addAttribute("phoneSetStatus", v);
			return "DmPhoneStatus";
		}
		
		else {
			return null;
		}
	}
	
	//Fso setStatus process
	@RequestMapping(value="/fsoStatus{voucherId}", method = RequestMethod.GET)
	public String fsoStatus(@PathVariable("voucherId")int id,  Model model) {
		String travel = "Travel Voucher";
		String medical = "Medical Voucher";
		String cash = "Cash Voucher";
		String phone  = "PhoneBill Voucher";
		Voucher v = vDao.getVoucherById(id);
		
		if(v.getName().compareTo(travel)==0) {
			model.addAttribute("travelStatus", v);
			return "travelStatus";
		}
		
		else if(v.getName().compareTo(medical)==0) {
			model.addAttribute("medicalStatus", v);
			return "medicalStatus";
		}
		
		else if(v.getName().compareTo(cash)==0) {
			model.addAttribute("cashStatus", v);
			return "CashVoucherStatus";
		}
		
		else if(v.getName().compareTo(phone)==0) {
			model.addAttribute("phoneStatus", v);
			return "PhoneBillStatus";
		}
		
		else {
			return null;
		}
	}
	
	
	// Method Updating final status in fso page 
	@RequestMapping(value="/finalStatus{voucherId}/{status}", method = RequestMethod.GET)
	public String finalStatus(@PathVariable("voucherId")int id, @PathVariable("status")String approval, Model model, HttpServletRequest request) {
		Voucher vch = new Voucher();
		vch=vDao.getVoucherById(id);
		vch.setStatus(approval);
		vch.setRemarks(request.getParameter("remarks"));
		vDao.insertVoucher(vch);
		List<Voucher> vlist = fDao.getVoucher();
		Collections.reverse(vlist);
		model.addAttribute("voucher", vlist);
		return "FsoHome";
	}
	
	
	//Employee home page track status process
	@RequestMapping(value="/trackStatus{voucherId}", method = RequestMethod.GET)
	public String trackStatus(@PathVariable("voucherId")int id,  Model model) {
		String travel = "Travel Voucher";
		String medical = "Medical Voucher";
		String cash = "Cash Voucher";
		String phone  = "PhoneBill Voucher";
		Voucher v = vDao.getVoucherById(id);
		
		if(v.getName().compareTo(travel)==0) {
			model.addAttribute("travelStatus", v);
			return "travelTrackStatus";
		}
		
		else if(v.getName().compareTo(medical)==0) {
			model.addAttribute("medicalStatus", v);
			return "medicalTrackStatus";
		}
		
		else if(v.getName().compareTo(cash)==0) {
			model.addAttribute("cashStatus", v);
			return "cashTrackStatus";
		}
		
		else if(v.getName().compareTo(phone)==0) {
			model.addAttribute("phoneStatus", v);
			return "phoneTrackStatus";
		}
		
		else {
			return null;
		}
	}
	
	//Employee home page delete process
	@RequestMapping(value="/delete/{voucherId}", method = RequestMethod.GET)
	public String delete(@PathVariable("voucherId")int id,  Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Voucher v = new Voucher();
		v=vDao.getVoucherById(id);
		vDao.deleteVoucher(v);
		Employee emp =  (Employee) session.getAttribute("name");
		List<Voucher> vl = travelDao.getVoucherById(emp);
		Collections.reverse(vl);
		model.addAttribute("voucherList", vl);
		return "EmployeeHome";
	}
	
	//logout Process
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
}



//Registering fso
//@RequestMapping(value="/fso",method=RequestMethod.POST)
//public String insertFso (HttpServletRequest request) {
//	Fso f = new Fso();
//	f.setName(request.getParameter("userName"));
//	f.setPassword(request.getParameter("password"));
//	fDao.insertFso(f);
//	return "redirect:/fsoLogin";
//}




//Data insertion in Emmployee Table
//@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
//public String addEmployee(HttpServletRequest request) {
//	Employee emp = new Employee();
//	emp.setEmpName(request.getParameter("userName"));
//	emp.setPassword(request.getParameter("password"));
//	empDao.insertEmployee(emp);
//	return "redirect:/empLogin";
//}



//Data insertion in Department Manager Table
//@RequestMapping(value="/addDm",method=RequestMethod.POST)
//public String insertDm(HttpServletRequest request) {
//	System.out.println("Hello");
//	DepartmentManager dm = new DepartmentManager();
//	dm.setName(request.getParameter("userName"));
//	dm.setPassword(request.getParameter("password"));
//	dmDao.insertDept(dm);
//	System.out.println("Hello world");
//	return "redirect:/dmLogin";
//}



//String s = (String) session.getAttribute("emptyMsg");
////session.setAttribute("msg", s);
////session.invalidate();
//return "EmployeeHome";
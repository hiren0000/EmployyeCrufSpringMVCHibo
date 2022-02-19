package employeeCrud.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import employeeCrud.dao.EmployeeDao;
import employeeCrud.mail.Email;
import employeeCrud.model.Employee;

@Controller
public class MainController 
{ 
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private Email email;
	
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Employee> emp = employeeDao.getAll();
		m.addAttribute("emp", emp);
		
		System.out.println("working properly");
		return "index";
	}
	
	
	//add-emp
	@RequestMapping("/addEmp")
	public String addEmp()
	{
		
		return "addEmployee";
	}
	
	//form handler
	@RequestMapping(value = "/form-handler", method = RequestMethod.POST)
	public RedirectView form(@ModelAttribute Employee emp, HttpServletRequest request)
	{
		System.out.println(emp);
		
		//Sending Otp for the Verification
		Random ra = new Random();
		long otp = ra.nextLong(999999);
		
	    email.sendEmail(emp.getEmail(), otp);
		employeeDao.saveEmp(emp);
		RedirectView rd = new RedirectView();
		rd.setUrl(request.getContextPath()+"/");
		return rd;
	}
	
	//login
	@RequestMapping("/login")
	public String loginEmp()
	{
		
		return "login";
	}
	
	//form handler
	@RequestMapping(value = "/logform-handler", method = RequestMethod.POST)
	public RedirectView logInform(@RequestParam("email") String lmail, HttpServletRequest request,Model m)
	{
		RedirectView rd = new RedirectView();
	   Employee exEmp = employeeDao.login(lmail);
	  
	   
  try {
	   
		  if(exEmp == null)
		  {
			  m.addAttribute("msg" ,"Invalid Credentials");
			  rd.setUrl("login");		 
		  }
		  
		  else
		  {  		 
			  rd.setUrl(request.getContextPath()+"/");
			  m.addAttribute("msg", "Welcome"+exEmp.geteName());
			  return rd;  
		  }
	  
	   }catch (Exception e) {
		System.out.println("sm prb wid logInform function"+e);
	   }
	  
	   return rd;
	  
	}
	
	//deleting employee
	@RequestMapping("/delete/{eId}")
	public RedirectView delete(@PathVariable("eId") int eId, HttpServletRequest request)
	{
		employeeDao.delete(eId);
		System.out.println(eId);
		RedirectView rd = new RedirectView();
		rd.setUrl(request.getContextPath()+"/");
		return rd;
	}
	
	//updating Data
	@RequestMapping(value = "/update/{eId}")
	public String update(@PathVariable("eId") int eId, Model m)	
	{
		Employee emp = employeeDao.getEmpById(eId);
		m.addAttribute("emp",emp);
		
		return "update";
	}
	
	

}

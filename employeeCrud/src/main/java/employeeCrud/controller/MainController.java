package employeeCrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	    email.sendEmail(emp.getEmail());
		employeeDao.saveEmp(emp);
		RedirectView rd = new RedirectView();
		rd.setUrl(request.getContextPath()+"/");
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

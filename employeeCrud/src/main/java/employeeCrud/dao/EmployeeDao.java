package employeeCrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import employeeCrud.model.Employee;

@Component
public class EmployeeDao 
{
	@Autowired
	private HibernateTemplate hbt;
	
	
	
	public void setHbt(HibernateTemplate hbt) {
		this.hbt = hbt;
	}


    //Saving Employee
	@Transactional
	public void saveEmp(Employee emp)
	{
		hbt.saveOrUpdate(emp);
	}
	
	//Getting a list of employees
	public List<Employee> getAll()
	{
		List<Employee> emList = hbt.loadAll(Employee.class);
		
		return emList;
	}
	
	//Deleting Employee
	@Transactional
	public void delete(int eId)
	{
		Employee emp = hbt.get(Employee.class, eId);
		hbt.delete(emp);
	}
	
	//getting single Emp
	public Employee getEmpById(int eId)
	{
		Employee emp = hbt.get(Employee.class, eId);
		
		return emp;
		
	}
	
	

}

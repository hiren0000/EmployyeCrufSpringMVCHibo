package employeeCrud.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	@Autowired
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}


	public void setHbt(HibernateTemplate hbt) {
		this.hbt = hbt;
	}


    //Saving Employee
	@Transactional
	public void saveEmp(Employee emp)
	{
		hbt.saveOrUpdate(emp);
	}
	
	//LogIn Employee
	public Employee login(String email)
	{
		Employee emp1 = null;
		
	 try {	
	   Session session = factory.openSession();
	   
	   org.hibernate.query.Query<Employee> query = session.createQuery("from Employee where email =:email", Employee.class);
	   query.setParameter("email", email);
	   
	   emp1 = query.getSingleResult();
	   session.close();
	 } catch(Exception e)
	 {
		  System.out.println("sm prb with login function in dao"+ e);
	 }
	   
	   return emp1;
		
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

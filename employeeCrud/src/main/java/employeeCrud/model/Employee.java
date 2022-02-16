package employeeCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eId;
	private String eName;
	private String eSurname;
	private String eDesi;
	
	public Employee()
	{
		
	}

	public Employee(int eId, String eName, String eSurname, String eDesi) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSurname = eSurname;
		this.eDesi = eDesi;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteSurname() {
		return eSurname;
	}

	public void seteSurname(String eSurname) {
		this.eSurname = eSurname;
	}

	public String geteDesi() {
		return eDesi;
	}

	public void seteDesi(String eDesi) {
		this.eDesi = eDesi;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSurname=" + eSurname + ", eDesi=" + eDesi + "]";
	}
	
	
	
}

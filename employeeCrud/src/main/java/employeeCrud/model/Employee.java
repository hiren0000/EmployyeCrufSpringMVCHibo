package employeeCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_crud")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eId;
	private String eName;
	private String eSurname;
	private String eDesi;
	private String email;
	private long OTP;
	
	public Employee()
	{
		
	}

	public Employee(int eId, String eName, String eSurname, String eDesi, String email) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSurname = eSurname;
		this.eDesi = eDesi;
		this.email = email;
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getOTP() {
		return OTP;
	}

	public void setOTP(long OTP) {
		OTP = OTP;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSurname=" + eSurname + ", eDesi=" + eDesi + "]";
	}
	
	
	
}

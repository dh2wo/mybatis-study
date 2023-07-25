package net.kdigital.vo;

public class UsrInfo {
	
	private int empID;
	private String fName;
	private double salary;
	private int depID;
	private String depName;
	private String city;
	
	public UsrInfo() {
		
	}
	
	public UsrInfo(int empID, String fName, double salary, int depID, String depName, String city) {
		this.empID = empID;
		this.fName = fName;
		this.salary = salary;
		this.depID = depID;
		this.depName = depName;
		this.city = city;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public double getSal() {
		return salary;
	}

	public void setSal(int sal) {
		this.salary = sal;
	}

	public int getDepID() {
		return depID;
	}

	public void setDepID(int depID) {
		this.depID = depID;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "사원번호 : " + empID + ", 이름 : " + fName + ", 연봉 : " + salary + ", 부서번호 : " + depID + ", 부서명 : "
				+ depName + ", 도시 : " + city;
	}
}

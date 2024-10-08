package com.yedam;

public class Employee {
	private String member;
	private String name;
	private String phone;
	private String hire;
	private int salary;
	
	Employee(){}
	
	Employee (String member,String name,String phone,String hire,int salary){
		this.member = member;
		this.name = name;
		this.phone = phone;
		this.hire = hire;
		this.salary = salary;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHire() {
		return hire;
	}

	public void setHire(String hire) {
		this.hire = hire;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [사번 = " + member + ", 이름 = " + name + ", 전화번호 = " + phone + ", 입사일자 = " + hire + ", 급여 = "
				+ salary + "]";
	}



	
	
}

package com.springboot;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_tb1")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employee_id;
	private String employee_name;
	private int employee_age;
	private String employee_email;
	private long employee_phoneNo;
	private float employee_salary;
	public Employee(int employee_id, String employee_name, int employee_age, String employee_email,
			long employee_phoneNo, float employee_salary) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.employee_email = employee_email;
		this.employee_phoneNo = employee_phoneNo;
		this.employee_salary = employee_salary;
	}
	public Employee() {
		super();
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public long getEmployee_phoneNo() {
		return employee_phoneNo;
	}
	public void setEmployee_phoneNo(long employee_phoneNo) {
		this.employee_phoneNo = employee_phoneNo;
	}
	public float getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(float employee_salary) {
		this.employee_salary = employee_salary;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_age="
				+ employee_age + ", employee_email=" + employee_email + ", employee_phoneNo=" + employee_phoneNo
				+ ", employee_salary=" + employee_salary + "]";
	}
	
	
}

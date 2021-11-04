package com.virtualpairprogrammers.employeemanagement.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.ServiceUnavailableException;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;


@ManagedBean(name="newEmployee")
public class NewEmployeePageBackingBean {

	private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
	
	@EJB
	private EmployeeManagementServiceLocal service; 
	
	public String createEmployee() {
		
		Employee newEmployee = new Employee(firstName, surname, jobRole, salary); 
		
		try {
			service.registerEmployee(newEmployee);
			return "allEmployees";
		} catch (ServiceUnavailableException e) {
			return "employeeNotCreated";
		}
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}

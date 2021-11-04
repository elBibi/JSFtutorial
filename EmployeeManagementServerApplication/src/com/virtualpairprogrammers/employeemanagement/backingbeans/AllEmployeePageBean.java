package com.virtualpairprogrammers.employeemanagement.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;


@ManagedBean(name="allEmployeePageBean")
public class AllEmployeePageBean {

	private UIData dataTable;
	private Employee selectedEmployee;
	
	@EJB
	private EmployeeManagementServiceLocal service;
	
	public List<Employee> getAllEmployees(){
			return service.getAllEmployees();
	}
	
	//------------------------------
	public String showEmployee() {
		// find employee
		this.selectedEmployee = (Employee)dataTable.getRowData();
		//forward to the Detail page
		return "employeeDetail";
		
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	
}

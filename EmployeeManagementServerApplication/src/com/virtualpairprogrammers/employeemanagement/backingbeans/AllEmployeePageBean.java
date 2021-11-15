package com.virtualpairprogrammers.employeemanagement.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;


@ManagedBean(name="allEmployeePageBean")
public class AllEmployeePageBean {

	
	@EJB
	private EmployeeManagementServiceLocal service;
	private org.primefaces.component.api.UIData dataTable;
	//private UIData dataTable;
	private Employee selectedEmployee;
	
	
	
	
	
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

package com.virtualpairprogrammers.employeemanagement.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.employeemanagement.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@ManagedBean(name="findEmployeePageBean")
public class findEmployeePageBean {
	
	@EJB
	private EmployeeManagementServiceLocal service;

	public Employee getSelectedEmployee() {
		// get the id the old fashion way.
		String employeeId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("employeeId");
		//String to Integrer
		int id= Integer.parseInt(employeeId);
		
		try {
			return service.getById(id);
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}

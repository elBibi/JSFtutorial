package com.virtualpairprogrammers.employeemanagement.backingbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")
public class UserBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package com.virtualpairprogrammers.employeemanagement.backingbeans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")
public class UserBean {

	private String name;
	private String niceDate;
	
	public String getniceDate() {
		return niceDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Return welcome page.
	public String greetUser() {
		//1. Business process/ Get Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		 niceDate = sdf.format(new Date());
		
		//Forward to next page
		return "welcome";
	}
}

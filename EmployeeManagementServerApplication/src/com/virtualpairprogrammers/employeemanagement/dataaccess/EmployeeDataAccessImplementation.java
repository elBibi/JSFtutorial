package com.virtualpairprogrammers.employeemanagement.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
@Default
public class EmployeeDataAccessImplementation implements EmployeeDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(Employee newEmployee) {
		em.persist(newEmployee);
	}

	@Override
	public List<Employee> findAll() {
		
		Query q = em.createQuery("select employee from Employee employee");
		List<Employee> employees = q.getResultList();
		return employees;
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException{
		Query q = em.createQuery("select employee from Employee employee where employee.id = :id");
		q.setParameter("id", id);
		try {
			return (Employee)q.getSingleResult();
		}
		catch (NoResultException e) {
			throw new EmployeeNotFoundException();
		}
	}

	@Override
	public List<Employee> getAllEmployeesWhereIdBetween(int firstId,
			int secondId) {
		Query q = em.createQuery("select employee from Employee employee where employee.id >= :first and employee.id <= :last");
		q.setParameter("first",firstId);
		q.setParameter("last",secondId);
		List<Employee> employees = q.getResultList();
		return employees;
	}
	
	@Override
	public void updateEmployee(int id, String jobRole, int salary) throws EmployeeNotFoundException {
		Employee e = findById(id);
		e.setJobRole(jobRole);
		e.setSalary(salary);
	}
	
	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Employee e = findById(id);
		em.remove(e);
	}

}

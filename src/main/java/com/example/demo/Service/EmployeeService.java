package com.example.demo.Service;

import java.util.List;

import com.example.demo.Domain.Employee;

public interface EmployeeService {
	public Employee SaveEmplyee(Employee emp);
	public List<Employee> getAll();
	public Employee getEmployeeById(long id);
	public Employee updateEmployee(Employee emp,long id);
	public void delete(long id);

}

package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Employee;
import com.example.demo.Exception.RessourceNotFoundException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
    private EmployeeRepository empRep;
	@Override
	public Employee SaveEmplyee(Employee emp) {
		return empRep.save(emp);
	}
	@Override
	public List<Employee> getAll() {
		return empRep.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = empRep.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new RessourceNotFoundException("Employee", "Id", id);
		}
		
	}
	@Override
	public Employee updateEmployee(Employee emp,long id) {
		Employee employee = empRep.findById(id).orElseThrow(()-> new RessourceNotFoundException("Employee", "Id", id));
			

		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		empRep.save(employee);
 		return employee;
	}
	@Override
	public void delete(long id) {
		empRep.deleteById(id);
	}

}

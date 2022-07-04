package com.example.demo.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Employee;
import com.example.demo.Service.EmployeeService;
@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	 private EmployeeService empServ;
	 

	@PostMapping()
	 public ResponseEntity<Employee> Save(@RequestBody Employee emp) {

            return new ResponseEntity<Employee>(empServ.SaveEmplyee(emp),HttpStatus.CREATED);
		 
	 }
	//getAll Employees
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return empServ.getAll();
	}
	//getById
	@GetMapping("/getId/{id}")
	public Employee getByIdEmp(@PathVariable("id") long idEmp) {
		return empServ.getEmployeeById(idEmp);
	}
	//update
	@PutMapping("/update/{id}")
	public  ResponseEntity<Employee> modifer( @RequestBody Employee emp, @PathVariable("id") long Eid) {
		return new ResponseEntity<Employee>(empServ.updateEmployee(emp, Eid),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmp( @PathVariable("id") long Eid) {
		empServ.delete(Eid);
	}

}

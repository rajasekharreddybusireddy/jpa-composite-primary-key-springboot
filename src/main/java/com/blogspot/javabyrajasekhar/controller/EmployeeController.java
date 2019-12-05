package com.blogspot.javabyrajasekhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	

	@GetMapping("/company/{id}")
	public List<Employee> getAllEmployeesBycompanyId(@PathVariable("id") String id){
		return employeeRepository.findByEmployeeIdentityCompanyId(id);
		
	}
	
	@PostMapping("/save")	
	public Employee save(@RequestBody Employee employee){
		return employeeRepository.save(employee);
		
	}
	
}

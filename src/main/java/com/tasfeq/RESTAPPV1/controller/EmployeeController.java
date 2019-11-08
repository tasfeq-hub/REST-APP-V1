package com.tasfeq.RESTAPPV1.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tasfeq.RESTAPPV1.dao.EmployeeDAO;
import com.tasfeq.RESTAPPV1.domain.Employee;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		employee.setCreatedAt(new Date());
		employeeDAO.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(name="id") Long id) {
		Optional<Employee> employee = employeeDAO.findById(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name="id") Long id, @Valid @RequestBody Employee employee){
		Optional<Employee> oldEmployee = employeeDAO.findById(id);
		
		if(oldEmployee == null) {
			return ResponseEntity.notFound().build();
		}
		
		employee.setId(id);
		employee.setCreatedAt(new Date());
		Employee updatedEmployee = employeeDAO.save(employee);
		
		return ResponseEntity.ok().body(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(value="id") Long id){
		Optional<Employee> employee = employeeDAO.findById(id);
		
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
}

package com.tasfeq.RESTAPPV1.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tasfeq.RESTAPPV1.domain.Employee;
import com.tasfeq.RESTAPPV1.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(Long id){
		return employeeRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
}

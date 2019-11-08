package com.tasfeq.RESTAPPV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasfeq.RESTAPPV1.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

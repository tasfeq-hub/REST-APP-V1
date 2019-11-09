package com.tasfeq.RESTAPPV1.test.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tasfeq.RESTAPPV1.dao.EmployeeDAO;
import com.tasfeq.RESTAPPV1.domain.Employee;

@SpringBootTest
class EmployeeDAOTest {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	void testSave() {
		Employee abir = new Employee("abir","123213",new Date());
		Employee result = employeeDAO.save(abir);
		
		assertNotNull(result);
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}

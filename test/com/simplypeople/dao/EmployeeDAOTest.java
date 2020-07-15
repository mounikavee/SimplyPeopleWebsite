package com.simplypeople.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.simplypeople.dao.EmployeeDAO;
import com.simplypeople.entity.Employee;

public class EmployeeDAOTest {
	private static EmployeeDAO employeeDAO;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		employeeDAO = new EmployeeDAO();		
	}
	
	@Test
	public void testCreateEmployee() {
		Employee employee1 = new Employee();
		employee1.setEmail("nikhil@simplypeople.com");
		employee1.setFullname("nikhil s");
		employee1.setPassword("Java");
		
		employee1 = employeeDAO.create(employee1);
		
		assertTrue(employee1.getEmployeeId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateEmployeeFieldsNotSet() {
		Employee employee1 = new Employee();		
		employee1 = employeeDAO.create(employee1);		
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmail("ajith@simplypeople.com");
		employee.setFullname("Ajith Vimal");
		employee.setPassword("secret");
		
		employee = employeeDAO.update(employee);
		String expected = "secret";
		String actual = employee.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetEmployeeFound() {
		Integer employeeId = 1;
		Employee employee = employeeDAO.get(employeeId);
		
		if (employee != null) {
			System.out.println(employee.getEmail());
		}
		
		assertNotNull(employee);
	}

	@Test
	public void testGetEmployeeNotFound() {
		Integer employeeId = 99;
		Employee employee = employeeDAO.get(employeeId);
		
		assertNull(employee);
	}
	
	@Test
	public void testDeleteEmployee() {
		Integer employeeId = 4;
		employeeDAO.delete(employeeId);
		
		Employee employee = employeeDAO.get(employeeId);
		
		assertNull(employee);
	}
	
	public void testDeleteNonExistEmployee() {
		Integer employeeId = 55;
		employeeDAO.delete(employeeId);
	}
	
	@Test
	public void testListAll() {
		List<Employee> listEmployee = employeeDAO.listAll();
		
		for (Employee employee : listEmployee) {
			System.out.println(employee.getEmail());
		}
		
		assertTrue(listEmployee.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalEmployee = employeeDAO.count();
		
		assertTrue(totalEmployee > 0);
		
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "ajith@simplypeople.com";
		String password = "secret";
		boolean loginResult = employeeDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}

	@Test
	public void testCheckLoginFailed() {
		String email = "nik123";
		String password = "mysecret1";
		boolean loginResult = employeeDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "ajith@simplypeople.com";
		Employee employee = employeeDAO.findByEmail(email);
		
		assertNotNull(employee);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeDAO.close();
	}
}

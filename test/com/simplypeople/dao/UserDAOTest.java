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

import com.simplypeople.dao.UserDAO;
import com.simplypeople.entity.Users;

public class UserDAOTest {
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		userDAO = new UserDAO();		
	}
	
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("admin2@gmail.com");
		user1.setFullname("admin2 admin2");
		user1.setPassword("password");
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUsersId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();		
		user1 = userDAO.create(user1);		
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUsersId(1);
		user.setEmail("nikhilsridar@gmail.com");
		user.setFullname("Nikhil Sridhar");
		user.setPassword("secret");
		
		user = userDAO.update(user);
		String expected = "secret";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		
		if (user != null) {
			System.out.println(user.getEmail());
		}
		
		assertNotNull(user);
	}

	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 15;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	public void testDeleteNonExistUsers() {
		Integer userId = 55;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for (Users user : listUsers) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		
		assertTrue(totalUsers > 0);
		
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "nikhilsridar@gmail.com";
		String password = "secret";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}

	@Test
	public void testCheckLoginFailed() {
		String email = "nik123";
		String password = "mysecret1";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "nikhil@java.com";
		Users user = userDAO.findByEmail(email);
		
		assertNull(user);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO.close();
	}
}

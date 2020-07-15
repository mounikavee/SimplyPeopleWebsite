package com.simplypeople.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import com.simplypeople.entity.Projectmanager;

public class ProjectmanagerDAOTest {
	private static ProjectmanagerDAO projectmanagerDao; 
	
	

	@BeforeClass
	public static void setUpClass() throws Exception {
		projectmanagerDao = new ProjectmanagerDAO();		
	}
	

	@Test
	public void testCreateProjectmanager() {
		Projectmanager projectmanager = new Projectmanager();
		projectmanager.setPid(222);
		projectmanager.setEmail("dummy@simplypeople.com");
		projectmanager.setPassword("dummy");
		projectmanager.setFullname("dummy");
		Projectmanager newmanager = projectmanagerDao.create(projectmanager);
		
		assertTrue(newmanager.getPmid() > 0);
	}
	
	@Test (expected = PersistenceException.class)
	public void testCreateProjectmanagerFieldsNotSet() {
		Projectmanager projectmanager = new Projectmanager();
		projectmanager = projectmanagerDao.create(projectmanager);
		}
	
	@Test
	public void testUpdateProjectmanager() {
		Projectmanager projectmanager = new Projectmanager();
		projectmanager.setPmid(1);
		projectmanager.setPid(66);
		projectmanager.setEmail("arun@simplypeople.com");
		projectmanager.setFullname("arun s");
		projectmanager.setPassword("biztalk");
		
		projectmanager = projectmanagerDao.update(projectmanager);
		

		
		String expected = "biztalk";
		String actual = projectmanager.getPassword();
		
		
		assertEquals(expected,actual);

	}

	@Test
	public void testGet() {
		
		Integer pmid = 1;
		Projectmanager projectmanager = projectmanagerDao.get(pmid);
		
		if (projectmanager != null) {
			System.out.println(projectmanager.getEmail());
		}
		
		assertNotNull(projectmanager);
		
	}
	
	@Test
	public void testGetProjectmanagerNotFound() {
		Integer pmid = 77;
		Projectmanager projectmanager = projectmanagerDao.get(pmid);

		assertNull(projectmanager);
	}

	@Test
	public void testDeleteObject() {
		Integer pmid = 3;
		projectmanagerDao.delete(pmid);

		Projectmanager projectmanager = projectmanagerDao.get(pmid);

		assertNull(projectmanager);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNotExistProjectmanager() {
		Integer pmid = 66;
		projectmanagerDao.delete(pmid);
     }
	
	@Test
	public void testListAll() {
		List<Projectmanager> listProjectmanager = projectmanagerDao.listAll();
		for (Projectmanager projectmanager : listProjectmanager) {
			System.out.println(projectmanager.getEmail());
		}
		assertTrue(listProjectmanager.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalProjectmanager = projectmanagerDao.count();

		assertEquals(2, totalProjectmanager );
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "arun@simplypeople.com";
		String password = "biztalk";
		Projectmanager loginResult = projectmanagerDao.checkLogin(email, password);
		
		assertNotNull(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed() {
		String email = "nik123";
		String password = "mysecret1";
		Projectmanager loginResult = projectmanagerDao.checkLogin(email, password);
		
		assertNull(loginResult);
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		projectmanagerDao.close();
	}

}

package com.simplypeople.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.simplypeople.entity.Employee;

import com.simplypeople.entity.Grievances;
import com.simplypeople.entity.Users;

public class GrievancesDAOTest  {

	private static GrievancesDAO grievancesDao;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		 
		grievancesDao = new GrievancesDAO();
	}

	

	@Test
	public void testCreateGrievances() {
		Grievances grievance = new Grievances();
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		
		Users user = new Users();
		user.setUsersId(4);
		
		grievance.setEmployee(employee);
		grievance.setUsers(user);
		
		
	
		
		grievance.setComment("My laptop is old enough ");
		
		Grievances savedGrievances = grievancesDao.create(grievance);
		
		assertTrue(savedGrievances.getGrievancesId() > 0);
	}

	@Test
	public void testGet() {
		Integer grievanceId = 10;
		Grievances grievance = grievancesDao.get(grievanceId);
		
		assertNotNull(grievance);
	}

	@Test
	public void testUpdateGrievances() {
		Integer grievanceId = 10;
		Grievances grievance = grievancesDao.get(grievanceId);
		grievance.setComment("My appraisal is not enough and unacceptable");
		
		Grievances updatedGrievances = grievancesDao.update(grievance);
		
		assertEquals(grievance.getComment(), updatedGrievances.getComment());
		
	}
	
	@Test
	public void testListAll() {
		List<Grievances> listGrievances = grievancesDao.listAll();
		
		for (Grievances grievance : listGrievances) {
			System.out.println(grievance.getGrievancesId() + " - " + 
					 " - " 
					+ " - " + grievance.getComment() );
		}
		
		assertTrue(listGrievances.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalGrievancess = grievancesDao.count();
		System.out.println("Total Grievancess: " + totalGrievancess);
		assertTrue(totalGrievancess > 0 );
	}
	
	@Test
	public void testDeleteGrievances() {
		int grievanceId = 10;
		grievancesDao.delete(grievanceId);
		
		Grievances grievance = grievancesDao.get(grievanceId);
		
		assertNull(grievance);
		
	}

	

	

	@Test
	public void testFindByUsersAndEmployeeNotFound() {
		Integer userid = 111;
		Integer empid = 2;
		
		Grievances result = grievancesDao.findByAdminAndEmployee(userid, empid);
		
		assertNull(result);
	}
	
	@Test
	public void testFindByUsersAndEmployeeFound() {
		Integer usersId = 1;
		Integer empid = 1;
		
		Grievances result = grievancesDao.findByAdminAndEmployee(usersId, empid);
		
		assertNotNull(result);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		grievancesDao.close();
	}
	
	
}

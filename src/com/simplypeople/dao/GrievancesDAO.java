package com.simplypeople.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.simplypeople.entity.Grievances;

public class GrievancesDAO extends JpaDAO<Grievances> implements GenericDAO<Grievances> {

	public GrievancesDAO() {
		super();
		
	}

	@Override
	public Grievances create(Grievances grievance) {
		
		return super.create(grievance);
	}
	
	@Override
	public Grievances get(Object grievanceId) {
		return super.find(Grievances.class, grievanceId);
	}

	@Override
	public void delete(Object grievanceId) {
		super.delete(Grievances.class, grievanceId);
	}

	@Override
	public List<Grievances> listAll() {
		return super.findWithNamedQuery("Grievances.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Grievances.countAll");
	}
	
	public Grievances findByAdminAndEmployee(Integer usersId, Integer empid) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("usersId", usersId);
		parameters.put("employeeId", empid);
		
		List<Grievances> result = super.findWithNamedQuery("Grievances.findByAdminAndEmployee", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	


}

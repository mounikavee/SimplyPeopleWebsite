package com.simplypeople.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplypeople.entity.Projectmanager;

public class ProjectmanagerDAO extends JpaDAO<Projectmanager> implements GenericDAO<Projectmanager> {

	public ProjectmanagerDAO() {
	}

	public Projectmanager create(Projectmanager projectmanager) {
		return super.create(projectmanager);
	}
	
	@Override
	public Projectmanager update(Projectmanager projectmanager) {
		return super.update(projectmanager);
	}

	@Override
	public Projectmanager get(Object pmid) {
		return super.find(Projectmanager.class, pmid);
	}
	
	public Projectmanager findByEmail(String email) {
		List<Projectmanager> listManager = super.findWithNamedQuery("Projectmanager.findByEmail", "email", email);
		
		if (listManager != null && listManager.size() > 0) {
			return listManager.get(0);
		}
		
		return null;
	}
	
	public Projectmanager checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Projectmanager> listManager = super.findWithNamedQuery("Projectmanager.checkLogin", parameters);
		
		if (!listManager.isEmpty()) {
			return listManager.get(0);
		}
		
		return null;
	}

	@Override
	public void delete(Object pmid) {
		super.delete(Projectmanager.class, pmid);
	}

	@Override
	public List<Projectmanager> listAll() {
		return super.findWithNamedQuery("Projectmanager.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Projectmanager.countAll");
	}

}

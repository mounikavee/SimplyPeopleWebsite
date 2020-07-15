package com.simplypeople.controller.frontend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.simplypeople.entity.Employee;

public class ResourcePool {
	private Map<Employee, Integer> pool = new HashMap<>();
	
	public void addItem(Employee employee) {
		if (pool.containsKey(employee)) {
			Integer quantity = pool.get(employee) + 1;
			pool.put(employee, quantity);			
		} else {
			pool.put(employee, 1);
		}
	}
	
	public void removeItem(Employee employee) {
		pool.remove(employee);
	}
	
	public int getTotalQuantity() {
		int total = 0;
		
		Iterator<Employee> iterator = pool.keySet().iterator();
		
		while (iterator.hasNext()) {
			Employee next = iterator.next();
			Integer quantity = pool.get(next);
			total += quantity;
		}
		
		return total;
	}
	
	
	
	
	
	
	public void clear() {
		pool.clear();
	}
	
	public int getTotalItems() {
		return pool.size();
	}
	
	public Map<Employee, Integer> getItems() {
		return this.pool;
	}
	
}

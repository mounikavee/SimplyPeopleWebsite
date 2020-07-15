package com.simplypeople.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.simplypeople.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	public ReviewDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Review create(Review review) {
		
		return super.create(review);
	}
	
	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}
	
	public Review findByProjectmanagerAndEmployee(Integer pmid, Integer empid) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("pmid", pmid);
		parameters.put("employeeId", empid);
		
		List<Review> result = super.findWithNamedQuery("Review.findByProjectmanagerAndEmployee", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	


}

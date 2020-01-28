package com.app.dao;

import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;

public interface IUserDao {

	
	User addUserDetails(User u);
	
	User validateUser(User u);
	void updateUser(User oldU, User u);
	 User getUserById(int id);
	 
	 
	 
	 
    Visit scheduleVisit(Visit visit);

    
    
	Donation makeDonation(Donation d);

	User addUser(User u);
}

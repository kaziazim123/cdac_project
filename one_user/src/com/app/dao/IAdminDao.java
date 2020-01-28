package com.app.dao;

import java.util.List;

import com.app.pojos.AdoptionRecord;
import com.app.pojos.Children;
import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;

public interface IAdminDao {

	 List<User> getAllUser();
	 User getUserById(int id);
	 void deleteById(User u);
	// void updateUser(User oldU, User u);
	 
	 Children addchildDetails(Children c);
	 List<Children> getAllChildren();
	 Children getChildById(int id);
	 void deleteChild(Children c);
	 void updateChild(Children oldC , Children c);
	 
	 
	 
	 List<Donation> donationRecord();
	 Donation getDonationRecord(int id);
	 void deleteDonationRecord(Donation d);
//	void deleteDonationRecord(int id);
	 
	 
	 List<Visit> adoptionVisitList();
	 
	 
	 
	 List<AdoptionRecord> adoptionRecord();
	 AdoptionRecord addAdoptionDetails(AdoptionRecord adoptionDetails);
}

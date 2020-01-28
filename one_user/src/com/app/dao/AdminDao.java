package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AdoptionRecord;
import com.app.pojos.AdoptionStatus;
import com.app.pojos.Children;
import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;



@Repository
@Transactional
public class AdminDao implements IAdminDao{

	@Autowired
	private SessionFactory sf;
	
	////////////////////////////////user related/////////////////////////
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String jpql="select u from User u";
		return sf.getCurrentSession().createQuery(jpql,User.class).getResultList();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(User.class, id);
	}

	@Override
	public void deleteById(User u) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(u);	
	}

//	@Override
//	public void updateUser(User oldU, User u) 
//	{
//        oldU.setuName(u.getuName());  
//        oldU.setuEmail(u.getuEmail());
//        oldU.setuPassword(u.getuPassword());
//        oldU.setuAadharNo(u.getuAadharNo());
//        oldU.setuPhoneNo(u.getuPhoneNo());
//          sf.getCurrentSession().update(oldU);
//          
//	}

	
	//////////////////////////////children related////////////////////
	
	
	@Override
	public List<Children> getAllChildren() {
		// TODO Auto-generated method stub
		String jpql = "select c from Children c";
		return sf.getCurrentSession().createQuery(jpql,Children.class).getResultList();
	}

	@Override
	public Children getChildById(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Children.class, id);
		
	}

	@Override
	public void deleteChild(Children c) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(c);	
	}

	@Override
	public void updateChild(Children oldC, Children c) {
		// TODO Auto-generated method stub
		oldC.setcId(c.getcId());
		oldC.setcName(c.getcName());
		oldC.setcAge(c.getcAge());
		oldC.setcGender(c.getcGender());
//		oldC.setAdoptionStatus(c.getAdoptionStatus());
		  sf.getCurrentSession().update(oldC);
	}

	@Override
	public Children addchildDetails(Children c) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(c);
		return c;
	}

	@Override
	public List<Donation> donationRecord() {
		// TODO Auto-generated method stub
		String jpql = "select d from Donation d";
		return sf.getCurrentSession().createQuery(jpql, Donation.class).getResultList();
	}
	
	@Override
	public void deleteDonationRecord(Donation d) {
        sf.getCurrentSession().delete(d);
        
	}

	@Override
	public Donation getDonationRecord(int id) {
		return sf.getCurrentSession().get(Donation.class,id);
	}


	@Override
	public List<Visit> adoptionVisitList() {
		String jpql = "select v from Visit v";
		return sf.getCurrentSession().createQuery(jpql,Visit.class).getResultList();
	}

	@Override
	public AdoptionRecord addAdoptionDetails(AdoptionRecord adoptionDetails) {
		// TODO Auto-generated method stub
		Children c = adoptionDetails.getChild();
		c.setcStatus(AdoptionStatus.ADOPTED);
		sf.getCurrentSession().persist(adoptionDetails);
		sf.getCurrentSession().update(c);
		return adoptionDetails;
	}
	@Override
	public List<AdoptionRecord> adoptionRecord() {
		String jpql = "select a from AdoptionRecord a";
		return sf.getCurrentSession().createQuery(jpql, AdoptionRecord.class).getResultList();
	}
}

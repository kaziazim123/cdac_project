package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;

@Repository
@Transactional
public class UserDao implements IUserDao{

	
	@Autowired
	private SessionFactory sf;
	
	
	
	@Override
	public User addUserDetails(User u) {
		// TODO Auto-generated method stub
		 sf.getCurrentSession().persist(u);
			return u;
	}

	@Override
	public User validateUser(User u)
	{
		System.out.println("inside validate dao "+u);
		String jpql="select u from User u where u.uEmail=:email and u.uPassword=:pass";
		
		try {
			return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("email", u.getuEmail()).setParameter("pass", u.getuPassword()).getSingleResult();
		}
			catch (Exception e)
		{
			 
				return null;

		}
	
	}
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(User.class, id);
	}


	@Override
	public void updateUser(User oldU, User u) {
		// TODO Auto-generated method stub
        oldU.setuName(u.getuName());  
        oldU.setuEmail(u.getuEmail());
        oldU.setuPassword(u.getuPassword());
        oldU.setuAadharNo(u.getuAadharNo());
        oldU.setuPhoneNo(u.getuPhoneNo());
          sf.getCurrentSession().update(oldU);

	}

	@Override
	public Visit scheduleVisit(Visit visit) {
		// TODO Auto-generated method stub
		 sf.getCurrentSession().persist(visit);
     	 return visit;
	}

	@Override
	public Donation makeDonation(Donation donation) {
		    sf.getCurrentSession().persist(donation);
		    return donation;
		
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		 sf.getCurrentSession().update(u);
			return u;
	}

	
}

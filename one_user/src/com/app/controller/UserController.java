package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User u)
	{
		System.out.println("in register user ");
		
		try {
			return new ResponseEntity<User>(dao.addUserDetails(u),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/validation")
	public ResponseEntity<?> validateUser(@RequestBody User u)
	{
//		System.out.println("=====================================================> "+id);

		System.out.println("=====================================================> "+u);
		
		User user=dao.validateUser(u);
		if(user !=null)
		{
		System.out.println(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id)
	{
		System.out.println("in user dtls " +id);
		User u=dao.getUserById(id);
		System.out.println(u);
		if(u == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(u,HttpStatus.OK);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody User u) {
		u.setuId(id);
		System.out.println("in add user dtls " + u);
		
		User oldU=dao.getUserById(u.getuId());
		       dao.updateUser(oldU,u);
		
		return null;

	}
	
	
	 @PostMapping("/visit/{id}")
		public ResponseEntity<?> adoptionVisit(@RequestBody Visit v,@PathVariable int id) {
			System.out.println("in adoptionVisit>>"+v);

			User u = dao.getUserById(id);
			u.addvisit(v);
			try {
				return new ResponseEntity<User>(dao.addUser(u), HttpStatus.CREATED);
			} catch (RuntimeException e1) {
				e1.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	 
		@PostMapping("/donate")
		public ResponseEntity<?> makeDonation(@RequestBody Donation d) {
			System.out.println("inside make donation ");
			try {
				return new ResponseEntity<Donation>(dao.makeDonation(d), HttpStatus.CREATED);
			} catch (RuntimeException e1) {
				e1.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
//	@PostMapping
//	public validateUser(@RequestBody User u)
//	{
//		return 
//	}
	 
}

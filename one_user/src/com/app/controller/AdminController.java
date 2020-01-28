package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAdminDao;
import com.app.pojos.AdoptionRecord;
import com.app.pojos.Children;
import com.app.pojos.Donation;
import com.app.pojos.User;
import com.app.pojos.Visit;


@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminDao dao;
	
	
	
	
	///////////////////////////user////////////////////////
	
	// REST request handling method to get list of user
			@GetMapping
			public ResponseEntity<?> listUsers() {
				System.out.println("in list user");
				List<User> allUser = dao.getAllUser();
				if (allUser.size() == 0)
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
			}
			
			
			// REST request handling method to get user by id
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
			
			//Rest delete by id
			@DeleteMapping("/{id}")
			public void deleteUserById(@PathVariable int id)
			{
				System.out.println("in user delete by id " +id);
				User u = dao.getUserById(id);
				dao.deleteById(u);
				
			}

			// REST request handling method to create new resoures : User
//			@PutMapping("/{id}")
//			public ResponseEntity<?> updateUserDetails(@PathVariable int id,@RequestBody User u) {
//				u.setuId(id);
//				System.out.println("in add user dtls " + u);
//				
//				User oldU=dao.getUserById(u.getuId());
//				       dao.updateUser(oldU,u);
//				
//				return null;
//
//			}
//			
			/////////////////////////////////////children////////////////////////////
			
			
			@PostMapping("/register_child")
			public ResponseEntity<?> registerUser(@RequestBody Children c)
			{
				System.out.println("in register user ");
				
				try {
					return new ResponseEntity<Children>(dao.addchildDetails(c),HttpStatus.OK);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			@GetMapping("/children")
			public ResponseEntity<?> listchildren()
			{
				System.out.println("in list children");
				List<Children> allchildren= dao.getAllChildren();
				return new ResponseEntity<List<Children>>(allchildren , HttpStatus.OK);
			}
			
			// REST request handling method to get children by id
			@GetMapping("/children/{id}")
			public ResponseEntity<?> getChildrenById(@PathVariable int id)
			{
				System.out.println("in children dtls " +id);
				//User u=dao.getUserById(id);
				Children c = dao.getChildById(id);
				System.out.println(c);
				if(c == null)
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				return new ResponseEntity<Children>(c,HttpStatus.OK);
				
			}
			
			//Rest delete by id
			@DeleteMapping("children/{id}")
			public void deleteChildById(@PathVariable int id)
			{
				System.out.println("in children delete by id " +id);
				Children c  = dao.getChildById(id);
				dao.deleteChild(c);
				
			}
			
			
			  @GetMapping("/donations")
				public ResponseEntity<?> donationRecord() {
					System.out.println("in donationRecord");
					List<Donation> donations = dao.donationRecord();
					if (donations.size() == 0)
						return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
					return new ResponseEntity<List<Donation>>(donations, HttpStatus.OK);
				}
			  @DeleteMapping("/donations/delete/{id}")
			   public void deleteDonationRecord(@PathVariable int id)
			   {
				  
//				  System.out.println("in children delete by id " +id);
//					Children c  = dao.getChildById(id);
//					dao.deleteChild(c);
				   System.out.println("in delete donation record ");
				   Donation d = dao.getDonationRecord(id);
				   dao.deleteDonationRecord(d);
			   }
			  @GetMapping("/visit") 
			  public ResponseEntity<?> adoptionVisitList() {
				  System.out.println("in adoptionVisitList");
					List<Visit> adoptionVisitList = dao.adoptionVisitList();
					if (adoptionVisitList.size() == 0)
						return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
					return new ResponseEntity<List<Visit>>(adoptionVisitList, HttpStatus.OK);
			    
			  }
			  
			  
			  
			  
			  @GetMapping("/adoption_record")
		     	public ResponseEntity<?> adoptionRecord() {
				System.out.println("in adoptionRecord");
				List<AdoptionRecord> adoptionRecord = dao.adoptionRecord();
				if (adoptionRecord.size() == 0)
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				return new ResponseEntity<List<AdoptionRecord>>(adoptionRecord, HttpStatus.OK);
			}
		  
		        @PostMapping("/adoption_record/add")
			    public ResponseEntity<?> addAdoptionRecord(@RequestBody AdoptionRecord r) {
				System.out.println("inside addAdoptionRecord "+r);
				try {
					return new ResponseEntity<AdoptionRecord>(dao.addAdoptionDetails(r), HttpStatus.CREATED);
				} catch (RuntimeException e1) {
					e1.printStackTrace();
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}
			  
			   
}


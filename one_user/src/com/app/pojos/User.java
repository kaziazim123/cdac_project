package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity		
@Table(name = "users")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class User {
	
	private int uId;
	private String uName;
	private String uEmail;
	private String uPassword;
	private String uAadharNo;
	private String uPhoneNo;
	private Role uRole;

//	
	private List<Visit> visits = new ArrayList<>();
	
	
	
	public User() {}

	
    
	public User(String uName, String uEmail, String uPassword, String uAadharNo, String uPhoneNo, Role uRole) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAadharNo = uAadharNo;
		this.uPhoneNo = uPhoneNo;
		this.uRole = uRole;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20)
    public Role getuRole() {
		return uRole;
	}

	public void setuRole(Role uRole) {
		this.uRole = uRole;
	}
	
	@OneToMany(mappedBy = "vUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	@Column(length = 25)
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}
    
//	@NotEmpty(message = "Email required")
	@Column(length = 55, unique = true)
//	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$" )
//	@Email(message = "Invalid required")
	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
	@Column(length = 20)
	//@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="invalid password")
	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
    
	@Column(length = 20)
//	@Pattern(regexp = "[0-9]{12}")
	public String getuAadharNo() {
		return uAadharNo;
	}
    
	public void setuAadharNo(String uAadharNo) {
		this.uAadharNo = uAadharNo;
	}
    
	@Column(length = 10)
//	@Pattern(regexp="([0-9]*{10})",message="invalid mobile no")
	public String getuPhoneNo() {
		return uPhoneNo;
	}

	public void setuPhoneNo(String uPhoneNo) {
		this.uPhoneNo = uPhoneNo;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uAadharNo=" + uAadharNo
				+ ", uPhoneNo=" + uPhoneNo + "]";
	}
	
	
	
	
	
	/////////////////helper method
	
	public void addvisit(Visit v)
	{
		visits.add(v);
		v.setvUser(this);
	}
	
	public void removevisit(Visit v)
	{
		visits.remove(v);
		v.setvUser(null);
	}
	
}
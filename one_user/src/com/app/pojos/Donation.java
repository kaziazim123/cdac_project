package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name",length = 30)
	private String name;
	@Column(length = 55)
	private String email;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "transaction_id",length = 10,unique = true)
	private String transactionId;
	private double amount;
	
	public Donation() {}

	public Donation(int id, String name, String email, String contactNo, String transactionId, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	
	public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
    
//	@NotEmpty(message = "Email required")
//	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$" )
//	@Email(message = "Invalid required")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
	@Pattern(regexp="([0-9]*{10})",message="invalid mobile no")
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
    
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
    
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", transactionId=" + transactionId + ", amount=" + amount + "]";
	}
	
	
}

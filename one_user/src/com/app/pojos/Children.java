package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "children")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Children 
{
    private int cId;
    private String cName;
    private int cAge;
    private Gender cGender;
    private AdoptionStatus cStatus;
    
   // private AdoptionStatus cAdoptionStatus;
    
	public Children() {};

	public Children(int cId, String cName, int cAge, Gender cGender 
	 ,AdoptionStatus cStatus)
	{
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAge = cAge;
		this.cGender = cGender;
		this.cStatus = cStatus;
	}
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}
    
	@Column(length = 25)
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcAge() {
		return cAge;
	}

	public void setcAge(int cAge) {
		this.cAge = cAge;
	}

	
	
	@Enumerated(EnumType.STRING)
    public Gender getcGender() {
		return cGender;
	}

	public void setcGender(Gender cGender) {
		this.cGender = cGender;
	}
	@Enumerated(EnumType.STRING)
	public AdoptionStatus getcStatus() {
		return cStatus;
	}

	public void setcStatus(AdoptionStatus cStatus) {
		this.cStatus = cStatus;
	}

	@Override
	public String toString() {
		return "Children [cId=" + cId + ", cName=" + cName + ", cAge=" + cAge + ", cGender=" + cGender + ", cStatus="
				+ cStatus + "]";
	}

//	@Override
//	public String toString() {
//		return "Children [cId=" + cId + ", cName=" + cName + ", cAge=" + cAge + ", cGender=" + cGender + "]";
//	}
//    
	
	
	
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "cgender", length = 10)
//	public Gender getcGender() {
//		return cGender;
//	}
//
//	public void setcGender(Gender gender) {
//		this.cGender = gender;
//	}
    
//	@Enumerated(EnumType.STRING)
//	@Column(name = "cadoption_status", length = 20)
//	public AdoptionStatus getAdoptionStatus() {
//		return cadoptionStatus;
//		
//	}
//
//	public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
//		this.cadoptionStatus = adoptionStatus;
//	}

//	@Override
//	public String toString() {
//		return "Children [cId=" + cId + ", cName=" + cName + ", cAge=" + cAge + ", gender=" + cGender
//				+ ", adoptionStatus=" + cadoptionStatus + "]";
//	}
	
	
	
}

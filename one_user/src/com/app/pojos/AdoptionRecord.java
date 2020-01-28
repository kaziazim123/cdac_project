package com.app.pojos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "adoption_record")
public class AdoptionRecord 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User parent;
	@OneToOne
	private Children child;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "adoption_date")
	@Temporal(TemporalType.DATE)
	private Date adoptionDate;
	
	public AdoptionRecord() {}

	public AdoptionRecord(int id, User parent, Children child, Date adoptionDate) {
		this.id = id;
		this.parent = parent;
		this.child = child;
		this.adoptionDate = adoptionDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name = "parent_id",length = 30,unique = true)
	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}
    
	@Column(name = "child_id",length = 30,unique = true)
	public Children getChild() {
		return child;
	}

	public void setChild(Children child) {
		this.child = child;
	}
    
	
	public Date getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(Date adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	@Override
	public String toString() {
		return "AdoptionRecord [id=" + id + ", parent=" + parent + ", child=" + child + ", adoptionDate=" + adoptionDate
				+ "]";
	}

}

package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adoption_visit")
public class Visit {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
//		@OneToOne
//		private User uId;
//		@JsonFormat(pattern="yyyy-MM-dd")
//		@Temporal(TemporalType.DATE)
		private String visitDate;
		
		private String description;

		@ManyToOne
		@JoinColumn(name = "user_id")
		@JsonIgnore
		private User vUser;
		
		public Visit() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getVisitDate() {
			return visitDate;
		}

		public void setVisitDate(String visitDate) {
			this.visitDate = visitDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public User getvUser() {
			return vUser;
		}

		public void setvUser(User vUser) {
			this.vUser = vUser;
		}

		public Visit(String visitDate, String description) {
			super();
			this.visitDate = visitDate;
			this.description = description;
		}

		@Override
		public String toString() {
			return "Visit [id=" + id + ", visitDate=" + visitDate + ", description=" + description + ", vUser=" + vUser
					+ "]";
		}




}

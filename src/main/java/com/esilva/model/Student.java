package com.esilva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String address;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String email;
	private String telephoneNumber;
	
	
	public Student() {
		super();
	}

	public Student(String name, String address, Date birthDate, Gender gender, String email, String telephoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public enum Gender{
		MALE("Male"),FEMALE("Female");
		
		private String description;
		private Gender(String description){
			this.description=description;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate
				+ ", gender=" + gender + ", email=" + email + ", telephoneNumber=" + telephoneNumber + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}

package com.esilva.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Course course;
	@Enumerated(EnumType.STRING)
	private Term term;
	private Integer yearOfEnrollment;
	private String finalGrade;
	
	public Enrollment() {
		super();
	}
	

	public Enrollment(Term termOfEnrollment, Integer yearOfEnrollment, String finalGrade) {
		super();
		this.term = termOfEnrollment;
		this.yearOfEnrollment = yearOfEnrollment;
		this.finalGrade = finalGrade;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Term getTerm() {
		return term;
	}


	public void setTerm(Term term) {
		this.term = term;
	}


	public Integer getYearOfEnrollment() {
		return yearOfEnrollment;
	}


	public void setYearOfEnrollment(Integer yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}


	public String getFinalGrade() {
		return finalGrade;
	}


	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}


	public enum Term{
		SPRING("Spring"), FALL("Fall"), SUMMER("Summer"), WINTER("Winter");
		private String description;
		private Term(String description){
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
		return "Enrollment [id=" + id + ", student=" + student + ", course=" + course + ", term=" + term
				+ ", yearOfEnrollment=" + yearOfEnrollment + ", finalGrade=" + finalGrade + "]";
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

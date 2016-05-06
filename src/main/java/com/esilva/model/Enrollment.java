package com.esilva.model;

import javax.persistence.Entity;
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
	private Term termOfEnrollment;
	private Integer yearOfEnrollment;
	private String finalGrade;
	
	public Enrollment() {
		super();
	}
	

	public Enrollment(Term termOfEnrollment, Integer yearOfEnrollment, String finalGrade) {
		super();
		this.termOfEnrollment = termOfEnrollment;
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


	public Term getTermOfEnrollment() {
		return termOfEnrollment;
	}


	public void setTermOfEnrollment(Term termOfEnrollment) {
		this.termOfEnrollment = termOfEnrollment;
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
		SPRING, FALL, SUMMER, WINTER
	}
}

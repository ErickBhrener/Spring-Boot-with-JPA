package com.esilva.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esilva.model.Course;
import com.esilva.model.Enrollment;
import com.esilva.model.Student;
import com.esilva.repository.CourseRepository;
import com.esilva.repository.EnrollmentRepository;
import com.esilva.repository.StudentRepository;

@Controller
public class CourseController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@RequestMapping("/")
	public String index(){
		return "redirect:/home";
	}
	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("enrollments",enrollmentRepository.findAll());
		return "home";
	}
	@RequestMapping(value="/newStudent", method=RequestMethod.GET)
	public String newStudentForm(Student student){
		return "create-student";
	}
	@RequestMapping(value="/newCourse",method=RequestMethod.GET)
	public String newCourseForm(Course course){
		return "create-course";
	}
	@RequestMapping(value="/newEnrollment",method=RequestMethod.GET)
	public String newEnrollmentForm(Enrollment enrollment, Model model){
		model.addAttribute("students", studentRepository.findAll());
		model.addAttribute("courses", courseRepository.findAll());
		return "create-enrollment";
	}
	@RequestMapping(value="/newStudent", method=RequestMethod.POST)
	public String newStudent(@Valid Student student, BindingResult bindResult){
		if(bindResult.hasErrors()){
			return "create-student";
		}
		studentRepository.save(student);
		return "home";
	}
	@RequestMapping(value="/newCourse", method=RequestMethod.POST)
	public String newCourse(@Valid Course course, BindingResult bindResult){
		if(bindResult.hasErrors()){
			return "create-course";
		}
		courseRepository.save(course);
		return "home";
	}
	@RequestMapping(value="/newEnrollment", method=RequestMethod.POST)
	public String newEnrollment(@Valid Enrollment enrollment, BindingResult bindResult){
		if(bindResult.hasErrors()){
			return "redirect:/create-enrollment";
		}
		System.out.println(enrollment.toString());
		enrollmentRepository.save(enrollment);
		return "home";
	}
}

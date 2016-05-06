package com.esilva.repository;

import org.springframework.data.repository.CrudRepository;

import com.esilva.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}

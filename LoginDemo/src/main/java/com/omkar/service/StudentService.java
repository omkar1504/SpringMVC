package com.omkar.service;

import java.util.List;

import com.omkar.entity.Student;

public interface StudentService {

	void addStudent(Student student);

	public Student validate(String name, String password);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
}

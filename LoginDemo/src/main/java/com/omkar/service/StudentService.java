package com.omkar.service;

import java.util.List;

import com.omkar.entity.Student;

public interface StudentService {

	void addStudent(Student student);

	public Student validate(String name, String password);

	public List<Student> getAllStudents();

	public Student getStudentById(int id);

	public Student updateStudent(Student student);
	
	public void deleteStudent(Integer id);
	
	public void update1(int id, Student student);
}

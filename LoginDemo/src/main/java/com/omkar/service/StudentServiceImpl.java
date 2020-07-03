package com.omkar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omkar.dao.StudentDao;
import com.omkar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Transactional
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Transactional
	public Student validate(String name, String password) {
		return studentDao.validate(name, password);
	}

	@Transactional
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Transactional
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	@Transactional
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

}

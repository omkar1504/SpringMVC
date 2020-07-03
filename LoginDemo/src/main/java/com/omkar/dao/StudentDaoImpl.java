package com.omkar.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omkar.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	public Student validate(String name, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student where name=:name and password=:password");
		query.setParameter("name", name);
		query.setParameter("password", password);

		return (Student) query.getSingleResult();
	}

	public List<Student> getAllStudents() {

		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public Student getStudentById(int id) {

		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	public Student updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return student;
	}
	
	public void update1(int id, Student student) {
	      Session session = sessionFactory.getCurrentSession();
	      Student student1 = session.byId(Student.class).load(id);
	      student1.setName(student.getName());
	      student1.setPassword(student.getPassword());
	      session.flush();
	   }

	public void deleteStudent(Integer id) {
		Student student = sessionFactory.getCurrentSession().load(Student.class, id);
		if(null != student) {
			this.sessionFactory.getCurrentSession().delete(student);
		}
		
	}
}

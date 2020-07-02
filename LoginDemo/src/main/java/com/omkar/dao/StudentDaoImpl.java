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
		/*
		 * Session session = sessionFactory.getCurrentSession(); List<Student> list =
		 * session.createQuery("from Student").list(); for(Student student : list){
		 * System.out.println("Student List::"+list); } return list;
		 */

		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

}

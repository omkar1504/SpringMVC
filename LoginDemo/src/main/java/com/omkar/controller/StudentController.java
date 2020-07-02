package com.omkar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.omkar.entity.Student;
import com.omkar.service.StudentService;

@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@RequestMapping("/registerForm")
	public String showRegisterForm() {
		return "register";
	}

	@RequestMapping("/loginForm")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/registerStudent")
	public ModelAndView regStudent(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Student student = new Student(name, password);
		studentService.addStudent(student);

		ModelAndView mv = new ModelAndView();
		mv.addObject("regStud", student);
		mv.setViewName("login");

		return mv;
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/registerStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student regStudent1(@RequestBody Student student, Model model) {
		studentService.addStudent(student);
		System.out.println("saving student: " + student);
		// logger.info("Student: {}", student);
		return student;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		ModelAndView mv = null;

		Student student = new Student(name, password);

		if (name.equals(student.getName()) && password.equals(student.getPassword())) {
			try {
				studentService.validate(name, password);
				mv = new ModelAndView();
				mv.addObject("logStud", student);
				mv.setViewName("welcome");
				return mv;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		mv = new ModelAndView();
		mv.addObject("error", "Username & Password is incorrect");
		mv.setViewName("login");
		return mv;
	}

	@ResponseStatus(value = HttpStatus.FOUND)
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student loginStudent1(@RequestBody Student student, Model model) {
		String name = student.getName();
		String password = student.getPassword();
		studentService.validate(name, password);
		System.out.println("found student: " + student);
		// logger.info("Student: {}", student);
		return student;
	}

	@RequestMapping(value = "/get")
	public ModelAndView listAllStudent() {
		List<Student> list = studentService.getAllStudents();

		ModelAndView mv = new ModelAndView();
		mv.addObject("studentList", list);
		mv.setViewName("listStudents");

		return mv;
	}

	@GetMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> listAllStudent1() {
		List<Student> list = studentService.getAllStudents();
		return list;
	}
}

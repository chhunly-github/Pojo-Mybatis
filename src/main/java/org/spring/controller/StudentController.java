package org.spring.controller;

import java.util.ArrayList;
import org.spring.entity.Student;
import org.spring.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentservice;
	
	@RequestMapping(value="/student")
	@ResponseBody
	public ArrayList<Student> findAll(){
		return studentservice.findAll();
	}
	
	@RequestMapping(value={"/index","/","/home"})
	public String studentURL(){
		return "index";
	}
}

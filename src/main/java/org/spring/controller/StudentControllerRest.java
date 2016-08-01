package org.spring.controller;

import java.util.ArrayList;

import org.spring.entity.Student;
import org.spring.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentControllerRest {
	@Autowired
	private StudentServiceImpl studentService;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ArrayList<Student> findAll(){
		
		return studentService.findAll();
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.DELETE)
	public boolean remove(@PathVariable("id") int id){
		return studentService.remove(id);
	}
	
	@RequestMapping(value="/student", method=RequestMethod.PUT)
	public boolean update(@RequestBody Student student){
		return studentService.update(student);
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public boolean Save(@RequestBody Student student){
		return studentService.save(student);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public Student findOne(@PathVariable("id") int id){
		return studentService.findOne(id);
	}
}

/*package org.spring.controller;

import java.util.ArrayList;
import org.spring.entity.Student;
import org.spring.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@ResponseBody
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id){
		System.out.println("deleting..." + id);
		return studentservice.remove(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatestudent", method = RequestMethod.PUT)
	public boolean update(@RequestBody Student student){
		return studentservice.update(student);
	}
	
	@RequestMapping(value="/addstudent",method=RequestMethod.POST)
	@ResponseBody
	public boolean add(@RequestBody Student student){
		return studentservice.save(student);
	}
}
*/
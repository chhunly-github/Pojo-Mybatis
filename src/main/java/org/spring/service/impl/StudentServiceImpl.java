package org.spring.service.impl;

import java.util.ArrayList;

import org.spring.entity.Student;
import org.spring.repository.StudentRepository;
import org.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentrepository;
	@Override
	public boolean save(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public boolean remove(int id) {
		return studentrepository.remove(id);
	}

	@Override
	public boolean update(Student student) {
		return studentrepository.update(student);
	}

	@Override
	public ArrayList<Student> findAll() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Student findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

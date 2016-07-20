package org.spring.service;

import java.util.ArrayList;

import org.spring.entity.Student;

public interface StudentService {
	/***
	 * 
	 * @param student
	 * @return
	 */
	boolean save(Student student);
	/***
	 * 
	 * @param id
	 * @return
	 */
	boolean remove(int id);
	/***
	 * 
	 * @param student
	 * @return
	 */
	boolean update(Student student);
	/***
	 * 
	 * @return
	 */
	ArrayList<Student> findAll();
	/***
	 * 
	 * @param id
	 * @return
	 */
	Student findOne(int id);
}

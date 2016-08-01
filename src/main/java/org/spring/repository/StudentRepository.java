package org.spring.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.spring.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

	@Insert("INSERT INTO tbstudent(name, gender, score) VALUES(#{name}, #{gender}, #{score})")
	boolean save(Student student);

	@Delete("DELETE FROM tbstudent WHERE id=#{id}")
	boolean remove(int id);

	@Update("UPDATE tbstudent SET name=#{name}, gender=#{gender}, score=#{score} WHERE id=#{id}")
	boolean update(Student student);

	@Select("SELECT id, name, gender, score FROM tbstudent ORDER BY id DESC")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="gender", column="gender"),
		@Result(property="score", column="score")
	})
	ArrayList<Student> findAll();

	@Select("SELECT id, name, gender, score FROM tbstudent WHERE id=#{id}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name",column="name"),
		@Result(property="gender", column="gender"),
		@Result(property="score", column="score")
	})
	Student findOne(int id);
}

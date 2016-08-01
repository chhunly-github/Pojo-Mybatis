package org.spring.entity;

public class Student {
	private int id;
	private String name;
	private String gender;
	private float score;

	public Student() {
	}
	public Student(int id, String name, String gender, float score) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	@Override
	public String toString(){
		return this.id+"/"+this.name+"/"+this.gender+"/"+this.score;
	}
	
}

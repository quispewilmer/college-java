package model;

import java.util.Date;

import util.enums.Gender;

public class Teacher {
	private String id;
	private String courseId;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private double money;
	private String phone;
	private Gender gender;
	private Date birthday;
	
	public Teacher() {
		
	}

	public Teacher(String id, String courseId, String firstName, String lastName, String email, int age, double money, String phone,
			Gender gender, Date birthday) {
		this.id = id;
		this.courseId = courseId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.money = money;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Teacher(String courseId, String firstName, String lastName, String email, int age, double money, String phone, Gender gender,
			Date birthday) {
		this.courseId = courseId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.money = money;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}

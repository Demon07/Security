package com.example.demo.entity;

public class User {

	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	public User(String loginName, String password, int age, int sex) {
		super();
		LoginName = loginName;
		Password = password;
		Age = age;
		this.sex = sex;
	}
	
	public User() {
		super();
	}
	
	String LoginName;
	String Password;
	int Age;
	int sex;
	
}

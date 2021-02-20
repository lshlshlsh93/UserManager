package com.mydemo.project.domain;

/**
 * 
 * @Description Customer为实体对象，用来封装对象信息
 * @author LSH QQ:1945773750
 * @version
 * @date 2021-1-14 10:34:32
 *
 */
public class Customer {
	private String name; // 姓名
	private char gender; // 性别
	private int age; // 年龄
	private String phone; // 电话号码
	private String e_mail;// 电子邮箱

	public Customer() {

	}

	public Customer(String name, char gender, int age, String phone, String e_mail) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.e_mail = e_mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

}

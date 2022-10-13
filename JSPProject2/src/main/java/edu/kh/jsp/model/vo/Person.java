package edu.kh.jsp.model.vo;

public class Person {
	// 필드(멤버변수)
	private String name; // 캡슐화
	private int age;
	private String address;
	
	// 기본생성자
	public Person() {}
	
	// getter / setter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	// object.toString() 오버라이딩
	@Override
	public String toString() {
		return name + " / " + age + " / " + address;
	}
	
}

package edu.kh.jsp.model.vo;

public class Person {
	// 필드
	private String name;	// 왜 private? 캡슐화 원직에 의해(필드에 직접 접근 제한)
	private int age;
	private String address;
	
	// 컨트롤 스페이스 엔터
	public Person() { } // 기본 생성자

	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	// Object.toString() 오버라이딩
	@Override
	public String toString(){
		return name+" / " + age + " / " + address;
	}
	
	
}

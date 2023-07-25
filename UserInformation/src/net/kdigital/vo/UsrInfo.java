package net.kdigital.vo;

public class UsrInfo {
	
	//문자열 id, 문자열 name, 정수 age
	private String id;
	private String name;
	private int age;
	
	//기본 생성자
	public UsrInfo() {
		
	}

	//사용자 정의 생성자(멤버변수 전부 받기)
	public UsrInfo(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	//toString() 재정의
	@Override
	public String toString() {
		return "UsrInfo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}

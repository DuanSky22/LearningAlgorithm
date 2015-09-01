package com.sky.learningJava.Collections;

public class Student extends Person {

	private String school;
	private String idNumber;
	
	Student(String name,int age,String school, String idNumber){
		super(name,age);
		this.school=school;
		this.idNumber=idNumber;
	}
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	@Override
	public boolean equals(Object s){
		return super.equals(s) && this.school.equals(((Student)s).school) && this.idNumber.equals(((Student)s).idNumber);
	}
	
	@Override
	public int hashCode(){
		int result=super.hashCode();
		result+=this.school.hashCode()*37+this.idNumber.hashCode()*37;
		return result;
	}

	
}

package com.sky.learningJava.chapter08;

public class ClassIntro {
	
	public static void main(String args[]){
		Student student1=new Student();
		Student student2=new Student(1,"DuanSky",24,Gender.MALE);
		final int a;
		a=5;
		
		Person p=new Student();
		if(p instanceof Student){
			Student s=(Student)p;
		}
		System.out.println(new Person() instanceof Student);
	}
	
	

}

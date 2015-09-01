package com.sky.learningJava.chapter08;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Externalizable {

    private String name;
    transient private Integer age;
	private Gender gender;
	private static Integer NUM_OF_CREATE_INSTANCE=0;
	
	public Person(){
		NUM_OF_CREATE_INSTANCE++;
		System.out.println("默认构造函数被调用");
	}
	public Person(String name,Integer age,Gender gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
		NUM_OF_CREATE_INSTANCE++;
		System.out.println("带参数的构造函数被调用");
	}
	
	//手动控制序列化的过程
	private void writeObject(ObjectOutputStream out) throws Exception{
		out.defaultWriteObject();
		out.writeInt(age);
	}
	
	private void readObject(ObjectInputStream input) throws Exception{
		input.defaultReadObject();
		age=input.readInt();
	}
	
	@Override
	public String toString(){
		return "[name:"+name+",age:"+age+",gender:"+gender+"]"+"["+NUM_OF_CREATE_INSTANCE+"]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public static Integer getNUM_OF_CREATE_INSTANCE() {
		return NUM_OF_CREATE_INSTANCE;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name=(String)in.readObject();
		age=in.readInt();
	}
	public double getRandom() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

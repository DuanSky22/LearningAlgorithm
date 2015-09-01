package com.sky.learningJava.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sky.learningJava.chapter08.Gender;

public class SerializableIntro  {
	
	public static void main(String args[]) throws Exception{
//		Person person1=new Person();
//		Person person2=new Person();
		Person person=new Person("Duansky",24,Gender.MALE);
		System.out.println(person.getNUM_OF_CREATE_INSTANCE());
		File file=new File("D:\\person.out");
		//将可序列化的对象写到文件中.如果这个对象不可序列化，则不能按照流的方式写入到文件中
		//可以测试将Person的Serializable去掉。
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(person);
		oos.close();
		//将可序列化的对象从文件中读取到内存。可以发现并没有调用构造函数和set方法
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
		Object newPerson=ois.readObject();
		
		ois.close();
		System.out.println(newPerson);
		
	}
	
	

}

package com.sky.learningJava.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.sky.learningJava.Serializable.Person;
import com.sky.learningJava.chapter08.Gender;

public class InputOutputStream {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		
		File file=new File("test.data");
		/*
		 * OutputStream 是抽象类 FileOutputStream是具体实现。没有引入新的方法。
		 * 以字节流的形式输出。
		 * FilterOutputStream继承自OutputStream,实现对输出流的过滤。
		 * BufferedOutputStream又继承自FilterOutputStream,设置的有缓冲区。
		 * 可以有效改善写的性能。
		 * DataOutputStream继承自FilterOutputStream，可以以Java基础类型或者
		 * 字符串的形式写入到文件中
		 * ObjectOutputStream继承自OutputStream，顾名思义，是可以向文件中写入序列化的对象
		 */
		OutputStream outputStream=new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream); 
		DataOutputStream dataOutputStream=new DataOutputStream(bufferedOutputStream);
		dataOutputStream.writeUTF("DuanSky");
		dataOutputStream.writeInt(100);
		dataOutputStream.writeChar('A');
		dataOutputStream.close();
		
		InputStream inputStream=new FileInputStream(file);
		BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
		DataInputStream dataInputStream=new DataInputStream(bufferedInputStream);
		
		print(dataInputStream.readUTF());
		print(dataInputStream.readInt());
		print(dataInputStream.readChar());
		
		Person person=new Person("DuanSky",24,Gender.MALE);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		objectOutputStream.writeObject(person);
		objectOutputStream.close();
		
		ObjectInputStream objectInputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		Person personCopy=(Person) objectInputStream.readObject();
		print(personCopy);
		
	}
	
	public static void print(Object o){
		System.out.println(o);
	}

}

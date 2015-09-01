package com.sky.learningJava.Reflection.example2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassIntro {

	public static void main(String args[]){
		try {
			Class ccc=Person.class;
			Class cc=Class.forName("com.sky.learningJava.reflection.Person");
			System.out.println("****");
			try {
				
				Constructor constructor=cc.getConstructor(String.class,int.class);
				try {
					Object obj=constructor.newInstance("DuanSky",24);
					System.out.println(obj);
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

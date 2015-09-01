package com.sky.learningJava.chapter08;

public class Student extends Person {

	private int idNmuber;
	
	Student(){
		System.out.println("Student无参数构造函数被调用");
	}
	//如果用户不显示的调用父类的构造方法，则在调用子类的构造方法之前，会默认调用super()[即父类的无参数构造方法]
	//当然用户可以使用super(...)显式的调用父类的构造方法。
	//用户还可以通过super.methods()来调用父类的实例方法或静态方法。
	Student(int idNumber,String name,int age,Gender gender){
		//显示调用父类的构造方法
		//super(name,age,gender);
		//显式调用父类的方法
		super.setAge(age);
		super.setGender(gender);
		super.setName(name);
		//因为这些方法都是public,则直接被子类继承下来，即可以在子类中直接调用
		this.setAge(age);
		this.setGender(gender);
		this.setName(name);
		//也可以不使用this
//		setAge(age);
//		setGender(gender);
//		setName(name);
		
		this.idNmuber=idNumber;
		System.out.println("Student带参数构造函数被调用");
	}
	//覆盖父类的方法，必须有相同的方法签名和返回值类型
	@Override
	public double getRandom(){
		return 0;
	}
	//如果方法签名不同，则是重载，而不是覆盖
	public double getRandom(double d){
		return d;
	}

}

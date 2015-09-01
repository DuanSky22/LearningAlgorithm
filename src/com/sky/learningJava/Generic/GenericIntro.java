package com.sky.learningJava.Generic;

/*
 * 使用泛型的目的是在增强程序扩展能力的同时，使编译器在编译的时候就能够检查错误，而不是要等到运行的时候才发现类型不匹配问题。
 * 所以泛型在编译时存在，在运行时都会被特定的类型所取代，在运行时不存在。
 * 因此使用 E e=new E(); 这样的语句是非法的，因为在运行时不存在泛型E.
 */
public class GenericIntro {
	
	public static void main(String args[]){
		GenericStack<String> s=new GenericStack<String>();
		s.add("1");
		s.add("2");
		s.add("3");
		System.out.println(s);
		print(new Integer[]{1,2,3,4,5,6});
		findMax(new Integer[]{1,2,3,4,5,6});
	}
	
	//定义泛型方法 注意要将泛型写在返回值前面
	//下面定义了一个泛型方法，打印数组的所有值。
	public static <E> void  print(E[] list){
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
	//也可以定义一个泛型是另外一个泛型的子类型
	//编译器在编译的时候，默认将泛型当做object类型来处理。所有object上面的方法，在泛型都可以使用
	//反过来，如果object上面没有定义的方法，在泛型上不能使用。
	public static <E extends Comparable<E>> E findMax(E[] list){
		E max=list[0];
		for(E object: list){
			//if(object>max) 这句是错误的。因为object类上没有定义">"的含义。
			if(object.compareTo(max)>0)
				max=object;
		}
		System.out.println(max);
		return max;
	}
	
	//采用统配类型来写泛型方法
	/*
	 * 通配类型一共有三种：
	 * <?> 非受限通配 ： 即是object对象即可
	 * <? extends T> 受限匹配  匹配的类型必须是用户指定的（T）的类型或子类型
	 * <? super T> 下限匹配  匹配的类型必须是用户指定的（T）的类型或父类型
	 */
	
	public static double findMax(GenericStack<? extends Number> stack){
		double max=stack.pop().doubleValue();
		for(int i=0;i<stack.size();i++){
			double temp=stack.get(i).doubleValue();
			if(temp>max)
				max=temp;
		}
		System.out.println(max);
		return max;
	}
	
	
}

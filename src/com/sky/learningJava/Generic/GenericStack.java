package com.sky.learningJava.Generic;

import java.util.ArrayList;

//定义泛型类
public class GenericStack<E> {
	private ArrayList<E> stack=new ArrayList<E>();
	
	public GenericStack() {
	}
	
	public int size(){
		return stack.size();
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public void add(E object){
		stack.add(object);
	}
	
	public E top(){
		return stack.get(this.size()-1);
	}
	
	public E pop(){
		E object=stack.get(this.size()-1);
		stack.remove(this.size()-1);
		return object;
	}
	public E get(int i){
		return stack.get(i);
	}
	
	@Override
	public String toString(){
		String result="";
		for(int i=0;i<this.size();i++){
			result+=stack.get(i).toString()+" ";
		}
		return result;
	}
	
	

}

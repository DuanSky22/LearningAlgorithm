package com.sky.learningJava.Reflection.example2;

import java.util.ArrayList;
import java.util.List;

/*
 *  @author: DuanSky
 *    @time: 2015年8月19日 下午3:34:29
 * @content:

 */
class CountedInteger{
	private static long counter;
	private final long id=counter++;
	public String toString(){
		return Long.toString(id);
	}
}
class FilledList<T>{
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type=type;
	}
	public List<T> create(int nElements){
		List<T> result=new ArrayList<T>();
		try{
			for(int i=0;i<nElements;i++){
				result.add(type.newInstance());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
public class ClassBoundedClassReferences {
	public static void main(String args[]){
		/*
		//通配符的使用
		Class<? extends Number> bounded = int.class;
		bounded=double.class;
		bounded=Number.class;
		*/
		FilledList<CountedInteger> fl=
				new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));
	}

}

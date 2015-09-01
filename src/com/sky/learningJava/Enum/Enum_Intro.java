package com.sky.learningJava.Enum;
/*
 *  @author: DuanSky
 *    @time: 2015年8月26日 下午9:09:06
 * @content:

 */
enum Unit{
	hour("时"),
	minute("分"),
	second("秒");
	private String description;
	
	private Unit(String description){
		this.description=description;
	}
	
	public String getDescription(){
		return description;
	}
}
public class Enum_Intro {
	public static void main(String args[]){
		Unit[] units=Unit.values();
		Unit unit2=Unit.hour;
		for(Unit unit : Unit.values()){
			System.out.println(unit+":"+unit.name()+":"+unit.ordinal()+":"+unit.toString());
		}
	}
	
}

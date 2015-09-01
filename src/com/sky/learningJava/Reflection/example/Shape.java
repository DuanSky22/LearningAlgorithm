package com.sky.learningJava.Reflection.example;
/*
 *  @author: DuanSky
 *    @time: 2015骞�8鏈�19鏃� 涓婂崍11:09:58
 * @content:

 */
public abstract class Shape {
	void draw(){
		System.out.println(this+".draw()");
	}
	//寮哄埗缁ф壙鑰呬滑閲嶅啓璇ユ柟娉�
	abstract public String toString();
}

package com.sky.learningJava.ClassLoader;

import com.duansky.maven_intro.helloworld.HelloClassLoader;

public class LoaderExtraResources {
	public static void main(String args[]){
		System.out.println(LoaderExtraResources.class.getClassLoader());
		HelloClassLoader hello=new HelloClassLoader();
		System.out.println(hello.getName());
	}
}

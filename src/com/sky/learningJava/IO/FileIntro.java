package com.sky.learningJava.IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/*
 * File类是文件名及其路径的一个包装类。可以检测指定路径下文件名或者文件是否存在，以及创建文件和删除文件。
 * 同时还可以访问文件的属性（修改时间、文件地址、文件路径等）,但是不能读写文件内容。
 */
public class FileIntro {
	
	public static void main(String args[]) throws IOException{
		File file=new File("test.txt");
		print(file.exists());
		//在创建文件时，如果给出文件路径，一定要是合法的正确的存在的路径，否则无法正确创建文件；
		//如果没有给出文件路径，则默认是当前路径下创建文件
		print(file.createNewFile());
		print(file.getTotalSpace()/(1024*1024*1024)+"G");
		//mkdir()是创建目录。
		print(file.mkdir());
		print(file.getAbsolutePath());
		print(new Date(file.lastModified()));
		print(file.isFile());
		
	}
	
	
	public static void print(Object o){
		System.out.println(o);
	}

}


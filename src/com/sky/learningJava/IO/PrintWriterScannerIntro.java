package com.sky.learningJava.IO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
 * PrinteWriter 可以向文件中写内容
 * Scanner 可以从文件中扫描内容
 */
public class PrintWriterScannerIntro {

	public static void main(String args[]) throws IOException{
		File file=new File("test.txt");
		if(file.exists())
			file.delete();
		file.createNewFile();
		
		PrintWriter output=new PrintWriter(file);
		output.print("DuanSky ");
		output.println(100);
		output.print('a');
		output.close();
		
		Scanner input=new Scanner(file);
		print(input.next());
		print(input.nextInt());
		print(input.next());
		
	}
	
	public static void print(Object o){
		System.out.println(o);
	}
}

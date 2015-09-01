package com.sky.learningJava.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileSelection {

	public static void main(String args[]) throws IOException{
		JFileChooser fileChooser=new JFileChooser();
		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File file=fileChooser.getSelectedFile();
			print(file.getName());
			if(file.isFile()){
				InputStream input=new FileInputStream(file);
				while(input.read()!=-1){
					System.out.println(input.read());
				}
				input.close();
			}
			else{
				System.out.println("请选择文件");
			}
		}
	}
	public static void print(Object o){
		System.out.println(o);
	}
}

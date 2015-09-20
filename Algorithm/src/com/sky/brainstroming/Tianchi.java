package com.sky.brainstroming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tianchi {
	
	public static void engine(String args[]) throws Exception{
		String path="";
		File file=new File(path);

		if(file.exists() && file.isFile()){
			InputStreamReader input=new InputStreamReader(new FileInputStream(file));
			BufferedReader buffer=new BufferedReader(input);
			String lineData=null;
			while((lineData=buffer.readLine())!=null){
				List<List<String>> result=new ArrayList<List<String>>();
				String line[]=lineData.split(";"); //for a line data
				for(String tuple : line){
					if(tuple!=null && tuple.length()>0){ 
						String singles[]=tuple.split(","); // for a tuple data
						List<String> tupleList=new ArrayList<String>(); // store tuple data
						for(String single : singles){
							tupleList.add(single);
						}
						result.add(tupleList); 
					}
				}
				// now we store a line data into result list.
				List<Integer> size=getSize(result);
				List<Integer> currentState=null;
				Collections.copy(currentState, size);
				while(isFinished(size)){
					printCurrentState(result,size);
					moveStep(currentState,size);
				}
			}
		}
	}
	
	private static List<Integer> getSize(List<List<String>> result){
		List<Integer> sizeList=new ArrayList<Integer>();
		for(List<String> tuple : result){
			sizeList.add(tuple.size());
		}
		return sizeList;
	}
	
	public static boolean isFinished(List<Integer> sizeList){
		for(Integer i : sizeList)
			if(i!=0)
				return false;
		return true;
	}
	
	public static void moveStep(List<Integer> currentState,List<Integer> originalData){
		if(currentState.size()==0)
			return;
		Integer first=currentState.get(0);
		if(first>1)
			first=first-1;
		else{
			// find the first size that is not equals 1.
			int lastOne=0;
			while(currentState.get(lastOne)==1)
				lastOne++;
			if(lastOne==currentState.size()) // now finished.
				return;
			else{
				 for(int i=0;i<lastOne;i++){
					 Integer temp=currentState.get(i); 
					 temp=originalData.get(i);  //restoration
				 }
				 Integer temp=currentState.get(lastOne);
				 temp=temp-1;
			}
		}
	}
	
	public static void printCurrentState(List<List<String>> data,List<Integer> currentState){
		for(int i=0;i<data.size();i++){
			System.out.print(data.get(i).get(currentState.get(i)-1));
		}
		System.out.println();
	}

}

package com.sky.brainstroming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tianchi {
	
	public static void main(String args[]) throws Exception{
		String path="dim_fashion_matchsets.txt";
		File file=new File(Tianchi.class.getClassLoader().getResource(path).toURI());
		if(file.exists() && file.isFile()){
			InputStreamReader input=new InputStreamReader(new FileInputStream(file));
			BufferedReader buffer=new BufferedReader(input);
			String lineData=null;
			while((lineData=buffer.readLine())!=null){
				List<List<String>> parseResult=new ArrayList<List<String>>(); //parseResult store the line data.
				int spacePosition=lineData.indexOf(" ");
				lineData=lineData.substring(spacePosition+1);
				String line[]=lineData.split(";"); //for a line data
				for(String tuple : line){
					if(tuple!=null && tuple.length()>0){ 
						String singles[]=tuple.split(","); // for a tuple data
						List<String> tupleList=new ArrayList<String>(); // store tuple data
						for(String single : singles){
							tupleList.add(single);
						}
						parseResult.add(tupleList); 
					}
				}
				// now we store a line data into result list.
				int[] sizes=getSizes(parseResult);
				int[] currentState=new int[sizes.length];
				currentState=Arrays.copyOf(sizes, sizes.length);
				printCurrentState(parseResult,currentState);
				while(!isFinished(currentState)){
					moveStep(currentState,sizes);
					printCurrentState(parseResult,currentState);

				}
			}
		}
	}
	
	private static int[] getSizes(List<List<String>> result){
		int[] sizes=new int[result.size()];
		int i=0;
		for(List<String> tuple : result){
			sizes[i++]=tuple.size();
		}
		return sizes;
	}
	
	public static boolean isFinished(int[] sizeList){
		for(Integer i : sizeList)
			if(i!=1)
				return false;
		return true;
	}
	
	public static void moveStep(int[] currentState,int[] originalData){
		if(currentState.length==0)
			return;
		int first=currentState[0];
		if(first>1)
			currentState[0]=currentState[0]-1;
		else{
			// find the first size that is not equals 1.
			int lastOne=0;
			while(lastOne<currentState.length && currentState[lastOne]==1)
				lastOne++;
			if(lastOne==currentState.length) // now finished.
				return;
			else{
				 for(int i=0;i<lastOne;i++){
					 originalData[i]=currentState[i]; 
				 }
				 currentState[lastOne]-=1;
			}
		}
	}
	
	public static void printCurrentState(List<List<String>> data,int[] currentState){
		for(int i=0;i<data.size();i++){
			System.out.print(data.get(i).get(currentState[i]-1)+" ");
		}
		System.out.println();
	}

}

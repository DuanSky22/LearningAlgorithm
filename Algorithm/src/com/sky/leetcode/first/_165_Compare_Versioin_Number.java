package com.sky.leetcode.first;

public class _165_Compare_Versioin_Number {
	
	public static void main(String args[]){
		_165_Compare_Versioin_Number test = new _165_Compare_Versioin_Number();
		String version1 = "1.0.1";
		String version2 = "1";
		System.out.println(test.compareVersion(version1, version2));
	}
	
	 public int compareVersion(String version1, String version2) {
		int p1 = 0, p2 = 0, v1 = 0, v2 = 0;
        for(int i = 0, j = 0; i < version1.length() || j < version2.length();){
        	if(i != version1.length()){
        		p1 = version1.indexOf('.',i); 
            	if(p1 != -1) v1 = Integer.parseInt(version1.substring(i,p1));
            	else v1 = Integer.parseInt(version1.substring(i));
        	}else{
        		v1 = 0;
        	}
        	if(j != version2.length()){
        		p2 = version2.indexOf('.',j);
        		if(p2 != -1) v2 = Integer.parseInt(version2.substring(j,p2));
        		else v2 = Integer.parseInt(version2.substring(j));
        	}
        	else{
        		v2 = 0;
        	}
        	if(v1 != v2) return v1 > v2 ? 1 : -1;
        	i = p1 == -1 ? version1.length() : p1 + 1;
        	j = p2 == -1 ? version2.length() : p2 + 1;
        	
        }
        return 0;
     }
}

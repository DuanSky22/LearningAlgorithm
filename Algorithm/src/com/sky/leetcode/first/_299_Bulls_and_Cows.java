package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _299_Bulls_and_Cows {
	
	public static void main(String args[]){
		_299_Bulls_and_Cows test = new _299_Bulls_and_Cows();
		String secret ="0123";
		String guess = "3210";
		System.out.println(test.count(secret, guess));
	}

	public int count(String s1,String s2){
		int n = s1.length(), count = 0;
		int res[] = new int[10];
		for(int i = 0; i < n; i++){
			if(res[s1.charAt(i)-'0']++ < 0) 
				count++;
			if(res[s2.charAt(i)-'0']-- > 0) 
				count++;
		}
		return count;
	}
	
	public String getHint_(String secret,String guess){
	    int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        if (secret.charAt(i) == guess.charAt(i)) bulls++;
	        else {
	            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
	            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}
	
	//two pass and with extra space. no good!
	public String getHint(String secret, String guess) {
		int n = secret.length(), bows = 0, crows = 0;
		Map<Character,Integer> candidate = new HashMap<>();
		Set<Integer> set = new HashSet<>(n);
		for(int i = 0; i < n; i++){
			if(secret.charAt(i) == guess.charAt(i)){
				bows++;
				set.add(i);
			}
			else{
				Integer curr;
				if((curr = candidate.putIfAbsent(secret.charAt(i), 1)) != null)
					candidate.put(secret.charAt(i), curr+1);
			}
		}
		for(int i = 0; i < n; i++){
			if(set.contains(i)) continue;
			char c = guess.charAt(i);
			if(candidate.containsKey(c)){
				crows++;
				if(candidate.get(c) == 1)
					candidate.remove(c);
				else
					candidate.put(c, candidate.get(c)-1);
			}
		}
		return bows+"A"+crows+"B";
    }
}

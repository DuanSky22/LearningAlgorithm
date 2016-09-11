package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2015年12月31日 上午9:39:43
 * @content 
 *     这道题考虑的是这样的一种情况： 如果字典比较长，层次遍历的时候需要遍历字典里的每一个元素来查找下一步的梯子，这样会超时。
 * 考虑到字典采用HashSet来存储元素，如果只判断某个字符串在字典里是否存在，那么可以在常量时间里判断，大大提高了速度。
 * 		如果记录每个梯子的当前步骤，可以加快速度。
 */

public class _127_Word_Ladder_2 {
	
	public static void main(String args[]){
		
//		_127_Word_Ladder test1=new _127_Word_Ladder();
//		System.out.println(test1.hashCode());
//		_127_Word_Ladder test2=new _127_Word_Ladder();
//		System.out.println(Integer.toHexString(test2.hashCode()));
//		System.out.println(test2);
//		
//		Map<String,Boolean> test=new HashMap<String,Boolean>();
//		test.put(new String("1"), true);
//		System.out.println(test.containsKey(new String("1")));
//		
//		String a=new String("12");
//		String b=new String("12");
//		System.out.println(a==b);
//		System.out.println(a.hashCode()==b.hashCode());
		
//		String beginWord="hit";
//		String endWord="cog";
//		Set<String> wordList = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log","hit","cog"));
		
		String beginWord = "nape";
		String endWord = "mild";
		Set<String> wordList = new HashSet<String>(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));
		System.out.println(ladderLength_time_limited(beginWord,endWord,wordList));
//		System.out.println(__ladderLength(beginWord,endWord,wordList));
	}
	//这里巧妙的用了一个distanceQueue用来记录每一个梯子的当前步数。
	public static int ladderLength_right_answer(String beginWord, String endWord, Set<String> wordList){
		if (wordList.size() == 0)
			return 0;

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(beginWord);
		distanceQueue.add(1);

		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			if (currWord.equals(endWord)) {
				return currDistance;
			}
			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if (wordList.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						wordList.remove(newWord);
					}
				}
			}
		}
		return 0;
	}
	
	//层次遍历
	public static int ladderLength_time_limited(String beginWord, String endWord, Set<String> wordList){
		Queue<String> queue = new LinkedList<String>(); queue.add(beginWord); 
		int counter=0; 
		while(!queue.isEmpty()){
			int size=queue.size(); int k=0; counter++;
			while(k++<size){
				String current = queue.poll(); int length=current.length();
				String replace; char[] array=new char[length];
				for(int i=0;i<length;i++){//循环遍历每个字符来替换
					for(char j='a'; j<='z'; j++){
						array = current.toCharArray();
						array[i]=j;
						replace = String.copyValueOf(array);
						//MISTAKE 这里注意如果使用字符串拷贝将会超时。
//						replace = current.substring(0,i)+j+current.substring(i+1,length);
						if(replace.equals(endWord)) 
							return counter+1;
						if(wordList.contains(replace)){//hashset能够在常量时间内找到元素
							queue.add(replace);
							wordList.remove(replace);
						}
					}
				}
			}
		}
		//MISTAKE 如果还是表示没有找到这样的梯子。
		return 0;
	}
	
	
	//采用广度优先遍历-超时
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<String> queue=new LinkedList<>(); wordList.add(endWord); int size=0;
		Queue<String> removed=new LinkedList<>(); queue.add(beginWord); int counter=1;
		while(!queue.isEmpty() && !wordList.isEmpty()){
			size=queue.size(); //遍历整层的元素
			for(int i=0;i<size;i++){ 
				String top=queue.poll();
				removed.clear();
				for(String word : wordList){ //添加下一层的元素
					if(isLadder(word,top)){ //如果在添加的过程中遇到了要找的endWord。
						if(word.equals(endWord)) return counter+1;
						queue.add(word);
						removed.add(word);
					}
				}
				wordList.removeAll(removed);
			}
			counter++;
		}
		return 0;
    }
	
	//采用深度优先遍历-严重超时
	public static int _ladderLength(String beginWord, String endWord, Set<String> wordList){
		wordList.add(endWord);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		for(String word : wordList)
			map.put(word, false);
		return _ladderLength(1,beginWord,endWord,map);
	}
	
	//深度优先遍历会穷举所有的可能路径。
	public static int _ladderLength(int count,String currentWord,String endWord,Map<String,Boolean> wordList){
		int result=0; int temp=0;
		if(isFinished(wordList)){//此时单词表里面还有很多元素 
			for(Entry<String,Boolean> entry : wordList.entrySet()){
				String word=entry.getKey();
				if(!entry.getValue() && isLadder(word,currentWord)){//测试这个元素和当前的元素是否可以构成梯子
					if(word.equals(endWord)) //如果这个元素和当前的元素可以构成梯子，而且这个元素就是endWord,那么就找到了这么一个梯子。但是这个梯子不一定是最短的。
						return count+1;
					else{//如果这个元素不是endword，则需要将这个元素设置为当前的元素，继续往下查找
						wordList.put(word, true);
						temp=_ladderLength(count+1,word,endWord,wordList);
						if(temp!=0) result= result==0 ? temp : Math.min(result, temp);
						wordList.put(word,false); //查找完word之后，需要恢复现场，让其他的元素在当前的状态继续往下查找
					}
				}
			}
		}
		//此时，wordList只有一个元素，这个元素肯定就是endWord.
		return result;
	}
	
	public static boolean isFinished(Map<String,Boolean> map){
		for(Entry<String,Boolean> entry : map.entrySet()){
			if(!entry.getValue()) return true;
		}
		return false;
	}
	
	public static boolean isLadder(String a,String b){
		int counter=0;
		for(int i=0;i<a.length();i++)
			if(a.charAt(i)!=b.charAt(i)) counter++;
		return counter==1 ? true : false;
	}
	
	public static int __ladderLength(String startWord,String endWord,Set<String> wordList){
		wordList.add(endWord); wordList.add(startWord); int size=wordList.size();
		List<String> wordTab=new ArrayList<>(); int counter=1;
		int[][] wordLadder=createMatrix(wordList,wordTab);
		Queue<String> queue=new LinkedList<String>(); queue.add(startWord);
		while(!queue.isEmpty()){
			int qnum=queue.size();
			for(int k=0;k<qnum;k++){
				String word = queue.poll();
				int id=wordTab.indexOf(word);
				for(int i=0;i<size;i++){
					if(wordLadder[id][i]==1) {
						if(wordTab.get(i).equals(endWord))
							return counter+1;
						queue.add(wordTab.get(i));
					}
				}
			}
			counter++;
		}
		return 0;
	}
	
	public static int[][]  createMatrix(Set<String> wordList,List<String> tab){
		int size=wordList.size();
		int[][] result=new int[size][size];
		for(String word : wordList){
			tab.add(word);
		}
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++)
				if(isLadder(tab.get(i),tab.get(j))){
					result[i][j]=1; result[j][i]=1;
				}
		}
		
		return result;
	}

}

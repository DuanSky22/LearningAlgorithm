package com.sky.leetcode.first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年3月7日 下午4:09:57
 * @content 
 * 
 */

public class _211_Add_and_Search_Word_Data_structure_design {
	
	public static void main(String args[]){
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("bat");
		wd.addWord("dad");
		Node root = wd.getRoot();
		System.out.println(wd.search("b"));
	}
	
	
	static class WordDictionary {
		
		private Node root = new Node('*',false);
		private int deep = 0;
		
		public Node getRoot(){
			return root;
		}
		
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	       if(word==null || word.length()==0) return;
	       deep = Math.max(deep, word.length());
	       Node father = root, son = root, addPos = root;
	       for(int i = 0; i < word.length(); i ++){
	    	   char val = word.charAt(i);
	    	   son = getSon(father,val);
	    	   if(son == null){//如果son为空，表明没有找到值为i的孩子，则需要新建这样的一颗树
	    		   son = new Node(val,false); //新建这样的节点，这个节点被追加到father的最后一个son的后面
	    		   addPos = getLastSon(father);
	    		   if(addPos==null)//父亲还没有一个孩子,则这是第一个孩子
	    			   father.son = son;
	    		   else //追加到最后一个son的后面
	    			   addPos.brother = son;
	    	   }
	    	   father = son;
	       }
	       father.isLeaf = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        if(word == null || word.length() == 0 || word.length()>deep) return false;
	        Queue<Node> fathers = new LinkedList<>(); fathers.add(root);
	        for(int i = 0; i < word.length(); i ++){
	        	char val = word.charAt(i);
	        	int fatherNum = fathers.size();
	        	if(val == '.'){
	        		for(int f = 0; f < fatherNum; f ++){
	        			Node father = fathers.poll(); //当前的father.
        				Node son = father.son;
        				while(son!=null){
        					fathers.add(son);
        					son = son.brother;
        				}
	        		}
	        	}
	        	else{//如果不是特殊字符，则在父亲的所有孩子中查找这个字符
	        		for(int f = 0; f < fatherNum; f ++){
	        			Node father = fathers.poll(); //当前的father.
        				Node son = father.son;
        				while(son!=null){
        					if(son.val==val){ 
        						fathers.add(son);
        						break;
        					}
        					son = son.brother;
        				}
	        		}
	        	}
	        	if(fathers.isEmpty()) return false;
	        }
	        //MISTAKE 有可能出现匹配上部分单词的情况，需要注意判断是否是完整的单词，而不是单词的一部分。
	        for(Node father : fathers){
	        	if(father.isLeaf == true) return true;
	        }
	        return false;
	    }
	    
	    private Node getLastSon(Node father){
	    	if(father==null || father.son == null) return null;
	    	Node lastSon = father.son;
	    	while(lastSon.brother!=null) lastSon = lastSon.brother;
	    	return lastSon;
	    }
	    //查找该字符是否存在，如果存在，返回字符的位置，如果不存在，则返回null.
	    private Node getSon(Node father,char val){
	    	if(father==null || father.son==null) return null;
	    	Node firstSon = father.son;
	    	while(firstSon!=null){
	    		if(firstSon.val == val) return firstSon;
	    		firstSon=firstSon.brother;
	    	}
	    	return null;
	    }
	}
	
	static class Node{
		char val;
		boolean isLeaf = false;
		Node brother = null;
		Node son = null;
		
		Node(char val,boolean isLeaf){
			this.val = val;
			this.isLeaf = isLeaf;
		}
	}
}

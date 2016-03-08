package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.sky.leetcode._211_Add_and_Search_Word_Data_structure_design.Node;
import com.sky.leetcode._211_Add_and_Search_Word_Data_structure_design.WordDictionary;

/**
 * @author DuanSky
 * @date 2016年3月7日 下午9:41:47
 * @content
 */

public class _211_Add_and_Search_Word_Data_structure_design_2 {
	
	public static void main(String args[]){
		WordDictionary wd = new WordDictionary();
		wd.addWord("a");
		wd.addWord("ab");
		System.out.println(wd.search(".a"));
	}
	
	static class WordDictionary {

		private Node root = new Node(false);
		private int deep = 0;

		// Adds a word into the data structure.
		public void addWord(String word) {
			if(word == null || word.length() == 0) return ;
			deep = Math.max(deep, word.length());
			Node father = root;
			for(int i = 0; i < word.length(); i ++){
				int curr = word.charAt(i)-'a';
				if(father.children[curr]==null) 
					father.children[curr]=new Node(false);
				father = father.children[curr];
			}
			father.isLeaf = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if(word==null || word.length()>deep) return false;
			Queue<Node> fathers = new LinkedList<Node>();
			fathers.add(root);
			for(int i=0;i<word.length();i++){
				int curr = word.charAt(i)-'a';
				int nums = fathers.size();
				for(int f = 0; f < nums; f++){
					Node father = fathers.poll();
					if(curr=='.'-'a'){//如果遇到的是 [.]，需要把所有的非空孩子节点都加上去
						for(Node son : father.children)
							if(son!=null) 
								fathers.add(son);
					}
					else if(father.children[curr]!=null) //如果遇到的不是 [.]
						fathers.add(father.children[curr]);
				}
				if(fathers.isEmpty()) return false;
			}
			for(Node father : fathers)
				if(father.isLeaf) return true;
			return false;
		}

		class Node {
			Node[] children = new Node[26]; //如果第i个孩子不为空，表明第i个字符存在。
			boolean isLeaf = false;
			Node(boolean isLeaf){
				this.isLeaf = isLeaf;
			}
		}
	}
}

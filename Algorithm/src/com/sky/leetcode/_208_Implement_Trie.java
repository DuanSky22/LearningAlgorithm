package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年4月1日 下午7:45:07
 * @content 
 */

public class _208_Implement_Trie {
	class TrieNode {
	    // Initialize your data structure here.
    	TrieNode[] children = new TrieNode[26];
    	boolean isLeaf = false;
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	TrieNode currRoot = root;
	        for(int i = 0; i < word.length(); i++){
	        	int currPos = word.charAt(i) - 'a';
	        	if(currRoot.children[currPos] == null) currRoot.children[currPos] = new TrieNode();
	        	currRoot = currRoot.children[currPos];
	        }
	        currRoot.isLeaf = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	TrieNode currRoot = root;
	        for(int i = 0; i < word.length(); i++){
	        	int currPos = word.charAt(i) - 'a';
	        	if(currRoot.children[currPos] == null) return false;
	        	currRoot = currRoot.children[currPos];
	        }
	        return currRoot.isLeaf;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode currRoot = root;
	        for(int i = 0; i < prefix.length(); i++){
	        	int currPos = prefix.charAt(i) - 'a';
	        	if(currRoot.children[currPos]==null) return false;
	        	currRoot = currRoot.children[currPos];
	        }
	        return true;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}

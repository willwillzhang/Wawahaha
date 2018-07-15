package com.zocdoc;

import java.util.HashMap;

class TrieHashNode{
	char c;
	HashMap<Character, TrieHashNode> children ;
	boolean isLeaf = false;
	
	public TrieHashNode(char c){
		
		this.children = new HashMap<Character, TrieHashNode>();
		this.c = c;
	}
}

public class Test1 {
	
	private TrieHashNode root;
	
	public Test1(){
		root = new TrieHashNode(' ');
	}
	
	public void insert(String word){
		if(word == null)
			return;
		
		HashMap<Character, TrieHashNode> children = root.children;
		for(int i =0; i<word.length(); i++){
			char c = word.charAt(i);
			
			TrieHashNode t;
			if(children.containsKey(c)){
				t = children.get(c);
			}else{
				t = new TrieHashNode(c);
				children.put(c, t);
			}
			
			if(i == word.length() - 1){
				t.isLeaf = true;
			}
		}
	}
	
	public boolean search(String word){
		if(word == null)
			return false;
		
		HashMap<Character, TrieHashNode> children = root.children;
		TrieHashNode t = null;
		for(int i = 0; i<word.length();i++){
			char c = word.charAt(i);
			if(children.containsKey(c)){
				t = children.get(c);
				children = t.children;
			}else{
				return false;
			}
			
			if(i == word.length() -1){
				return t.isLeaf;
			}
		}
		
		return false;
	}

}

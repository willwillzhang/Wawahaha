package com.zocdoc;

public class TrieArrayNode {

	private TrieArrayNode[] children;
	public boolean hasWord;

	// Initialize your data structure here.
	public TrieArrayNode() {
		children = new TrieArrayNode[26];
		hasWord = false;
	}

	public void insert(String word, int index) {
		if (index == word.length()) {
			this.hasWord = true;
			return;
		}

		int pos = word.TrieArrayNodecharAt(index) - 'a';
		if (children[pos] == null) {
			children[pos] = new TrieArrayNode();
		}
		children[pos].insert(word, index + 1);
	}

	public TrieArrayNode find(String word, int index) {
		if (index == word.length()) {
			return this;
		}

		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			return null;
		}
		return children[pos].find(word, index + 1);
	}
}

class Solution {
	private TrieArrayNode root;

	public Solution() {
		root = new TrieArrayNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		root.insert(word, 0);
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieArrayNode node = root.find(word, 0);
		return (node != null && node.hasWord);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieArrayNode node = root.find(prefix, 0);
		return node != null;
	}
}

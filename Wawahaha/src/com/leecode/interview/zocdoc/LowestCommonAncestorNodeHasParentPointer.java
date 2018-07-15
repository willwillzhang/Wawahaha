package com.leecode.interview.zocdoc;

import java.util.ArrayList;

public class LowestCommonAncestorNodeHasParentPointer {
	
	private ArrayList<TreeNode> getPath2Root(TreeNode node){
		ArrayList<TreeNode> nodes = new ArrayList<>();
		while(node != null){
			nodes.add(node);
			node = node.parent;
		}
		return nodes;
	}
	
	public TreeNode getLowestComAncestor(TreeNode node1, TreeNode node2){
		ArrayList<TreeNode> list1 = getPath2Root(node1);
		ArrayList<TreeNode> list2 = getPath2Root(node2);
		
		int i, j;
		
		for(i = list1.size() -1, j = list2.size()-1 ; i>=0 && j>=0; i--, j--){
			if(list1.get(i) != list2.get(i)){
				return list1.get(i).parent;
			}
		}
		
		return list1.get(i+1);
		
	}

}

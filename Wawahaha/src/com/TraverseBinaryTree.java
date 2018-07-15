package com;

import java.util.ArrayList;
import java.util.List;

public class TraverseBinaryTree {
	
	TreeNode root = null;

	public static void getRootToLeafPaths(TreeNode root) {
        if(root == null)
            return;
            
        List<List<Integer>> rfPaths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        
        helper(root, path, rfPaths);
        
        rfPaths.forEach(e -> System.out.println(e));
    }
    
    public static void helper(TreeNode root, List<Integer> path, List<List<Integer>> rfPaths){
    	
    	path.add(root.val);
    	
        if(root.left == null && root.right == null){
             rfPaths.add(new ArrayList<Integer>(path));
        }
            
        if(root.left != null){
            helper(root.left, path, rfPaths);
        }
        
        if(root.right != null){
            helper(root.right, path, rfPaths);
        }
        
        path.remove(path.size()-1);
        //path.remove(path.size()-1);
    }
    
    public static void main(String[] args){
    	TraverseBinaryTree tree = new TraverseBinaryTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(20);
		tree.root.left.right = new TreeNode(1);
		tree.root.right.right = new TreeNode(-25);
		tree.root.right.right.left = new TreeNode(3);
		tree.root.right.right.right = new TreeNode(4);
		getRootToLeafPaths(tree.root);
    }
	
}



class TreeNode {
      int val;
      TreeNode left, right;
      TreeNode(int x) { val = x; }
}

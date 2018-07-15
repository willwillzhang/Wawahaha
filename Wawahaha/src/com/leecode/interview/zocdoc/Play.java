package com.leecode.interview.zocdoc;

public class Play {
	
	TreeNode root;
	
	public int getMaxSum(TreeNode root){
		Result res = new Result();
		res.val = Integer.MIN_VALUE;
		maxSum(root, res);
		
		return res.val;
	}
	
	public int maxSum(TreeNode root, Result res){
		if(root == null)
			return 0;
		
		int left = maxSum(root.left, res);
		int right = maxSum(root.right, res);
		int leftRootRight = root.val +left +right;
		
		int max_single = Math.max(root.val, Math.max(right, left) + root.val);
		res.val = Math.max(res.val, Math.max(leftRootRight, max_single));
		
		return max_single;
	}
	
	public int findMaxSum(){
		return getMaxSum(root);
	}
	
	public static void main(String[] args){
		Play tree = new Play();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(20);
		tree.root.left.right = new TreeNode(1);
		tree.root.right.right = new TreeNode(-25);
		tree.root.right.right.left = new TreeNode(3);
		tree.root.right.right.right = new TreeNode(4);
		System.out.println("maximum path sum is : " +
							tree.findMaxSum());
	}
}


class Result{
	int val;
}
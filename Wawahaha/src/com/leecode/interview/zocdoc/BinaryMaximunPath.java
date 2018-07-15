package com.leecode.interview.zocdoc;

public class BinaryMaximunPath {
	
	public int findMaxSum(){
		ResultType result = helper(root);
		return result.maxPath;
	}
	// Root of the Binary Tree
	TreeNode root;
	
    private class ResultType{
        int singlePath, maxPath;
        
        public ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    public ResultType helper(TreeNode root){
         // write your code here
        if(root == null)
            return new ResultType(0, Integer.MIN_VALUE);
        
        ResultType left = helper(root.left);
        ResultType right =  helper(root.right);
        
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath+right.singlePath+root.val);
        
        return new ResultType(singlePath, maxPath);
        
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
       ResultType result = helper(root);
       return result.maxPath;
    }
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryMaximunPath tree = new BinaryMaximunPath();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(10);
		tree.root.left.left = new TreeNode(20);
		tree.root.left.right = new TreeNode(1);
		tree.root.right.right = new TreeNode(-25);
		tree.root.right.right.left = new TreeNode(3);
		tree.root.right.right.right = new TreeNode(4);
		System.out.println("maximum path sum is : " + tree.findMaxSum());
	}
}


class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		left = right = null;
	}
}

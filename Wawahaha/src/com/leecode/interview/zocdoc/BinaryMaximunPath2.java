package com.leecode.interview.zocdoc;

//my preferred solution

/*
-arch代表穿过当前节点的路径（左边一支儿+自己节点+右边一支儿）。
-注意树的节点可以是负数，所以arch不一定是最长的。
-每次return以root（当前节点）开头最大的单只path sum。
-res[]就是一个存result的reference object，java不支持c++那种直接&传reference，
 所以要么用个长度为一的数组，要么创建一个wrapper object。还是用数组简单。
-update res[0]，用arch和以自己开头一支儿的比，谁大就把res[0] update成谁。*/

public class BinaryMaximunPath2 {
	TreeNode root;
	
	public int findMaxSum(){
		return maxPathSum(root);
	}
	
	public int maxPathSum(TreeNode root) {
	    int[] res = new int[1];
	    res[0] = Integer.MIN_VALUE;
	    maxPath(root, res);
	    return res[0];
	}
	
	private int maxPath(TreeNode root, int[] result) {
	    if (root == null)
	        return 0;
	    int left = maxPath(root.left, result);//左边一支儿（不算自己）
	    int right = maxPath(root.right, result);
	    int arch = left + right + root.val; //穿过自己
	    int single = Math.max(root.val, Math.max(left, right) + root.val);
	    //（算上自己）
	    result[0]= Math.max(result[0], Math.max(arch, single));//update结果
	    return single;
	}
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryMaximunPath2 tree = new BinaryMaximunPath2();
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

//An object of Res is passed around so that the
//same value can be used by multiple recursive calls.
class Res {
 public int val;
}
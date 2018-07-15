package com.capitalOne;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeInsertNode {

	private TreeNode root;

	public void addNode(Integer id) {

		root = addNodeHelperRecursive(root, id);
	}

	public TreeNode addNodeHelperRecursive(TreeNode parent, Integer val) {

		if (parent == null) {
			return new TreeNode(val);
		}
		if (val < parent.val) {
			parent.left = addNodeHelperRecursive(parent.left, val);
		}
		if (val > parent.val) {
			parent.right = addNodeHelperRecursive(parent.right, val);
		}

		return parent;
	}

	public TreeNode addNodeHelperIterative(TreeNode root, Integer val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}

		TreeNode current = root;
		TreeNode parent = null;

		while (current != null) {
			parent = current;
			if (current.val > val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (parent != null) {
			if (parent.val > val) {
				parent.left = new TreeNode(val);
			} else {
				parent.right = new TreeNode(val);
			}
		}

		return root;
	}

	/**
	 * non-recursive
	 * BFS - Queue
	 */
	public static boolean isBst(TreeNode root) {

		if (root == null)
			return false;

		Queue<BNode> queue = new LinkedList<BNode>();
		queue.offer(new BNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (!queue.isEmpty()) {
			BNode bNode = queue.poll();
			if (bNode.node.val < bNode.left || bNode.node.val > bNode.right) {
				return false;
			}
			if (bNode.node.left != null) {
				queue.offer(new BNode(bNode.node.left, bNode.left, bNode.node.val));
			}
			if (bNode.node.right != null) {
				queue.offer(new BNode(bNode.node.right, bNode.node.val, bNode.right));
			}
		}

		return true;
	}

	// All values on the left sub tree must be less than root,
	// and all values on the right sub tree must be greater than root. So we
	// just check the boundaries for each node.
	public static boolean isBSTRecursive(TreeNode root) {
		if (root == null)
			return true;
		return isBstHelper1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBstHelper1(TreeNode node, int low, int high) {
		if (node == null) {
			return true;
		}

		if (node.val > low && node.val < high) {
			return isBstHelper1(node.left, low, node.val) && isBstHelper1(node.right, node.val, high);
		} else {
			return false;
		}
	}

	public static void printOutPreOrderTree(TreeNode root) {
		if (root == null)
			return;

		System.out.println(root.val);
		printOutPreOrderTree(root.left);
		printOutPreOrderTree(root.right);
	}

	public static void main(String[] args) {

		BinarySearchTreeInsertNode bst = new BinarySearchTreeInsertNode();
		/*
		 * bst.addNode(1); // bst.addNode(1); bst.addNode(2); bst.addNode(5);
		 * bst.addNode(4); bst.addNode(3); bst.addNode(6);
		 */
		//this is invalid tree
		bst.root = new TreeNode(10);
		bst.root.left = new TreeNode(8);
		bst.root.right = new TreeNode(15);
		bst.root.left.left = new TreeNode(5);
		bst.root.left.right = new TreeNode(20);

		System.out.println(isBSTRecursive(bst.root));

		// printOutPreOrderTree(bst.root);
	}
}

	class TreeNode {
		int val;
		TreeNode left, right;
	
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	class BNode {
		TreeNode node;
		int left;
		int right;
	
		public BNode(TreeNode node, int left, int right) {
			this.node = node;
			this.left = left;
			this.right = right;
		}
	}

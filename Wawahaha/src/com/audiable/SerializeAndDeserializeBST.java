package com.audiable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SerializeAndDeserializeBST {

	private Node root;
	
	public static String serializeBstRecusive(Node root){
		StringBuilder sb = new StringBuilder();
		serializeBstHelper(root, sb);
		return sb.substring(0, sb.length()-1);
	}
	
	//recursive solution - preOrder
	public static void serializeBstHelper(Node root, StringBuilder sb){
		if(root == null){
			sb.append("null").append(",");
		}else{
			sb.append(root.value).append(",");
			serializeBstHelper(root.left, sb);
			serializeBstHelper(root.right, sb);
		}
	}
	
	public static Node deserializeRecursive(String data){
		Queue<String> nodes = new LinkedList<String>();
		nodes.addAll(Arrays.asList(data.split(",")));
		return buildTree(nodes);
	}
	
	public static Node buildTree(Queue<String> nodes){
		String val = nodes.poll();
		if(val.equals("null")){
			return null;
		}else{
			Node node = new Node(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}

	// non-recursive - preOrder traverse
	public String serializeBT(Node root) {

		if (root == null)
			return null;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Node n = stack.pop();
			if (n != null) {
				sb.append(n.value + ",");
				stack.push(n.right);
				stack.push(n.left);
			} else {
				sb.append("null,");
			}
		}

		return sb.toString().substring(0, sb.length() - 1);
	}
	
	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data == null)
			return null;

		int[] t = { 0 };
		String[] arr = data.split(",");

		return helper(arr, t);
	}

	public Node helper(String[] arr, int[] t) {
		if (arr[t[0]].equals("#")) {
			return null;
		}

		Node root = new Node(Integer.parseInt(arr[t[0]]));

		t[0] = t[0] + 1;
		root.left = helper(arr, t);
		t[0] = t[0] + 1;
		root.right = helper(arr, t);

		return root;
	}
	
	// An iterative process to print preOrder traversal of Binary tree
	static void  preorderTraveralIterative(Node node) {
        // Base Case
        if (node == null) {
            return;
        }
        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
 
        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child firstly, cause the stack is LIFO
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!stack.empty()) {
             
            // Pop the top item from stack and print it
            Node mynode = stack.pop();
            System.out.print(mynode.value + " ");
 
            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                stack.push(mynode.right);
            }
            if (mynode.left != null) {
                stack.push(mynode.left);
            }
        }
    }

	public static void main(String[] args) {

		SerializeAndDeserializeBST tree = new SerializeAndDeserializeBST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		//System.out.println(tree.serializeBT(tree.root));
		//preorderTraveralIterative(tree.deserialize(tree.serializeBT(tree.root)));
		
		String serializedStr = serializeBstRecusive(tree.root);
		System.out.println(serializedStr);
		Node node = deserializeRecursive(serializedStr);
		preorderTraveralIterative(node);
	}
}

class Node {
	int value;
	Node left, right;

	public Node(int val) {
		this.value = val;
		this.left = null;
		this.right = null;
	}

}
package com.jpchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Using the stack as the data structure to do the traversal because of the stack is LIFO
 * 
 * @author brianzhang
 *
 */
public class BinaryTreeTraversal {
	
	private Node root;
	List<Integer> result = new ArrayList<>();
	
	public void inorderTraversal(Node node){
		if(node == null){
			return;
		}
		
		inorderTraversal(node.left);
		System.out.println(node.value);
		inorderTraversal(node.right);
	}
	
	public void preorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		System.out.println(root.value);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	public void postorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.value);
	}
	
	/* stack process
			   1
			 2    3
		   4  5
	push stack : 1, 2 ,4
	output left sub-tree: start
	pop: 4, 2
	push: 5
	pop: 5
	output left sub-tree: end 
	pop: 1   - output the middle node (inOrder traversal)
	output right sub-tree: start
	push: 3
	pop: 3
	output right sub-tree: end
	
	DFS algorithm
	
	In-order
		1. Traverse the left subtree by recursively calling the in-order function.
		2. Display the data part of the root (or current node).
		3. Traverse the right subtree by recursively calling the in-order function.
	*/ 
	public void inorderTraveralIterative(Node root) {
        if(root == null)
            return; 
        Stack<Node> stack = new Stack<>();
        //define a pointer to track nodes
        Node p = root;
        while(!stack.isEmpty() || p != null){
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
                Node t = stack.pop();
                //list.add(t.value);
                System.out.println(t.value);
                p = t.right;
            }
        }
    }
	
	// An iterative process to print preOrder traversal of Binary tree
    void preorderTraveralIterative(Node node) {
        // Base Case
        if (node == null) {
            return;
        }
        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
 
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
    
    public void postorderTraversalIterative(Node root) {
     
        if(root==null) {
            return;
        }
     
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
     
        while(!stack.isEmpty()) {
            Node temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                Node pop = stack.pop();
                System.out.println(pop.value);
            }
            else 
            {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
     
                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
    }
	
	public static void main(String[] args){
		
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		//tree.preorderTraversal(tree.root);
		//tree.inorderTraversal(tree.root);
		//tree.inorderTraveralIterative(tree.root);
		tree.preorderTraveralIterative(tree.root);
		
		//tree.inorderTraversalLeetcode(tree.root);
		//for(Integer val : result){
			//System.out.println(val);
		//}
	}
}

class Node{
	int value;
	Node left, right;
	
	public Node(int val, Node left, Node right){
		this.value = val;
		this.left = left;
		this.right = right;
	}
	
	public Node(int value){
		this(value, null, null);
	}

}
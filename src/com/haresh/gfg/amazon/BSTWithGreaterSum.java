package com.haresh.gfg.amazon;

import com.haresh.gfg.amazon.BinarySearchTree1.Node;

/*
	Transform a BST to greater sum tree
	
	We strongly recommend to minimize the gbrowser and try this yourself first.
	
	Method 1 (Naive):
	This method doesn’t require the tree to be a BST. Following are steps.
	1. Traverse node by node(Inorder, preorder, etc.)
	2. For each node find all the nodes greater than that of the current node, sum the values. Store all these sums.
	3. Replace each node value with their corresponding sum by traversing in the same order as in Step 1.
	This takes O(n^2) Time Complexity.
	
	Method 2 (Using only one traversal)
	By leveraging the fact that the tree is a BST, we can find an O(n) solution. 
	The idea is to traverse BST in reverse inorder. Reverse inorder traversal of a BST gives us keys in decreasing order. 
	Before visiting a node, we visit all greater nodes of that node. 
	While traversing we keep track of sum of keys which is the sum of all the keys greater than the key of current node.
	
 */

class BSTWithGreaterSum1 {
	int sum;
	
	public BSTWithGreaterSum1() {
		this.sum = 0;
	}
	
	public void sumBST1(Node root) {
		if (root == null)
			return;
		
		// Recur for right subtree 
		sumBST1(root.right); 
	  
		// Update sum 
		this.sum = this.sum + root.data; 
	  
		// Store old sum in current node 
		root.data = this.sum - root.data; 
	  
		// Recur for left subtree 
		sumBST1(root.left);
	}
}

public class BSTWithGreaterSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree1 tree = new BinarySearchTree1();
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 31);
		
		tree.inOrder(tree.root);
		System.out.println();
		
		new BSTWithGreaterSum1().sumBST1(tree.root);
		
		tree.inOrder(tree.root);
	}

}

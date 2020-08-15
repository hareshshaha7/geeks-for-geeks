package com.haresh.gfg.amazon;

//Java program to demonstrate insert operation in binary search tree 
class BinarySearchTree1 {

	// Class containing left and right child of current node and key value
	public class Node {
		int data;
		Node left;
		Node right;
		Node(int d){
			data = d;
		}
	}
	
	// Root of BST 
	Node root;
	
	// Constructor 
    BinarySearchTree1() {  
        root = null;  
    } 
    
    // A recursive function to insert a new key in BST
	public Node insert(Node root, int data) {
		// If the tree is empty, return a new node
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		// Otherwise, recur down the tree
		if (root.data > data)
			root.left = insert(root.left, data);
		else 
			root.right = insert(root.right, data);
		
		// return the (unchanged) node pointer
		return root;
	}
	
	// A utility function to do inorder traversal of BST 
	public void inOrder(Node root) {
		if (root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);	
	}
	
}

public class BinarySearchTree{
	
	public static void main(String[] args) {
		BinarySearchTree1 tree = new BinarySearchTree1();
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 31);
		
		tree.inOrder(tree.root);
	}
}
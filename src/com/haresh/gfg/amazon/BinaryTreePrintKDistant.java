package com.haresh.gfg.amazon;

/*
 * Print nodes at k distance from root
 */

// Java program to print nodes at k distance from root 

/* A binary tree node has data, pointer to left child 
   and a pointer to right child */

public class BinaryTreePrintKDistant {

	// Class containing left and right child of current node and key value
	public static class Node {
		int data;
		Node left;
		Node right;
		Node(int d){
			data = d;
		}
	}
	
	Node root;

	void printKDistant(Node node, int k) {
		if (node == null)
			return;
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTreePrintKDistant tree = new BinaryTreePrintKDistant();

		/*
		 * Constructed binary tree is 
		 *     1 
		 *   /   \ 
		 *  2     3 
		 * / \   / 
		 *4   5 8
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printKDistant(tree.root, 2);
	}
}

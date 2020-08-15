package com.haresh.gfg.amazon;

/*
 * Print nodes at k distance from root
 */

// Java program to print nodes at k distance from root 

/* A binary tree node has data, pointer to left child 
   and a pointer to right child */

class Node1 {
	int data;
	Node1 left, right;

	Node1(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreePrintKDistant {
	Node1 root;

	void printKDistant(Node1 node, int k) {
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
		tree.root = new Node1(1);
		tree.root.left = new Node1(2);
		tree.root.right = new Node1(3);
		tree.root.left.left = new Node1(4);
		tree.root.left.right = new Node1(5);
		tree.root.right.left = new Node1(8);

		tree.printKDistant(tree.root, 2);
	}
}

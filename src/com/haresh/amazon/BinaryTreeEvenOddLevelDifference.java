package com.haresh.amazon;

/*
 	Difference between sums of odd level and even level nodes of a Binary Tree
	
	Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even level. 
	Consider root as level 1, left and right children of root as level 2 and so on.
 */

public class BinaryTreeEvenOddLevelDifference {
	Node root;
		
	// Driver program to test above functions 
    public static void main(String args[])  
    { 
        BinaryTreeEvenOddLevelDifference tree = new BinaryTreeEvenOddLevelDifference(); 
        /*
	         *    5
			    /   \
			   2     6
			 /  \     \  
			1    4     8
			    /     / \ 
			   3     7   9  
         */
        tree.root = new Node(5); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.left = new Node(3); 
        tree.root.right.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
        tree.root.right.right.left = new Node(7); 
        System.out.println(tree.evenOddLevelDifference(tree.root) + " is the required difference"); 
   
    }

	private int evenOddLevelDifference(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;	
		
		return root.data - evenOddLevelDifference(root.left) - evenOddLevelDifference(root.right);
	} 

}

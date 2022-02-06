package com.haresh.gfg.google;

/*
    Mirror Tree
    Easy Accuracy: 63.43% Submissions: 100k+ Points: 2

    Given a Binary Tree, convert it into its mirror.

    Example 1:
    Input:
              1
            /  \
           2    3
    Output: 3 1 2
    Explanation: The tree is
           1    (mirror)  1
         /  \    =>      /  \
        2    3          3    2
        The inorder of mirror is 3 1 2

    Example 2:
    Input:
              10
             /  \
            20   30
           /  \
          40  60
    Output: 30 10 60 20 40
    Explanation: The tree is
              10               10
            /    \  (mirror) /    \
           20    30    =>   30    20
          /  \                   /   \
         40  60                 60   40
        The inroder traversal of mirror is
        30 10 60 20 40.

    Your Task:
    Just complete the function mirror() that takes node as paramter  and convert it into its mirror. The printing is done by the driver code only.

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(Height of the Tree).

    Constraints:
        1 ≤ Number of nodes ≤ 105
        1 ≤ Data of a node ≤ 105
 */

/**
 * @author Haresh Shaha
 * @since 07-Feb-2022
 */
class Program01 {

    static class Node {
        private final int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        mirror(root);
        inOrder(root);
    }

    // Function to convert a binary tree into its mirror tree.
    public static void mirror(Node node) {
        // Your code here
        if (node != null) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            mirror(node.left);
            mirror(node.right);
        }
    }
}
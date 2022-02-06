package com.haresh.gfg.problemoftheday;

/*
    Postorder Traversal (Iterative)
    Medium Accuracy: 74.7% Submissions: 9137 Points: 4

    Given a binary tree. Find the postorder traversal of the tree without using recursion.

    Example 1
    Input:
               1
             /   \
            2     3
          /  \
         4    5

    Output: 4 5 2 3 1
    Explanation:
        Postorder traversal (Left->Right->Root) of
        the tree is 4 5 2 3 1.

    Example 2
    Input:
                 8
              /      \
            1          5
             \       /   \
              7     10    6
               \   /
                10 6

    Output: 10 7 1 6 10 6 5 8
    Explanation:
        Inorder traversal (Left->Right->Root)
        of the tree is 10 7 1 6 10 6 5 8 .

    Your task:
    You don't need to read input or print anything. Your task is to complete the function postOrder() which takes the root of the tree as input and returns a list containing the postorder traversal of the tree, calculated without using recursion.

    Expected time complexity: O(N)
    Expected auxiliary space: O(N)

    Constraints:
        1 <= Number of nodes <= 105
        1 <= Data of a node <= 105
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Haresh Shaha
 * @since 07-Feb-2022
 */
public class Program01 {

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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> list = postOrder(root);
        System.out.println(list);
    }

    public static ArrayList<Integer> postOrder(Node node) {
        // code here
        if (node == null)
            return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(node);

        while (!s.isEmpty()) {
            Node n = s.pop();
            list.add(n.data);
            if (n.left != null) {
                s.push(n.left);
            }
            if (n.right != null) {
                s.push(n.right);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

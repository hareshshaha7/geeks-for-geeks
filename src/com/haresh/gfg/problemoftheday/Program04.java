package com.haresh.gfg.problemoftheday;

/*
    Largest value in each level
    Easy Accuracy: 80.38% Submissions: 6325 Points: 2

    Given a binary tree, find the largest value in each level.

    Example 1:
    Input :
            1
           / \
          2   3
    Output : 1 3
    Explanation :
        There are two levels in the tree :
        1. {1}, max = 1
        2. {2, 3}, max = 3

    Example 2:
    Input :
            4
           / \
          9   2
         / \   \
        3   5   7
    Output : 4 9 7
    Explanation :
        There are three levels in the tree:
        1. {4}, max = 4
        2. {9, 2}, max = 9
        3. {3, 5, 7}, max=7

    Your task :
    You don't need to read input or print anything. Your task is to complete the function largestValues()
    which takes the root node of the tree as input and returns a vector containing the largest value in each level.

    Expected Time Complexity : O(n) , where n = number of nodes
    Expected Auxiliary Space : O(n) , where n = number of nodes

    Constraints : 1 ≤ Number of nodes ≤ 10^5
 */

import java.util.ArrayList;

/**
 * @author Haresh Shaha
 * @since 13-Feb-2022
 */
public class Program04 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        ArrayList<Integer> result = largestValues(root);
        System.out.println(result);
    }

    public static ArrayList<Integer> largestValues(Node root) {
        //code here
        ArrayList<Integer> result = new ArrayList<>();
        visitNodes(root, result, 0);
        return result;
    }

    public static void visitNodes(Node root, ArrayList<Integer> result, int level) {
        if (root == null)
            return;

        if (result.size() == level)
            result.add(root.data);
        else
            result.set(level, Math.max(root.data, result.get(level)));

        visitNodes(root.left, result, level + 1);
        visitNodes(root.right, result, level + 1);
    }
}

package com.haresh.gfg.problemoftheday;

/*
    [Medium] Merge K sorted linked lists
    https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1

    Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

    Example 1:
    Input:
    K = 4
    value = {{1,2,3},{4 5},{5 6},{7,8}}
    Output: 1 2 3 4 5 5 6 7 8
    Explanation:
        The test case has 4 sorted linked
        list of size 3, 2, 2, 2
        1st    list     1 -> 2-> 3
        2nd   list      4->5
        3rd    list      5->6
        4th    list      7->8
        The merged list will be
        1->2->3->4->5->5->6->7->8.

    Example 2:
    Input:
    K = 3
    value = {{1,3},{4,5,6},{8}}
    Output: 1 3 4 5 6 8
    Explanation:
        The test case has 3 sorted linked
        list of size 2, 3, 1.
        1st list 1 -> 3
        2nd list 4 -> 5 -> 6
        3rd list 8
        The merged list will be
        1->3->4->5->6->8.
    Your Task:
        The task is to complete the function mergeKList() which merges the K given lists into a sorted one.
        The printing is done automatically by the driver code.

    Expected Time Complexity: O(nk Logk)
    Expected Auxiliary Space: O(k)
    Note: n is the maximum size of all the k link list

    Constraints
        1 <= K <= 103
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Haresh Shaha
 * @since 07-Mar-2022
 */
public class Program08 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }
    }

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode mergeKLists = mergeKLists(lists);
        while (mergeKLists != null) {
            System.out.print(mergeKLists.val + " ");
            mergeKLists = mergeKLists.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                l.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        Collections.sort(l);
        ListNode node = head;
        for (Integer integer : l) {
            node.next = new ListNode(integer);
            node = node.next;
        }

        return head.next;

        // Slower Approach
//		for (int i = 1; i < lists.length; i++) {
//			lists[0] = mergeTwoList(lists[0], lists[i]);
//		}
//
//		return lists[0];
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode node = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        return head.next;
    }
}

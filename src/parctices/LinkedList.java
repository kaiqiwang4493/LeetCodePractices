package parctices;

import dataStructure.ListNode;

public class LinkedList {
	/*
	 * Reverse Linked List (iterative)
	 * 
	 * Reverse a singly-linked list iteratively.
	 */
	
	public ListNode reverseIterative(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode next;
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	
	/*
	 * Reverse Linked List (recursive)
	 * 
	 * Reverse a singly-linked list recursively.
	 */
	
	public ListNode reverseRecursive(ListNode head) {
		//base case
		if(head == null || head.next == null) {
			return head;
		}
		// new a ListNode to protect the new head of reversed linked list.
		ListNode newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	
	
	
}

package parctices;

import dataStructure.ListNode;

public class LinkedListPractices {

	public LinkedListPractices() {

	}

	/*
	 * Reverse Linked List (iterative)
	 * 
	 * Reverse a singly-linked list iteratively.
	 */

	public ListNode reverseIterative(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		ListNode next;
		while (cur != null) {
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
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		// new a ListNode to protect the new head of reversed linked list.
		ListNode newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	/*
	 * Insert In Sorted Linked List
	 * 
	 * Insert a value in a sorted linked list.
	 */

	public ListNode insert(ListNode head, int value) {
		if (head == null) {
			return new ListNode(value);
		}

		if (value < head.value) {
			ListNode temp = new ListNode(value);
			temp.next = head;
			return temp;
		}

		ListNode i = head;
		// notice the the bound of while loop.Not i != null. Because we have to check
		// the i.next.value
		while (i.next != null) {
			// find the position insert the new node
			if (i.value <= value && i.next.value > value) {
				ListNode newNode = new ListNode(value);
				newNode.next = i.next;
				i.next = newNode;
				return head;
			} else {
				i = i.next;
			}
		}
		ListNode newNode = new ListNode(value);
		i.next = newNode;
		return head;
	}

	/*
	 * ReOrder Linked List
	 * 
	 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
	 * to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
	 */
	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode mid = findMidNode(head);
		ListNode head2 = reverseIterative(mid.next);
		mid.next = null;
		ListNode newHead = mergeLinkedNode(head, head2);
		return newHead;
	}

	private ListNode findMidNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode mergeLinkedNode(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		while (cur1.next != null && cur2.next != null) {
			ListNode temp1 = cur1.next;
			ListNode temp2 = cur2.next;
			cur1.next = cur2;
			cur2.next = temp1;
			cur1 = temp1;
			cur2 = temp2;
		}
		// because the length of 2 Linked List is equal(total even) or shorter(total
		// odd) than 1 Linked List
		// when cur1.next == null, the cur2.next must be equal to null
		if (cur1.next == null) {
			cur1.next = cur2;
		} else {
			// cur2.next == null, cur1.next != null
			ListNode temp1 = cur1.next;
			cur1.next = cur2;
			cur2.next = temp1;
		}
		return head1;
	}

	/*
	 * Partition Linked List Given a linked list and a target value T, partition it
	 * such that all nodes less than T are listed before the nodes larger than or
	 * equal to target value T. The original relative order of the nodes in each of
	 * the two partitions should be preserved.
	 */

	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		int length = 0;
		ListNode temp = head;
		ListNode tail = temp;
		while (temp != null) {
			length++;
			tail = temp;
			temp = temp.next;
		}
		temp = head;
		ListNode pre = null;
		for (int i = 0; i < length; i++) {
			if (temp.value < target) {
				pre = temp;
				temp = temp.next;
			} else {
				if (temp == head) {
					head = head.next;
					tail.next = temp;
					temp.next = null;
					tail = tail.next;
					temp = head;
				} else {
					pre.next = temp.next;
					tail.next = temp;
					temp.next = null;
					tail = tail.next;
					temp = pre.next;
				}
			}
		}
		return head;
	}
}

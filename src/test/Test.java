package test;


import dataStructure.ListNode;
import parctices.LinkedListPractices;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for(int i = 7 ; i >0; i--) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		cur.next = new ListNode(4);
		cur = cur.next;
		cur.next = new ListNode(7);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(9);
		cur = cur.next;
		ListNode head = dummy.next;
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.value);
			temp = temp.next;
		}
		System.out.println();
		LinkedListPractices test = new LinkedListPractices();
		ListNode result = test.mergeSort(head);
		temp = result;
		while(temp != null) {
			System.out.print(temp.value);
			temp = temp.next;
		}
	}

}

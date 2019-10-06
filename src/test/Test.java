package test;


import java.util.ArrayDeque;
import java.util.Queue;

import dataStructure.ListNode;
import parctices.LinkedListPractices;
import parctices.QueueByTwoStacks;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueByTwoStacks qs = new QueueByTwoStacks();
		qs.offer(1);
		qs.offer(2);
		qs.offer(3);
		qs.offer(4);
		System.out.println(qs.peek());
		System.out.println(qs.poll());
		qs.offer(5);
		qs.offer(6);
		System.out.println(qs.peek());
		System.out.println(qs.poll());
		System.out.println(qs.poll());
		
		System.out.println();
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		queue.offer(5);
		queue.offer(6);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}

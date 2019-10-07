package test;


import java.util.ArrayDeque;
import java.util.Queue;

import dataStructure.ListNode;
import parctices.LinkedListPractices;
import parctices.QueueByTwoStacks;
import parctices.StackWithMinNode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMinNode minStack = new StackWithMinNode();
		System.out.println(minStack.pop());
		System.out.println(minStack.top());
		System.out.println(minStack.min());
		minStack.push(6);
		minStack.push(2);
		minStack.push(3);
		minStack.push(4);
		minStack.push(1);
		minStack.push(5);
		minStack.push(3);
		minStack.push(0);
		minStack.push(2);
		minStack.push(0);
		minStack.push(1);
		System.out.println(minStack.min()); // 0
		System.out.println(minStack.top()); // 1
		System.out.println(minStack.pop()); //1
		System.out.println(minStack.pop());  //0
		System.out.println(minStack.min());  //0
		System.out.println(minStack.pop());  //2
		System.out.println(minStack.pop());  //0
		System.out.println(minStack.top());  //3
		System.out.println(minStack.min());  //1
		
	}

}

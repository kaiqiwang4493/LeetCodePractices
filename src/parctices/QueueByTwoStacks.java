package parctices;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Queue By  Two Stacks
 * Implement a queue by using two stacks. 
 * The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
 * When the queue is empty, poll() and peek() should return null.
 */

public class QueueByTwoStacks {
	Deque<Integer> inStack;
	Deque<Integer> outStack;
	
	public QueueByTwoStacks() {
		this.inStack = new LinkedList<>();
		this.outStack = new LinkedList<>();
	}
	
	public Integer poll() {
		if(inStack.isEmpty()) {
			if(outStack.isEmpty()) {
				return null;
			}
		}
		//move the bottom of element at inStack to the top of outStack.
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
		
		Integer result = outStack.pop();
		
		while(!outStack.isEmpty()) {
			inStack.push(outStack.pop());
		}
		return result;
	}
	
	public void offer(int element) {
		inStack.push(element);
	}
	
	public Integer peek() {
		if(inStack.isEmpty()) {
			if(outStack.isEmpty()) {
				return null;
			}
		}
		//move the bottom of element at inStack to the top of outStack.
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
		
		Integer result = outStack.peek();
		
		while(!outStack.isEmpty()) {
			inStack.push(outStack.pop());
		}
		
		return result;
	}
	
	public int size() {
		return inStack.size() + outStack.size();
	}
	
	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
}

package parctices;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMinNode {
	/*
	 * Stack With min()
	 * 
	 * Enhance the stack implementation to support min() operation. 
	 * min() should return the current minimum value in the stack. 
	 * If the stack is empty, min() should return -1.
	 * 
	 * push(int element) - push the element to top
	 *pop() - return the top element and remove it, if the stack is empty, return -1
	 *top() - return the top element without remove it, if the stack is empty, return -1
	 *min() - return the current min value in the stack.
	 */
	
	Deque<Integer> stack;
	Deque<Integer> minStack;
	
	public StackWithMinNode() {
		this.stack = new ArrayDeque<>();
		this.minStack = new ArrayDeque<>();
	}
	
	public void push(int element) {
		if(stack.size() == 0 || element < minStack.peek()) {
			stack.push(element);
			minStack.push(element);
		}else  {
			stack.push(element);
			minStack.push(minStack.peek());
		}
	}
	
	public int pop() {
		if(stack.size() == 0) {
			return -1;
		}
		minStack.pop();
		return stack.pop();
	}
	
	public int top() {
		if(stack.size() == 0) {
			return -1;
		}
		return stack.peek();
	}
	
	public int min() {
		if(stack.size() == 0) {
			return -1;
		}
		return minStack.peek();
	}
}

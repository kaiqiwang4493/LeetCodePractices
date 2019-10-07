package parctices;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
	// stack1 contains the front part of Deque.
	// stack2 contains the rear part of Deque.
	// stack3 is not been used
	Deque<Integer> stack1;
	Deque<Integer> stack2;
	Deque<Integer> stack3;
	
	public DequeByThreeStacks() {
		this.stack1 = new ArrayDeque<>();
		this.stack2 = new ArrayDeque<>();
		this.stack3 = new ArrayDeque<>();
	}
	
	public void offerFirst(int element) {
		stack2.push(element);
		return;
	}
	
	public void offerLast(int element) {
		stack1.push(element);
	}
	
	public Integer pollFirst() {
		if(stack2.isEmpty()) {
			if(!stack1.isEmpty()) {
				transfer(stack1, stack2);
			}else {
				return null;
			}
			return stack2.pop();
		}
		return stack2.pop();
	}
	
	public Integer pollLast() {
		if(stack1.isEmpty()) {
			if(!stack2.isEmpty()) {
				transfer(stack2, stack1);
			}else {
				return null;
			}
			return stack1.pop();
		}
		return stack1.pop();
	}
	
	public Integer peekFirst() {
		if(stack2.isEmpty()) {
			if(!stack1.isEmpty()) {
				transfer(stack1, stack2);
			}else {
				return null;
			}
			return stack2.peek();
		}
		return stack2.peek();
	}
	
	public Integer peekLast() {
		if(stack1.isEmpty()) {
			if(!stack2.isEmpty()) {
				transfer(stack2, stack1);
			}else {
				return null;
			}
			return stack1.peek();
		}
		return stack1.peek();
	}
	
	public int size() {
		return stack1.size() + stack2.size();
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	private void transfer(Deque<Integer> source, Deque<Integer> target) {
		if(source == null || source.size() == 0) {
			return;
		}
		while(!source.isEmpty()) {
			target.push(source.pop());
		}
	}
}

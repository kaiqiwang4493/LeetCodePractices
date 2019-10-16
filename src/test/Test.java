package test;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;


import dataStructure.ListNode;
import parctices.DFS;
import parctices.LinkedListPractices;
import parctices.QueueByTwoStacks;
import parctices.StackWithMinNode;

public class Test {

	public static void main(String[] args) {
		DFS dfs = new DFS();
		List<List<Integer>> result = dfs.getFactors(12);
		for(List<Integer> i : result) {
			System.out.println(i);
		}
	}

}

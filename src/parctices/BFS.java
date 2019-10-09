package parctices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import dataStructure.TreeNode;

public class BFS {
	
	/*
	 * K Smallest In Unsorted Array
	 * 
	 * Find the K smallest numbers in an unsorted integer array A. 
	 * The returned numbers should be in ascending order.
	 */
	// use PriorityQueue to sort the array
	public int [] KSmallest(int[] array, int k) {
		if(k == 0) {
			return null;
		}
		List<Integer> temp = new ArrayList<>();
		for(int num : array) {
			temp.add(num);
		}
		 int[] result = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<>(temp);
		for(int i = 0; i < k; i++) {
			result[i] = pq.poll();
		}
		return result;
	}
	
	
	
	/*
	 * Check If Binary Tree Is Completed
	 * 
	 * Check if a given binary tree is completed. 
	 * 
	 * A complete binary tree is one in which every level of 
	 * the binary tree is completely filled except possibly the last level.
	 * 
	 * Furthermore, all nodes are as far left as possible.
	 * 
	 * use a Queue to traverse the tree level by level.
	 * if we find any node following a null node
	 * we can say the tree is not a completed tree
	 */
	public boolean isCompleted(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		//false means does not meet any null node.
		// true means has meet the null node.
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp.left != null) {
				if(!flag) {
					queue.add(temp.left);
				}else {
					return false;
				}
				
			}else {
				flag = true;
			}
			if(temp.right != null) {
				if(!flag) {
					queue.add(temp.right);
				}else {
					return false;
				}
			}else {
				flag = true;
			}
		}
		return true;
	}
	
	/*
	 * Kth Smallest Number In Sorted Matrix
	 * 
	 * Given a matrix of size N x M. 
	 * For each row the elements are sorted in ascending order, 
	 * and for each column the elements are also sorted in ascending order. 
	 * Find the Kth smallest number in it.
	 */
	
	
}

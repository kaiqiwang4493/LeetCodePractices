package parctices;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
	
}

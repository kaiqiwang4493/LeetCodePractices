package parctices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

	
	/*
	 * 3 Sum solution 2
	 * use two pointers to 
	 */
	public List<List<Integer>> allTriples2(int[] array, int target){
		List<List<Integer>> result = new ArrayList<>();
		// because use the array[i] and array[i - 1] to check whether the two elements are duplicated.
		// so the array must be sorted
		Arrays.sort(array);
		for(int i = 0; i < array.length; i++) {
			// to prevent the duplicated element
			if(i > 0 && array[i] == array[i - 1]) {
				continue;
			}else {
				int left = i + 1;
				int right = array.length - 1;
				while(left < right) {
					int temp = array[left] + array[right];
					if(temp + array[i] == target) {
						result.add(Arrays.asList(array[i], array[left], array[right]));
						left++;
						// meet the duplicated element
						while(left < right && array[left] == array[left - 1]) {
							left++;
						}
					}else if(temp + array[i] < target) {
						// The array is sorted, so we can use the comparison of target and the sum 
						//to move the left or right index
						left++;
					}else {
						right--;
					}
				}
			}
		}
		return result;
	}
	
	/*
	 * 4 Sum
	 * Determine if there exists a set of four elements in a given array that sum to the given target number.
	 * 
	 * Assumptions
	 * The given array is not null and has length of at least 4
	 */
	
	public boolean exist4sum(int[] array, int target) {
		Arrays.sort(array);
		for(int i = 0; i < array.length - 3; i++) {
			for(int j = i + 1; j < array.length - 2; j++) {
				int left = j + 1;
				int right = array.length - 1;
				while(left < right) {
					int temp = array[i] + array[j] + array[left] + array[right];
					if(target == temp) {
						return true;
					}else if(target > temp){
						left++;
					}else {
						right--;
					}
				}
			}
		}
		return false;
	}
}

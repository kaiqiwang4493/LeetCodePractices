package parctices;

public class RecursionalAndSorting {
	/*
	 * Selection Sort
	 * Given an array of integers, sort the elements in the array in ascending order.
	 * The selection sort algorithm should be used to solve this problem.
	 * 
	 */
		
	public int[] solve(int[] array) {
		if(array == null || array.length == 1) {
			return array;
		}
		int right = array.length - 1;
		while(right > 0) {
			int temp = biggest(array, 0, right);
			swap(array, right, temp);
			right--;
		}
		return array;
	}
	
	private int biggest(int[] array, int left, int right) {
		int max = right;
		for(int i = 0; i < right; i++) {
			if(array[i] > array[max]) {
				max = i;
			}
		}
		return max;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}

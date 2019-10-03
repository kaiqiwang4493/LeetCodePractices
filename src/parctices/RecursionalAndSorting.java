package parctices;

public class RecursionalAndSorting {
	/*
	 * Selection Sort
	 * Given an array of integers, sort the elements in the array in ascending order.
	 * The selection sort algorithm should be used to solve this problem.
	 * 
	 */
	public 	RecursionalAndSorting(){
		
	}
	
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
	
	/*
	 * Merge Sort
	 * Given an array of integers, sort the elements in the array in ascending order. 
	 * The merge sort algorithm should be used to solve this problem.
	 * 
	 */
	
	public int[] mergeSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		// directly change the values in original array
		 mergeSortHelp(array, 0, array.length - 1);
		 return array;
	}
	
	private void mergeSortHelp(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		
		int mid = left + (right - left) / 2;
		mergeSortHelp(array, left, mid);
		mergeSortHelp(array, mid + 1, right);
		
		// merge two sorted array
		// new a helper array to save the original order of array.
		// and we change the value at the original array.
		// the helper array length must be array.length, since the index i , j , cur is the original index,
		// if the helper array length is right-left+1, the index will out of the bound.
		int[] helper = new int[array.length];
		int i = left;
		int j = mid + 1;
		int cur = left;
		for(int k = left; k<= right; k++) {
			helper[k] = array[k];
		}
		while(i <= mid && j <= right) {
			// copy the smaller value 
			if(helper[i] <= helper[j]) {
				array[cur] = helper[i];
				i++;
			}else {
				array[cur] = helper[j];
				j++;
			}
			cur++;
		}
		// if there are left part element not be copy to array, copy them.
		// do not have to consider the right part elements, because them have been copied before merge.
		while(i <= mid) {
			array[cur] = helper[i];
			cur++;
			i++;
		}
		
	}
	
	
	/*
	 * Quick Sort 1 (Lomuto's Partition - two pointers start from left end, and move to same direction)
	 * Given an array of integers, sort the elements in the array in ascending order. 
	 * The quick sort algorithm should be used to solve this problem.
	 */
	
	public int[] quickSort1(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		partition1(array, 0, array.length - 1);
		return array;
	}
	
	// left side of index i (include i) includes the values <= pivot
	// the pace between i and j(not include j) includes the values > pivot
	// the array[j] is the element should be checked.
	private void partition1(int [] array, int left, int right) {
		//base case
		if(left >= right) {
			return;
		}
		int i = left - 1;
		int j = left;
		int pivot = array[right];
		while(j < right) {
			if(array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
			j++;
		}
		swap(array, i + 1, right);
		// the pivot neither included in left nor right side.
		partition1(array, left, i);
		partition1(array, i + 2 , right);
	}
	
	
	
	/*
	 * Quick Sort 1 (Hoare Partition - two pointers start from both end, and move to then middle of array)
	 * Given an array of integers, sort the elements in the array in ascending order. 
	 * The quick sort algorithm should be used to solve this problem.
	 */
	public int[] quickSort2(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		partition2(array, 0, array.length - 1);
		return array;
	}
	
	// left side of index l(not include l) includes the elements <= pivot
	// right side of index r(not include r) includes the elements > pivot
	// so when l and r are overlapped, we must to check the array[l](array[r])
	private void partition2(int[] array, int left, int right) {
		//base case
		if(left >= right) {
			return;
		}
		
		int l = left;
		int r = right - 1;
		int pivot = array[right];
		while(l <= r) {
			if(array[l] <= pivot) {
				l++;
			}else if(array[r] > pivot) {
				r--;
			}else {
				swap(array, l, r);
				l++;
				r--;
			}
		}
		swap(array, l, right);
		partition2(array, left, l - 1);
		partition2(array, l + 1, right);
	}
	
	/*
	 * Rainbow Sort
	 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
	 * sort the balls such that all the Red balls are grouped on the left side, 
	 * all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
	 * (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
	 * 
	 * Assumption
	 * The input array is not null.
	 */
	public int[] rainbowSort(int[] array) {
		if(array.length <= 1) {
			return array;
		}
		//[0,i) is the area of -1
		//[i k] is the area of 0
		//(k, array.length - 1] is the area of 1
		// array[j] is the element should be checked
		int i = 0;
		int j = 0;
		int k = array.length - 1;
		while(j <= k) {
			if(array[j] == -1) {
				swap(array, i, j);
				i++;
				j++;
			}else if(array[j] == 1){
				swap(array, j, k);
				k--;
			}else {
				j++;
			}
		}
		return array;
	}
	
	/*
	 * Counting Sort
	 * 
	 * Assumption
	 * the input is nonnegative Integer. 
	 */
	
	public int[] countingSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int[] count = new int[10];
		for(int i = 0; i< 10; i++) {
			count[i] = 0;
		}
		
		// store count of each character 
		for(int i = 0 ; i < array.length; i++) {
			count[array[i]]++;
		}
		
		//change count[i] 
		// the count[i] contains actual position of this character in output array
		for(int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		//build the output array
		// move the elements from array to output 
		// we want to keep the order of elements
		int [] output = new int[array.length + 1];
		for(int i = array.length - 1; i >= 0; i--) {
			output[count[array[i]]] = array[i];
			--count[array[i]];
		}
		
		//transfer the sorted from output to array
		// because the count[array[i]] contains the number of the values
		// so there is no zero in count
		// the first value in output is start from output[1]
		if(count[0] == 0) {
			for(int i = 1; i < output.length; i++) {
				array[i - 1] = output[i];
			}
		}else {
			// if there is zero value in array and count
			for(int i = 0; i < output.length; i++) {
				array[i] = output[i];
			}
		}
		
		return array;
	}
}

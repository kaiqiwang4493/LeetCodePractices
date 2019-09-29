package parctices;

public class BinarySearch {
	
	/*
	 * Search In Sorted Matrix 1
	 * 
	 * Given a 2D matrix that contains integers only, 
	 * which each row is sorted in an ascending order. 
	 * The first element of next row is larger than (or equal to) the last element of previous row.
	 * Given a target number, returning the position that the target locates within the matrix. 
	 * If the target number does not exist in the matrix, return {-1, -1}.
	 * 
	 * The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
	 */
	public int[] searchInSortedMatrix1(int[][] matrix, int target) {
		//base case, the input matrix is empty.
		if(matrix.length ==0 || matrix[0].length == 0) {
			return new int[] {-1,-1};
		}
		//all elements are larger than target
		if(matrix[0][0] > target) {
			return new int[]  {-1, -1};
		}
		//find the index of row.
		int row =matrix.length - 1;
		for(int i = 0; i < matrix.length; i++) {
			// find the target at the first element of the row
			if(matrix[i][0] == target) {
				return new int[] {i, 0};
			}
			else if(matrix[i][0] > target) {
				row = i - 1;
				break;
			}
		}
		//find the column at the row.
		for(int i = 0; i < matrix[row].length; i++) {
			if(matrix[row][i] == target) {
				return new int[] {row, i};
			}
		}
		// do not find the target in matrix.
		return new int[] {-1, -1};
	}
	// an other way to solve the problem, change the matrix to 1D array.
	public int[] searchInSortedMatrix2(int[][] matrix, int target) {
		//base case
		int[] result = new int[] {-1, -1};
		if(matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		// treat the matrix as a array, then use binary search.
		int n = matrix.length;
		int m = matrix[0].length;
		int left = 0;
		int right = n * m - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			// transfer 1D index to 2D index, and compare the element and target
			if(target < matrix[mid/m][mid%m]) {
				right = mid - 1;
			}else if(target > matrix[mid/m][mid%m]) {
				left = mid + 1;
			}else {
				result[0] = mid/m;
				result[1] = mid%m;
				return result;
			}
		}
		return result;
	}
	
	
	/*
	 * K Closest In Sorted Array
	 * Given a target integer T, 
	 * a non-negative integer K and an integer array A sorted in ascending order, 
	 * find the K closest numbers to T in A.
	 * 
	 * Assumptions:
	 * A is not null
	 * K is guaranteed to be >= 0 and K is guaranteed to be <= A.length
	 */
	public int[] KClosest(int[] array, int target, int k) {
		//base case
		if(array == null || array.length == 0) {
			return array;
		}
		if(k == 0) {
			return new int[] {0};
		}
		// binary search to find the two closest elements.
		int left = 0;
		int right = array.length;
		while(right - left > 1) {
			int mid = left +(right - left) / 2;
			if(target < array[mid]) {
				right = mid;
			}else if(target > array[mid]){
				left = mid;
			}else {
				right = mid;
				left = mid;
			}
		}
		int[] result = new int[k];
		for(int i = 0; i< k; i++){
			if(left == right) {
				result[i] = array[left];
				if(left > 0) {
					left--;
				}
				if(right < array.length - 1) {
					right++;
				}
			}else {
				if(Math.abs(array[left]- target) < Math.abs(array[right] - target)) {
					result[i] = array[left];
					
				}
			}
			
			
		}
	}
	
	
	
	
	
	
	
}

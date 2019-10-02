package test;

import parctices.RecursionalAndSorting;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {5,4,3,2,2};
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		RecursionalAndSorting sort = new RecursionalAndSorting();
		int[] result = sort.countingSort(array);
		System.out.println();
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

}

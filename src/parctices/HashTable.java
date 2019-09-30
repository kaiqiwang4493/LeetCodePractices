package parctices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashTable {

	/*
	 * 2 Sum
	 * Determine if there exist two elements in a given array, 
	 * the sum of which is the given target number.
	 * 
	 * Assumptions
	 * The given array is not null and has length of at least 2
	 */
	
	public boolean existSum(int[] array, int target) {
		// Use a set save the elements that has been checked.
		Set<Integer> set = new HashSet<>();
		for(int num : array) {
			if(set.contains(target - num)) {
				return true;
			}else {
				set.add(num);
			}
		}
		return false;
	}
	
	/*
	 * 2 Sum All Pair I
	 * Find all pairs of elements in a given array that sum to the given target number. 
	 * Return all the pairs of indices.
	 * 
	 * Assumption
	 * The given array is not null and has length of at least 2.
	 * 
	 * Caution:
	 * There are the duplicate element in the array
	 */
	
	public List<List<Integer>> allPairs(int[] array, int target){
		// Use a map to record the element.
		// key is the number of element
		// value is a list to record all index of the element
		Map<Integer,List<Integer>> map = new HashMap<>();
		// final result.
		List<List<Integer>> finalResult = new ArrayList<>();
		for(int i  = 0; i<array.length; i++) {
			List<Integer> result = map.get(target - array[i]);
			// if we find two element, they are sum equal target
			if(result != null) {
				for(int j : result) {
					// we need add all possible pairs. 
					// Must to consider the duplicate element. 
					finalResult.add(Arrays.asList(j, i));
				}
			}
			// Whether the map include the array[i]
			// Add the element if not.
			if(!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			// add the array[i] into the map, 
			map.get(array[i]).add(i);
			
		}
		return finalResult;
	}
	
	/*
	 * 3 Sum
	 * Determine if there exists three elements in a given array that sum to the given target number. 
	 * Return all the triple of values that sums to target.
	 * 
	 * Assumption
	 * The given array is not null and has length of at least 3
	 * No duplicate triples should be returned, order of the values in the tuple does not matter
	 */
	// I change the 3 sum question to find 2 sum pairs in the array except array[i].
	// And the new target is target - array[i]
	public List<List<Integer>> allTriples(int[] array, int target){
		List<List<Integer>> finalResult = new ArrayList<>();
		
		for(int i = 0; i < array.length - 2; i++) {
			//find the all 2 sum pairs 
			List<List<Integer>> temp = twoPairs(array, i, array.length - 1, target - array[i]);
			// add index i into the pairs of two sum.
			for(List<Integer> j : temp) {
				j.add(array[i]);
				finalResult.add(j);
			}
		}
		return finalResult;
	}
	
	private List<List<Integer>> twoPairs(int[] array, int left, int right, int target){
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> finalResult = new ArrayList<>();
		for(int i  = left; i <= right; i++) {
			if(map.containsKey(target - array[i])) {
				// prevent the duplicate,because the combination is unique, if the number has been added into the result
				// it is impossible the number adds with a different number equal to target.
				// example, 3 + 5 = 8, if the value of key==3 is 2, which prove that there is a 5 exist before this 5.
				// And the former 5 has been added into answer.
				if(map.get(target - array[i]) == 2) {
					continue;
				}else {
					finalResult.add(Arrays.asList(array[i], target - array[i]));
					map.put(target - array[i], 2);
				}
			}
			if(!map.containsKey(array[i])) {
				map.put(array[i], 1);
			}
		}
		return finalResult;
	}
}

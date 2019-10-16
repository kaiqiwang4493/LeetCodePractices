package parctices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
	
	// All the time complexity must be x^n. x could be different number(2, n~~)
	
	/*
	 * All Subsets I
	 * Basic DFS - 1
	 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
	 * 
	 * use the basic method for DFS, first go to the deepest and left node(abc), then remove the last letter(ab)
	 * then execute the method again.
	 * 
	 * Time= 2^n. the last level has 2^n nodes.
	 */
	
	public List<String> subSets(String set){
		List<String> result = new ArrayList<>();
		if(set == null) {
			return result;
		}
		char[] array = set.toCharArray();
		// create a StringBuilder to save the temporary result
		StringBuilder builder = new StringBuilder();
		int index = 0;
		subSetsHelper(array,index,builder,result);
		return result;
	}
	
	private void subSetsHelper(char[] array, int index, StringBuilder builder, List<String> result) {
		if(index == array.length) {
			result.add(builder.toString());
			return;
		}
		// add char in to StringBuilder
		builder.append(array[index]);
		subSetsHelper(array,index + 1, builder, result);
		// delete the last char e.g: abc->ab and step into next recursion.
		builder.deleteCharAt(builder.length() - 1);
		subSetsHelper(array,index + 1, builder, result);
	}
	
	/*
	 * All Valid Permutations Of Parentheses I
	 * Basic DFS - 2
	 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
	 *  this is similar with the All Subsets question.
	 *  
	 *   
	 */
	public List<String> validParentheses(int n){
		List<String> result = new ArrayList<>();
		// the number of left and right parentheses.
		int left = 0;
		int right = 0;
		StringBuilder sb = new StringBuilder();
		vaildParenthesesHelper(sb, left, right, n, result);
		return result;
	}
	
	private void vaildParenthesesHelper(StringBuilder sb, int left, int right, int n, List<String> result) {
		if(left == n && right == n) {
			result.add(sb.toString());
		}
		
		if(left < n) {
			sb.append('(');
			vaildParenthesesHelper(sb, left + 1, right, n, result);
			sb.deleteCharAt(sb.length()-1);
		}
		// it is wrong that number of right parentheses more than the number of left  parentheses.
		// this line the important different compare with previous question.
		if(right < left) {
			sb.append(')');
			vaildParenthesesHelper(sb, left, right + 1, n, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	/*
	 * Combinations Of Coins
	 * Basic DFS - 3
	 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
	 * get all the possible ways to pay a target number of cents.
	 * 
	 * time = O(target / smallest coin denomination)^coins.length.
	 */
	
	public List<List<Integer>> combinations(int target, int[] coins){
		List<List<Integer>> finalResult = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if(target == 0 || coins.length == 0){
			return finalResult;
		}
		// use sum to record the sum of coins add in temporary result.
		int index = 0;
		combinationsHelper(finalResult, temp ,index, target, coins);
		return finalResult;
	}
	
	private void combinationsHelper(List<List<Integer>> finalResult, List<Integer> temp, int index, int target, int[] coins) {
		if(index == coins.length - 1) {
			// if target % coins[index] == 0, we find one answer
			// else, this combination is not existing.
			if(target % coins[index] == 0) {
				temp.add(target /coins[index]);
				finalResult.add(new ArrayList<Integer>(temp));
				temp.remove(temp.size() - 1);
				// must to add remove() at the each level has add()
			}
			return;
		}
		// to find out the possible number for coins except smallest one.
		// each loop add one on the number of coins without the last unit.
		//this method will check the combination consist on smallest coins firstly.
		// then increase the number of larger denomination coins.
		for(int i = 0; (i* coins[index]	<= target); i++) {
			temp.add(i);
			combinationsHelper(finalResult, temp, index + 1, target - (i * coins[index]), coins);
			temp .remove(temp.size() - 1);
		}
	}
	
	/*
	 * All Permutations I
	 * Basic DFS - 4
	 * 
	 * Given a string with no duplicate characters, return a list with all permutations of the characters.
	 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
	 * 
	 * the key method is swap the different position letter. Do not use the add and delete method like previous questions.
	 * swap- swap way is used for the questions that requires all elements must be existing in the result.
	 * 
	 * level0( 0 swap with other elements) :          swap(0.0)             swap(0,1)             swap(0, 2)
	 * level1( 1 swap with other elements):      swap(1,1)   swap(1,2)   swap(1,1)  swap(1,2)  swap(1,1)  swap (1,2)
	 * level2( 2 swap with other elements- itself):
	 * each swap must be start from index. 
	 * time = O(3*2*1) = n!
	 */
	public List<String> permutations(String set){
		List<String> result = new ArrayList<>();
		// record depth of recursion.
		int level = 0;
		char[] array = set.toCharArray();
		permutationsHelper(array, level, result);
		return result;
	}
	
	private void permutationsHelper(char[] array, int level, List<String> result) {
		if(level == array.length) {
			result.add(new String(array));
			return;
		}
		for(int i = level; i < array.length; i++) {
			// swap two letter position, like the step of append in the previous questions.
			swap(array, level, i);
			permutationsHelper(array, level + 1, result);
			// we have to swap two letters back. like the step of delete in previous questions
			swap(array, level, i);
		}
	}
	
	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	/*
	 * All Subsets II
	 * 
	 * Given a set of characters represented by a String, return a list containing all subsets of the characters. 
	 * Notice that each subset returned will be sorted to remove the sequence.
	 */
	
	public List<String> subSets2(String set){
		List<String> result = new ArrayList<>();
		if(set == null) {
			return result;
		}
		if(set.length() == 0) {
			result.add("");
			return result;
		}
		
		char[] array = set.toCharArray();
		Arrays.sort(array);
		int index = 0;
		StringBuilder temp = new StringBuilder();
		subSet2Helper(array, result,temp, index);
		return result;
	}
	
	private void subSet2Helper(char[] array, List<String> result,StringBuilder temp, int index) {
		if(index == array.length) {
			result.add(temp.toString());
			return;
		}
		
		temp.append(array[index]);
		subSet2Helper(array, result, temp, index + 1);
		temp.deleteCharAt(temp.length() - 1);
		// skip the duplicated element in the array.
		//CAUTION: index < array.length - 1 not < array.length. Because we need dereference array[index + 1]
		while(index < array.length - 1 && array[index + 1] == array[index]) {
			index++;
		}
		subSet2Helper(array, result, temp, index + 1);
	}
	
	
	/*
	 * All Subsets of Size K
	 * Given a set of characters represented by a String, 
	 * return a list containing all subsets of the characters whose size is K.
	 * 
	 * we find all subsets like All Subsets I. And we just need check the subset length before adding into result.
	 */
	
	public List<String> subSetsOfSizeK(String set ,int k){
		List<String> result = new ArrayList<>();
		char[] array = set.toCharArray();
		int index = 0;
		StringBuilder temp = new StringBuilder();
		
		subSetsOfSizeKHelper(array, temp, result,index, k);
		return result;
	}
	
	private void subSetsOfSizeKHelper(char[] array, StringBuilder temp, List<String> result, int index, int k) {
		if(index == array.length) {
			// we need check the length of subsets,only the length == k is ok.
			if(temp.length() == k) {
				result.add(temp.toString());
			}
			return;
		}
		
		temp.append(array[index]);
		subSetsOfSizeKHelper(array, temp, result, index + 1, k);
		temp.deleteCharAt(temp.length() - 1);
		subSetsOfSizeKHelper(array, temp, result, index + 1, k);	
	}
	
	/*
	 * Factor Combinations(coins)
	 * Given an integer number, return all possible combinations of the factors that can multiply to the target number.
	 * 
	 * find the factors first( find the all denominations of coins)
	 * combine the different factors.
	 * 
	 * This coding has some problem. 
	 */
	
//	public List<List<Integer>> factorCombinations(int target){
//		List<List<Integer>> result = new ArrayList<>();
//		List<Integer> quotient = new ArrayList<>();
//		//find the factors
//		List<Integer> factorList = new ArrayList<>();
//		for(int i  = 2; i < target ; i++) {
//			if(target % i == 0) {
//				factorList.add(i);
//			}
//		}
//		
//		int index = 0;
//		factorCombinationsHelper(result, quotient, factorList, index, target);
//		return result;	
//	}
//	
//	private void factorCombinationsHelper(List<List<Integer>> result, List<Integer> quotient, List<Integer> factorList, int index, int target) {
//		if(index == factorList.size() - 1) {
//			if(target == 1) {
//				quotient.add(0);
//				makeTheResult(result, quotient, factorList);
//				quotient.remove(quotient.size()- 1);
//			}else if(target % factorList.get(index) == 0) {
//				quotient.add(target / factorList.get(index));
//				makeTheResult(result, quotient, factorList);
//				quotient.remove(quotient.size()- 1);
//			}
//			return;
//		}
//		
//		for(int i = 0; i * factorList.get(index) < target; i++) {
//			quotient.add(i);
//			if(i == 0) {
//				factorCombinationsHelper(result, quotient, factorList, index + 1, target);
//			}else {
//				factorCombinationsHelper(result, quotient, factorList, index + 1, target/(factorList.get(index) * i));
//			}
//			quotient.remove(quotient.size() - 1);
//		}
//	}
//	
//	private void makeTheResult(List<List<Integer>> result, List<Integer> quotient, List<Integer> factorList) {
//		// records the temporary result.
//		List<Integer> preResult = new ArrayList<>();
//		for(int i = 0; i < quotient.size(); i++) {
//			if(quotient.get(i) >1) {
//				preResult.add(quotient.get(i));
//				preResult.add(factorList.get(i));
//			}else if(quotient.get(i) == 1){
//				preResult.add(factorList.get(i));
//			}else {
//				continue;
//			}
//		}
//		result.add(preResult);
//	}
	
	
	/*
	 * Factor Combinations(coins)
	 * this method is getting from leetcode
	 * 
	 * The index cannot be used in this question. In this recursion tree, the number of branch and layer is dynamic.
	 * So we cannot use the index to decide the number of layers has. Only comparing the value of product and target.
	 * 
	 * Because this problem is about multiply, so we should not update target in to next recursion. 
	 * Updating the value of product, and comparing the product and factor with target to know should I stop increase factor.
	 */
	
	public List<List<Integer>> getFactors(int target){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		getFactorsHelper(result, temp, 2, 1, target);
		return result;
	}
	
	private void getFactorsHelper(List<List<Integer>> result, List<Integer> temp, int start, int product, int target) {
		if(start > target || product > target) {
			return;
		}
		if(product == target) {
			ArrayList<Integer> t = new ArrayList<>(temp);
			result.add(t);
			return;
		}
		for(int i = start; i<target; i++) {
			// the i is too large, and the product is larger than target. Then we do not need continue increase i.
			if(i * product > target) {
				break;
			}
			// the i is one of factors of target,then add it in temp,
			if( target % i == 0) {
				temp.add(i);
				// use this factors as a new start, to find the next factor.And we need update the product.
				getFactorsHelper(result, temp, i, i*product, target);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	/*
	 * Factor Combinations(solution2)
	 * the way to update target
	 */
	public List<List<Integer>> getFactors2(int target){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		getFactorsHelper2(result, temp, 2, target);
		return result;
	}
	
	private void getFactorsHelper2(List<List<Integer>> result, List<Integer> temp, int start, int target) {
		if(target == 1) {
			// avoid the answer just includes the target itself.
			if(temp.size() == 1) {
				return;
			}else {
			ArrayList<Integer> t = new ArrayList<>(temp);
			result.add(t);
			return;}
			
		}
		for(int i = start; i<=target; i++) {
			// the i is one of factors of target,then add it in temp,
			if( target % i == 0) {
				temp.add(i);
				// use this factors as a new start, to find the next factor.And we need update the target.
				getFactorsHelper2(result, temp, i, target / i);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	
}

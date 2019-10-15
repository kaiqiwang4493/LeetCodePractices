package parctices;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	/*
	 * All Subsets I
	 * 
	 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
	 * 
	 * use the basic method for DFS, first go to the deepest and left node(abc), then remove the last letter(ab)
	 * then execute the method again.
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
	 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
	 *  this is similar with the All Subsets quesiton.
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
		if(right < left) {
			sb.append(')');
			vaildParenthesesHelper(sb, left, right + 1, n, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	/*
	 * Combinations Of Coins
	 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
	 * get all the possible ways to pay a target number of cents.
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
			}
			return;
		}
		// to find out the possible number for coins except smallest one.
		//this method will check the combination consist on smallest coins firstly.
		// then increase the number of larger denomination coins.
		for(int i = 0; (i* coins[index]	<= target); i++) {
			temp.add(i);
			combinationsHelper(finalResult, temp, index + 1, target, coins);
			temp .remove(temp.size() - 1);
		}
	}
}

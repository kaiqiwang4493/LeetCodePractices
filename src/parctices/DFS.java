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
	
	
}

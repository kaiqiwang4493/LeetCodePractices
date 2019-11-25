package parctices;

import java.util.ArrayList;
import java.util.List;

import dataStructure.TreeNode;

public class Recursion {

	
/*  Question 1 N queens
 * 
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 * 
 */
	
	public List<List<Integer>> nqueens(int n){
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		nqueensHelper(result, cur , n);
		return result;
	}
	
	private void nqueensHelper(List<List<Integer>> result, List<Integer> cur, int n) {
		if(cur.size() == n) {
			//find one of the possible solution for question.
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if (nqueensVaild(cur, i)) {
				cur.add(i);
				nqueensHelper(result, cur, n);
				cur.remove(cur.size() - 1);//continue to check the next position
			}
		}
	}
	
	private boolean nqueensVaild(List<Integer> cur, int column) {
		int row = cur.size();
		for(int i = 0; i < row; i++) {
			if(cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	/*
	 * 
	 * Spiral Order Traverse II
	 * 
	 */
	
	public List<Integer> spiralTraverse(int[][] matrix){
		List<Integer> result = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		if(m == 0) {
			return result;
		}
		
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = m - 1;
		
		while(left < right && up < down) {
			for(int i = left; i<=right; i++) {
				result.add(matrix[up][i]);
			}
			
			for(int i = up + 1; i<= down; i++) {
				result.add(matrix[i][right]);
			}
			
			for(int i = right - 1; i >= left; i--) {
				result.add(matrix[down][i]);
			}
			
			for(int i = down - 1; i>= up + 1; i--) {
				result.add(matrix[i][left]);
			}
			
			left++;
			right--;
			up++;
			down--;
		}
		
		if(left > right || up > down) {
			return result;
		}
		if(left == right) {
			for (int i = up; i <= down; i++) {
				result.add(matrix[i][left]);
			}
		}else {
			for(int i = left; i<= right; i++) {
				result.add(matrix[up][i]);
			}
		}
		return result;
	}
	
	
	/*
	 * Lowest Common Ancestor I
	 * 
	 */
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if(root == null || root == one || root == two) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		
		if(left != null && right != null) {
			return root;
		}else {
			return left == null ? right:left;
		}
	}
	
	
}

package parctices;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import dataStructure.TreeNode;

public class BinaryTree {
	/*
	 *  Height of Binary Tree
	 */
	public int findHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
			int leftHeight =1 + findHeight(root.left);
			int rightHeight = 1 + findHeight(root.right);
		return Math.max(leftHeight, rightHeight);
	}
	
	/*
	 * Check If Binary Tree Is Balanced
	 * 
	 * Check if a given binary tree is balanced. 
	 * 
	 * A balanced binary tree is 
	 * one in which the depths of every node’s left and right subtree differ by at most 1.
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		//separate the question to basic level
		boolean leftIsBalance = isBalanced(root.left);
		boolean rightIsBalance = isBalanced(root.right);
		
		if(!leftIsBalance || !rightIsBalance) {
			return false;
		}
		// decide the tree is or not balance base on the definition of Balance Tree 
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 *  In-order Traversal Of Binary Tree (recursion)
	 */
	List<Integer> resultInOrderTraversal = new ArrayList<>();
	public List<Integer> inOrder(TreeNode root){
		InOrderTraversalHelper(root);
		return resultInOrderTraversal;
	}
	private void InOrderTraversalHelper(TreeNode root) {
		if(root == null) {
			return;
		}
		InOrderTraversalHelper(root.left);
		resultInOrderTraversal.add(root.key);
		InOrderTraversalHelper(root.right);
	}
	
	/*
	 * In-order Traversal Of Binary Tree (iterative)
	 */
	public List<Integer> inOrderIterative(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			// make sure go to left side to check there is any node
			// because this is in-order, must push the left node first.
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}else {
				// if the cur == null, we know that cur has touch the bottom of tree.
				// poll the last node in the stack. The node is the last level node.
				cur = stack.pollFirst();
				result.add(cur.key);
				cur = cur.right;
			}
		}
		return result;
	}
	
	
	/*
	 * Post-order Traversal Of Binary Tree (iterative)
	 * 
	 * Implement an iterative, post-order traversal of a given binary tree, 
	 * return the list of keys of each node in the tree as it is post-order traversed.
	 *
	 * the key point of this algorithm is we must to know the direction of cur node
	 * whether it move from top to bottom or from bottom to top. when it move from
	 * top to bottom, offer it into stack. But, when it move from bottom to top, we
	 * have to distinguish come from left or right. Because when the cur is coming
	 * from left, we need to check the cur.right. We can add the cur.key to list
	 * when right is null when the cur is coming from right, the left and right nods
	 * have been traversed, we just add the cur.key to list directly.
	 */
	
	public List<Integer> postOrder(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur;
		TreeNode pre = null;
		if(root == null) {
			return list;
		}
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			cur = stack.peekFirst();
			// the cur is from top to bottom
			if(pre == null || cur == pre.left || cur == pre.right) {
				if(cur.left != null) {
					stack.offerFirst(cur.left);
				}else if(cur.right != null) {
					stack.offerFirst(cur.right);
				}else {
					// the both left and right are null, so the node is the leaf node, 
					// print it out and go back to it's parents node
					list.add(cur.key);
					stack.pollFirst();
				}
				// comes from left node. If the right node exited, we have to offer the right node first. 
			}else if(pre == cur.left) {
				if(cur.right != null) {
					stack.offerFirst(cur.right);
				}else {
					//if the right node is null
					list.add(cur.key);
					stack.pollFirst();
				}
			}else {
				// come from right node. It proves that the left and right node have been checked.
				list.add(cur.key);
				stack.pollFirst();
			}
			pre = cur;
		}
		return list;
	}
	
	/*
	 * Delete In Binary Search Tree
	 * 
	 * Delete the target key K in the given binary search tree if the binary search tree contains K. 
	 * Return the root of the binary search tree.
	 */
	
	public TreeNode deleteTree(TreeNode root, int key) {
		if(root == null) {
			return root;
		}
		if(key < root.key) {
			return deleteTree(root.left, key);
		}
		if (key > root.key) {
			return deleteTree(root.right, key);
		}

		// find the TreeNode should be deleted.
		if (root.left == null) {
			return root.right;
		}
		if (root.right == null) {
			return root.left;
		}
		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}

		TreeNode smallest = deleteSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;

	}
			
	private TreeNode deleteSmallest(TreeNode root) {
		TreeNode prev = root;
		while(root.left != null) {
			prev = root;
			root = root.left;
		}
		//find the smallest node
		prev.left = root.right;
		return root;
	}
}

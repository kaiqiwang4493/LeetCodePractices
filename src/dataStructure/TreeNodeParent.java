package dataStructure;

public class TreeNodeParent {
	int value;
	TreeNodeParent left;
	TreeNodeParent right;
	TreeNodeParent parent;
	
	public TreeNodeParent(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}

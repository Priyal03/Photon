package tree;

public class Tree {

	private TreeNode root;

	public void createTree(int value) {

		if (root == null) {
			root = new TreeNode(value);
		} else
			root.insertNode(value);
	}

	public void printTree() {

		root.traverseInorder();
		System.out.println("----------------------------------------------");
		root.traversePreOrder();
	}

	public TreeNode get(int value) {

		if (root != null)
			return root.get(value);

		return null;
	}

	public int min() {

		if (root == null)
			return Integer.MIN_VALUE;
		else
			return root.min();
	}

	public int max() {

		if (root == null)
			return Integer.MAX_VALUE;
		else
			return root.max();
	}

	public void delete(int value) {
		root = delete(root, value);
		//deleteNode(root, value);
	}

	private TreeNode delete(TreeNode node, int value) {

		System.out.println("method call for "+node.getData()+" tree and value ="+value);
		TreeNode temp = null;
		if (node == null)
			return node;

		if (value < node.getData()) {
			temp = delete(node.getLeft(), value);
			node.setLeft(temp);
		} else if (value > node.getData()) {
			temp = delete(node.getRight(), value);
			node.setRight(temp);
		} else {//one child or no child simple case.
			if(node.getLeft()==null) {
				return node.getRight();
			}else if(node.getRight()==null) {
				return node.getLeft();
			}else {//for two children deletion
				
				node.setData(node.getRight().min()); //first of all set the rightsubtreeroot node with min of subtree
				
				node.setRight(delete(node.getRight(), node.getData()));//then deleting the redundant node by passing the data and rightsubtreeroot
			}
		}
		
		

		return node;
	}
	
	public static TreeNode deleteNode(TreeNode root, int value) {
		if (root == null)
			return null;
		if (root.data > value) {
			root.left = deleteNode(root.left, value);
		} else if (root.data < value) {
			root.right = deleteNode(root.right, value);
 
		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				TreeNode temp = root;
				// Finding minimum element from right
			//	TreeNode minNodeForRight = 
				// Replacing current node with minimum node from right subtree
				root.data = temp.min();
				// Deleting minimum node from right now
				root.right = deleteNode(root.right, root.data);
 
			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		}
		return root;
	}

}
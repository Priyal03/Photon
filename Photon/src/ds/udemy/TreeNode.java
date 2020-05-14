package tree;

public class TreeNode {

	public int data;
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode left;
	 TreeNode right;
	
	public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}

	public void insertNode(int value) {
		// TODO Auto-generated method stub
		
		if(data==value) {
			return;
		}
		
		if(value<data) {
			
			if(left==null) {
				left=new TreeNode(value);
			}
			else
				left.insertNode(value);
		}
		
		if(value>data) {
			
			if(right==null) {
				right=new TreeNode(value);
			}else
				right.insertNode(value);
			
		}
	}
	
	public void traverseInorder() {
		
		if(left!=null)
			left.traverseInorder();
		System.out.print(data+", ");
		if(right!=null)
			right.traverseInorder();
		
	}
	
	public TreeNode get(int value) {
		
		if(value==data)
			return this;
		
		if(value>data) { 
			if(right!=null)
			return right.get(value);
		}
		
		if(value<data) {
			if(left!=null)
			return left.get(value);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		
		return "TreeNode [data=" + data+"]";
	}

	public int min() {
		
		if(left==null)
			return data;
		else
			return left.min();
	}

	public int max() {
		if(right==null)
			return data;
		else
			return right.max();
	}
	
	public void traversePreOrder(){
		
		System.out.print(data+", ");
		if(left!=null)
			left.traversePreOrder();
		if(right!=null)
			right.traversePreOrder();
	}
}
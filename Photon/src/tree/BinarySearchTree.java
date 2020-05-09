package tree;

public class BinarySearchTree {
	
	private TreeNode root;
	
	public static void main(String[] args) {
		
		//25,20,15,27,30,29,26,22,32
		
		
		Tree tree=new Tree();
		tree.createTree(25);
		tree.createTree(20);
		tree.createTree(15);
		tree.createTree(27);
		tree.createTree(30);
		tree.createTree(29);
		tree.createTree(26);
		tree.createTree(22);
		tree.createTree(32);
		
		
		tree.printTree();
		
		System.out.println();
		System.out.println(tree.get(25));
		System.out.println(tree.get(32));
		System.out.println(tree.get(80));
		
		
		System.out.println(tree.min());
		System.out.println(tree.max());
		
		tree.delete(25);
		
		tree.printTree();
	}
	
}

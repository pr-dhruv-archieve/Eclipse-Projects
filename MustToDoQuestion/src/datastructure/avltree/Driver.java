package datastructure.avltree;

public class Driver {
	
	public static void main(String[] args) {

		Node root = AVLTree.createTree(null, 6);
		
		AVLTree.printChildWise(root);
		
	}
}

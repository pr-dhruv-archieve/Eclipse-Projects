package datastructure.avltree;

public class Geeks {
	Node root;
	 
    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, int data) {
 
        if (node == null)
            return (new Node(data));
 
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else 
            return node;
 
        node.height = 1 + max(height(node.left),
                              height(node.right));

        int balance = getBalance(node);
 
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
 
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
 
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        return node;
    }
 
    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
 
    public static void main(String[] args) {
        Geeks tree = new Geeks();
 
        /* Constructing tree given in the above figure */
        //tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 2);AVLTree.printChildWise(tree.root);
        tree.root = tree.insert(tree.root, 3);AVLTree.printChildWise(tree.root);
        tree.root = tree.insert(tree.root, 4);AVLTree.printChildWise(tree.root);
        tree.root = tree.insert(tree.root, 5);AVLTree.printChildWise(tree.root);
        AVLTree.printChildWise(tree.root);
        tree.root = tree.insert(tree.root, 6);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        AVLTree.printChildWise(tree.root);
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        AVLTree.printChildWise(tree.root);
    }
}

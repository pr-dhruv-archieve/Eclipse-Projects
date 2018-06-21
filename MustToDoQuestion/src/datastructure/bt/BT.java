package datastructure.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class BT {

	static int max;

	public static Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		} else {
			Node parent = null;
			Node cur = root;

			while (true) {

				// left part
				if (Math.random() <= 0.5) {
					if (cur.left == null) {
						cur.left = new Node(data);
						return root;
					} else {
						parent = cur;
						cur = cur.left;
					}
				} else { // right part
					if (cur.right == null) {
						cur.right = new Node(data);
						return root;
					} else {
						parent = cur;
						cur = cur.right;
					}
				}
			}
		}
	}

	public static Node createBT(Node root, int nodes) {
		Random r = new Random();
		for (int i = 1; i <= nodes; i++) {
			int data = r.nextInt() % 100 + 1;
			if (data < 0)
				data = data * -1;

			root = insert(root, data);
		}
		return root;
	}

	public static void preorderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}

	public static void preorderIterative(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node cur = root;

		while (true) {
			while (cur != null) {
				System.out.print(cur.data + " ");
				s.push(cur.right);
				cur = cur.left;
			}
			if (s.isEmpty())
				break;
			else
				cur = s.pop();
		}
	}

	public static void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}

	public static void inorderIterative(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node cur = root;
		while (true) {
			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			if (s.isEmpty())
				break;
			else {
				cur = s.pop();
				System.out.print(cur.data + " ");
				cur = cur.right;
			}
		}
	}

	public static void postordeRecursive(Node root) {
		if (root != null) {
			postordeRecursive(root.left);
			postordeRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}

	private static void auxGraphicalPrint(Node root, int space) {

		for (int i = 1; i < space; ++i)
			System.out.print(" ");
		if (root == null) {
			System.out.println("-");
			return;
		}
		System.out.println(root.data);

		auxGraphicalPrint(root.left, space + 4);
		auxGraphicalPrint(root.right, space + 4);
	}

	public static void graphicalView(Node root) {
		auxGraphicalPrint(root, 0);
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);

		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public static int findMax(Node root) {
		int left, right, max = Integer.MIN_VALUE;
		if (root == null)
			return -1;
		else {

			left = findMax(root.left);
			right = findMax(root.right);

			if (left > right)
				max = left;
			else
				max = right;

			if (max < root.data)
				max = root.data;
		}
		return max;
	}

	public static int findMaxUsingLevelOrder(Node root) {
		LinkedList<Node> q = new LinkedList<Node>();
		int max = Integer.MIN_VALUE;
		Node cur = root;
		q.add(cur);
		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if (cur.data > max)
				max = cur.data;
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return max;
	}

	public static boolean findRecursion(Node root, int data) {
		if (root == null)
			return false;
		else {
			if (root.data == data)
				return true;
			else {
				if (root.left != null)
					return findRecursion(root.left, data);
				if (root.right != null)
					return findRecursion(root.right, data);
			}
		}
		return false;
	}

	public static boolean findLevelOrder(Node root, int data) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.removeFirst();
			if (root.data == data)
				return true;
			if (root.left != null)
				q.add(root.left);
			if (root.right != null)
				q.add(root.right);
		}
		return false;

	}

	public static int sizeRecursion(Node root) {
		if (root == null)
			return 0;
		else
			return sizeRecursion(root.left) + sizeRecursion(root.right) + 1;
	}

	public static int sizeIterative(Node root) {
		Node cur = root;
		LinkedList<Node> q = new LinkedList<Node>();
		int size = 0;
		q.add(cur);

		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if (cur != null)
				size++;
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return size;
	}

	public static void levelOrderInReverse(Node root) {
		LinkedList<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();

		Node cur = root;
		q.add(cur);
		while (!q.isEmpty()) {
			cur = q.removeFirst();
			s.push(cur);
			if (cur.right != null)
				q.add(cur.right);
			if (cur.left != null)
				q.add(cur.left);
		}

		while (!s.isEmpty())
			System.out.print(s.pop().data + " ");
		System.out.println();
	}

	public static int findHeightIterative(Node root) {
		int height = -1;
		if (root == null)
			return height;
		else {
			Node cur = root;
			LinkedList<Node> q = new LinkedList<Node>();
			height = 1;

			q.add(cur);
			q.add(null);

			while (!q.isEmpty()) {
				cur = q.removeFirst();
				if (cur == null) {
					if (!q.isEmpty())
						q.add(null);
					height++;
				}

				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
			return height;
		}
	}

	public static int deepestNode(Node root) {
		if (root == null)
			return -1;
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur = root;

		q.add(root);

		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return cur.data;
	}

	public static int fullNodeCount(Node root) {
		if (root == null)
			return 0;
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur = root;
		int count = 0;
		q.add(root);

		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if (cur.left != null && cur.right != null)
				count++;
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return count;
	}

	public static int halfNodeCount(Node root) {
		if (root == null)
			return 0;
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur = root;
		int count = 0;
		q.add(root);

		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if ((cur.left != null && cur.right == null) || (cur.left == null && cur.right != null))
				count++;
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return count;
	}

	public static int leafNodeCount(Node root) {
		if (root == null)
			return 0;
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur = root;
		int count = 0;
		q.add(root);

		while (!q.isEmpty()) {
			cur = q.removeFirst();
			if (cur.right == null && cur.left == null)
				count++;
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		return count;
	}

	public static boolean isStructuredIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return ((root1 != null && root2 != null) && isStructuredIdentical(root1.left, root2.left)
				&& isStructuredIdentical(root1.right, root2.right));
	}

	public static int treeDiameter(Node root) {
		if (root == null)
			return 0;

		int leftheight = height(root.left);
		int rightheight = height(root.right);
		int height = 1 + leftheight + rightheight;

		int leftdiameter = treeDiameter(root.left);
		int rightdiameter = treeDiameter(root.right);

		return Math.max(height, Math.max(leftdiameter, rightdiameter));

	}

	private static void auxLeftView(Node root, int level) {
		if (root == null)
			return;

		if (max < level) {
			System.out.print(root.data + " ");
			max = level;
		}

		auxLeftView(root.left, level + 1);
		auxLeftView(root.right, level + 1);

	}

	public static void leftView(Node root) {
		auxLeftView(root, 1);
		System.out.println();
	}

	private static void auxRightView(Node root, int level) {
		if (root == null)
			return;

		if (max < level) {
			System.out.print(root.data + " ");
			max = level;
		}

		auxRightView(root.right, level + 1);
		auxRightView(root.left, level + 1);

	}

	public static void rightView(Node root) {
		auxRightView(root, 1);
	}

	private static void auxallRootToLeafPath(Node root, String path) {
		if (root == null)
			return ;
		
		if (root.left == null && root.right == null) {
			System.out.println(path + root.data);
			return;
		}
		else {
			auxallRootToLeafPath(root.left, path + root.data + "->");
			auxallRootToLeafPath(root.right, path + root.data + "->");
		}
	}

	public static void allRootToLeafPath(Node root) {
		auxallRootToLeafPath(root, "");
	}

	public static boolean pathForGivenSum(Node root, int sum) {
		if (root == null)
			return sum == 0;
		else {
			boolean ans = false;
			int remaining = sum - root.data;
			
			if (remaining == 0 & root.left == null && root.right == null)
				return true;
			if (root.left != null)
				ans = ans || pathForGivenSum(root.left, remaining);
			if (root.right != null)
				ans = ans || pathForGivenSum(root.right, remaining);
			return ans;
		}
	}

	public static int sumOfTree(Node root) {
		if (root == null)
			return 0;
		return root.data + sumOfTree(root.left) + sumOfTree(root.right);
	}
	
	public static Node mirrorTree(Node root) {
		if (root != null) {
			mirrorTree(root.left);
			mirrorTree(root.right);
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
	
}

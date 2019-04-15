package com.horiaconstantin.tree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		Node bstRoot = new Node();
		bstRoot.setKey(15);
		Node _6 = new Node();
		_6.setKey(6);
		bstRoot.setLeftChild(_6);
		Node _3 = new Node();
		_3.setKey(3);
		Node _2 = new Node();
		_2.setKey(2);
		Node _4 = new Node();
		_4.setKey(4);
		Node _7 = new Node();
		_7.setKey(7);
		Node _13 = new Node();
		_13.setKey(13);
		Node _9 = new Node();
		_9.setKey(9);
		Node _18 = new Node();
		_18.setKey(18);
		Node _17 = new Node();
		_17.setKey(17);
		Node _20 = new Node();
		_20.setKey(20);

		bstRoot.setRightChild(_18);
		_18.setLeftChild(_17);
		_18.setRightChild(_20);
		_6.setLeftChild(_3);
		_6.setRightChild(_7);
		_3.setLeftChild(_2);
		_3.setRightChild(_4);
		_7.setRightChild(_13);
		_13.setLeftChild(_9);

		// System.out.println(recursiveTreeSearch(bstRoot, 13));
		// System.out.println(iterativeTreeSearch(bstRoot, 13));
		// System.out.println(treeMin(bstRoot));
		// System.out.println(treeMax(bstRoot));
		// // System.out.println(successor(bstRoot));
		Node newNode = new Node();
		newNode.setKey(14);
		//
		insertNode(bstRoot, newNode);
		// System.out.println(treeMax(bstRoot));
		// System.out.println(treeMin(bstRoot));
		inOrderTreeWalk(bstRoot);
	}

	private static void inOrderTreeWalk(Node root) {
		if (root == null) {
			return;
		}
		inOrderTreeWalk(root.getLeftChild());
		System.out.println(root);
		inOrderTreeWalk(root.getRightChild());
	}

	/**
	 * recursive
	 * 
	 * @author Horia Constantin
	 * @param root
	 * @param key
	 * @return
	 */
	private static Node recursiveTreeSearch(Node root, int key) {
		if (root == null || root.getKey() == key) {
			return root;
		}
		if (key < root.getKey()) {
			return recursiveTreeSearch(root.getLeftChild(), key);
		} else {
			return recursiveTreeSearch(root.getRightChild(), key);
		}
	}

	/**
	 * iterative
	 * 
	 * @author Horia Constantin
	 * @param root
	 * @param key
	 * @return
	 */
	private static Node iterativeTreeSearch(Node root, int key) {
		while (root.getKey() != key) {
			if (key < root.getKey()) {
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
			}
			if (root == null) {
				return root;
			}
		}
		return root;
	}

	private static Node treeMin(Node root) {
		while (root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		return root;
	}

	private static Node treeMax(Node root) {
		while (root.getRightChild() != null) {
			root = root.getRightChild();
		}
		return root;
	}

	private static Node successor(Node target) {
		if (target.getRightChild() != null) {
			return treeMin(target.getRightChild());
		}
		while (target.getParent().getRightChild() == null) {
			target = target.getParent();
		}
		return treeMin(target.getRightChild());
	}

	private static Node predecessor(Node target) {
		if (target.getLeftChild() != null) {
			return treeMax(target.getLeftChild());
		}
		while (target.getParent().getLeftChild() == null) {
			target = target.getParent();
		}
		return treeMax(target.getLeftChild());
	}

	/**
	 * NOT optimized, but working
	 * 
	 * @author Horia Constantin
	 * @param root
	 * @param newNode
	 */
	private static void insertNode(Node root, Node newNode) {
		if (root == null) {
			root = newNode;
		}
		Node prevRoot = root;
		boolean leftChild = true;
		while (root != null) {
			prevRoot = root;
			if (root.getKey() > newNode.getKey()) {
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
				leftChild = false;
			}
		}
		newNode.setParent(prevRoot);
		if (leftChild) {
			prevRoot.setLeftChild(newNode);
		} else {
			prevRoot.setRightChild(newNode);
		}

	}

	/**
	 * according to algorithms book
	 * 
	 * @author Horia Constantin
	 * @param root
	 * @param newNode
	 */
	private static void insertNodeOptimized(Node root, Node newNode) {
		Node prevRoot = null;
		while (root != null) {
			prevRoot = root;
			if (root.getKey() > newNode.getKey()) {
				root = root.getLeftChild();
			} else {
				root = root.getRightChild();
			}
		}
		newNode.setParent(prevRoot);
		if (prevRoot == null) {
			root = newNode;
		} else if (newNode.getKey() < prevRoot.getKey()) {
			prevRoot.setLeftChild(newNode);
		} else {
			prevRoot.setRightChild(newNode);
		}
	}

	private static void transplant(Node root, Node oldNode, Node newNode) {
		Node parent = oldNode.getParent();
		if (parent == null) {
			root = newNode;
		} else if (parent.getLeftChild().equals(oldNode)) {
			parent.setLeftChild(newNode);
		} else {
			parent.setRightChild(newNode);
		}
		if (newNode != null) {
			newNode.setParent(parent);
		}
	}

	private static void delete(Node root, Node toDelete) {
		if (toDelete.getLeftChild() == null) {
			transplant(root, toDelete, toDelete.getRightChild());
		} else if (toDelete.getRightChild() == null) {
			transplant(root, toDelete, toDelete.getLeftChild());
		} else {
			Node min = treeMin(toDelete.getRightChild());
			if (!toDelete.equals(min)) {
				transplant(root, min, min.getRightChild());
				min.rightChild = toDelete.getRightChild();
				min.rightChild.parent = min;
			}
			transplant(root, toDelete, min);
			min.leftChild = toDelete.leftChild;
			min.leftChild.parent = min;
		}
	}
}

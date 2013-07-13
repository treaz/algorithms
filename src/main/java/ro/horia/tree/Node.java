package ro.horia.tree;

public class Node {

	public Node() {
	};

	@Override
	public String toString() {
		return "Node [key=" + key + "]";
	}

	public Node(Node leftChild, Node rightChild, Node parent, int key) {
		super();
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
		this.key = key;
	}

	 Node leftChild;
	 Node rightChild;
	 Node parent;

	private int key;

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}

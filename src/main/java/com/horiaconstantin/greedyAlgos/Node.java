package com.horiaconstantin.greedyAlgos;

public class Node implements Comparable<Node>{

	@Override
	public String toString() {
		return "Node [character=" + character + ", freq=" + freq + "]";
	}

	public Node(char character, int freq) {
		super();
		this.character = character;
		this.freq = freq;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public char character;
	public int freq;
	public Node left;
	public Node right;

	@Override
	public int compareTo(Node o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;

	    //this optimization is usually worthwhile, and can
	    //always be added
	    if ( freq == o.freq ) return EQUAL;

	    //primitive numbers follow this form
	    if (freq < o.freq) return BEFORE;
	    if (freq > o.freq) return AFTER;
		return AFTER;
	}
	
	// is the node a leaf node?
    public boolean isLeaf() {
        assert (left == null && right == null) || (left != null && right != null);
        return (left == null && right == null);
    }
}

package com.horiaconstantin.java;

import java.util.List;

public class BetterProgrammerTask {

	// Please do not change this interface
	public static interface Node {
		int getValue();

		List<Node> getChildren();
	}

	public static int getLargestRootToLeafSum(Node root) {
		// base case
		if (root == null) {
			return 0;
		}
		int max_sum = Integer.MIN_VALUE;
		for (Node target_leaf : root.getChildren()) {

			// find the target leaf and maximum sum
			getTargetLeaf(root, max_sum, 0, target_leaf);

			// print the path from root to the target leaf
			printPath(root, target_leaf);
		}
		return max_sum; // return maximum sum
	}

	// A utility function that prints all nodes on the path from root to
	// target_leaf
	static boolean printPath(Node root, Node target_leaf) {
		// base case
		if (root == null)
			return false;

		// return true if this node is the target_leaf or target leaf is present
		// in
		// one of its descendants
		if (root == target_leaf
				|| printPath(root.getChildren().get(0), target_leaf)
				|| printPath(root.getChildren().get(1), target_leaf)) {
			System.out.println("%d " + root.getValue());
			return true;
		}

		return false;
	}

	// This function Sets the target_leaf_ref to refer the leaf node of the
	// maximum
	// path sum. Also, returns the max_sum using max_sum_ref
	static void getTargetLeaf(Node node, int max_sum_ref, int curr_sum,
			Node target_leaf_ref) {
		if (node == null)
			return;

		// Update current sum to hold sum of nodes on path from root to this
		// node
		curr_sum = curr_sum + node.getValue();

		// If this is a leaf node and path to this node has maximum sum so far,
		// then make this node target_leaf
		if (node.getChildren().get(0) == null
				&& node.getChildren().get(1) == null) {
			if (curr_sum > max_sum_ref) {
				max_sum_ref = curr_sum;
				target_leaf_ref = node;
			}
		}

		// If this is not a leaf node, then recur down to find the target_leaf
		getTargetLeaf(node.getChildren().get(0), max_sum_ref, curr_sum,
				target_leaf_ref);
		getTargetLeaf(node.getChildren().get(1), max_sum_ref, curr_sum,
				target_leaf_ref);
	}
}

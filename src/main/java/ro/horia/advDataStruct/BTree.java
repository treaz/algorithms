package ro.horia.advDataStruct;

public class BTree {

	/**
	 * the degree of the tree
	 */
	static int t = 4;

	/**
	 * starts from the root and compares the elements, if same return; if
	 * smaller go left else go right In the child do the same procedure for
	 * every key. If You discover the next key is still smaller, don't go in the
	 * right node, but to the key after that.
	 * 
	 * @author Horia Constantin
	 * @param x
	 * @param s
	 * @return
	 */
	public static Node search(Node x, String s) {
		int n = x.keys.size();
		int i = 0;
		while (i < n && s.charAt(0) > x.keys.get(i).charAt(0)) {
			i++;
		}
		if (i < n && s.equals(x.keys.get(i))) {
			System.out.println(i);
			return x;
		} else if (x.leaf) {
			return null;
		} else {
			// disk read
			return search(x.children[i], s);
		}
	}

	/**
	 * this method increases the tree height
	 * 
	 * @author Horia Constantin
	 * @param x
	 *            nonfull internal node stored in memory
	 * @param i
	 *            index of a full child
	 */
	public static Node split(Node x, int i) {
		Node z = new Node();
		Node y = x.children[i];
		z.leaf = y.leaf;
		z.children = new Node[t];
		z.size = t - 1;
		// all the second half of keys of the child y are put into z
		for (int j = 0; j < t - 1; j++) {
			z.keys.add(y.keys.get(j + t));
		}
		// if y is a node then take all the right half children and place them
		// into z's children
		if (!y.leaf) {
			for (int j = 0; j < t; j++) {
				x.children[j] = y.children[j + t];
			}
		}
		y.size = t - 1;
		// move the right half of x's children one posion to the right (so we
		// can make space for z)
		for (int j = x.size; j >= i; j--) {
			x.children[j + 1] = x.children[j];
		}
		x.children[i+1] = z;
		// move the right half of x's keys to the right to make room for the
		// median element of y (this elem gets promoted to x).
		y.keys.get(t-1);
		x.keys.add(i, y.keys.get(t-1));
		x.size++;
		// diskwrite (y,z,x)
		return x;
	}

	
	/**
	 * in order to ensure the btree property a split is done on each traversed
	 * node to the insertion point
	 * 
	 * @author Horia Constantin
	 */
	public static Node insert(Node r, String key) {
		Node s = new Node();
		if (r.size == (2 * t - 1)) {
			s.leaf = false;
			s.size = 0;
			s.children = new Node[2*t-1];
			s.children[0] = r;
			split(s, 0);
			insertNonFull(s, key);
		} else {
			insertNonFull(r, key);
			s=r;
		}
		return s;
	}

	private static void insertNonFull(Node x, String key) {
		int i = x.size-1;
		if (x.leaf) {
			while (i >= 1 && key.charAt(0) < x.keys.get(i).charAt(0)) {
				i--;
			}
			x.keys.add(i + 1, key);
			x.size++;
			// disk write x
		} else {
			while (i >= 1 && key.charAt(0) < x.keys.get(i).charAt(0)) {
				i--;
			}
//			i++;
			// diskread child i of x
			if (x.children[i].size == 2 * t - 1) {
				x = split(x, i);

				if (key.charAt(0) > x.keys.get(i).charAt(0)) {
					i++;
				}

			}
			insertNonFull(x.children[i], key);
		}

	}

	public static void main(String[] args) {
//		Node root = new Node();
//		root.keys.add("m");
//
//		Node leftC = new Node();
//		leftC.keys.add("d");
//		leftC.keys.add("h");
//		Node c1 = new Node();
//		c1.leaf = true;
//		c1.keys.add("b");
//		c1.keys.add("c");
//		Node c2 = new Node();
//		c2.leaf = true;
//		c2.keys.add("f");
//		c2.keys.add("g");
//		Node c3 = new Node();
//		c3.leaf = true;
//		c3.keys.add("j");
//		c3.keys.add("k");
//		c3.keys.add("l");
//		leftC.children = new Node[2 * t];
//		leftC.children[0] = c1;
//		leftC.children[1] = c2;
//		leftC.children[2] = c3;
//
//		Node rightC = new Node();
//		rightC.keys.add("q");
//		rightC.keys.add("t");
//		rightC.keys.add("x");
//		Node rc1 = new Node();
//		rc1.leaf = true;
//		rc1.keys.add("n");
//		rc1.keys.add("p");
//		Node rc2 = new Node();
//		rc2.leaf = true;
//		rc2.keys.add("r");
//		rc2.keys.add("s");
//		Node rc3 = new Node();
//		rc3.leaf = true;
//		rc3.keys.add("v");
//		rc3.keys.add("w");
//		Node rc4 = new Node();
//		rc4.leaf = true;
//		rc4.keys.add("y");
//		rc4.keys.add("z");
//		rightC.children = new Node[2 * t];
//		rightC.children[0] = rc1;
//		rightC.children[1] = rc2;
//		rightC.children[2] = rc3;
//		rightC.children[3] = rc4;
//		root.children = new Node[2 * t];
//		root.children[0] = leftC;
//		root.children[1] = rightC;

//		search(root, "l");
		
		Node root = new Node();
		root.keys.add("a");
		root.keys.add("d");
		root.keys.add("f");
		root.keys.add("h");
		root.keys.add("l");
		root.keys.add("n");
		root.keys.add("p");
		root.size=7;
		root.leaf=true;
		search(root, "c");
		Node res= insert(root, "c");
		search(res, "c");
	}
}

package ro.horia.greedyAlgos;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * a class for doing huffman encoding of strings based on a greedy algorithm (frequencies fo the letters) and a prio queue.
 * @author Horia Constantin
 *
 */
public class HuffmanCoding {

	public static void main(String[] args) {
		Node[] input = { new Node('a', 45), new Node('b', 13),
				new Node('c', 12), new Node('d', 16), new Node('e', 9),
				new Node('f', 5) };
		String[] st = new String[256];
		buildCode(st, calc(input), "");
		for (String sts :st) {
			if (sts!=null)
			System.out.println(sts);
		}
	}

	/**
	 * generates the tree and returns the root node
	 * @author Horia Constantin
	 * @param c
	 * @return
	 */
	public static Node calc(Node[] c) {
		Queue<Node> q = new PriorityQueue<>();
		for (Node elem : c) {
			q.add(elem);
		}
		for (int i = 0; i < c.length - 1; i++) {
			Node z = new Node();
			Node x = q.poll();
			z.left = x;
			Node y = q.poll();
			z.right = y;
			z.freq = x.freq + y.freq;
			q.add(z);
		}
		return q.poll();
	}
	
	// make a lookup table from symbols and their encodings
	/**
	 * the table contains the code at the ascii index of the character
	 * @author Horia Constantin
	 * @param st
	 * @param x
	 * @param s
	 */
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.character] = s;
        }
    }
}

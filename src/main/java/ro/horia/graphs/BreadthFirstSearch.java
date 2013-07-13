package ro.horia.graphs;

import static ro.horia.graphs.Vertex.BLACK;
import static ro.horia.graphs.Vertex.GRAY;
import static ro.horia.graphs.Vertex.WHITE;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	/**
	 * finds the shortest path distance to all of the vertices of the graph starting from startVertex
	 * @author Horia Constantin
	 * @param g
	 * @param startVertex
	 */
	public static void search(GraphList g, Vertex startVertex) {
		for (Vertex v : g.vertices) {
			v.color = WHITE;
			v.distanceFromSource = Integer.MAX_VALUE;
		}
		startVertex.color = GRAY;
		startVertex.distanceFromSource = 0;
		Queue<Vertex> queue = new LinkedList<>();
		queue.offer(startVertex);
		while (queue.peek() != null) {
			Vertex u = queue.poll();
			for (Vertex vertex : u.adjacentNodes) {
				if (vertex.color.equals(WHITE)) {
					vertex.color = GRAY;
					vertex.distanceFromSource = u.distanceFromSource + 1;
					vertex.predecessor = u;
					queue.offer(vertex);
				}
				u.color = BLACK;
			}

		}
	}
	
	/**
	 * before running this you have to run the search method
	 * @author Horia Constantin
	 * @param g
	 * @param start
	 * @param end
	 */
	public static void printPath(GraphList g, Vertex start, Vertex end) {
		if (start.equals(end)) {
			System.out.println(start);
		} else if (end.predecessor==null) {
			System.out.println("no path");
		} else {
			printPath(g, start, end.predecessor);
			System.out.println(end);
		}
	}
	
	public static void main(String[] args) {
		Vertex r = new Vertex("r");
		Vertex s = new Vertex("s");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex u = new Vertex("u");
		r.adjacentNodes.add(s);
		r.adjacentNodes.add(v);
		v.adjacentNodes.add(r);
		s.adjacentNodes.add(r);
		s.adjacentNodes.add(w);
		w.adjacentNodes.add(s);
		w.adjacentNodes.add(t);
		w.adjacentNodes.add(x);
		t.adjacentNodes.add(u);
		t.adjacentNodes.add(x);
		t.adjacentNodes.add(w);
		x.adjacentNodes.add(w);
		x.adjacentNodes.add(t);
		x.adjacentNodes.add(u);
		x.adjacentNodes.add(y);
		u.adjacentNodes.add(t);
		u.adjacentNodes.add(x);
		u.adjacentNodes.add(y);
		GraphList g = new GraphList();
		g.vertices.add(u);
		g.vertices.add(y);
		g.vertices.add(t);
		g.vertices.add(r);
		g.vertices.add(s);
		g.vertices.add(x);
		g.vertices.add(w);
		g.vertices.add(v);
		
		search(g, s);
		System.out.println(y.distanceFromSource);
		printPath(g, s, u);
		
	}
}

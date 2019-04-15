package com.horiaconstantin.graphs;

import java.util.Collections;

import static com.horiaconstantin.graphs.Vertex.*;

public class DepthFirstSearch {

	static int time = 0;

	/**
	 * the result of running this method is the start and end times that are calculated for all the nodes
	 * this algo is better applied on directed graphs
	 * @author Horia Constantin
	 * @param g
	 */
	public static void search(GraphList g) {
		for (Vertex v : g.vertices) {
			v.color = WHITE;
			v.distanceFromSource = Integer.MAX_VALUE;
		}

		for (Vertex v : g.vertices) {
			if (v.color.equals(WHITE)) {
				visit(g, v);
			}
		}
	}

	private static void visit(GraphList g, Vertex u) {
		time++;
		u.startTime=time;
		u.color=GRAY;
		for (Vertex v:u.adjacentNodes) {
			if (v.color.equals(WHITE)) {
				v.predecessor=u;
				visit(g, v);
			}
			
		}
		u.color=BLACK;
		time++;
		u.endTime=time;
	}

	public static void main(String[] args) {
		//graph at 626
		Vertex z = new Vertex("z");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex u = new Vertex("u");
		
		u.adjacentNodes.add(v);
		u.adjacentNodes.add(x);
		v.adjacentNodes.add(y);
		w.adjacentNodes.add(y);
		w.adjacentNodes.add(z);
		x.adjacentNodes.add(v);
		y.adjacentNodes.add(x);
		z.adjacentNodes.add(z);
		
		
		GraphList g = new GraphList();
		g.vertices.add(u);
		g.vertices.add(y);
		g.vertices.add(z);
		g.vertices.add(x);
		g.vertices.add(w);
		g.vertices.add(v);

		search(g);
		System.out.println(u.startTime);//should be 1
		System.out.println(u.endTime);//should be 16 see page 596
		topoSort(g);
//		 printPath(g, s, u);

	}
	
	public static void topoSort(GraphList g) {
		Collections.sort(g.vertices);
	}
}

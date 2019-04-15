package com.horiaconstantin.graphs;

import java.util.*;

/**
 * page 658
 * 
 * @author Horia Constantin
 * 
 */
public class DijkstraSP {

	public static void calc(GraphList g,
			Map<VertexDijkstra, List<Map<VertexDijkstra, Integer>>> w, VertexDijkstra s) {
		GraphList.initSingleSource(g, s);

		//this is the queue 
		List<Vertex> q = new ArrayList<>();
		q.addAll(g.vertices);
		Collections.sort(q);

		while (!q.isEmpty()) {
			//extracting the minimum element from the remaining elems
			//the first elem will be s
			VertexDijkstra u = (VertexDijkstra) q.get(0);
			q.remove(0);
			//for all the edges that start from u, relax...
			for (Map<VertexDijkstra, Integer> weight : w.get(u)) {
				for (VertexDijkstra vert : weight.keySet()) {
					GraphList.relax(u, vert, weight.get(vert));
				}
			}
			
			Collections.sort(q);
		}
	}
	
	public static void main(String[] args) {
		GraphList g = new GraphList();
		VertexDijkstra s = new VertexDijkstra("s");
		VertexDijkstra t = new VertexDijkstra("t");
		VertexDijkstra x = new VertexDijkstra("x");
		VertexDijkstra y = new VertexDijkstra("y");
		VertexDijkstra z = new VertexDijkstra("z");
		g.vertices.add(s);
		g.vertices.add(y);
		g.vertices.add(t);
		g.vertices.add(x);
		g.vertices.add(z);
		
		Map<VertexDijkstra, List<Map<VertexDijkstra, Integer>>> edges = new HashMap<VertexDijkstra, List<Map<VertexDijkstra, Integer>>>();
		Map<VertexDijkstra, Integer> st = new HashMap<>();
		st.put(t, 10);
		Map<VertexDijkstra, Integer> sy = new HashMap<>();
		sy.put(y, 5);
		List<Map<VertexDijkstra, Integer>> list = new ArrayList<>();
		list.add(sy);
		list.add(st);
		edges.put(s, list);
		
		Map<VertexDijkstra, Integer> tx = new HashMap<>();
		tx.put(x, 1);
		Map<VertexDijkstra, Integer> ty = new HashMap<>();
		ty.put(y, 2);
		list = new ArrayList<>();
		list.add(tx);
		list.add(ty);
		edges.put(t, list);
		
		Map<VertexDijkstra, Integer> yx = new HashMap<>();
		yx.put(x, 9);
		Map<VertexDijkstra, Integer> yz = new HashMap<>();
		yz.put(z, 2);
		Map<VertexDijkstra, Integer> yt = new HashMap<>();
		yt.put(t, 3);
		list = new ArrayList<>();
		list.add(yx);
		list.add(yz);
		list.add(yt);
		edges.put(y, list);

		Map<VertexDijkstra, Integer> zx = new HashMap<>();
		zx.put(x, 6);
		Map<VertexDijkstra, Integer> zs = new HashMap<>();
		zs.put(s, 7);
		list = new ArrayList<>();
		list.add(zx);
		list.add(zs);
		edges.put(z, list);

		Map<VertexDijkstra, Integer> xz = new HashMap<>();
		xz.put(z, 4);
		list = new ArrayList<>();
		list.add(xz);
		edges.put(x, list);

		calc(g, edges, s);
		System.out.println(t.spEst);// expected 8
		System.out.println(x.spEst);// expected 9
		System.out.println(y.spEst);// expected 5
		System.out.println(z.spEst);// expected 7
	}
}

package ro.horia.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BellmanFordSP {

	public static boolean calc(GraphList g,
			Map<Vertex, List<Map<Vertex, Integer>>> w, Vertex s) {
		GraphList.initSingleSource(g, s);
		//iterate vertices-1 times through all the edges
		for (int i = 0; i < g.vertices.size() - 1; i++) {
			for (Vertex vvv : w.keySet()) {
				for (Map<Vertex, Integer> v : w.get(vvv)) {
					for (Vertex vert : v.keySet()) {
						System.out.println(vvv.name + "\t" + vert.name);
						GraphList.relax(vvv, vert, v.get(vert));
					}
				}
			}
		}

		for (Vertex u : g.vertices) {
			for (Map<Vertex, Integer> v : w.get(u)) {
				for (Vertex vert : v.keySet()) {
					if (vert.spEst > u.spEst + v.get(vert)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		GraphList g = new GraphList();
		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");
		g.vertices.add(s);
		g.vertices.add(y);
		g.vertices.add(t);

		g.vertices.add(x);
		g.vertices.add(z);
		Map<Vertex, List<Map<Vertex, Integer>>> edges = new HashMap<Vertex, List<Map<Vertex, Integer>>>();
		Map<Vertex, Integer> st = new HashMap<>();
		st.put(t, 6);
		Map<Vertex, Integer> sy = new HashMap<>();
		sy.put(y, 7);
		List<Map<Vertex, Integer>> list = new ArrayList<>();
		list.add(sy);
		list.add(st);
		edges.put(s, list);

		Map<Vertex, Integer> tx = new HashMap<>();
		tx.put(x, 5);
		Map<Vertex, Integer> tz = new HashMap<>();
		tz.put(z, -4);
		Map<Vertex, Integer> ty = new HashMap<>();
		ty.put(y, 8);
		list = new ArrayList<>();
		list.add(tx);
		list.add(tz);
		list.add(ty);
		edges.put(t, list);

		Map<Vertex, Integer> yx = new HashMap<>();
		yx.put(x, -3);
		Map<Vertex, Integer> yz = new HashMap<>();
		yz.put(z, 9);
		list = new ArrayList<>();
		list.add(yx);
		list.add(yz);
		edges.put(y, list);

		Map<Vertex, Integer> zx = new HashMap<>();
		zx.put(x, 7);
		Map<Vertex, Integer> zs = new HashMap<>();
		zs.put(s, 2);
		list = new ArrayList<>();
		list.add(zx);
		list.add(zs);
		edges.put(z, list);

		Map<Vertex, Integer> xt = new HashMap<>();
		xt.put(t, -2);
		list = new ArrayList<>();
		list.add(xt);
		edges.put(x, list);

		calc(g, edges, s);
		System.out.println(t.spEst);// expected 2
		System.out.println(x.spEst);// expected 4
		System.out.println(y.spEst);// expected 7
		System.out.println(z.spEst);// expected -2

	}
}

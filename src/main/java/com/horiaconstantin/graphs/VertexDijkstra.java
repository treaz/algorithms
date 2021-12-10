package com.horiaconstantin.graphs;

public class VertexDijkstra extends Vertex {

	public VertexDijkstra(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(Vertex o) {
		if (distanceFromSource>o.distanceFromSource) {
			return 1;
		} else if (distanceFromSource<o.distanceFromSource) {
			return -1;
		}
		return 0;
	}

}

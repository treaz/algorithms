package com.horiaconstantin.graphs;

public class StronglyConnectedComps {

	public static void comp(GraphList g) {
		DepthFirstSearch.search(g);
		GraphList transposedGraph = GraphList.transpose(g);
		//but in the main loop of DFS, consider the vertices in order of decreasing u:f
		DepthFirstSearch.search(transposedGraph);
		//the call from above creates many trees based on Vertex.predecessor.
		//just compress the trees into single components.
	}
}

package com.horiaconstantin.graphs;

import java.util.*;

public class GraphList {

	List<Vertex> vertices = new ArrayList<>();
	
	//not tested
	/**
	 * transposing a directed graph means to change the direction of the edges
	 * @author Horia Constantin
	 * @param G
	 * @return
	 */
	public static GraphList transpose(GraphList G) {
		GraphList GT = new GraphList();

	   for ( Vertex U : G.vertices){
		   for ( Vertex V : U.adjacentNodes ) {
			   V.adjacentNodes.add(U);
			   
			   GT.vertices.add(V);
		   }
	   }

	   return GT;
	}
	
	//this should definitely work
	 public static void main(String[] args) {
	        Map<String,List<String>> g = new HashMap<String,List<String>>();
	        g.put("A", Arrays.asList("B", "C"));
	        g.put("B", Arrays.asList("A", "D"));
	        g.put("C", Arrays.asList("D"));

	        System.out.println(g);
	        // prints "{A=[B, C], B=[A, D], C=[D]}"
	        //
	        // .--- A <--> B --> D <--.
	        // |                      |
	        // '---------> C ---------'

	        Map<String,List<String>> gT = new HashMap<String,List<String>>();
	        for (String u : g.keySet()) {
	            for (String v : g.get(u)) {
	                List<String> gTv = gT.get(v);
	                if (gTv == null) {
	                    gT.put(v, gTv = new ArrayList<String>());
	                }
	                gTv.add(u);
	            }
	        }
	        System.out.println(gT);
	        // prints "{D=[B, C], A=[B], B=[A], C=[A]}"
	        //
	        // .--> A <--> B <-- D ---.
	        // |                      |
	        // '---------- C <--------'     
	    }
	 
	 public static void initSingleSource(GraphList g, Vertex s) {
		 for (Vertex v:g.vertices) {
			 
			 v.spEst=Integer.MAX_VALUE;
		 }
		 s.spEst=0;
	 }
	 
	 /**
	  * 
	  * @author Horia Constantin
	  * @param u
	  * @param v
	  * @param w the weight of the edge between u and v
	  */
	 public static void relax(Vertex u, Vertex v, int w) {
		 int right;
		//The problem with using Integer.MAX_VALUE is that when you do u.spEst+w you get a negative number and that messes up the algo
		 if (u.spEst== Integer.MAX_VALUE) {
			 right=u.spEst;
		 } else {
			 right=u.spEst+w;
		 }
		 if (v.spEst>right) {
			 v.spEst=right;
			 v.predecessor=u;
		 }
	 }
}

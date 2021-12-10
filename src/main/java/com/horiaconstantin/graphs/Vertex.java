package com.horiaconstantin.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{


	@Override
	public String toString() {
		return "Vertex [name=" + name + ", endTime=" + endTime + ", spEst="
				+ spEst + "]";
	}

	public Vertex(String name) {
		super();
		this.name = name;
	}
	public static final String WHITE = "W";
	public static final String GRAY = "G";
	public static final String BLACK = "B";
	
	List<Vertex> adjacentNodes = new ArrayList<>();
	String color;
	Vertex predecessor;
	int distanceFromSource;
	String name;
	
	//used in depth search
	int startTime;
	int endTime;
	
	//shortest path estimate
	int spEst;

	@Override
	public int compareTo(Vertex o) {
		if (endTime>o.endTime) {
			return -1;
		} else if (endTime<o.endTime) {
			return 1;
		}
		return 0;
	}
}

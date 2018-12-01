package application;

import java.util.HashMap;
import java.util.HashSet;

/*Trieda reprezentuje uzol*/
public class Vertex {
	private static final int NEKONECNO = 99999;
	private String name;
	private HashSet<Vertex> vertexSet = new HashSet<Vertex>();
	private HashMap<Vertex, Integer> costs = new HashMap<Vertex, Integer>();
	
	public String getName() {
		return name;
	}

	public Vertex(String name) {
		super();
		this.name = name;
	}

	public int getCost(Vertex v2) {
		if (!costs.containsKey(v2)) {
			return NEKONECNO;
		}
		return costs.get(v2);
	}

	public void addConnection(Vertex v2, int cost) {
		vertexSet.add(v2);
		costs.put(v2, cost);
	}
	
	public int getPocetSoused() {
		return vertexSet.size();
	}
	
	public HashSet<Vertex> getSousede() {
		return vertexSet;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
}

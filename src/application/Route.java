package application;

import java.util.PriorityQueue;
import java.util.Vector;

/* Trieda, reprezentuje cestu grafom*/
public class Route implements Comparable<Route> {

	private Graph graf;
	private Vertex lastNode = null;
	private Vector<Vertex> nodes = new Vector<Vertex>();
	private int cost;

	public int getCost() {
		return cost;
	}

	public Route(Graph graf) {
		super();
		this.graf = graf;
	}
	
	public void addVertex(String s) {
		nodes.addElement(graf.getVertext(s));
		if (lastNode == null) {
			cost = 0;
		} else {
			cost += lastNode.getCost(graf.getVertext(s));
		}
		lastNode = graf.getVertext(s);
	}

	public boolean isDestination(String destination) {
		if (lastNode.equals(graf.getVertext(destination))) {
			return true;
		}
		return false;
	}

	public Route cloneAndAdd(String uzol) {
		Route kopia = new Route(graf);
		kopia.lastNode = lastNode;
		kopia.nodes.addAll(nodes);
		kopia.cost = cost;

		kopia.addVertex(uzol);
		return kopia;
	}

	public Route DijkstrovAlg(String start, String ciel) {
		PriorityQueue<Route> fronta = new PriorityQueue<Route>();
		Route c = new Route(graf);
		c.addVertex(start);
		fronta.add(c);

		while (!fronta.isEmpty()) {
			Route tpm = fronta.remove();
			if (tpm.isDestination(ciel)) {
				return tpm;
			} else {
				for (Vertex v : tpm.lastNode.getSousede()) {
					Route kopia = tpm.cloneAndAdd(v.getName());
					String uzol = kopia.lastNode.getName();
					System.out.println(kopia.toString());
					fronta.add(kopia);
				}
			}
		}
		return null;
	}

	@Override
	public int compareTo(Route o) {
		Integer c1 = cost;
		Integer c2 = o.cost;
		return c1.compareTo(c2);
	}

	@Override
	public String toString() {
		return "Cesta " + nodes + " cena: " + cost;
	}

}

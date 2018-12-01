package application;

public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		Route c = new Route(g);
		
		g.add("A", "B", 11);
		g.add("A", "E", 9);
		g.add("A", "C", 4);
		g.add("B", "E", 2);
		g.add("B", "D", 2);
		g.add("C", "E", 2);
		g.add("C", "D", 7);
		g.add("E", "D", 8);

		System.out.println("Final: " + c.DijkstrovAlg("A", "D"));
	}

}

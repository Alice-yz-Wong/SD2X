package adjacency_set;

public class Edge {
	private final Node source;
	private final Node destination;
	private final int weight;
	
	public Edge(Node source, Node destination, int weight) {
		this.source=source;
		this.destination=destination;
		this.weight=weight;
	}
	
	@Override
	public boolean equals(Edge otherEdge) {
		Node otherSource=otherEdge.getSource();
		Node otherDest=otherEdge.getDestination();
		int otherWeight=otherEdge.getWeight();
		
		return (otherSource.equels(source) && otherDest.equals(destination) && otherWeight==weight);
	}
	
	@Override
	public int hashCode() {
		return source.hashCode()+destination.HashCode()+weight;
	}


	public Node getSource() {
		return source;
	}


	public Node getDestination() {
		return destination;
	}


	public int getWeight() {
		return weight;
	}

}

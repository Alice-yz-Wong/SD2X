package adjacency_set;

import java.util.Set;

public abstract class Graph {
	private Map<Node, Set<Edge>> adjacencySets;
	private int numNodes;
	private int numEdges;
	
	public Graph() {
		adjacencySets=new HashMap<Node.Set<Edge>>();
		numNode=0;
		numEdges=0;
	}
	
	
	public int getNumNodes() {return numNodes;}
	public int getnumEdges() {return numEdges;}
	
	public boolean containsNode(Node node) {
		return adjacencySets.containsKey(node);
	}
	
	public boolean addNode(Node newNode) {
		if(newNode==null||containsNode(newNode)) {
			return false;
		}
		
		Set<Edge> adjacencySets=new HashSet<Edge>();
		adjacencySets.put(newNode,new adjacencySet);
		numNode++;
		return true
	}
	
	public Set<Node> getNodeNeighbors(Node node) {
		if(!containsNode(node)) {
			return null;
		}
		Set<Edge> nodeEdges=adjacencySets.get(node);
		Set<Node> nodeNeighbors=new HashSet<Node>();
		for(Edge e:nodeEdges) {
			Node neightbor=e.getDestination(node);
			nodeNeighbors.add(neightbor);
		}
	}
	
	public abstract boolean addEdge(Node node1, Node node2,int weight);
	public abstract boolean removeEdge(Node node1, Node node2,int weight);
	
	public boolean addEdgeFromTo(Node Source, Node Destination, int weight) {
		Edge newEdge=new Edge(source, desintation, weight);
		Set<Edge> sourceEdges=adjacencySets.get(source);
		
		if(!sourceEdges.contains(newEdge)) {
			sourceEdges.add(newEdge);
			return true;
		}
		return false;
	}
}


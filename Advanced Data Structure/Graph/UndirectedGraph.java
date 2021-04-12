package adjacency_set;

public class UndirectedGraph extends Graph {

	public UndirectedGraph() {
		super();
	}
	@Override
	public boolean addEdge(Node node1, Node node2, int weight) {
		addNode(node1);
		addNode(node2);
		
		boolean addEdgeSuccess= {
				addEdgeFromTo(Node node1, Node node2, int weight)&&(Node node2, Node node1, int weight)
		}
		
		if(addEdgeSuccess) {
			numEdges++;
		}
		
		return addEdgeSuccess;
	}
}

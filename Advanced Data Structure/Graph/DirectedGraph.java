package adjacency_set;

public class DirectedGraph extends Graph {

	@Override
	public boolean addEdge(Node node1, Node node2, int weight) {
		addNode(source);
		addNode(dest);
		
		boolean addSuccess=addEdgeFromTo(source,dest,weight);
		if(addSuccess) {
			numEdges++;
		}
		return addSuccess;
	}

}

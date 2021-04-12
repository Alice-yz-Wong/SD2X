package adjacency_set;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {
	private Set<Node> marked;
	private Graph graph;
	
	public BFS(Graph graphToSearch) {
		marked=new HashSet<Node>();
		graph=graphToSearch;
	}
	
	public boolean bfs(String elementToFind, Node start) {
		if(!graph.containsNode(start)) {
			return false;
		}
		
		if(start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore=new LinkedLIst<Node>();
		marked.add(start);
		toExplore.add(start);
		while(!toExplore.isEmpty()) {
			Node current=toExplore.remove();
			for(Node neighbor:graph.getNodeNeighbors(current)) {
				if(!marked.contains(neighbor)) {
					if(neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}

}

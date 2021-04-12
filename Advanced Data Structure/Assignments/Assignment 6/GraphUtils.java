

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {
	
//	Given a Graph, this method returns the shortest distance (in terms of number of edges) from the node labeled src to the node labeled dest.
//	The method should return -1 for any invalid inputs, including: null values for the Graph, src, or dest; there is no node labeled src or dest in the graph; 
//	there is no path from src to dest. Keep in mind that this method does not just return the distance of any path from src to dest, it must be the shortest path.

	public static int minDistance(Graph graph, String src, String dest) {
		if(graph!=null&&src!=null&&dest!=null) {
			return new BreadthFirstSearch(graph).bfsDistance(graph.getNode(src),dest);
		}else {
			return -1;
		}
	}
	
	
//Given a Graph, this method returns a Set of the values of all nodes within the specified distance (in terms of number of edges) of the node labeled src, 
//i.e. for which the minimum number of edges from src to that node is less than or equal to the specified distance. 
//The value of the node itself should not be in the Set, even if there is an edge from the node to itself. 
//The method should return null for any invalid inputs, including: 
//	null values for the Graph or src; 
//	there is no node labeled src in the graph; 
//	distance less than 1.
//However, if distance is greater than or equal to 1 and there are no nodes within that distance (meaning: src is the only node in the graph), the method should return an empty Set.

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if(graph!=null&&src!=null&&graph.containsElement(src)||distance>=1) {
			Set<String> nwd=new HashSet<String>();
			if(graph.getNumNodes()==1) {
				return nwd;
			}
			
			//distances map
			Map<Node, Integer> distances = new HashMap<>();	
				
			//same as min distance, return neighbor node
			Queue<Node> toExplore = new LinkedList<Node>();
			Set<Node> marked=new HashSet<>();
			
			marked.add(graph.getNode(src));
			toExplore.add(graph.getNode(src));
			distances.put(graph.getNode(src),0);
			while (!toExplore.isEmpty()) {
				Node current = toExplore.remove();
				for (Node neighbor : graph.getNodeNeighbors(current)) {
					if (!marked.contains(neighbor)) {
						distances.put(neighbor, distances.get(current)+1);
						if (distances.get(neighbor)<=distance) {
							nwd.add(neighbor.getElement());
						}
						marked.add(neighbor);
						toExplore.add(neighbor);
					}
				}
			}
			return nwd;
			
		}else {
			return null;
		}
	}


//Given a Graph, this method indicates whether the List of node values represents a Hamiltonian Path. 
//A Hamiltonian Path is a valid path through the graph in which every node in the graph is visited exactly once, 
//except for the start and end nodes, which are the same, so that it is a cycle. 
//If the values in the input List represent a Hamiltonian Path, the method should return true, 
//but the method should return false otherwise, e.g. if the path is not a cycle, 
//if some nodes are not visited, 
//if some nodes are visited more than once, 
//if some values do not have corresponding nodes in the graph, 
//if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not connected by an edge), etc.  
//The method should also return false if the input Graph or List is null.
	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if(g!=null&&values!=null&&!isEmpty(values)) {
			String start=values.get(0);
			Set <String> marked=new HashSet<>();
			marked.add(start);
			
			if(!start.equals(values.get(values.size()-1))) {
				return false;
			}else{
				for(int i=1;i<values.size();i++) { //begin and end removed
					
					//value doesn't exist in g
					if(!g.containsElement(values.get(i))) {
						return false;
					}
					
					//if some nodes are visited more than once, 
					if(marked.contains(values.get(i))) {
						return false;
					}
					
					//if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not connected by an edge), etc.  
					if(!g.getNodeNeighbors(g.getNode(values.get(i-1))).contains(g.getNode(values.get(i)))) {
						return false;
					}
					
					marked.add(values.get(i));
				}
				
			}
			
			
			//values num = marked num
			if(marked.size()==g.getNumNodes()) {
				return true;
			}
			
		}
        
		return false;
		
	}


private static boolean isEmpty(List<String> values) {
	// TODO Auto-generated method stub
	return false;
}
	
}

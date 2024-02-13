package dijkstra;

import java.util.ArrayList;

/**
 * Class implementing the Dijkstra's methods to find shortest routes through a graph.
 * @author Hugo Queniat
 *
 */
public class Dijkstra {
	/**
	 * Modifies previous so that for each vertex, finding the shortest route through the graph from r only consists in going back up through the vertex's ancestors until finding r.
	 * @param g GraphInterface in which we search every route.
	 * @param r VertexInterface from which we try to find the shortest to all the other vertices.
	 * @param a ASetInterface which is a set of vertices, used to marked the visited vertices
	 * @param pi PiInterface which will be used to store the length of the route between r and every other vertex.
	 * @param previous PreviousInterface which will be used to describe the shortest route between r and another r via showing every vertex to go to.
	 * @return PreviousInterface modified and that holds every shortest route from r to any other vertex.
	 */
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous)
		{
		a.add(r);
		VertexInterface pivot = r;
		pi.setPi(r, 0);
		ArrayList<VertexInterface> graph = g.getAllVertices();
		for (VertexInterface vertex : graph) {
			if (!(vertex.equals(r))) {
				pi.setPi(vertex, Integer.MAX_VALUE);
			}
		}
		for (int j = 1; j < graph.size(); j++) {
			modifyRouteWeight(pivot, graph, previous, g, pi, a);
			pivot = searchNewPivot(a, pi, graph);
			a.add(pivot);
		}
		return previous;
	}
	/**
	 * Reposing on the 'pivot' vertex, modifyRouteWeight redefines both the PiInterface and PreviousIterface, for all the vertices that have not been visited yet, with new potential shortest routes passing through the pivot vertex.
	 * @param pivot VertexInterface that will be used to reconsider potential shortest routes
	 * @param graph ArrayList<VertexInterface> which is a set of all the vertices 
	 * @param previous PreviousInterface that holds every potential routes 
	 * @param g GraphInterface of origin for pivot and which through all the routes are determined.
	 * @param pi PreviousInterface holds for every vertex the length of the shortest route from r
	 * @param a ASetInterface set of the vertices already visited
	 */
	private static void modifyRouteWeight(VertexInterface pivot, ArrayList<VertexInterface> graph, PreviousInterface previous, GraphInterface g, PiInterface pi, ASetInterface a) {
		for (VertexInterface vertex : graph) {
			if ((!(a.isIn(vertex)) && (g.getSuccessors(pivot).contains(vertex)))) {
				Integer newDistance = (pi.getPi(pivot))+(g.getWeight(pivot, vertex));
				if (newDistance < pi.getPi(vertex)) {
					pi.setPi(vertex, newDistance);
					previous.setFather(vertex, pivot);
				}
			}
		}
	}
	/**
	 * Finds the next pivot by selecting, through all the not visited vertices, the one that is the closest to r (and therefore that has the lowest value in PiInterface).
	 * @param a ASetInterface which is the set of all vertices that have been visited.
	 * @param pi PiInterface holds an Integer value for all vertices.
	 * @param graph ArrayList<VertexInterface> holds all the graph's vertices.
	 * @return VertexInterface that holds the lowest Pi value and is yet to be visited.
	 */
	private static VertexInterface searchNewPivot(ASetInterface a, PiInterface pi, ArrayList<VertexInterface> graph) {
		Integer min = Integer.MAX_VALUE;
		VertexInterface vertexPiMin = null;
		for (VertexInterface vertex : graph) {
			if ((!(a.isIn(vertex)))&& (pi.getPi(vertex)<=min)) {
				min = pi.getPi(vertex);
				vertexPiMin = vertex;
			}
	
		}
		 return vertexPiMin;
	}
	/**
	 * Determines all the shortest routes through the graph g from vertex r to the accessible vertices. This route is accessible through the ancestors in the PreviousInterface that is returned.
	 * @param g GraphInterface is the graph in which the program searches the shortest routes
	 * @param r VertexInterface that belongs to the graph, origin of all the routes that are calculated.
	 * @return PreviousInterface that holds all the shortest routes to the accessible vertices. Routte is obtained by going up through the family tree of a vertex until getting to r.
	 */
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		return dijkstra(g, r, a, pi, previous);
	}
	
	

}

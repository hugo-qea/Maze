package dijkstra;

import java.util.ArrayList;
/**
 * Interface describing a class supposed to represent a Graph (set of vertices linked by edges).
 * @author Hugo Queniat
 *
 */
public interface GraphInterface {
	
	/**
	 * Method to get the Graph's set of vertices.
	 * @return the Graph's set of vertices
	 */
	public ArrayList<VertexInterface> getAllVertices();
	
	/**
	 * Method to get all the vertices that share an edge with the issued vertex.
	 * @param vertex A vertex of the Graph
	 * @return Set of all the vertices that are neighbors with vertex in the Graph.
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
	
	/**
	 * Calculates the weight of the edge between src and dst.
	 * @param src Departure of the edge in the Graph.
	 * @param dst Arrival of the edge in the Graph.
	 * @return The weight of the edge.
	 */
	public int getWeight (VertexInterface src, VertexInterface dst);

}

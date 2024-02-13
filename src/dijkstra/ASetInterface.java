package dijkstra;
/**
 * Interface describing the behavior of an object supposed to holds vertices and able to answer whether a vertex is in or not.
 * @author Hugo Queniat
 *
 */
public interface ASetInterface {
	
	/**
	 * Adds a vertex to the set of vertices.
	 * @param vertex Vertex to be added.
	 * @return true if it successfully added the vertex and false otherwise.
	 */
	public boolean add(VertexInterface vertex);
	
	/**
	 * Checks if the vertex issued is in the set of vertices.
	 * @param vertex Vertex whose belonging to the set of vertices will be checked.
	 * @return true if it does belong to the set and false otherwise.
	 */
	
	public boolean isIn(VertexInterface vertex);
	
}

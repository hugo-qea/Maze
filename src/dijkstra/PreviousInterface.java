package dijkstra;
/**
 * Interface describing the behavior of a tree structure within the routes of a graph : the father is visited before the son on the route.
 * @author Hugo Queniat
 *
 */
public interface PreviousInterface {
	
	/**
	 * Finds the father of the issued vertex.
	 * @param vertex The son
	 * @return A VertexInterface which is the father.
	 */
	public VertexInterface getFather(VertexInterface vertex);
	
	/**
	 * Sets within the PreviousInterface vertexFather as vertexSon's father.
	 * @param vertexSon VertexInterface whose father is about to be set up.
	 * @param vertexFather VertexInterface, vertexSon's father.
	 */
	public void setFather(VertexInterface vertexSon, VertexInterface vertexFather);


}

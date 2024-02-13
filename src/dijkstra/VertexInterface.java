package dijkstra;
/**
 * Interface describing the characteristics of vertex within a graph.
 * @author Hugo Queniat
 *
 */
public interface VertexInterface {
	
	/**
	 * Gives the VertexInterface's recognition label, a component of its identity within the graph. 
	 * @return A String, Vertex's label.
	 */
	public String getLabel();
}

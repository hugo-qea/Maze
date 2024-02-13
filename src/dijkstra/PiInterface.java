package dijkstra;
/**
 * Interface describing the behavior of what we called a Pi function : holds a certain integer for each vertex.
 * @author Hugo Queniat
 *
 */
public interface PiInterface {
	
	/**
	 * Gives the Integer linked to the issued vertex.
	 * @param vertex VertexInterface which we want to know the Integer.
	 * @return Integer linked to the issued vertex.
	 */
	public Integer getPi(VertexInterface vertex);
	
	/**
	 * Sets a certain integer value for a certain vertex.
	 * @param vertex VertexInterface which Pi value is supposed to be set.
	 * @param value Integer that represents the value linked to the vertex.
	 */
	public void setPi(VertexInterface vertex, Integer value);
	

}

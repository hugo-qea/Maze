package maze;

import dijkstra.VertexInterface;

/**
 * Abstract class that implements a certain type of vertex which is the box within a maze (can be considered as a graph).
 * @author Hugo Queniat
 *
 */
public abstract class MBox implements VertexInterface {
	
	/**
	 * Int which is the lateral coordinate of the box.
	 */
	private final int X;
	
	/**
	 * Int which is the longitudinal coordinate of the box.
	 */
	private final int Y;
	
	/**
	 * String which is the type of the box.
	 */
	private final String label;
	
	/**
	 * Original Maze the box comes from.
	 */
	private final Maze origin;
	
	/**
	 * Constructor for MBox.
	 * @param X Int which will be the lateral coordinate of the box.
	 * @param Y Int which will be the longitudinal coordinate of the box
	 * @param origin Maze which the box will belong to.
	 * @param label String which holds the type of the box.
	 */
	public MBox(int X, int Y, Maze origin, String label) {
		this.X=X;
		this.Y=Y;
		this.origin=origin;
		this.label=label;
	}
	
	public String getLabel() {
		return label;
	}
	
	/**
	 * Getter for X.
	 * @return Int X
	 */
	public final int getX() {
		return X;
	}
	
	/**
	 * Getter for Y.
	 * @return Int Y
	 */
	public final int getY() {
		return Y;
	}

	/**
	 * Getter for origin.
	 * @return Maze origin.
	 */
	public final Maze getOrigin() {
		return origin;
	}
	
	
	

}

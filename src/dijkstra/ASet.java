package dijkstra;

import java.util.HashSet;
/**
 * Set of vertices responding to the traits of an ASetInterface.
 * @author Hugo Queniat
 *
 */
public class ASet extends HashSet<VertexInterface> implements ASetInterface {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for ASet.
	 */
	public ASet() {
		super();
	}

	@Override
	public boolean add(VertexInterface sommet) {
		// TODO Auto-generated method stub
		return super.add(sommet);
		
	}

	@Override
	public boolean isIn(VertexInterface sommet) {
		// TODO Auto-generated method stub
		return super.contains(sommet);
	}

}

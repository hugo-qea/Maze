package dijkstra;

import java.util.Hashtable;
/**
 * Implements the PreviousInterface using an Hashtable by taking advantage of the keys/values structure, using them as fathers and sons.
 * @author Hugo Queniat
 *
 */
public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for Previous.
	 */
	public Previous() {
		super();
	}

	@Override
	public VertexInterface getFather(VertexInterface sommet) {
		// TODO Auto-generated method stub
		return get(sommet);
	}

	@Override
	public void setFather(VertexInterface sommetFils, VertexInterface sommetPere) {
		// TODO Auto-generated method stub
		put(sommetFils, sommetPere);
	}

}

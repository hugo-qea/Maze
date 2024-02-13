package dijkstra;

import java.util.Hashtable;
/**
 * Implements a PiInterface through the structure of an Hashtable to use the purposes of keys and values as vertices and integers.
 * @author Hugo Queniat
 *
 */
public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for Pi.
	 */
	public Pi() {
		super();
	}

	@Override
	public Integer getPi(VertexInterface sommet) {
		// TODO Auto-generated method stub
		return get(sommet);
	}

	@Override
	public void setPi(VertexInterface sommet, Integer valeur) {
		// TODO Auto-generated method stub
		put(sommet, valeur);
		
	}

}

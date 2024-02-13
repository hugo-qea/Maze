package maze;

/**
 * Departure Box iteration of MBox.
 * @author Hugo Queniat
 *
 */
public class DBox extends MBox {
	
	/**
	 * Constructor for DBox.
	 * @param X Int which will be the lateral coordinate of the box.
	 * @param Y Int which will be the longitudinal coordinate of the box.
	 * @param origin Maze which the box will belong to.
	 */
	public DBox(int X, int Y, Maze origin) {
		super(X,Y,origin,"D");
	}

}

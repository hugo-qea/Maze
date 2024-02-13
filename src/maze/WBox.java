package maze;

/**
 * Wall Box iteration fo MBox.
 * @author Hugo Queniat
 *
 */
public class WBox extends MBox {
	
	/**
	 * Constructor for WBox.
	 * @param X Int which will be the lateral coordinate of the box.
	 * @param Y Int which will be the longitudinal coordinate of the box.
	 * @param origin Maze which the box will belong to.
	 */
	public WBox(int X, int Y, Maze origin) {
		super(X,Y,origin,"W");
	}

}

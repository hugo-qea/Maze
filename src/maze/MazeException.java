package maze;

/**
 * Certain type of exception concerning the inner construction of the maze (wrong number of departure or arrival boxes).
 * @author Hugo Queniat
 *
 */
public class MazeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6302278835550529058L;
	
	/**
	 * Constructor for MazeException.
	 * @param exceptionMessage String describing what issue happened and that triggered the exception.
	 */
	public MazeException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
	


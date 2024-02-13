package maze;

/**
 * Certain type of exception concerning an issue happening when solving or opening a maze.
 * @author Hugo Queniat
 *
 */
public class MazeIOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for MazeioException.
	 * @param exceptionMessage String describing what issue happened and that triggered the exception.
	 */
	public MazeIOException(String exceptionMessage) {
		super(exceptionMessage + "your file.");
	}

}

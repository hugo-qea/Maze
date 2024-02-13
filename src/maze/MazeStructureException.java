package maze;

/**
 * Exception occurring when the maze is actually fine but the dimensions of the maze are not within the requirements.
 * @author Hugo Queniat
 *
 */
public class MazeStructureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for MazeStructureException.
	 * @param exceptionMessage String describing what issue happened and that triggered the exception.
	 */
	public MazeStructureException(String exceptionMessage) {
		super(exceptionMessage);
	}

}

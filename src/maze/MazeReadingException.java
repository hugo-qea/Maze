package maze;

/**
 * A certain type of exception occurring when opening a maze that is not conform to what's expected.
 * @author Hugo Queniat
 *
 */
public class MazeReadingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6302278835550529058L;
	
	/**
	 * Constructor for MazeReadingException.
	 * @param exceptionMessage String describing what issue happened and that triggered the exception.
	 */
	public MazeReadingException(int lineNumber, String exceptionMessage) {
		super("The following error : " + exceptionMessage + "appeared at line " + lineNumber + " of your file.");
	}
	
}

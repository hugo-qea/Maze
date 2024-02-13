package dialog;

import javax.swing.JOptionPane;

import gui.MazeDisplayApp;
/**
 * JOptionPane used in case the user chose to leave the app or open an other maze, even though he modified a maze and didn't save it.
 * This Pane offers him the opportunity to reconsider.
 * @author Hugo Queniat
 *
 */
public class InsurancePane extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * App of origin.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	/**
	 * Constructor for InsurancePane.
	 * @param mazeDisplayApp MazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public InsurancePane(MazeDisplayApp mazeDisplayApp) {
		super("Saving App");
		this.mazeDisplayApp = mazeDisplayApp;
	}
	/**
	 * Opens the dialog asking him if he wants to save the maze and offering him a way to do so if he wants to.
	 * @return Boolean false if he aborts what he started or true if he continues on.
	 */
	public boolean isGoingThrough() {
		int response = showInternalOptionDialog(this, "The currently opened maze is not saved. Do you want to save it?", "Save", YES_NO_CANCEL_OPTION, WARNING_MESSAGE, null, null, null);
		if (response==CLOSED_OPTION || response ==CANCEL_OPTION) {
			return false;
		}
		else if (response==YES_OPTION) {
			new SaveDialog(mazeDisplayApp);
		}
		return true;
	}

}

package menuBar;

import javax.swing.*;

import gui.MazeDisplayApp;

/**
 * MenuBar at the top of the frame, holding every menu the user can access. 
 * @author Hugo Queniat
 *
 */
public class MazeDisplayMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * EditMenu displayed in the MenuBar.
	 */
	private final EditMenu editMenu;
	
	/**
	 * MazeMenu displayed in the MenuBar.
	 */
	private final MazeMenu mazeMenu;
	
	/**
	 * Constructor for MazeDisplayMenuBar.
	 * @param mazeDisplayApp App of origin.
	 */
	public MazeDisplayMenuBar(MazeDisplayApp mazeDisplayApp) {
		super();
		// Create and add menus
		add(new FileMenu(mazeDisplayApp));
		add(mazeMenu = new MazeMenu(mazeDisplayApp));
		add(editMenu = new EditMenu(mazeDisplayApp));
		
		
	}
	
	/**
	 * Getter for editMenu.
	 * @return EditMenu which is the EditMenu presented on the MenuBar.
	 */
	public EditMenu getEditMenu() {
		return editMenu;
	}
	
	/**
	 * Getter for mazeMenu.
	 * @return MazeMenu which is the MazeMenu presented on the MenuBar.
	 */
	public MazeMenu getMazeMenu() {
		return mazeMenu;
	}

}

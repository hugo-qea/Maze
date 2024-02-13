package boxSelectionMenu;

import javax.swing.JCheckBoxMenuItem;

import menuBar.EditMenu;

/**
 * Abstract class representing a MenuItem allowing the user to choose which box he wants to use to modify the displayed maze.
 * @author Hugo Queniat
 *
 */
public abstract class MBoxSelection extends JCheckBoxMenuItem {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Menu the MenuItem is linked to.
	 */
	protected EditMenu menu;
	/**
	 * Constructor for the MBoxSelection.
	 * @param title String which is the name of the box.
	 * @param menu EditMenu corresponding to the menu attribute.
	 */
	protected MBoxSelection(String title , EditMenu menu) {
		super(title, false);
		this.menu = menu;
	}

	
	

	
	
	
	
	
}

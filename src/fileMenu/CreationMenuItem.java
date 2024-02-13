package fileMenu;

import javax.swing.JMenuItem;

/**
 * Abstract class that creates a JMenuItem designed specifically for the JMenuItems that provides window to draw a new maze.
 * @author Hugo Queniat
 *
 */
public abstract class CreationMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Boolean that holds the info on whether the message coming when opening the MenuItem should not be shown or should be shown.
	 */
	private boolean doNotShowMe = false;
	
	/**
	 * Constructor for CreationMenuItem.
	 * @param title Name of the MenuItem
	 */
	public CreationMenuItem(String title) {
		super(title);
	}
	
	/**
	 * Gives whether the isDoNotShowMe option was validated before.
	 * @return Boolean doNotShowMe.
	 */
	public final boolean isDoNotShowMe() {
		return doNotShowMe;
	}
	
	/**
	 * Changes doNotShowMe to its opposite.
	 */
	public final void reverseDoNotShowMe() {
		doNotShowMe = !doNotShowMe;
	}
	
	/**
	 * Sets a potential new value to doNotShowMe (potentially still the same).
	 * @param flag Boolean that will become the new doNotShowMe.
	 */
	public final void setDoNotShowMe(boolean flag) {
		doNotShowMe = flag;
	}

}

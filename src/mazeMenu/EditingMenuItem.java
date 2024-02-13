package mazeMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;


import menuBar.MazeMenu;

/**
 * MenuItem within the MazeMenu that holds the purpose of allowing the user to edit the maze.
 * @author Hugo Queniat
 *
 */
public class EditingMenuItem extends JCheckBoxMenuItem implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeMenu the Item is linked to.
	 */
	private MazeMenu menu;
	
	/**
	 * Constructor for EditingMenuItem.
	 * @param menu MazeMenu which corresponds to the attribute menu.
	 */
	public EditingMenuItem(MazeMenu menu) {
		super("Editing",true);
		this.menu = menu;
		addActionListener(this);
	}
	
	/**
	 * What happens when the user selects this MenuItem, checks the Item and notifies then about the new mode.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setState(true);
		menu.editingMode();
	}

}

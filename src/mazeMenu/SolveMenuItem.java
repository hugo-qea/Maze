package mazeMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

import menuBar.MazeMenu;

/**
 * MenuItem within a MazeMenu that holds the purpose of displaying (if possible) the route between departure and arrival.
 * @author Hugo Queniat
 *
 */
public class SolveMenuItem extends JCheckBoxMenuItem implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeMenu which is the menu of origin.
	 */
	private MazeMenu menu;
	
	/**
	 * Constructor for SolveMenuItem.
	 * @param menu MazeMenu corresponding to the attribute menu.
	 */
	public SolveMenuItem(MazeMenu menu) {
		super("Solving",false);
		this.menu = menu;
		addActionListener(this);
	}

	/**
	 * What happens when the user selects this MenuItem, checks the box and notifies about the new mode.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		setState(true);
		menu.solveMaze();
	}

}

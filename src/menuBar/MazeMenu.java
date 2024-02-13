package menuBar;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import gui.MazeDisplayApp;
import maze.MazeException;
import mazeMenu.EditingMenuItem;
import mazeMenu.SolveMenuItem;

/**
 * Menu within the MenuBar, holds the purpose of allowing the user to shoose the view he desires.
 * @author Hugo Queniat
 *
 */
public class MazeMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * SolveMenuItem displayed in the menu.
	 */
	private SolveMenuItem solveMenuItem;
	
	/**
	 * EditingMenuItem displayed in the menu.
	 */
	private EditingMenuItem editingMenuItem;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Constructor for MazeMenu.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public MazeMenu(MazeDisplayApp mazeDisplayApp) {
		super("Maze");
		add(solveMenuItem = new SolveMenuItem(this));
		add(editingMenuItem = new EditingMenuItem(this));
		this.mazeDisplayApp = mazeDisplayApp;

	}
	
	/**
	 * Method that is called when the SolvingMenuItem is clicked on. Triggers the resolution of the maze and its display.
	 */
	public void solveMaze() {
		try {
			mazeDisplayApp.getMazeDisplayAppModel().displayShortestRoute();
		} catch (MazeException  e1) {
			solveMenuItem.setState(false);
			JOptionPane.showMessageDialog(solveMenuItem, e1.getMessage()+"\nModify your maze to meet the above requirements and try again.", "Error", JOptionPane.ERROR_MESSAGE, getDisabledIcon());
			return;
		}
		mazeDisplayApp.getMazeDisplayAppModel().setDisplayingAuthorisation(true);
		editingMenuItem.setState(false);
		mazeDisplayApp.getMazeDisplayAppModel().setEditingAuthorization(false);
	}
	
	/**
	 *  Methods that is called when the EditingMenuItem is clicked on, moving to the ediiting mode.
	 */
	public void editingMode() {
		// TODO Auto-generated method stub
		mazeDisplayApp.getMazeDisplayAppModel().setEditingAuthorization(true);
		solveMenuItem.setState(false);
		mazeDisplayApp.getMazeDisplayAppModel().setDisplayingAuthorisation(false);
	}
	
	/**
	 * Getter for editingMenuItem.
	 * @return EditingMenuItem shown in the menu.
	 */
	public EditingMenuItem getEditingMenuItem() {
		return editingMenuItem;
	}
	
	/**
	 * Getter for solveMenuItem
	 * @return SolveMenuIItem shown in the menu.
	 */
	public SolveMenuItem getSolveMenuItem() {
		return solveMenuItem;
	}

}

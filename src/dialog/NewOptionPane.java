package dialog;


import javax.swing.*;

import fileMenu.CreationMenuItem;
import gui.MazeDisplayApp;
/**
 * OptionPane whose objective is to get the maze's dimensions (while making sure it respects the established rules).
 * @author Hugo Queniat
 *
 */
public class NewOptionPane extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * App of origin which the pane is linked to.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	
	
	/** 
	 * 
	 * Constructor for NewOptionPane.
	 * Displays a confirmation message by the end, to make sure the user didn't make a mistake.
	 * Displays a warning message at the beginning, letting the user know what the boundaries are for the maze. This message can be deactivated via a checkbox to not bore the user with it.
	 * @param mazeDisplayApp MazeDisplayApp corresponding to the attribute mazeDisplayApp
	 * 
	 */
	public NewOptionPane(MazeDisplayApp mazeDisplayApp, CreationMenuItem menu) {
		super("New Maze");
		int width, length;
		this.mazeDisplayApp = mazeDisplayApp;
		if (mazeDisplayApp.getMazeDisplayAppModel().isModified()) {
			InsurancePane checkSave = new InsurancePane(mazeDisplayApp);
			if (!(checkSave.isGoingThrough())) {return;}
		}
		boolean flag = menu.isDoNotShowMe();
		if (!flag) {
			int input = showOptionDialog(this,new PanelInfo("Before going any further, let us introduce you to a set of rules we came up with, to make sure the algorithm runs smoothly.\nMaximum rows : 100\nMaximum columns : 100\nMaximum total boxes : 2500\nThe selection you will be offered is set up accordingly.", menu), "New Maze", OK_CANCEL_OPTION, PLAIN_MESSAGE, null, null, null);				
			if (input==CANCEL_OPTION || input==CLOSED_OPTION) {
				menu.setDoNotShowMe(flag);
				return;
			}
		}
		while (true) {
			try {
				width = getDimension("Columns", 100);
				length = getDimension("Rows", Math.min(100, 2500/width));
			} catch (NullPointerException e) {return;}
			int input2 = showConfirmDialog(this,"Are those the intended values?\n" + "Rows : " + length + "\nColumns :" + width, "Summary", YES_NO_CANCEL_OPTION);
			if (input2==YES_OPTION) {
				break;
			}
			else if (input2==CANCEL_OPTION || input2==CLOSED_OPTION) {return;}
			else continue;
		}
		this.mazeDisplayApp.getMazeDisplayAppModel().setMazeDisplayAppModel(width, length);
	}
	
	/**
	 * Asks the user to enter a positive integer that corresponds to the labeled object's size.
	 * @param label Which object's size is the algorithm supposed to get from the user.
	 * @param limit Maximum integer the user is able to choose.
	 * @return User's int of choice, or null if he cancels or closes the pane.
	 */
	private int getDimension(String label, int limit) {
		Integer[] tab = new Integer[limit];
		for (int k=0; k<limit; k++) {
			tab[k] = k+1;
		}
		int res = (Integer) showInputDialog(this, "Enter Maze's number of "+label, label, QUESTION_MESSAGE, null, tab, tab[0]);
		return res;
	}
}



package dialog;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import fileMenu.CreationMenuItem;
import gui.MazeDisplayApp;
import maze.MazeIOException;
import maze.MazeReadingException;
import maze.MazeStructureException;
/**
 * OpenDialog that allows the user to specify a file he wants the program to open as its maze. 
 * Makes sure the file is readable as a maze and, otherwise, asks the user to modify its file or choose another one.
 * @author Hugo Queniat
 *
 */
public class OpenDialog extends JFileChooser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Constructor for OpenDialog.
	 * Displays, at the beginning, a warning message telling the user how the MazeReading works, can be deactivated through a checkbox.
	 * @param mazeDisplayApp Original App.
	 * @param menu MenuItem the DialogWindow is linked to.
	 */
	public OpenDialog(MazeDisplayApp mazeDisplayApp, CreationMenuItem menu) {
		super("Open Maze");
		setCurrentDirectory(new File("."+File.separator));
		if (mazeDisplayApp.getMazeDisplayAppModel().isModified()) {
			InsurancePane checkSave = new InsurancePane(mazeDisplayApp);
			if (!(checkSave.isGoingThrough())) {return;}
		}
		boolean flag = menu.isDoNotShowMe();
		if (!flag) {
			int input = JOptionPane.showOptionDialog(this,new PanelInfo("Before going any further, let us introduce you to a set of rules we came up with, to make sure the algorithm runs smoothly.\n\tMaximum rows : 100\n\tMaximum columns : 100\n\tMaximum total boxes : 2500\n\nFurthermore, in order for the program to be able to recognize your maze, your file should only feature several types of characters :\n\t'E' for the available routes ;\n\t'W' for the walls ;\n\t'D' for the departure box ;\n\t'A' for the arrival box.\n\nMoreover, every line of your file must be the same length.\n\nPlease bear all those requirements in mind when you choose the file you want to use.", menu), "New Maze", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);				
			if (input==JOptionPane.CANCEL_OPTION || input==JOptionPane.CLOSED_OPTION) {
				menu.setDoNotShowMe(flag);
				return;
			}
		}
		int response = showDialog(this, "Open Maze");
		if (response == JFileChooser.APPROVE_OPTION) {
			String adress = getSelectedFile().toString();
			try {
				mazeDisplayApp.getMazeDisplayAppModel().initFromFile(adress);
			} catch (MazeReadingException e) {JOptionPane.showOptionDialog(this,e.getMessage()+"\nRemember that each line of your file should have the same number of characters, and those should be either 'E', 'A', 'D' or 'W'.\nModify your file or choose another one and try again.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			} catch (MazeIOException e) {JOptionPane.showOptionDialog(this,e.getMessage()+"\nThe issue happened while handling your file. Try again or choose another one.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);				
			} catch (MazeStructureException e) {JOptionPane.showOptionDialog(this,e.getMessage()+"\nModify your file to match the requirements we have established earlier and try again", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);}				
		}
	}

}

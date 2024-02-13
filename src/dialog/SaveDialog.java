package dialog;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.MazeDisplayApp;
import maze.MazeIOException;
/**
 * Window that allows the user to save his maze (displayed on the window) to his location of choice.
 * @author Hugo Queniat
 *
 */
public class SaveDialog extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for SaveDialog.
	 * @param mazeDisplayApp Original App
	 */
	public SaveDialog(MazeDisplayApp mazeDisplayApp) {
		super();
		setCurrentDirectory(new File("."+File.separator));
		int response = showDialog(this, "Save As");
		if (response == JFileChooser.APPROVE_OPTION) {
			String adress = getSelectedFile().toString();
			try {
				mazeDisplayApp.getMazeDisplayAppModel().saveToFile(adress);
			} catch (MazeIOException e) {JOptionPane.showOptionDialog(this,e.getMessage()+"\nThe error happened while handling the file. Please try again or change your output file.", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);}
		}
	}

}

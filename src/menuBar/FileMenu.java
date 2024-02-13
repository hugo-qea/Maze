package menuBar;

import javax.swing.*;

import fileMenu.NewMenuItem;
import fileMenu.OpenMenuItem;
import fileMenu.QuitMenuItem;
import fileMenu.SaveMenuItem;
import gui.MazeDisplayApp;

/**
 * Menu within the MenuBar, holds the purpose of offering the ôssibility to the user to save, open ,create a new maze or to quit the app. 
 * @author Hugo Queniat
 *
 */
public class FileMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for FileMenu.
	 * @param mazeDisplayApp App of origin.
	 */
	public FileMenu(MazeDisplayApp mazeDisplayApp) {
		super("File");
		// Create and add menu items
		add(new NewMenuItem(mazeDisplayApp));
		add(new OpenMenuItem(mazeDisplayApp));
		add(new SaveMenuItem(mazeDisplayApp));
		add(new QuitMenuItem(mazeDisplayApp));
	}

}

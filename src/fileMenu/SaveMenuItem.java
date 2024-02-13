package fileMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import dialog.SaveDialog;
import gui.MazeDisplayApp;

/**
 * MenuItem that handles the saving purposes, allowing the user to save the currently displayed maze.
 * @author Hugo Queniat
 *
 */
public class SaveMenuItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Constructor for SaveMenuItem.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public SaveMenuItem(MazeDisplayApp mazeDisplayApp) {
		super("Save");
		this.mazeDisplayApp = mazeDisplayApp;
		addActionListener(this);
	}
	
	/**
	 * What happens when the user clicks on this MenuItem. Offers him a way to save the maze through a spearate dialog.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		SaveDialog saveDialog = new SaveDialog(mazeDisplayApp);
	}

}

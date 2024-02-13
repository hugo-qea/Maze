package fileMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import dialog.InsurancePane;
import gui.MazeDisplayApp;

/**
 * JMenuItem designed to handle the quitting demands of the user.
 * @author hugoqueniat
 *
 */
public class QuitMenuItem extends JMenuItem implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Constructor for QuitMenuItem.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public QuitMenuItem(MazeDisplayApp mazeDisplayApp) {
		super("Quit");
		this.mazeDisplayApp = mazeDisplayApp;
		addActionListener(this);
	}
	
	/**
	 * What triggers a click on this MenuItem. Asks the user, if necessary, whether he wants to save the maze or not. Then, exits the app.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((mazeDisplayApp.getMazeDisplayAppModel().isModified())) {
			InsurancePane askSave = new InsurancePane(mazeDisplayApp);
			if (!(askSave.isGoingThrough())) {
				return;
			}
		}
		System.exit(0);
	}

}

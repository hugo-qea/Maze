package gui;

import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.event.*;
import dialog.InsurancePane;
import menuBar.MazeDisplayMenuBar;

/**
 * The main app which all other frames and windows derive from for the displaying and solving of a maze.
 * @author Hugo Queniat
 *
 */
public class MazeDisplayApp extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayMenuBar which is the bar displayed on top of the frame.
	 */
	private final MazeDisplayMenuBar mazeDisplayMenuBar;
	
	/**
	 * MazeDisplayPanel which is the panel displayed within the frame.
	 */
	private final MazeDisplayPanel mazeDisplayPanel;
	
	/**
	 * MazeDisplayAppModel which models what's supposed to be displayed in the panel.
	 */
	private  MazeDisplayAppModel mazeDisplayAppModel;
	
	/**
	 * Constructor for MazeDisplayApp.
	 */
	public MazeDisplayApp() {
		super("Maze Display Application");
		//Menu Bar Creation
		setJMenuBar(mazeDisplayMenuBar = new MazeDisplayMenuBar(this));
		//Window content Creation
		setContentPane(mazeDisplayPanel = new MazeDisplayPanel(this));
		mazeDisplayAppModel = new MazeDisplayAppModel(0, 0, this);
		mazeDisplayAppModel.addObserver(this);
		//Window setup
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	/**
	 * Returns the mazeDisplayAppModel that models the shown maze in the DisplayPanel.
	 * @return mazeDisplayAppModel
	 */
	public MazeDisplayAppModel getMazeDisplayAppModel() {
		// TODO Auto-generated method stub
		return mazeDisplayAppModel;
	}
	
	/**
	 * A performed action from the user triggers the app to notify the DisplayPanel that the situation potentially changed and, then, the displaying panel should too.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		mazeDisplayPanel.notifyForUpdate();
	}
	
	/**
	 * Returns the MenuBar attached to the app
	 * @return mazeDisplayMenuBar
	 */
	public MazeDisplayMenuBar getMazeDisplayMenuBar() {
		return mazeDisplayMenuBar;
	}
	
	/**
	 * Processes the fact that the user clicked on the ClosingApp button. It asks the user if he wants to save before closing if he has not saved the maze displayed and later closes the app.
	 */
	protected void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
        	if (mazeDisplayAppModel.isModified()) {
				InsurancePane askSave = new InsurancePane(this);
        		if (!(askSave.isGoingThrough())) {
        			return;
        		}
        	}
        	System.exit(0);
        }
	}
}

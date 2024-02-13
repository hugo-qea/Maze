package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * MouseListner for the drawing panel in the app.
 * @author hugoqueniat
 *
 */
public class MazeDisplayPanelMouseListener implements MouseListener {
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Constructor for MazeDisplayPanelMouseListener.
	 * @param mazeDisplayApp MazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public MazeDisplayPanelMouseListener(MazeDisplayApp mazeDisplayApp) {
		super();
		this.mazeDisplayApp = mazeDisplayApp;
	}
	
	/**
	 * When a click occurs, notifies so the model behind the panel.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		mazeDisplayApp.getMazeDisplayAppModel().mouseClick(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

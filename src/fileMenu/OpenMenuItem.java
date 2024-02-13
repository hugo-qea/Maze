package fileMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.InsurancePane;
import dialog.OpenDialog;
import gui.MazeDisplayApp;

/**
 * MenuItem that serves the purpose of launching an attempt to create a brand new maze.
 * @author Hugo Queniat
 *
 */
public class OpenMenuItem extends CreationMenuItem implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Constructor for OpenMenuItem.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public OpenMenuItem(MazeDisplayApp mazeDisplayApp) {
		// TODO Auto-generated constructor stub
		super("Open");
		this.mazeDisplayApp = mazeDisplayApp;
		addActionListener(this);
	}
	
	/**
	 * What happens when the user clicks on this MenuItem. If necessary, asks the user to save the maze and then handles the opening demand.
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (mazeDisplayApp.getMazeDisplayAppModel().isModified()) {
			InsurancePane askSave = new InsurancePane(mazeDisplayApp);
		}
		OpenDialog openDialog = new OpenDialog(mazeDisplayApp, this);
	}

}

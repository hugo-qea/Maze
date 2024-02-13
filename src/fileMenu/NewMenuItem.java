package fileMenu;

import java.awt.event.*;
import dialog.InsurancePane;
import dialog.NewOptionPane;
import gui.MazeDisplayApp;

/**
 * An option in the "File" menu in the MenuBar, opens a window that allows the user to create a brand new maze. 
 * @author Hugo Queniat
 *
 */
public class NewMenuItem extends CreationMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayApp which is the original App the menu is linked to.
	 */
	private final MazeDisplayApp mazeDisplayApp;

	/**
	 * Constructor for NewMenuItem.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public NewMenuItem(MazeDisplayApp mazeDisplayApp) {
		super("New");
		this.mazeDisplayApp = mazeDisplayApp;
		addActionListener(this);
	}
	
	/**
	 * What happens when the user clicks on that button. If the displayed maze is not saved, an Insurance Pane is opened before opening a NewOptionPane, otherwise it just opens it directly.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (mazeDisplayApp.getMazeDisplayAppModel().isModified()) {
			new InsurancePane(mazeDisplayApp);
		}
		new NewOptionPane(this.mazeDisplayApp, this);
	}
}


package menuBar;

import javax.swing.*;

import boxSelectionMenu.*;
import gui.MazeDisplayApp;
/**
 * Menu within the MenuBar. Holds the purpose of allowing the user to choose what box will be the next he chooses to modify.
 * @author Hugo Queniat
 *
 */
public class EditMenu extends JMenu  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ABoxSelection that appears in the menu
	 */
	private final ABoxSelection aBox;
	
	/**
	 * EBoxSelection that appears in the menu
	 */
	private final EBoxSelection eBox;
	
	/**
	 * WBoxSelection that appears in the menu
	 */
	private final WBoxSelection wBox;
	
	/**
	 * DBoxSelection that appears in the menu
	 */
	private final DBoxSelection dBox;
	
	/**
	 * NoneSelection that appears in the menu
	 */
	private final NoneSelection noneBox;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private MazeDisplayApp mazeDisplayApp;

	/**
	 * Constructor for EditMenu.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public EditMenu(MazeDisplayApp mazeDisplayApp) {
		super("Edit");
		this.mazeDisplayApp = mazeDisplayApp;
		// Create and add menu items
		add(noneBox = new NoneSelection(this));
		add(eBox = new EBoxSelection(this));
		add(wBox = new WBoxSelection(this));
		add(dBox = new DBoxSelection(this));
		add(aBox = new ABoxSelection(this));
	}
	
	/**
	 * Method called when the WBoxMenuItem is selected, updates the other ones accordingly.
	 */
	public void wActivated() {
		// TODO Auto-generated method stub
		mazeDisplayApp.getMazeDisplayAppModel().setBoxSelected("W");
		eBox.setState(false);
		noneBox.setState(false);
		aBox.setState(false);
		dBox.setState(false);
		
	}
	
	/**
	 * Method called when the noneMenuItem is selected, updates the other ones accordingly.
	 */
	public void noneActivated() {
		// TODO Auto-generated method stub
		mazeDisplayApp.getMazeDisplayAppModel().setBoxSelected(null);
		eBox.setState(false);
		wBox.setState(false);
		aBox.setState(false);
		dBox.setState(false);
	}
	
	/**
	 * Method called when the ABoxMenuItem is selected, updates the other ones accordingly.
	 */
	public void aActivated() {
		mazeDisplayApp.getMazeDisplayAppModel().setBoxSelected("A");
		eBox.setState(false);
		wBox.setState(false);
		noneBox.setState(false);
		dBox.setState(false);
	}
	
	/**
	 * Method called when the EBoxMenuItem is selected, updates the other ones accordingly.
	 */
	public void eActivated() {
		mazeDisplayApp.getMazeDisplayAppModel().setBoxSelected("E");
		aBox.setState(false);
		wBox.setState(false);
		noneBox.setState(false);
		dBox.setState(false);
	}
	
	/**
	 * Method called when the DBoxMenuItem is selected, updates the other ones accordingly.
	 */
	public void dActivated() {
		mazeDisplayApp.getMazeDisplayAppModel().setBoxSelected("D");
		eBox.setState(false);
		wBox.setState(false);
		noneBox.setState(false);
		aBox.setState(false);
	}



	

}

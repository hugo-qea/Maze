package boxSelectionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuBar.EditMenu;
/**
 * Arrival Box iteration of the MBoxSelection.
 * @author Hugo Queniat
 *
 */
public class ABoxSelection extends MBoxSelection implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for the ABoxSelection
	 * @param menu EditMenu corresponding to the menu super attribute.
	 */
	public ABoxSelection(EditMenu menu) {
		super("Arrival", menu);
		addActionListener(this);
	}
	/**
	 * Receives the information of a click, checks the checkbox linked to the MenuItem and transfers the info to the competent object that can handle it properly, the editMenu of origin. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setState(true);
		menu.aActivated();
	}

}

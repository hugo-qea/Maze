package boxSelectionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuBar.EditMenu;
/**
 * Departure Box iteration of MBoxSelection.
 * @author Hugo Queniat
 *
 */
public class DBoxSelection extends MBoxSelection implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for the DBoxSelection.
	 * @param menu EditMenu corresponding to the super attribute menu.
	 */
	public DBoxSelection(EditMenu menu) {
		super("Departure", menu);
		addActionListener(this);
	}
	/**
	 * Receives the information of a click, checks the checkbox linked to the MenuItem and transfers the info to the competent object that can handle it properly, the editMenu of origin. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setState(true);
		menu.dActivated();
	}

}

package boxSelectionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuBar.EditMenu;
/**
 * Wall Box iteration of MBoxSelection.
 * @author Hugo Queniat
 *
 */
public class WBoxSelection extends MBoxSelection implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for the WBoxSelection
	 * @param menu EditMenu corresponding to the menu super attribute.
	 */
	public WBoxSelection(EditMenu menu) {
		super("Wall", menu);
		addActionListener(this);
	}
	/**
	 * Receives the information of a click, checks the checkbox and transfers the info to the competent object that can handle it properly, the editMenu of origin. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setState(true);
		menu.wActivated();
	}


}

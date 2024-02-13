package boxSelectionMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

import menuBar.EditMenu;
/**
 * JMenuItem corresponding to the no box selected in a Menu.
 * @author Hugo Queniat
 *
 */
public class NoneSelection extends JCheckBoxMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * JMenu of origin.
	 */
	private EditMenu menu;
	/**
	 * Constructor for NoneSelection.
	 * @param menu
	 */
	public NoneSelection(EditMenu menu) {
		super("None", true);
		this.menu = menu;
		addActionListener(this);
	}
	/**
	 * Receives the information of a click, checks the checkbox and transfers info to the competent object that can handle it properly, the editMenu of origin. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setState(true);
		menu.noneActivated();
	}

}

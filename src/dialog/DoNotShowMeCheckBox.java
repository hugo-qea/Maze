package dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import fileMenu.CreationMenuItem;

/**
 * Class corresponding to a checkbox appearing on messages and that, if checked, the mesage doesn't appear anymore later.
 * @author Hugo Queniat
 *
 */
public class DoNotShowMeCheckBox extends JCheckBox implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * MenuItem that displays messages using the specified checkbox.
	 */
	private final CreationMenuItem menu;
	/**
	 * Constructor for DoNotShowMeCHeckBox
	 * @param menu CreationMenuItem corresponding to the attribute menu.
	 */
	public DoNotShowMeCheckBox(CreationMenuItem menu) {
		super("Do not show me again");
		this.menu = menu;
		addActionListener(this);
	}
	/**
	 * The user checks or unchecks the box : it means that he chooses the opposite from the previous state menu.doNotShowMe was in.
	 * Therefore the method asks the menu to reverse doNotShowMe.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		menu.reverseDoNotShowMe();
	}

}

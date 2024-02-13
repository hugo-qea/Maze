package dialog;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import fileMenu.CreationMenuItem;
/**
 * Special JPanel used for the messages triggered by NewMenuItem and OpenMenuItem, allows to handle the 'Do Not Show Me Again' option.
 * @author Hugo Queniat
 *
 */
public class PanelInfo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for PanelInfo.
	 * @param msg DialogWindow message.
	 * @param menu Original Menu Item that was entered.
	 */
	public PanelInfo(String msg, CreationMenuItem menu) {
		super(new GridLayout(2,1));
		JTextArea msgLabel = new JTextArea(msg);
		DoNotShowMeCheckBox checkBox = new DoNotShowMeCheckBox(menu);
		add(msgLabel);
		add(checkBox);
	}

}

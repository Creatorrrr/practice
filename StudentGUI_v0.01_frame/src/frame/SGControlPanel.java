package frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.SGConstants.EEditMenuItems;
import constants.SGConstants.ELabelItems;
import controller.SGInterfaceEvent;

public class SGControlPanel extends JPanel {
	
	private JButton button;
	
	public SGControlPanel() {
		setLayout(new GridLayout(0, 5, 0, 0));
		
		for(EEditMenuItems e : EEditMenuItems.values()) {
			button = new JButton(e.name());
			button.addActionListener(new SGInterfaceEvent());
			add(button);
		}
	}

}

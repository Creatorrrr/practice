package frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.SGConstants.ELabelItems;

public class SGInputPanel extends JPanel {
	
	private JTextField[] textField;

	public SGInputPanel() {
		setLayout(new GridLayout(0, 3, 10, 10));
		
		textField = new JTextField[ELabelItems.values().length];
		
		for(ELabelItems e : ELabelItems.values()) {
			int p = e.ordinal();
			
			textField[p] = new JTextField();
			add(new JLabel(e.name()));
			add(textField[p]);
			if(p == e.이름.ordinal()) {
				add(new JButton("확인"));
			} else {
				add(new JPanel());
			}
		}
	}

}

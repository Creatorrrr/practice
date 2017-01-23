package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.SGConstants.ELabelItems;

public class SGRegisterInterface extends JDialog {

	private JTextField[] textField;

	public SGRegisterInterface() {
		
		setLayout(new GridLayout(0, 2, 10, 10));
		
		textField = new JTextField[ELabelItems.values().length];
		
		for(ELabelItems e : ELabelItems.values()) {
			int p = e.ordinal();
			textField[p] = new JTextField();
			add(new JLabel(e.name()));
			add(textField[p]);
		}
		
		add(new JButton("등록"));
		add(new JButton("취소"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}

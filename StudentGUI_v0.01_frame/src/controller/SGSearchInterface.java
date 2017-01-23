package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SGSearchInterface extends JDialog {

	private JTextField textField;

	public SGSearchInterface() {
		setLayout(new GridLayout(0, 3, 10, 10));
		textField = new JTextField();
		
		add(new JLabel("학번"));
		add(textField);
		add(new JButton("수정"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 100);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}

package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SGDeleteInterface extends JDialog {

	private JTextField textField;

	public SGDeleteInterface() {
		setLayout(new GridLayout(0, 3, 10, 10));
		textField = new JTextField();
		
		add(new JLabel("학번"));
		add(textField);
		add(new JButton("삭제"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 100);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

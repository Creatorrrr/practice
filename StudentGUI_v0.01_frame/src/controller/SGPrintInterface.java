package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class SGPrintInterface extends JDialog {
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private JRadioButton sortName;	
	private JRadioButton sortStudentId;

	public SGPrintInterface() {
		setModal(true);
		
		setLayout(new GridLayout(2, 2, 0, 0));
		
		buttonGroup = new ButtonGroup();
		
		sortName = new JRadioButton("�й��� ���");
		sortStudentId = new JRadioButton("������ ���");
		
		buttonGroup.add(sortName);
		buttonGroup.add(sortStudentId);
		
		add(sortName);
		add(sortStudentId);
		
		add(new JButton("���"));
		add(new JButton("���"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}

package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SGDeleteInterface extends JDialog {

	private JTextField textField;

	public SGDeleteInterface() {
		setModal(true);	// ��ȭ���� ���� �� ���� ������ ���� �Ұ��ϵ��� ����
		
		setLayout(new GridLayout(2, 2, 10, 10));
		textField = new JTextField();
		
		add(new JLabel("�й�"));
		add(textField);
		add(new JButton("����"));
		add(new JButton("���"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

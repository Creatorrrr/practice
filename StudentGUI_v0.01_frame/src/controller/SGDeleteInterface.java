package controller;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SGDeleteInterface extends JDialog {

	private JTextField textField;

	public SGDeleteInterface() {
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(2, 2, 10, 10));
		textField = new JTextField();
		
		add(new JLabel("학번"));
		add(textField);
		add(new JButton("삭제"));
		add(new JButton("취소"));
	}
	
	public void initialize() {
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

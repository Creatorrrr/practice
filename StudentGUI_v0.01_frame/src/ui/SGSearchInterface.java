package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.SGConstants.EActionButtonItems;
import controller.SGManageStudent;

public class SGSearchInterface extends JDialog {
	
	private SGManageStudent manageStudent;

	private JTextField textField;
	
	private SGSearchInterface searchInterface;

	public SGSearchInterface() {
		textField = new JTextField();
		searchInterface = this;
	}
	
	public void initialize(SGManageStudent manageStudent) {
		JButton button;	
		
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.manageStudent = manageStudent;
		
		setModal(true);	// ��ȭ���� ���� �� ���� ������ ���� �Ұ��ϵ��� ����
		
		setLayout(new GridLayout(2, 2, 10, 10));
		
		add(new JLabel("�й�"));
		add(textField);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.�˻�.name());
		add(button);
		button.addActionListener(event);
		button = new JButton(EActionButtonItems.�ݱ�.name());
		add(button);
		button.addActionListener(event);
	}
	
	public void openDialog() {
		this.setVisible(true);
	}
	
	private void clearTextField() {
		textField.setText("");
	}

	public class ButtonEvent implements ActionListener {
		
		String studentId;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case �˻�:
				studentId = textField.getText();
				
				manageStudent.searchStudent(studentId);
				
				clearTextField();
				
				searchInterface.dispose();
				
				break;
			case �ݱ�:
				searchInterface.dispose();
				break;
			}		
		}
		
	}
}

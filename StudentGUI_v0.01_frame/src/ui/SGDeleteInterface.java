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

public class SGDeleteInterface extends JDialog {

	private JTextField textField;
	
	private SGManageStudent manageStudent;
	
	private SGDeleteInterface deleteInterface;

	public SGDeleteInterface(SGManageStudent manageStudent) {
		textField = new JTextField();
		this.manageStudent = manageStudent;
		deleteInterface = this;
	}
	
	public void initialize() {
		JButton button;
		
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(2, 2, 10, 10));
		
		add(new JLabel("학번"));
		add(textField);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton("삭제");
		add(button);
		button.addActionListener(event);
		button = new JButton("닫기");
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
			case 삭제:
				studentId = textField.getText();
				
				manageStudent.deleteStudent(studentId);
				
				clearTextField();
				
				deleteInterface.dispose();
				
				break;
			case 닫기:
				deleteInterface.dispose();
				break;
			}		
		}
		
	}
}

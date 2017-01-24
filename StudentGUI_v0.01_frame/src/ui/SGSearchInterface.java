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
		
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(2, 2, 10, 10));
		
		add(new JLabel("학번"));
		add(textField);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.검색.name());
		add(button);
		button.addActionListener(event);
		button = new JButton(EActionButtonItems.닫기.name());
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
			case 검색:
				studentId = textField.getText();
				
				manageStudent.searchStudent(studentId);
				
				clearTextField();
				
				searchInterface.dispose();
				
				break;
			case 닫기:
				searchInterface.dispose();
				break;
			}		
		}
		
	}
}

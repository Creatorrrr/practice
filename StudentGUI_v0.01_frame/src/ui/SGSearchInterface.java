package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.SGConstants.EActionButtonItems;
import constants.SGConstants.ELabelItems;
import controller.SGManageStudent;
import controller.SGStudent;
import frame.SGPrintPanel;

public class SGSearchInterface extends JDialog {
	
	private SGManageStudent manageStudent;
	private SGPrintPanel printPanel;

	private JTextField textField;
	
	private SGSearchInterface searchInterface;

	public SGSearchInterface(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		textField = new JTextField();
		this.manageStudent = manageStudent;
		this.printPanel = printPanel;
		searchInterface = this;
	}
	
	public void initialize() {
		JButton button;	
		
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(2, 2, 10, 10));
		
		add(new JLabel(ELabelItems.STUDENT_ID.getLabel()));
		add(textField);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.SEARCH.getUsage());
		button.setActionCommand(EActionButtonItems.SEARCH.name());
		button.addActionListener(event);
		add(button);
		button = new JButton(EActionButtonItems.CLOSE.getUsage());
		button.setActionCommand(EActionButtonItems.CLOSE.name());
		button.addActionListener(event);
		add(button);
	}
	
	public void openDialog() {
		this.setVisible(true);
	}
	
	private void clearTextField() {
		textField.setText("");
	}

	public class ButtonEvent implements ActionListener {
		
		String studentId;
		ArrayList<SGStudent> studentList;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case SEARCH:
				studentId = textField.getText();
				
				studentList = manageStudent.searchStudent(studentId);
				
				if(studentList != null) {
					printPanel.setTable(manageStudent.searchStudent(studentId));
				} else {
					// 경고창
				}
				
				clearTextField();
				
				searchInterface.dispose();
				
				break;
			case CLOSE:
				searchInterface.dispose();
				break;
			}		
		}
		
	}
}

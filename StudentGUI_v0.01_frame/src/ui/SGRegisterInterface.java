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

public class SGRegisterInterface extends JDialog {

	private ArrayList<JTextField> textField;
	private SGManageStudent manageStudent;
	
	private SGRegisterInterface registerInterface;

	public SGRegisterInterface(SGManageStudent manageStudent) {
		textField = new ArrayList<>();
		this.manageStudent = manageStudent;		
		registerInterface = this;
	}
	
	public void initialize() {
		JButton button;
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(6, 2, 10, 10));
		
		for(ELabelItems e : ELabelItems.values()) {
			textField.add(new JTextField());
			add(new JLabel(e.name()));
			add(textField.get(e.ordinal()));
		}
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.등록.name());
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
		for(JTextField e : textField) {
			e.setText("");
		}
	}

	public class ButtonEvent implements ActionListener {
		
		String name;
		String studentId;
		int kor, eng, math;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case 등록:
				name = textField.get(0).getText();
				studentId = textField.get(1).getText();
				kor = Integer.parseInt(textField.get(2).getText());
				eng = Integer.parseInt(textField.get(3).getText());
				math = Integer.parseInt(textField.get(4).getText());
				
				manageStudent.registerStudent(name, studentId, kor, eng, math);
				
				clearTextField();
				
				registerInterface.dispose();
				
				break;
			case 닫기:
				registerInterface.dispose();
				break;
			}		
		}
		
	}
}

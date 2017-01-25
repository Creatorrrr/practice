package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.SGConstants.EActionButtonItems;
import constants.SGConstants.ELabelItems;
import controller.SGManageStudent;
import ui.SGRegisterInterface.ButtonEvent;

public class SGModifyInterface extends JDialog {
	
	private ArrayList<JTextField> textField;
	
	private SGManageStudent manageStudent;
	
	private SGModifyInterface modifyInterface;

	public SGModifyInterface(SGManageStudent manageStudent) {
		textField = new ArrayList<>();
		
		this.manageStudent = manageStudent;
		
		modifyInterface = this;
	}

	public void initialize() {
		JButton button;
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);	// 대화상자 실행 시 상위 프레임 조작 불가하도록 설정
		
		setLayout(new GridLayout(7, 2, 10, 10));
		
		textField.add(new JTextField());	// 최초 학번 받기용 (수정필요)
		add(new JLabel("학번"));				// 최초 학번 받기용 (수정필요)
		add(textField.get(0));				// 최초 학번 받기용 (수정필요)
		
		for(ELabelItems e : ELabelItems.values()) {
			textField.add(new JTextField());
			add(new JLabel(e.name()));
			add(textField.get(e.ordinal() + 1));
		}
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.수정.name());
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
		String target;
		
		String name;
		String studentId;
		int kor, eng, math;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case 수정:
				target = textField.get(0).getText();
				name = textField.get(1).getText();
				studentId = textField.get(2).getText();
				kor = Integer.parseInt(textField.get(3).getText());
				eng = Integer.parseInt(textField.get(4).getText());
				math = Integer.parseInt(textField.get(5).getText());
				
				manageStudent.modifyStudent(target, name, studentId, kor, eng, math);
				
				clearTextField();
				
				modifyInterface.dispose();
				
				break;
			case 닫기:
				modifyInterface.dispose();
				break;
			}		
		}
		
	}
}

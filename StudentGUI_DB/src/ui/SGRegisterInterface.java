package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.SGConstants.EActionButtonItems;
import constants.SGConstants.ELabelItems;
import constants.SGConstants.EOrderItems;
import controller.SGManageStudent;
import frame.SGPrintPanel;

public class SGRegisterInterface extends JDialog {

	private ArrayList<JTextField> textField;
	private SGManageStudent manageStudent;
	private SGPrintPanel printPanel;
	
	private SGRegisterInterface registerInterface;

	public SGRegisterInterface(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		textField = new ArrayList<>();
		this.manageStudent = manageStudent;
		this.printPanel = printPanel;
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
			add(new JLabel(e.getLabel()));
			add(textField.get(e.ordinal()));
			
			if(e.equals(ELabelItems.MATH)) {
				break;
			}
		}
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.REGIST.getUsage());
		button.setActionCommand(EActionButtonItems.REGIST.name());
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
			case REGIST:
				name = textField.get(0).getText();
				studentId = textField.get(1).getText();
				try {
					Integer.parseInt(studentId);
					kor = Integer.parseInt(textField.get(2).getText());
					eng = Integer.parseInt(textField.get(3).getText());
					math = Integer.parseInt(textField.get(4).getText());
					
					if(manageStudent.registerStudent(name, studentId, kor, eng, math)) {
						printPanel.setTable(manageStudent.searchStudent(null, EOrderItems.STUDENT_ID));
						JOptionPane.showMessageDialog(null, "등록되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "이미 등록된 학생입니다.");
					}
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "학번란, 점수란에 정수값을 입력해주세요.");
				}
				
				clearTextField();
				
				registerInterface.dispose();
				
				break;
			case CLOSE:
				registerInterface.dispose();
				break;
			default:
				break;
			}		
		}
		
	}
}

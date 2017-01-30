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
import frame.SGPrintPanel;
import ui.SGRegisterInterface.ButtonEvent;

public class SGModifyInterface extends JDialog {
	
	private ArrayList<JTextField> textField;
	
	private SGManageStudent manageStudent;
	private SGPrintPanel printPanel;
	
	private SGModifyInterface modifyInterface;

	public SGModifyInterface(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		textField = new ArrayList<>();
		
		this.manageStudent = manageStudent;
		this.printPanel = printPanel;
		
		modifyInterface = this;
	}

	public void initialize() {
		JButton button;
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);	// ��ȭ���� ���� �� ���� ������ ���� �Ұ��ϵ��� ����
		
		setLayout(new GridLayout(7, 2, 10, 10));
		
		textField.add(new JTextField());					// ���� �й� �ޱ�� (�����ʿ�)
		add(new JLabel(ELabelItems.STUDENT_ID.getLabel()));	// ���� �й� �ޱ�� (�����ʿ�)
		add(textField.get(0));								// ���� �й� �ޱ�� (�����ʿ�)
		
		for(ELabelItems e : ELabelItems.values()) {
			textField.add(new JTextField());
			add(new JLabel(e.getLabel()));
			add(textField.get(e.ordinal() + 1));
			
			if(e.equals(ELabelItems.MATH)) {
				break;
			}
		}
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.MODIFY.getUsage());
		button.setActionCommand(EActionButtonItems.MODIFY.name());
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
		String target;
		
		String name;
		String studentId;
		int kor, eng, math;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case MODIFY:
				target = textField.get(0).getText();
				name = textField.get(1).getText();
				studentId = textField.get(2).getText();
				kor = Integer.parseInt(textField.get(3).getText());
				eng = Integer.parseInt(textField.get(4).getText());
				math = Integer.parseInt(textField.get(5).getText());
				
				manageStudent.modifyStudent(target, name, studentId, kor, eng, math);
				
				printPanel.setTable(manageStudent.getStudentList());
				
				clearTextField();
				
				modifyInterface.dispose();
				
				break;
			case CLOSE:
				modifyInterface.dispose();
				break;
			}		
		}
		
	}
}
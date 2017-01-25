package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import constants.SGConstants.EActionButtonItems;
import constants.SGConstants.ESortOptionItems;
import controller.SGManageStudent;
import frame.SGPrintPanel;
import ui.SGDeleteInterface.ButtonEvent;

import javax.swing.ButtonGroup;

public class SGPrintInterface extends JDialog {
	
	private ButtonGroup buttonGroup;
	
	private JRadioButton sortName;	
	private JRadioButton sortStudentId;
	
	private SGManageStudent manageStudent;
	private SGPrintPanel printPanel;
	
	private SGPrintInterface printInterface;

	public SGPrintInterface(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		buttonGroup = new ButtonGroup();
		
		sortStudentId = new JRadioButton(ESortOptionItems.학번순출력.name());
		sortName = new JRadioButton(ESortOptionItems.성적순출력.name());
		
		this.manageStudent = manageStudent;
		this.printPanel = printPanel;
		
		printInterface = this;
	}
	
	public void initialize() {
		JButton button;
		
		this.setBounds(100, 100, 450, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setModal(true);
		
		setLayout(new GridLayout(2, 2, 0, 0));
		
		buttonGroup.add(sortStudentId);
		buttonGroup.add(sortName);
		
		add(sortStudentId);
		add(sortName);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton("출력");
		add(button);
		button.addActionListener(event);
		button = new JButton("취소");
		add(button);
		button.addActionListener(event);
	}
	
	public void openDialog() {
		this.setVisible(true);
	}
	
	public class ButtonEvent implements ActionListener {
		
		String studentId;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case 출력:
				if(sortStudentId.isSelected()) {
					printPanel.setTable(manageStudent.printStudent(ESortOptionItems.학번순출력.ordinal()));	// 임시로 학번순 고정
				} else if (sortName.isSelected()) {
					
				}
				printInterface.dispose();
				
				break;
			case 닫기:
				printInterface.dispose();
				break;
			}		
		}
		
	}

}

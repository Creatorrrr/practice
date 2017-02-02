package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import constants.SGConstants.EActionButtonItems;
import constants.SGConstants.ESortOptionItems;
import controller.SGManageStudent;
import controller.SGStudent;
import frame.SGPrintPanel;
import ui.SGDeleteInterface.ButtonEvent;

import javax.swing.ButtonGroup;

public class SGPrintInterface extends JDialog {
	
	private ButtonGroup buttonGroup;
	
	private JRadioButton sortScore;	
	private JRadioButton sortStudentId;
	
	private SGManageStudent manageStudent;
	private SGPrintPanel printPanel;
	
	private SGPrintInterface printInterface;

	public SGPrintInterface(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		buttonGroup = new ButtonGroup();
		
		sortStudentId = new JRadioButton(ESortOptionItems.SORT_BY_ID.getOrder());
		sortScore = new JRadioButton(ESortOptionItems.SORT_BY_SCORE.getOrder());
		
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
		buttonGroup.add(sortScore);
		
		add(sortStudentId);
		add(sortScore);
		
		ButtonEvent event = new ButtonEvent();
		
		button = new JButton(EActionButtonItems.PRINT.getUsage());
		button.setActionCommand(EActionButtonItems.PRINT.name());
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
	
	public class ButtonEvent implements ActionListener {
		
		String studentId;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EActionButtonItems.valueOf(e.getActionCommand())) {
			case PRINT:
				if(sortStudentId.isSelected()) {
					manageStudent.sortStudent(ESortOptionItems.SORT_BY_ID.ordinal());
				} else if (sortScore.isSelected()) {
					manageStudent.sortStudent(ESortOptionItems.SORT_BY_SCORE.ordinal());
				}
				
				printPanel.setTable(manageStudent.getStudentList());
				
				printInterface.dispose();
				
				break;
			case CLOSE:
				printInterface.dispose();
				break;
			}		
		}
		
	}

}

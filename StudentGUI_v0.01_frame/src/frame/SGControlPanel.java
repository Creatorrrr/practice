package frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.SGConstants.EEditButtonItems;
import controller.SGManageStudent;
import ui.SGDeleteInterface;
import ui.SGModifyInterface;
import ui.SGPrintInterface;
import ui.SGRegisterInterface;
import ui.SGSearchInterface;

public class SGControlPanel extends JPanel {
	
	private SGRegisterInterface registerInterface;
	private SGSearchInterface searchInterface;
	private SGPrintInterface printInterface;
	private SGDeleteInterface deleteInterface;
	private SGModifyInterface modifyInterface;
	
	public SGControlPanel(SGManageStudent manageStudent, SGPrintPanel printPanel) {
		registerInterface = new SGRegisterInterface(manageStudent);
		searchInterface = new SGSearchInterface(manageStudent);
		printInterface = new SGPrintInterface(manageStudent, printPanel);
		deleteInterface = new SGDeleteInterface(manageStudent);
		modifyInterface = new SGModifyInterface(manageStudent);
		
		JButton button;
		
		setLayout(new GridLayout(0, 5, 0, 0));
		
		for(EEditButtonItems e : EEditButtonItems.values()) {
			button = new JButton(e.name());
			button.addActionListener(new SGInterfaceEvent());
			button.setActionCommand(e.name());
//			if (e.name().equals(SGConstants.DELETE_STUDENT) ||
//					e.name().equals(SGConstants.MODIFY_STUDENT)) {
//				button.setEnabled(false);	// �켱 ��Ȱ��ȭ, ���̺��� ���ý� Ȱ��ȭ
//			}
			add(button);
		}
	}
	
	public void initialize() {
		registerInterface.initialize();
		searchInterface.initialize();
		printInterface.initialize();
		deleteInterface.initialize();
		modifyInterface.initialize();
	}
	
	public class SGInterfaceEvent implements ActionListener {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EEditButtonItems.valueOf(e.getActionCommand())) {
			case �л����:
				registerInterface.openDialog();
				break;
			case �л��˻�:
				searchInterface.openDialog();
				break;
			case �л����:
				printInterface.openDialog();
				break;
			case �л�����:
				deleteInterface.openDialog();
				break;
			case �л�����:
				modifyInterface.openDialog();
				break;
			}		
		}
	}
}

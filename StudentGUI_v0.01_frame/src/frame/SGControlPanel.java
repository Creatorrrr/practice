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
		registerInterface = new SGRegisterInterface(manageStudent, printPanel);
		searchInterface = new SGSearchInterface(manageStudent, printPanel);
		printInterface = new SGPrintInterface(manageStudent, printPanel);
		deleteInterface = new SGDeleteInterface(manageStudent, printPanel);
		modifyInterface = new SGModifyInterface(manageStudent, printPanel);
		
		JButton button;
		
		setLayout(new GridLayout(0, 5, 0, 0));
		
		for(EEditButtonItems e : EEditButtonItems.values()) {
			button = new JButton(e.getUsage());
			button.addActionListener(new SGInterfaceEvent());
			button.setActionCommand(e.name());
//			if (e.name().equals(SGConstants.DELETE_STUDENT) ||
//					e.name().equals(SGConstants.MODIFY_STUDENT)) {
//				button.setEnabled(false);	// 우선 비활성화, 테이블에서 선택시 활성화
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
			case REGIST_STUDENT:
				registerInterface.openDialog();
				break;
			case SEARCH_STUDENT:
				searchInterface.openDialog();
				break;
			case PRINT_STUDENT:
				printInterface.openDialog();
				break;
			case DELETE_STUDENT:
				deleteInterface.openDialog();
				break;
			case MODIFY_STUDENT:
				modifyInterface.openDialog();
				break;
			}		
		}
	}
}

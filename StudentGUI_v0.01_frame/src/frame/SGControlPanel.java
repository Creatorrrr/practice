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
	
	public SGControlPanel() {
		registerInterface = new SGRegisterInterface();
		searchInterface = new SGSearchInterface();
		printInterface = new SGPrintInterface();
		deleteInterface = new SGDeleteInterface();
		modifyInterface = new SGModifyInterface();
		
		JButton button;
		
		setLayout(new GridLayout(0, 5, 0, 0));
		
		for(EEditButtonItems e : EEditButtonItems.values()) {
			button = new JButton(e.name());
			button.addActionListener(new SGInterfaceEvent());
			button.setActionCommand(e.name());
//			if (e.name().equals(SGConstants.DELETE_STUDENT) ||
//					e.name().equals(SGConstants.MODIFY_STUDENT)) {
//				button.setEnabled(false);	// 우선 비활성화, 테이블에서 선택시 활성화
//			}
			add(button);
		}
	}
	
	public void initialize(SGManageStudent manageStudent) {
		registerInterface.initialize(manageStudent);
		searchInterface.initialize(manageStudent);
//		printInterface.initialize();
		deleteInterface.initialize(manageStudent);
//		modifyInterface.initialize();
	}
	
	public class SGInterfaceEvent implements ActionListener {
		 
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EEditButtonItems.valueOf(e.getActionCommand())) {
			case 학생등록:
				registerInterface.openDialog();
				break;
			case 학생검색:
				searchInterface.openDialog();
				break;
			case 학생출력:
				printInterface.initialize();
				break;
			case 학생삭제:
				deleteInterface.openDialog();
				break;
			case 학생수정:
				modifyInterface.initialize();
				break;
			}		
		}
	}
}

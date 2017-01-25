package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.SGConstants;
import controller.SGManageStudent;

public class SGMainFrame extends JFrame {
	
	private SGManageStudent manageStudent;
	
	private SGPrintPanel printPanel;
	private SGControlPanel inputPanel;
	
	public SGMainFrame(String title) {
		super(title);
		
		manageStudent = new SGManageStudent();
		
		printPanel = new SGPrintPanel();
		inputPanel = new SGControlPanel(manageStudent, printPanel);

		this.add(printPanel);		
		this.add(inputPanel, BorderLayout.SOUTH);
	}
	
	public void initialize() {
		this.setSize(SGConstants.MAINFRAME_WIDTH, SGConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		inputPanel.initialize();
	}

}

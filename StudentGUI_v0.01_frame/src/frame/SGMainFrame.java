package frame;

import java.awt.GridLayout;

import javax.swing.JFrame;

import constants.SGConstants;

public class SGMainFrame extends JFrame {

	private SGInputPanel inputPanel;
	private SGPrintPanel printPanel;
	
	public SGMainFrame(String title) {
		super(title);
		inputPanel = new SGInputPanel();
		printPanel = new SGPrintPanel();
		setLayout(new GridLayout(0, 1, 0, 0));
		
		this.add(inputPanel);
		this.add(printPanel);
	}
	
	public void initialize() {
		this.setSize(SGConstants.MAINFRAME_WIDTH, SGConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

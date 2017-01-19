package frame;

import javax.swing.JFrame;

import constants.SGConstants;

public class SGMainFrame extends JFrame{

//	private SGRegisterFrame registerFrame;
//	private SGSearchFrame searchFrame;
//	private SGDeleteFrame deleteFrame;
//	private SGPrintFrame printFrame;
//	private SGModifyFrame modifyFrame;
	
	public SGMainFrame(String title) {
		super(title);
	}
	
	public void initialization() {
		this.setSize(SGConstants.MAINFRAME_WIDTH, SGConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

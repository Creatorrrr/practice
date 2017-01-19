package frame;

import javax.swing.JButton;
import javax.swing.JFrame;

import constants.SGConstants;


public class SGMainFrame extends JFrame {
	
	private JButton button;

	public SGMainFrame(String title) {
		super(title);
		
		button = new JButton("SK");
		this.add(button);
	}
	
	public void initialization() {
		this.setSize(SGConstants.MAINFRAME_WIDTH, SGConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}
}

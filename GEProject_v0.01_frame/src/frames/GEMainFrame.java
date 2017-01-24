package frames;

import javax.swing.JFrame;

import constants.GEConstants;

public class GEMainFrame extends JFrame{
	
	private GEDrawingPanel drawingPanel;

	public GEMainFrame(String title) {
		super(title);
		
		drawingPanel = new GEDrawingPanel();
		
		this.add(drawingPanel);
	}
	
	public void initialization() {
		this.setSize(GEConstants.MAINFRAME_WIDTH, GEConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

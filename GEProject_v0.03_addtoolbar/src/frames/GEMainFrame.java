package frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame{
	
	private GEDrawingPanel drawingPanel;
	private GEMenuBar menuBar;
	private GEToolBar toolBar;

	public GEMainFrame(String title) {
		super(title);
		
		drawingPanel = new GEDrawingPanel();
		this.add(drawingPanel);
		
		menuBar = new GEMenuBar();
		this.setJMenuBar(menuBar);
		
		toolBar = new GEToolBar("Åø¹Ù");
		this.add(BorderLayout.NORTH, toolBar);
	}
	
	public void initialization() {
		this.setSize(GEConstants.MAINFRAME_WIDTH, GEConstants.MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

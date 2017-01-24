package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EColorMenuItems;
import frames.GEDrawingPanel;

public class GEColorMenu extends JMenu{
	
	private GEDrawingPanel drawingPanel;
	
	public GEColorMenu(String title) {
		super(title);
		
		EventHandler event = new EventHandler();
		
		for(EColorMenuItems e : EColorMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			
			item.addActionListener(event);
			item.setActionCommand(e.name());
			this.add(item);
		}
	}
	
	public void initialization(GEDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	
	private void setLineColor() {
		Color lineColor = JColorChooser.showDialog(null, "Select Line Color", null);
		
		if(lineColor != null) {	// JColorChooser���� ��� ������ ��� null
			drawingPanel.setLineColor(lineColor);
		}
	}
	
	private void setFillColor() {
		Color fillColor = JColorChooser.showDialog(null, "Select Fill Color", null);
		
		if(fillColor != null) {	// JColorChooser���� ��� ������ ��� null
			drawingPanel.setFillColor(fillColor);
		}
	}
	
	private void delLineColor() {
		drawingPanel.setLineColor(Color.BLACK);
	}
	
	private void delFillColor() {
		drawingPanel.setFillColor(Color.WHITE);
	}
	
	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EColorMenuItems.valueOf(e.getActionCommand())) {
			case ����:
				setLineColor();
				break;
			case ���:
				setFillColor();
				break;
			case ���������:
				delLineColor();
				break;
			case ��������:
				delFillColor();
				break;
			}
		}
		
	}
}

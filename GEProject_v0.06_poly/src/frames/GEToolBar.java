package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import constants.GEConstants.EToolbarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;

public class GEToolBar extends JToolBar{
	
	private GEDrawingPanel drawingPanel;

	public GEToolBar(String title) {
		super(title);
		
		ButtonGroup group = new ButtonGroup();
		
		ButtonEvent event = new ButtonEvent();
		
		for(EToolbarButtons e : EToolbarButtons.values()) {
			JRadioButton item = new JRadioButton();
			
			item.setIcon(new ImageIcon("images/" + e.name() + ".gif"));
			item.setSelectedIcon(new ImageIcon("images/" + e.name() +"SLT.gif"));
			
			item.addActionListener(event);
			item.setActionCommand(e.name());
			
			this.add(item);
			group.add(item);
		}
	}
	
	public void initialization(GEDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	
	private class ButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(EToolbarButtons.Select.name())) {
				
			} else if(e.getActionCommand().equals(EToolbarButtons.Rectangle.name())) {
				drawingPanel.setCurrentShape(new GERectangle());
			} else if(e.getActionCommand().equals(EToolbarButtons.Ellipse.name())) {
				drawingPanel.setCurrentShape(new GEEllipse());
			} else if(e.getActionCommand().equals(EToolbarButtons.Line.name())) {
				drawingPanel.setCurrentShape(new GELine());
			} else if(e.getActionCommand().equals(EToolbarButtons.Polygon.name())) {

			}
		}
	}
}

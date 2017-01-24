package frames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants.EToolbarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GERectangle;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel {
	
	private GEShape currentShape;

	public GEDrawingPanel() {
		this.setBackground(Color.ORANGE);
		
		MouseEventHandler event = new MouseEventHandler();
		
		this.addMouseListener(event);
		this.addMouseMotionListener(event);
	}
	
	public void setCurrentShape(GEShape currentShape) {
		this.currentShape = currentShape;
	}
	
	private void initDraw(Point startP) {
		currentShape.initDraw(startP);
	}
	
	private void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D)getGraphics();
		g2D.setXORMode(getBackground());
		
		currentShape.draw(g2D);
		currentShape.setCoordinate(currentP);
		currentShape.draw(g2D);
	}
	
	private class MouseEventHandler extends MouseInputAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			initDraw(e.getPoint());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			animateDraw(e.getPoint());
		}
		
	}
}

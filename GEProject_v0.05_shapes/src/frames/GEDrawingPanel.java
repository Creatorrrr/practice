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

public class GEDrawingPanel extends JPanel {
	
	private GERectangle rectangle;
	private GEEllipse ellipse;
	private GELine line;
	
	private EToolbarButtons selectedShape;

	public GEDrawingPanel() {
		this.setBackground(Color.ORANGE);
		
		MouseEventHandler event = new MouseEventHandler();
		
		this.addMouseListener(event);
		this.addMouseMotionListener(event);
	}
	
	public void setSelectedShape(EToolbarButtons selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	private void initDraw(Point startP) {
		if(selectedShape == EToolbarButtons.Rectangle) {
			rectangle = new GERectangle();
			rectangle.initDraw(startP);
		} else if (selectedShape == EToolbarButtons.Ellipse) {
			ellipse = new GEEllipse();
			ellipse.initDraw(startP);
		} else if (selectedShape == EToolbarButtons.Line) {
			line = new GELine();
			line.initDraw(startP);
		}
	}
	
	private void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D)getGraphics();
		g2D.setXORMode(getBackground());
		
		if (selectedShape == EToolbarButtons.Rectangle) {
			g2D.draw(rectangle.getRectangle());
			rectangle.setCoordinate(currentP);
			g2D.draw(rectangle.getRectangle());			
		} else if (selectedShape == EToolbarButtons.Ellipse) {
			g2D.draw(ellipse.getEllipse());
			ellipse.setCoordinate(currentP);
			g2D.draw(ellipse.getEllipse());			
		} else if (selectedShape == EToolbarButtons.Line) {
			g2D.draw(line.getLine());
			line.setCoordinate(currentP);
			g2D.draw(line.getLine());			
		}
		

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

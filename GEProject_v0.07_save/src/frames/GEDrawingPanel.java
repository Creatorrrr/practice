package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import shapes.GEShape;

public class GEDrawingPanel extends JPanel {
	
	private GEShape currentShape;
	
	private List<GEShape> shapeList;

	public GEDrawingPanel() {
		this.setBackground(Color.ORANGE);
		
		MouseEventHandler event = new MouseEventHandler();
		
		this.addMouseListener(event);
		this.addMouseMotionListener(event);
		
		shapeList = new ArrayList<>();
	}
	
	public void setCurrentShape(GEShape currentShape) {
		this.currentShape = currentShape;
	}
	
	private void initDraw(Point startP) {
		currentShape = currentShape.clone();
		currentShape.initDraw(startP);
	}
	
	private void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D)getGraphics();
		g2D.setXORMode(getBackground());
		
		currentShape.draw(g2D);
		currentShape.setCoordinate(currentP);
		currentShape.draw(g2D);
	}
	
	private void finishDraw() {
		shapeList.add(currentShape);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)g;
		for(GEShape shape : shapeList) {
			shape.draw(g2D);
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
		
		@Override
		public void mouseReleased(MouseEvent e) {
			finishDraw();
		}
	}
}

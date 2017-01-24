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

import constants.GEConstants.EState;
import shapes.GEPolygon;
import shapes.GEShape;

public class GEDrawingPanel extends JPanel {

	private GEShape currentShape;
	private List<GEShape> shapeList;
	private EState currentState;

	private GEShape selectedShape;

	public GEDrawingPanel() {
		this.setBackground(Color.ORANGE);

		MouseEventHandler event = new MouseEventHandler();

		this.addMouseListener(event);
		this.addMouseMotionListener(event);

		shapeList = new ArrayList<>();

		currentState = EState.Idle;
	}

	public void setCurrentShape(GEShape currentShape) {
		this.currentShape = currentShape;
	}

	private void initDraw(Point startP) {
		currentShape = currentShape.clone();
		currentShape.initDraw(startP);
	}

	private void animateDraw(Point currentP) {
		Graphics2D g2D = (Graphics2D) getGraphics();
		g2D.setXORMode(getBackground());

		currentShape.draw(g2D);
		currentShape.setCoordinate(currentP);
		currentShape.draw(g2D);
	}

	private void finishDraw() {
		shapeList.add(currentShape);

		currentState = EState.Idle;
		repaint();
	}

	private void continueDrawing(Point continueP) {
		((GEPolygon) currentShape).continueDrawing(continueP);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;
		for (GEShape shape : shapeList) {
			shape.draw(g2D);
		}
	}

	private GEShape onShape(Point p) {
		for (int i = shapeList.size(); i > 0; i--) {
			GEShape shape = shapeList.get(i - 1);
			if (shape.onShape(p)) {
				return shape;
			}
		}

		return null;
	}

	private void clearShapes() {
		for (GEShape shape : shapeList) {
			shape.setSelected(false);
		}
	}

	private class MouseEventHandler extends MouseInputAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (currentState == EState.Idle) { // Idle상태가 아니면 아무것도 안한다.

				if (currentShape != null) {
					initDraw(e.getPoint());

					if (currentShape instanceof GEPolygon) {
						currentState = EState.NPointsDrawing;
					} else {
						currentState = EState.TwoPointsDrawing;
					}
				} else {
					selectedShape = onShape(e.getPoint());
					if(selectedShape != null) {
						clearShapes();
						selectedShape.setSelected(true);
					}
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (currentState == EState.NPointsDrawing) {
				animateDraw(e.getPoint());
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (currentState != EState.Idle) {
				animateDraw(e.getPoint());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (currentState == EState.TwoPointsDrawing) {
				finishDraw();
			} else if(currentState != EState.NPointsDrawing) {
				repaint();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (currentState == EState.NPointsDrawing) {
					if (e.getClickCount() == 1) {
						continueDrawing(e.getPoint());
					} else if (e.getClickCount() == 2) {
						finishDraw();
					}
				}
			}
		}
	}
}

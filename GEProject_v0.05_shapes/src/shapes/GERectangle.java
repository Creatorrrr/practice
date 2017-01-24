package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle {

	private Point startP;
	private Rectangle rect;
	
	public GERectangle() {
		rect = new Rectangle();
	}
	
// ���콺�� press�� �� ȣ��Ǹ� ���� ��ǥ�� �����Ѵ�.
	public void initDraw(Point startP) {
		this.startP = startP;
	}

// ���콺�� drag�� �� ȣ��Ǹ� �簢���� ũ��� ��ġ�� �����Ѵ�.
	public void setCoordinate(Point currentP) {
		rect.setFrameFromDiagonal(startP, currentP);
	}
	
	public Rectangle getRectangle() {
		return rect;
	}
}

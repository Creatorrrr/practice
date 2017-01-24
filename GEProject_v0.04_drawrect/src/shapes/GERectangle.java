package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle {

	private Point startP;
	private Rectangle rect;
	
	public GERectangle() {
		rect = new Rectangle();
	}
	
// 마우스가 press될 때 호출되며 시작 좌표를 저장한다.
	public void initDraw(Point startP) {
		this.startP = startP;
	}

// 마우스가 drag될 때 호출되며 사각형의 크기와 위치를 설정한다.
	public void setCoordinate(Point currentP) {
		rect.setFrameFromDiagonal(startP, currentP);
	}
	
	public Rectangle getRectangle() {
		return rect;
	}
}

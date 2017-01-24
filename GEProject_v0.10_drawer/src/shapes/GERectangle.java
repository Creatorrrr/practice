package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle extends GEShape{

	public GERectangle() {
		super(new Rectangle());
	}
	
// 마우스가 press될 때 호출되며 시작 좌표를 저장한다.
	public void initDraw(Point startP) {
		this.startP = startP;
	}

// 마우스가 drag될 때 호출되며 사각형의 크기와 위치를 설정한다.
	public void setCoordinate(Point currentP) {
		((Rectangle)myShape).setFrameFromDiagonal(startP, currentP);
		
		if(anchorList != null) {
			anchorList.setPosition(myShape.getBounds());
		}
	}
	
	@Override
	public GEShape clone() {
		return new GERectangle();
	}
}

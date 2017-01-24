package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle extends GEShape{

	public GERectangle() {
		super(new Rectangle());
	}
	
// ���콺�� press�� �� ȣ��Ǹ� ���� ��ǥ�� �����Ѵ�.
	public void initDraw(Point startP) {
		this.startP = startP;
	}

// ���콺�� drag�� �� ȣ��Ǹ� �簢���� ũ��� ��ġ�� �����Ѵ�.
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

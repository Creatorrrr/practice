package shapes;

import java.awt.Point;
import java.awt.geom.Line2D;

public class GELine extends GEShape {

	public GELine() {
		super(new Line2D.Double());
	}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		((Line2D)myShape).setLine(startP, currentP);
	}
}
package shapes;

import java.awt.Point;
import java.awt.Polygon;

public class GEPolygon extends GEShape {

	public GEPolygon() {
		super(new Polygon());
	}

	@Override
	public void initDraw(Point startP) {
		((Polygon)myShape).addPoint(startP.x, startP.y);
	}

	@Override
	public void setCoordinate(Point currentP) {
//		Polygon poly = ((Polygon)myShape);
//		int index = poly.npoints;
//		
//		poly.xpoints[index - 1] = currentP.x;
//		poly.ypoints[index - 1] = currentP.y;
		
		((Polygon)myShape).xpoints[((Polygon)myShape).npoints - 1] = currentP.x;
		((Polygon)myShape).ypoints[((Polygon)myShape).npoints - 1] = currentP.y;
	}
	
	public void continueDrawing(Point continueP) {
		((Polygon)myShape).addPoint(continueP.x, continueP.y);
	}

	@Override
	public GEShape clone() {
		return new GEPolygon();
	}

}

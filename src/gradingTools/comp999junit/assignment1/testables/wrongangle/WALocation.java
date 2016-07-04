package gradingTools.comp999junit.assignment1.testables.wrongangle;

import util.annotations.Explanation;
@Explanation("Uses Cartesian representation.")
//@Tags({"cartesian", "point"})
public class WALocation
	{	
	protected int x, y;
	public WALocation(int theX, int theY) {
		x = theX;
		y = theY;
	}
	
	public int getX() { return x; }
	public int getY() { return y; } 	
	public double getAngle() { 
//		return Math.atan2(y, x); 
		return 0;
	}
	public double getRadius() { 
		return Math.sqrt(x*x + y*y); 
//		return 0;
	}	
//	@Override
//	public void print (WAPoint aPoint, String aString) {
//		System.out.println (aString + aPoint.getX() + " " + aPoint.getY());
//	}
	public void print () {
		System.out.println ("X: " + x + " Y:" + y);
	}
	// cannot make argumenyt WAPoint!
	// changed the name from translate to move, changed the order of parameters
	public WALocation move (int anXDelta, int aYDelta, WALocation aPoint) {
		return new WALocation(aPoint.getX() + anXDelta, aPoint.getY() + aYDelta);
	}
	
}

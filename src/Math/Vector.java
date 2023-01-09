
package Math;

/**
 *
 * @author carlos
 */
public class Vector {
    private double x,y;
	
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector()
	{
		x = 0;
		y = 0;
	}	
	
	public Vector add(Vector v)
	{
		return new Vector(x + v.getX(), y + v.getY());
	}
	
	public Vector subtract(Vector v)
	{
		return new Vector(x - v.getX(), y - v.getY());
	}
	
	public Vector scale(double value)
	{
		return new Vector(x*value, y*value);
	}
	
	public Vector limit(double value)
	{
		if(getMagnitude() > value)
		{
			return this.normalize().scale(value);
		}
		return this;
	}
	
	public Vector normalize()
	{
		double magnitude = getMagnitude();
		
		return new Vector(x / magnitude, y / magnitude);
	}
	
	public double getMagnitude()
	{
		return Math.sqrt(x*x + y*y);
	}
	
	public Vector setDirection(double angle)
	{
		double magnitude = getMagnitude();
		
		return new Vector(Math.cos(angle)*magnitude, Math.sin(angle)*magnitude);
	}
	
	public double getAngle() {
		return Math.asin(y/getMagnitude());
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}

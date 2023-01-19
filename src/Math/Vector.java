/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase para los diferentes movimientos de cada objeto llamese metorito
 * nave espacial o nave enemiga
 *
 * ****************************************************************************/
package Math;

/**
 *Clase para los calculos de las posiciones de los objetos
 * @author carlos
 */
public class Vector {
   private double x,y;
	/**
         * Constructor con parametros 
         * @param x
         * @param y 
         */
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	/**
         * contructor vacio para inicialisacion
         */
	public Vector()
	{
		x = 0;
		y = 0;
	}	
	/**
         * crear un nuevo vector
         * @param v
         * @return 
         */
	public Vector add(Vector v)
	{
		return new Vector(x + v.getX(), y + v.getY());
	}
	/**
         * quitar un vector
         * @param v
         * @return 
         */
	public Vector subtract(Vector v)
	{
		return new Vector(x - v.getX(), y - v.getY());
	}
	/**
         * escalar el vector
         * @param value
         * @return 
         */
	public Vector scale(double value)
	{
		return new Vector(x*value, y*value);
	}
	/**
         * limite del vector
         * @param value
         * @return 
         */
	public Vector limit(double value)
	{
		if(getMagnitude() > value)
		{
			return this.normalize().scale(value);
		}
		return this;
	}
	/**
         * normalizacion
         * @return 
         */
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

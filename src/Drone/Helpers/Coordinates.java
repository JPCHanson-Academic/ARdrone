package Drone.Helpers;
/**
 * this class represents a set of X,Y,Z - Coordinates, it is a convienience object
 * @author orpheus
 *
 */
public class Coordinates 
{
	/** X value **/
	float x;
	/** Y Value **/
	float y;
	/** Z Value **/
	float z;
	
	/**
	 * default constructor, initialises a coordinates object with origin values
	 */
	public Coordinates()
	{
		x = 0; 
		y = 0; 
		z = 0;
	}
	
	/**
	 * initialise a coordinates objext with the provided values
	 * @param xVal
	 * @param yVal
	 * @param zVal
	 */
	public Coordinates(float xVal, float yVal, float zVal)
	{
		x = xVal;
		y = yVal;
		z = zVal;
	}
	
	/**
	 * set the values associated with this coordinates object
	 * @param xVal
	 * @param yVal
	 * @param zVal
	 */
	public void setCoordinates(float xVal, float yVal, float zVal)
	{
		x = xVal;
		y = yVal;
		z = zVal;
	}
	
	/**
	 * return the x component of the coordinates
	 * @return
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * return the y component of the coordinates
	 * @return
	 */
	public float getY()
	{
		return y;
	}
	
	/**
	 * return the z component of the coordinates
	 * @return
	 */
	public float getZ()
	{
		return z;
	}

}

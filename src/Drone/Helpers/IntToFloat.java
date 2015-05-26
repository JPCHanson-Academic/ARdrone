package Drone.Helpers;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/**
 * 
 * @author orpheus
 *
 */
public class IntToFloat 
{
	/**  **/
	private static ByteBuffer bb = ByteBuffer.allocate(4);
	/**  **/
	private static FloatBuffer fb = bb.asFloatBuffer();
	/**  **/
	private static IntBuffer ib = bb.asIntBuffer();
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static int input(float f) 
	{
		fb.put(0, f);
		return ib.get(0);
	}
}

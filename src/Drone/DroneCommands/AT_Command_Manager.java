package Drone.DroneCommands;

import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * The client of the ATCommand pattern, also the facade through which users 
 * give the drone instructions.
 * @author orpheus
 *
 */
public class AT_Command_Manager 
{
	/** Reference to an Invoker object, will hold the commands to be executed **/
	private ATInvoker invoker;
	/** the "take-off" command **/
	private ATCommand takeOff;
	/** the "land" **/
	private ATCommand land;
	/** the "forwards" command **/
	private ATCommand forward;
	/** the "backwards" command **/
	private ATCommand back;
	/** the "left turn" command **/
	private ATCommand lTurn;
	/** the "right turn" command **/
	private ATCommand rTurn;
	/** the "strafe right" command **/
	private ATCommand right;
	/** the "strafe left" command **/
	private ATCommand left;
	/** the "ascend" command **/
	private ATCommand up;
	/** the "descend" command **/
	private ATCommand down;
	/** the "hover" command **/
	private ATCommand hover;
	/** the socket to send the AT_Commands to **/
	private DatagramSocket commandSocket;
	/** the socket to get the NavData from **/
	private DatagramSocket navSocket;
	/** the IP address of the done **/
	private InetAddress ipAddress;
	/** holder for the current time **/
	private long t;

	/**
	 * initialise stuff
	 * @throws Exception
	 */
	public AT_Command_Manager() 
	{
		initSockets();
		
		invoker = new ATInvoker();
		
		takeOff = new Cmnd_TakeOff(ipAddress,commandSocket);
		land = new Cmnd_AutoLand(ipAddress,commandSocket);
		forward = new Cmnd_MoveLeft(ipAddress,commandSocket);
		back = new Cmnd_MoveForward(ipAddress,commandSocket);
		lTurn = new Cmnd_TurnLeft(ipAddress,commandSocket);
		rTurn = new Cmnd_TurnRight(ipAddress,commandSocket);
		right = new Cmnd_MoveRight(ipAddress,commandSocket);
		left = new Cmnd_MoveBackward(ipAddress,commandSocket);
		up = new Cmnd_MoveUp(ipAddress,commandSocket);
		down = new Cmnd_MoveDown(ipAddress,commandSocket);
		hover = new Cmnd_Hover(ipAddress,commandSocket);
	}
	
	/**
	 * make the drone take off
	 * @throws Exception
	 */
	public void takeOff() 
	{
		invoker.setCommand(takeOff);
		invoker.execute();
	}
	/**
	 * make the drone land
	 * @throws Exception
	 */
	public void land()
	{
		invoker.setCommand(land);
		invoker.execute();
	}
	
	/**
	 * make the drone go forward
	 * @param time
	 * @throws Exception
	 */
	public void forward(int time)
	{
		invoker.setCommand(forward);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}

	/**
	 * make the drone go back
	 * @param time
	 * @throws Exception
	 */
	public void backward(int time)
	{
		invoker.setCommand(back);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone turn left
	 * @param time
	 * @throws Exception
	 */
	public void lTurn(int time)
	{
		invoker.setCommand(lTurn);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone turn right
	 * @param time
	 * @throws Exception
	 */
	public void rTurn(int time)
	{
		invoker.setCommand(rTurn);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone strafe left
	 * @param time
	 * @throws Exception
	 */
	public void left(int time)
	{
		invoker.setCommand(left);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone strafe right
	 * @param time
	 * @throws Exception
	 */
	public void right(int time)
	{
		invoker.setCommand(right);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone increase altitude
	 * @param time
	 * @throws Exception
	 */
	public void up(int time)
	{
		invoker.setCommand(up);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone decrease altitude
	 * @param time
	 * @throws Exception
	 */
	public void down(int time)
	{
		invoker.setCommand(down);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	/**
	 * make the drone decrease altitude
	 * @param time
	 * @throws Exception
	 */
	public void hover(int time)
	{
		invoker.setCommand(this.hover);
		t = System.currentTimeMillis();
		while (System.currentTimeMillis()< t + time)
		{
			invoker.execute();
		}
	}
	
	
	/**
	 * initialise the sockets for communication
	 * @throws Exception
	 */
	private void initSockets()
	{
		try{
		byte[] ip_bytes = new byte[4];
		ip_bytes[0] = (byte)192;
		ip_bytes[1] = (byte)168;
		ip_bytes[2] = (byte)1;
		ip_bytes[3] = (byte)1;
		//create an InetAddress from the byte array above
		ipAddress = InetAddress.getByAddress(ip_bytes);
	    //create sockets and set timeout value
	    commandSocket = new DatagramSocket();
	   	navSocket = new DatagramSocket();
	   	commandSocket.setSoTimeout(3000);
	    navSocket.setSoTimeout(3000);
		}
		
		catch(Exception e)
		{
			System.out.println("--sockets error in command manager--");
		}
	}
}
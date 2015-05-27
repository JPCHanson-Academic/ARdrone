package Drone.DroneCommands;

import java.net.DatagramSocket;
import java.net.InetAddress;

import Drone.Hardware.ATReciever;
/**
 * Sends the "take-off" command.
 * @author orpheus
 *
 */
public class Cmnd_TakeOff implements ATCommand 
{

	/** reference to the reciever **/
	private ATReciever motors;
	
	/** command string part 1**/
	private static final String AT_COMMAND_STRING1 = "AT*REF=";
	/** command string part 2**/
	private static final String AT_COMMAND_STRING2 = ",290718208";
	
	/**
	 * Default CTOR, initialise stuff
	 */
	public Cmnd_TakeOff(InetAddress ipAddress, DatagramSocket socket)
	{
		motors = new ATReciever(ipAddress, socket);	
	}
	
	/**
	 * send the command created by concatonating AT_COMMAND_STRING1, the sequence
	 * parameter and AT_COMMAND_STRING2 to the ATReciever
	 */
	@Override
	public void execute(int sequence) throws Exception 
	{
		motors.send_at_cmd(AT_COMMAND_STRING1+sequence+AT_COMMAND_STRING2);
	}

}

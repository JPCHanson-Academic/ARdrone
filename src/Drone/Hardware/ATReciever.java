package Drone.Hardware;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * This class is the interaction between the hardware and the software, it is where
 * individual concrete commands get executed.
 * @author orpheus
 *
 */
public class ATReciever 
{
	/** The IP address of the drone **/
	private InetAddress inet_addr;
	/** The socket to send AT commands to **/
	private DatagramSocket atSocket;
	
	/**
	 * initialise the InetAddress and the DatagramSocket
	 */
	public ATReciever(InetAddress inetaddr, DatagramSocket atSock)
	{
		inet_addr = inetaddr;
		atSocket = atSock;
	}
	
	/**
	 * Sends the actual AT-Command passed to it as a string argument.
	 * @param at_cmd the AT_Command
	 * @throws Exception ???
	 */
	public void send_at_cmd(String at_cmd) 
	{
//		System.out.println("AT command: " + at_cmd);
		byte[] buffer = (at_cmd + "\r").getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
				inet_addr, 5556);
		try {
			atSocket.send(packet);
			Thread.sleep(200, 0);
			} 
		
		
		catch (IOException e) 
		{
			System.out.println("--Could Not Send Packet: "+at_cmd+"--");
		}
		catch (InterruptedException iE)
		{
			System.out.println("--Thread Cannot Sleep--");
		}
		
	}
}

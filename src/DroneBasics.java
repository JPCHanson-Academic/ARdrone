import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Drone.DroneCommands.ATInvoker;
import Drone.DroneCommands.AT_Command_Manager;
import Drone.DroneCommands.Cmnd_AutoLand;
import Drone.DroneCommands.Cmnd_TakeOff;
import Drone.Hardware.ATReciever;
import Drone.Hardware.SensorManager;
import workspace.ARDroneNavData.src.NavData;


public class DroneBasics
{
	
	private static InetAddress inet_addr = null; 
	private static DatagramSocket atsocket = null;
	private static DatagramSocket ndsocket = null;
	private static NavData navdata = new NavData();
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		//generate array to store IP address
		int seq = 1;
		byte[] ip_bytes = new byte[4];
    	ip_bytes[0] = (byte)192;
    	ip_bytes[1] = (byte)168;
    	ip_bytes[2] = (byte)1;
    	ip_bytes[3] = (byte)1;
    	//create an InetAddress from the byte array above
        inet_addr = InetAddress.getByAddress(ip_bytes);
        //create sockets and set timeout value
        atsocket = new DatagramSocket();
       	ndsocket = new DatagramSocket();
        atsocket.setSoTimeout(3000);
        ndsocket.setSoTimeout(3000);
		
        //not really sure what these do.
        ATReciever reciever = new ATReciever(inet_addr, atsocket);
        reciever.send_at_cmd("AT*CONFIG=1,\"control:altitude_max\",\"9000\"");
        reciever.send_at_cmd("AT*CTRL=0");
		reciever.send_at_cmd("AT*CONFIG=605,\"general:navdata_demo\",\"FALSE\"");
       
		//call early on to avoid zero values
		NavData.main(args);
		
		SensorManager sm = new SensorManager();
		AT_Command_Manager cm = new AT_Command_Manager();

		cm.takeOff();
		Thread.sleep(4000);
		cm.hover(5000);
		cm.left(2000);
		cm.forward(2000);
		cm.up(2000);
		cm.down(1000);
		cm.right(2000);
//		cm.hover(1000);
//		System.out.println(SensorManager.getRoll());
		cm.land();

		atsocket.close();
    	ndsocket.close();
	}
}

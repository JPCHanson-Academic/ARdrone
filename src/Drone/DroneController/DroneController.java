package Drone.DroneController;

import Drone.DroneCommands.AT_Command_Manager;
import Drone.DroneController.AutoPilot.AutoPilot;
import Drone.Hardware.SensorManager;
import Drone.Helpers.Coordinates;
import Drone.View.BasicSwingView;
import Drone.View.View;

/**
 * 
 * @author orpheus
 *
 */
public class DroneController 
{
	private View view;
	private SensorManager sensorManager;
	private AT_Command_Manager commandManager;
	private Location world;
	private AutoPilot autopilot;
	private static final float LANDED_DIST = 0.1f;
	
	/**
	 * 
	 */
	public void run()
	{
		initialiseDrone();
//		Coordinates target = new Coordinates(1.0f,1.0f,1.0f);
//		autopilot.moveToTarget(target);	
	}
	
	/**
	 * 
	 */
	public void shutdownDrone()
	{
		System.out.println("<<SHUTTING DOWN DRONE>>");
		System.out.println("<attempting to land>");
		land();
		System.out.println("<kill: autopilot>");
		autopilot = null;
		System.out.println("<kill: world>");
		world = null;
		System.out.println("<kill: sensors>");
		sensorManager = null;
		System.out.println("<kill: controls>");
		commandManager = null;
	}
	
	public void initialiseDrone() 
	{
		System.out.println("<<INITIALISING DRONE>> ");
		System.out.println("<Graphical Interface> ");
		view = new BasicSwingView(this);
		System.out.println("<Sensors> ");
		sensorManager = new SensorManager();
		System.out.println("<Controls> ");
		commandManager = new AT_Command_Manager();
		System.out.println("<World> ");
		world = new Location();
		System.out.println("<Orienting> ");
		world.centerWorld();
		System.out.println("<AutoPilot> ");
		autopilot = new AutoPilot(world, commandManager);
		System.out.println("<<DRONE READY>>");
	}		
	
	private void land()
	{
		do
		{commandManager.land();}
		while(SensorManager.getAltitude() > LANDED_DIST );

	}
}
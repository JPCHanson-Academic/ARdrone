package Drone.View;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import Drone.DroneController.DroneController;
import Drone.DroneController.Location;
import Drone.View.Guages.Guage;
/**
 * 
 * @author orpheus
 *
 */
public class BasicSwingView implements View 
{
	DroneController droneController;
	private JFrame window;
	private Guage guages;
	Guage alt;
	Guage alt2;
	
	public BasicSwingView(DroneController controller)
	{
		droneController = controller;
		setupMainWindow();
		setupInstruments();
		combineGUIComponents();
	}
	/**
	 * 
	 */
	@Override
	public void refresh(Location loc) 
	{

	}

	private void setupMainWindow()
	{
		window = new JFrame("test");
		window.setSize(450, 800);	
		
		window.addWindowListener(new WindowAdapter() 
			{
	         	public void windowClosing(WindowEvent windowEvent)
	         	{
	         		droneController.shutdownDrone();
	         		System.exit(0);
	         	} 
			});
	}
	
	private void setupInstruments()
	{
		guages = new Guage();
		alt = new Guage();
		alt2 = new Guage();
		alt2.update(32f);
		alt.update(85f);
		guages.update(3.1415998732498324f);
;	}
	
	private void combineGUIComponents()
	{
		window.setLayout(new GridLayout(2,0));
		window.add(guages);
		window.add(alt);
		window.add(alt2);
		window.setVisible(true);
		window.pack();
	}
	
}

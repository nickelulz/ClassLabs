//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner()
	{
		super("Garbage Collector");
		setSize(WIDTH,HEIGHT);
						
		getContentPane().add(new GarbageCollector());
				
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();
	}
}
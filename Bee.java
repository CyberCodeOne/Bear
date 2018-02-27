
public class Bee extends Thread
{
	private Pot pot;
	public Bee (Pot pot)
	{
		this.pot = pot;
	}
	
	public void run()
	{
		for (int i = 0; i < 3; i++)
		{
			pot.waitForEmptyToFill();
			try {sleep(100);}
			catch (Exception ie) {System.out.println(ie.getMessage());}
		}
		pot.setShutDown(true);
	}
}


public class Bear extends Thread
{
	private Pot pot;
	public Bear (Pot pot)
	{
		this.pot = pot;
	}
	public void run ()
	{
		while (!pot.isTerminated())
		{
			pot.waitForFullToEat();
		}
	}
}

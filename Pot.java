public class Pot
{
	private int honey;
	boolean shutDown;
	boolean terminate;
	
	public Pot (int honey)
	{
		this.honey = honey;
	}
	
	public synchronized void waitForEmptyToFill()
	{
		while (honey >= 100)
		{
			notifyAll();
			try {wait ();}
			catch (Exception ie) {System.out.println(ie.getMessage());}
		}
		honey = honey + 10;
		System.out.println("Bee " + Thread.currentThread().getName() + " produced honey." + 
							" Amount of honey in pot is " + honey);
		
	}
	
	public synchronized void waitForFullToEat()
	{
		while (honey < 100 && !isTerminated())
		{
			try {wait ();}
			catch (Exception ie) {System.out.println(ie.getMessage());}
		}
		if (honey == 100 && !isTerminated())
		{
			System.out.println("The Bear is Eating!");
			honey = 0;
			notifyAll();
		}
		if (honey == 0 && isShutDown())
		{
			setTerminate(true);
			notifyAll();
		}
	}
	
	public synchronized boolean isShutDown ()
	{
		return shutDown;
	}
	
	public synchronized void setShutDown (boolean shutDown)
	{
		this.shutDown = shutDown;
	}
	
	public synchronized boolean isTerminated ()
	{
		return terminate;
	}
	
	public synchronized void setTerminate (boolean terminate)
	{
		this.terminate = terminate;
	}
}
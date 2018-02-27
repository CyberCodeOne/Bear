
public class BoundedBuffer 
{	
	public BoundedBuffer ()
	{
		int numBees = 10;
		int honey = 100;
		
		Pot pot = new Pot (honey);
		Bear bear = new Bear(pot);
		bear.start();
		
		Bee bee[] = new Bee[numBees];
		for (int i = 0; i < numBees; i++)
		{
			bee[i] = new Bee (pot);
			bee[i].start();
		}
		for (int i = 0; i < numBees; i++)
		{
			try {bee[i].join();}
			catch (Exception ie) {System.out.println(ie.getMessage());}
		}
		System.out.println("The bees are done making Honey. The bear is Happy :D");
	}
}

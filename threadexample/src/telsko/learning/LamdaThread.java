package telsko.learning;

public class LamdaThread {

	public static void main(String[] args)
	{
		
		Runnable obj1 = new Runnable()
		{
			public void run() 
			{
				for(int i=0;i<5;i++)
				{
					System.out.println("Hello");	
					try {Thread.sleep(1000);}catch(Exception e) {}
				}
				
				
			}
		
	
		};
		
	}
	
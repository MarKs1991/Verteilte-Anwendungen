package Aufgabe1_2_Dispatcher;
public class Dispatcher
{
	public static boolean running = true;

	public static int[] execute(F f, int n)
	{


		DispatcherThread[] threadArray = new DispatcherThread[n];
		for (int i = 0; i <= n - 1; i++)
		{
			threadArray[i] = new DispatcherThread(i, f, n, threadArray);
			threadArray[i].start();
			System.out.println("Active Threads:"+ Thread.activeCount());
		}


		int [] intArray = new int[n];
		//Result result = new Result();
		//intArray = result.returnIntArray(n);

		while(running)
		{

		}
		DispatcherThread d = new DispatcherThread(0,f,n, threadArray);
		intArray = d.getIntArray();

		return intArray;
	}
}

